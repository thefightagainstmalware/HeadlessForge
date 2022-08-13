package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetworkSystem;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldManager;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MinecraftServer implements Runnable, ICommandSender, IThreadListener, IPlayerUsage
{
    private static final Logger logger = LogManager.getLogger();
    public static final File USER_CACHE_FILE = new File("usercache.json");

    /** Instance of Minecraft Server. */
    private static MinecraftServer mcServer;
    private final ISaveFormat anvilConverterForAnvilFile;

    /** The PlayerUsageSnooper instance. */
    private final PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("server", this, func_130071_aq());
    private final File anvilFile;
    private final List<ITickable> playersOnline = Lists.<ITickable>newArrayList();
    protected final ICommandManager commandManager;
    public final Profiler field_71304_b = new Profiler();
    private final NetworkSystem networkSystem;
    private final ServerStatusResponse statusResponse = new ServerStatusResponse();
    private final Random random = new Random();

    /** The server's port. */
    private int serverPort = -1;

    /** The server world instances. */
    public WorldServer[] field_71305_c;

    /** The ServerConfigurationManager instance. */
    private ServerConfigurationManager serverConfigManager;

    /**
     * Indicates whether the server is running or not. Set to false to initiate a shutdown.
     */
    private boolean serverRunning = true;

    /** Indicates to other classes that the server is safely stopped. */
    private boolean serverStopped;

    /** Incremented every tick. */
    private int tickCounter;
    protected final Proxy serverProxy;

    /**
     * The task the server is currently working on(and will output on outputPercentRemaining).
     */
    public String currentTask;

    /** The percentage of the current task finished so far. */
    public int percentDone;

    /** True if the server is in online mode. */
    private boolean onlineMode;

    /** True if the server has animals turned on. */
    private boolean canSpawnAnimals;
    private boolean canSpawnNPCs;

    /** Indicates whether PvP is active on the server or not. */
    private boolean pvpEnabled;

    /** Determines if flight is allowed or not. */
    private boolean allowFlight;

    /** The server MOTD string. */
    private String motd;

    /** Maximum build height. */
    private int buildLimit;
    private int maxPlayerIdleMinutes = 0;
    public final long[] tickTimeArray = new long[100];

    /** Stats are [dimension][tick%100] system.nanoTime is stored. */
    public long[][] timeOfLastDimensionTick;
    private KeyPair serverKeyPair;

    /** Username of the server owner (for integrated servers) */
    private String serverOwner;
    private String folderName;
    private String worldName;
    private boolean isDemo;
    private boolean enableBonusChest;

    /**
     * If true, there is no need to save chunks or stop the server, because that is already being done.
     */
    private boolean worldIsBeingDeleted;

    /** The texture pack for the server */
    private String resourcePackUrl = "";
    private String resourcePackHash = "";
    private boolean serverIsRunning;

    /**
     * Set when warned for "Can't keep up", which triggers again after 15 seconds.
     */
    private long timeOfLastWarning;
    private String userMessage;
    private boolean startProfiling;
    private boolean isGamemodeForced;
    private final YggdrasilAuthenticationService authService;
    private final MinecraftSessionService sessionService;
    private long nanoTimeSinceStatusRefresh = 0L;
    private final GameProfileRepository profileRepo;
    private final PlayerProfileCache profileCache;
    protected final Queue < FutureTask<? >> futureTaskQueue = Queues. < FutureTask<? >> newArrayDeque();
    private Thread serverThread;
    private long currentTime = func_130071_aq();

    public MinecraftServer(Proxy proxy, File workDir)
    {
        this.serverProxy = proxy;
        mcServer = this;
        this.anvilFile = null;
        this.networkSystem = null;
        this.profileCache = new PlayerProfileCache(this, workDir);
        this.commandManager = null;
        this.anvilConverterForAnvilFile = null;
        this.authService = new YggdrasilAuthenticationService(proxy, UUID.randomUUID().toString());
        this.sessionService = this.authService.createMinecraftSessionService();
        this.profileRepo = this.authService.createProfileRepository();
    }

    public MinecraftServer(File workDir, Proxy proxy, File profileCacheDir)
    {
        this.serverProxy = proxy;
        mcServer = this;
        this.anvilFile = workDir;
        this.networkSystem = new NetworkSystem(this);
        this.profileCache = new PlayerProfileCache(this, profileCacheDir);
        this.commandManager = this.createNewCommandManager();
        this.anvilConverterForAnvilFile = new AnvilSaveConverter(workDir);
        this.authService = new YggdrasilAuthenticationService(proxy, UUID.randomUUID().toString());
        this.sessionService = this.authService.createMinecraftSessionService();
        this.profileRepo = this.authService.createProfileRepository();
    }

    protected ServerCommandManager createNewCommandManager()
    {
        return new ServerCommandManager();
    }

    /**
     * Initialises the server and starts it.
     */
    protected abstract boolean startServer() throws IOException;

    protected void convertMapIfNeeded(String worldNameIn)
    {
        if (this.getActiveAnvilConverter().isOldMapFormat(worldNameIn))
        {
            logger.info("Converting map!");
            this.setUserMessage("menu.convertingLevel");
            this.getActiveAnvilConverter().convertMapFormat(worldNameIn, new IProgressUpdate()
            {
                private long startTime = System.currentTimeMillis();
                public void displaySavingString(String message)
                {
                }
                public void resetProgressAndMessage(String message)
                {
                }
                public void setLoadingProgress(int progress)
                {
                    if (System.currentTimeMillis() - this.startTime >= 1000L)
                    {
                        this.startTime = System.currentTimeMillis();
                        MinecraftServer.logger.info("Converting... " + progress + "%");
                    }
                }
                public void setDoneWorking()
                {
                }
                public void displayLoadingString(String message)
                {
                }
            });
        }
    }

    /**
     * Typically "menu.convertingLevel", "menu.loadingLevel" or others.
     */
    protected synchronized void setUserMessage(String message)
    {
        this.userMessage = message;
    }

    public synchronized String getUserMessage()
    {
        return this.userMessage;
    }

    protected void loadAllWorlds(String p_71247_1_, String p_71247_2_, long seed, WorldType type, String p_71247_6_)
    {
        this.convertMapIfNeeded(p_71247_1_);
        this.setUserMessage("menu.loadingLevel");
        this.field_71305_c = new WorldServer[3];
        this.timeOfLastDimensionTick = new long[this.field_71305_c.length][100];
        ISaveHandler isavehandler = this.anvilConverterForAnvilFile.getSaveLoader(p_71247_1_, true);
        this.setResourcePackFromWorld(this.getFolderName(), isavehandler);
        WorldInfo worldinfo = isavehandler.loadWorldInfo();
        WorldSettings worldsettings;

        if (worldinfo == null)
        {
            if (this.isDemo())
            {
                worldsettings = DemoWorldServer.demoWorldSettings;
            }
            else
            {
                worldsettings = new WorldSettings(seed, this.getGameType(), this.canStructuresSpawn(), this.isHardcore(), type);
                worldsettings.setWorldName(p_71247_6_);

                if (this.enableBonusChest)
                {
                    worldsettings.enableBonusChest();
                }
            }

            worldinfo = new WorldInfo(worldsettings, p_71247_2_);
        }
        else
        {
            worldinfo.setWorldName(p_71247_2_);
            worldsettings = new WorldSettings(worldinfo);
        }

        for (int i = 0; i < this.field_71305_c.length; ++i)
        {
            int j = 0;

            if (i == 1)
            {
                j = -1;
            }

            if (i == 2)
            {
                j = 1;
            }

            if (i == 0)
            {
                if (this.isDemo())
                {
                    this.field_71305_c[i] = (WorldServer)(new DemoWorldServer(this, isavehandler, worldinfo, j, this.field_71304_b)).init();
                }
                else
                {
                    this.field_71305_c[i] = (WorldServer)(new WorldServer(this, isavehandler, worldinfo, j, this.field_71304_b)).init();
                }

                this.field_71305_c[i].initialize(worldsettings);
            }
            else
            {
                this.field_71305_c[i] = (WorldServer)(new WorldServerMulti(this, isavehandler, j, this.field_71305_c[0], this.field_71304_b)).init();
            }

            this.field_71305_c[i].addWorldAccess(new WorldManager(this, this.field_71305_c[i]));

            if (!this.func_71264_H())
            {
                this.field_71305_c[i].func_72912_H().setGameType(this.getGameType());
            }
        }

        this.serverConfigManager.setPlayerManager(this.field_71305_c);
        this.func_147139_a(this.getDifficulty());
        this.initialWorldChunkLoad();
    }

    protected void initialWorldChunkLoad()
    {
        int i = 16;
        int j = 4;
        int k = 192;
        int l = 625;
        int i1 = 0;
        this.setUserMessage("menu.generatingTerrain");
        int j1 = 0;
        logger.info("Preparing start region for level " + j1);
        WorldServer worldserver = this.field_71305_c[j1];
        BlockPos blockpos = worldserver.getSpawnPoint();
        long k1 = func_130071_aq();

        for (int l1 = -192; l1 <= 192 && this.isServerRunning(); l1 += 16)
        {
            for (int i2 = -192; i2 <= 192 && this.isServerRunning(); i2 += 16)
            {
                long j2 = func_130071_aq();

                if (j2 - k1 > 1000L)
                {
                    this.outputPercentRemaining("Preparing spawn area", i1 * 100 / 625);
                    k1 = j2;
                }

                ++i1;
                worldserver.theChunkProviderServer.loadChunk(blockpos.func_177958_n() + l1 >> 4, blockpos.func_177952_p() + i2 >> 4);
            }
        }

        this.clearCurrentTask();
    }

    protected void setResourcePackFromWorld(String worldNameIn, ISaveHandler saveHandlerIn)
    {
        File file1 = new File(saveHandlerIn.getWorldDirectory(), "resources.zip");

        if (file1.isFile())
        {
            this.setResourcePack("level://" + worldNameIn + "/" + file1.getName(), "");
        }
    }

    public abstract boolean canStructuresSpawn();

    public abstract WorldSettings.GameType getGameType();

    /**
     * Get the server's difficulty
     */
    public abstract EnumDifficulty getDifficulty();

    /**
     * Defaults to false.
     */
    public abstract boolean isHardcore();

    public abstract int getOpPermissionLevel();

    public abstract boolean func_181034_q();

    public abstract boolean func_183002_r();

    /**
     * Used to display a percent remaining given text and the percentage.
     */
    protected void outputPercentRemaining(String message, int percent)
    {
        this.currentTask = message;
        this.percentDone = percent;
        logger.info(message + ": " + percent + "%");
    }

    /**
     * Set current task to null and set its percentage to 0.
     */
    protected void clearCurrentTask()
    {
        this.currentTask = null;
        this.percentDone = 0;
    }

    /**
     * par1 indicates if a log message should be output.
     */
    protected void saveAllWorlds(boolean dontLog)
    {
        if (!this.worldIsBeingDeleted)
        {
            for (WorldServer worldserver : this.field_71305_c)
            {
                if (worldserver != null)
                {
                    if (!dontLog)
                    {
                        logger.info("Saving chunks for level \'" + worldserver.func_72912_H().getWorldName() + "\'/" + worldserver.provider.getDimensionName());
                    }

                    try
                    {
                        worldserver.saveAllChunks(true, (IProgressUpdate)null);
                    }
                    catch (MinecraftException minecraftexception)
                    {
                        logger.warn(minecraftexception.getMessage());
                    }
                }
            }
        }
    }

    /**
     * Saves all necessary data as preparation for stopping the server.
     */
    public void stopServer()
    {
        if (!this.worldIsBeingDeleted)
        {
            logger.info("Stopping server");

            if (this.getNetworkSystem() != null)
            {
                this.getNetworkSystem().terminateEndpoints();
            }

            if (this.serverConfigManager != null)
            {
                logger.info("Saving players");
                this.serverConfigManager.saveAllPlayerData();
                this.serverConfigManager.removeAllPlayers();
            }

            if (this.field_71305_c != null)
            {
                logger.info("Saving worlds");
                this.saveAllWorlds(false);

                for (int i = 0; i < this.field_71305_c.length; ++i)
                {
                    WorldServer worldserver = this.field_71305_c[i];
                    worldserver.flush();
                }
            }

            if (this.usageSnooper.isSnooperRunning())
            {
                this.usageSnooper.stopSnooper();
            }
        }
    }

    public boolean isServerRunning()
    {
        return this.serverRunning;
    }

    /**
     * Sets the serverRunning variable to false, in order to get the server to shut down.
     */
    public void initiateShutdown()
    {
        this.serverRunning = false;
    }

    protected void setInstance()
    {
        mcServer = this;
    }

    public void run()
    {
        try
        {
            if (this.startServer())
            {
                this.currentTime = func_130071_aq();
                long i = 0L;
                this.statusResponse.setServerDescription(new ChatComponentText(this.motd));
                this.addFaviconToStatusResponse(this.statusResponse);

                while (this.serverRunning)
                {
                    long k = func_130071_aq();
                    long j = k - this.currentTime;

                    if (j > 2000L && this.currentTime - this.timeOfLastWarning >= 15000L)
                    {
                        logger.warn("Can\'t keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] {Long.valueOf(j), Long.valueOf(j / 50L)});
                        j = 2000L;
                        this.timeOfLastWarning = this.currentTime;
                    }

                    if (j < 0L)
                    {
                        logger.warn("Time ran backwards! Did the system time change?");
                        j = 0L;
                    }

                    i += j;
                    this.currentTime = k;

                    if (this.field_71305_c[0].areAllPlayersAsleep())
                    {
                        this.tick();
                        i = 0L;
                    }
                    else
                    {
                        while (i > 50L)
                        {
                            i -= 50L;
                            this.tick();
                        }
                    }

                    Thread.sleep(Math.max(1L, 50L - i));
                    this.serverIsRunning = true;
                }
            }
            else
            {
                this.finalTick((CrashReport)null);
            }
        }
        catch (Throwable throwable1)
        {
            logger.error("Encountered an unexpected exception", throwable1);
            CrashReport crashreport = null;

            if (throwable1 instanceof ReportedException)
            {
                crashreport = this.addServerInfoToCrashReport(((ReportedException)throwable1).getCrashReport());
            }
            else
            {
                crashreport = this.addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", throwable1));
            }

            File file1 = new File(new File(this.getDataDirectory(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");

            if (crashreport.saveToFile(file1))
            {
                logger.error("This crash report has been saved to: " + file1.getAbsolutePath());
            }
            else
            {
                logger.error("We were unable to save this crash report to disk.");
            }

            this.finalTick(crashreport);
        }
        finally
        {
            try
            {
                this.serverStopped = true;
                this.stopServer();
            }
            catch (Throwable throwable)
            {
                logger.error("Exception stopping the server", throwable);
            }
            finally
            {
                this.systemExitNow();
            }
        }
    }

    private void addFaviconToStatusResponse(ServerStatusResponse response)
    {
        File file1 = this.func_71209_f("server-icon.png");

        if (file1.isFile())
        {
            ByteBuf bytebuf = Unpooled.buffer();

            try
            {
                BufferedImage bufferedimage = ImageIO.read(file1);
                Validate.validState(bufferedimage.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
                Validate.validState(bufferedimage.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
                ImageIO.write(bufferedimage, "PNG", (OutputStream)(new ByteBufOutputStream(bytebuf)));
                ByteBuf bytebuf1 = Base64.encode(bytebuf);
                response.setFavicon("data:image/png;base64," + bytebuf1.toString(Charsets.UTF_8));
            }
            catch (Exception exception)
            {
                logger.error((String)"Couldn\'t load server icon", (Throwable)exception);
            }
            finally
            {
                bytebuf.release();
            }
        }
    }

    public File getDataDirectory()
    {
        return new File(".");
    }

    /**
     * Called on exit from the main run() loop.
     */
    protected void finalTick(CrashReport report)
    {
    }

    /**
     * Directly calls System.exit(0), instantly killing the program.
     */
    protected void systemExitNow()
    {
    }

    /**
     * Main function called by run() every loop.
     */
    public void tick()
    {
        long i = System.nanoTime();
        ++this.tickCounter;

        if (this.startProfiling)
        {
            this.startProfiling = false;
            this.field_71304_b.field_76327_a = true;
            this.field_71304_b.clearProfiling();
        }

        this.field_71304_b.startSection("root");
        this.updateTimeLightAndEntities();

        if (i - this.nanoTimeSinceStatusRefresh >= 5000000000L)
        {
            this.nanoTimeSinceStatusRefresh = i;
            GameProfile[] agameprofile = new GameProfile[Math.min(this.func_71233_x(), 12)];
            int j = MathHelper.getRandomIntegerInRange(this.random, 0, this.func_71233_x() - agameprofile.length);

            for (int k = 0; k < agameprofile.length; ++k)
            {
            }

            Collections.shuffle(Arrays.asList(agameprofile));
        }

        if (this.tickCounter % 900 == 0)
        {
            this.field_71304_b.startSection("save");
            this.serverConfigManager.saveAllPlayerData();
            this.saveAllWorlds(true);
            this.field_71304_b.endSection();
        }

        this.field_71304_b.startSection("tallying");
        this.tickTimeArray[this.tickCounter % 100] = System.nanoTime() - i;
        this.field_71304_b.endSection();
        this.field_71304_b.startSection("snooper");

        if (!this.usageSnooper.isSnooperRunning() && this.tickCounter > 100)
        {
            this.usageSnooper.startSnooper();
        }

        if (this.tickCounter % 6000 == 0)
        {
            this.usageSnooper.addMemoryStatsToSnooper();
        }

        this.field_71304_b.endSection();
        this.field_71304_b.endSection();
    }

    public void updateTimeLightAndEntities()
    {
        this.field_71304_b.startSection("jobs");

        synchronized (this.futureTaskQueue)
        {
            while (!this.futureTaskQueue.isEmpty())
            {
            }
        }

        this.field_71304_b.endStartSection("levels");

        for (int j = 0; j < this.field_71305_c.length; ++j)
        {
            long i = System.nanoTime();

            if (j == 0 || this.getAllowNether())
            {
                WorldServer worldserver = this.field_71305_c[j];
                this.field_71304_b.startSection(worldserver.func_72912_H().getWorldName());

                if (this.tickCounter % 20 == 0)
                {
                    this.field_71304_b.startSection("timeSync");
                    this.serverConfigManager.sendPacketToAllPlayersInDimension(new S03PacketTimeUpdate(worldserver.func_82737_E(), worldserver.func_72820_D(), worldserver.func_82736_K().func_82766_b("doDaylightCycle")), worldserver.provider.getDimensionId());
                    this.field_71304_b.endSection();
                }

                this.field_71304_b.startSection("tick");

                try
                {
                    worldserver.tick();
                }
                catch (Throwable throwable1)
                {
                    CrashReport crashreport = CrashReport.makeCrashReport(throwable1, "Exception ticking world");
                    worldserver.addWorldInfoToCrashReport(crashreport);
                    throw new ReportedException(crashreport);
                }

                try
                {
                    worldserver.updateEntities();
                }
                catch (Throwable throwable)
                {
                    CrashReport crashreport1 = CrashReport.makeCrashReport(throwable, "Exception ticking world entities");
                    worldserver.addWorldInfoToCrashReport(crashreport1);
                    throw new ReportedException(crashreport1);
                }

                this.field_71304_b.endSection();
                this.field_71304_b.startSection("tracker");
                worldserver.getEntityTracker().updateTrackedEntities();
                this.field_71304_b.endSection();
                this.field_71304_b.endSection();
            }

            this.timeOfLastDimensionTick[j][this.tickCounter % 100] = System.nanoTime() - i;
        }

        this.field_71304_b.endStartSection("connection");
        this.getNetworkSystem().networkTick();
        this.field_71304_b.endStartSection("players");
        this.serverConfigManager.onTick();
        this.field_71304_b.endStartSection("tickables");

        for (int k = 0; k < this.playersOnline.size(); ++k)
        {
            ((ITickable)this.playersOnline.get(k)).update();
        }

        this.field_71304_b.endSection();
    }

    public boolean getAllowNether()
    {
        return true;
    }

    public void startServerThread()
    {
        this.serverThread = new Thread(this, "Server thread");
        this.serverThread.start();
    }

    /**
     * Returns a File object from the specified string.
     */
    public File func_71209_f(String fileName)
    {
        return new File(this.getDataDirectory(), fileName);
    }

    /**
     * Logs the message with a level of WARN.
     */
    public void logWarning(String msg)
    {
        logger.warn(msg);
    }

    /**
     * Gets the worldServer by the given dimension.
     */
    public WorldServer func_71218_a(int dimension)
    {
        return dimension == -1 ? this.field_71305_c[1] : (dimension == 1 ? this.field_71305_c[2] : this.field_71305_c[0]);
    }

    /**
     * Returns the server's Minecraft version as string.
     */
    public String getMinecraftVersion()
    {
        return "1.8.9";
    }

    /**
     * Returns the number of players currently on the server.
     */
    public int func_71233_x()
    {
        return this.serverConfigManager.getCurrentPlayerCount();
    }

    /**
     * Returns the maximum number of players allowed on the server.
     */
    public int func_71275_y()
    {
        return this.serverConfigManager.getMaxPlayers();
    }

    /**
     * Returns an array of the usernames of all the connected players.
     */
    public String[] func_71213_z()
    {
        return this.serverConfigManager.getAllUsernames();
    }

    /**
     * Returns an array of the GameProfiles of all the connected players
     */
    public GameProfile[] func_152357_F()
    {
        return this.serverConfigManager.getAllProfiles();
    }

    public String getServerModName()
    {
        return "vanilla";
    }

    /**
     * Adds the server info, including from theWorldServer, to the crash report.
     */
    public CrashReport addServerInfoToCrashReport(CrashReport report)
    {
        report.getCategory().addCrashSectionCallable("Profiler Position", new Callable<String>()
        {
            public String call() throws Exception
            {
                return MinecraftServer.this.field_71304_b.field_76327_a ? MinecraftServer.this.field_71304_b.getNameOfLastSection() : "N/A (disabled)";
            }
        });

        if (this.serverConfigManager != null)
        {
            report.getCategory().addCrashSectionCallable("Player Count", new Callable<String>()
            {
                public String call()
                {
                    return "";
                }
            });
        }

        return report;
    }

    public List<String> getTabCompletions(ICommandSender sender, String input, BlockPos pos)
    {
        List<String> list = Lists.<String>newArrayList();

        if (input.startsWith("/"))
        {
            input = input.substring(1);
            boolean flag = !input.contains(" ");
            List<String> list1 = this.commandManager.getTabCompletionOptions(sender, input, pos);

            if (list1 != null)
            {
                for (String s2 : list1)
                {
                    if (flag)
                    {
                        list.add("/" + s2);
                    }
                    else
                    {
                        list.add(s2);
                    }
                }
            }

            return list;
        }
        else
        {
            String[] astring = input.split(" ", -1);
            String s = astring[astring.length - 1];

            for (String s1 : this.serverConfigManager.getAllUsernames())
            {
                if (CommandBase.func_71523_a(s, s1))
                {
                    list.add(s1);
                }
            }

            return list;
        }
    }

    /**
     * Gets mcServer.
     */
    public static MinecraftServer func_71276_C()
    {
        return mcServer;
    }

    public boolean isAnvilFileSet()
    {
        return this.anvilFile != null;
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String func_70005_c_()
    {
        return "Server";
    }

    /**
     * Send a chat message to the CommandSender
     */
    public void func_145747_a(IChatComponent component)
    {
        logger.info(component.func_150260_c());
    }

    /**
     * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
     */
    public boolean func_70003_b(int permLevel, String commandName)
    {
        return true;
    }

    public ICommandManager func_71187_D()
    {
        return this.commandManager;
    }

    /**
     * Gets KeyPair instanced in MinecraftServer.
     */
    public KeyPair getKeyPair()
    {
        return this.serverKeyPair;
    }

    /**
     * Returns the username of the server owner (for integrated servers)
     */
    public String getServerOwner()
    {
        return this.serverOwner;
    }

    /**
     * Sets the username of the owner of this server (in the case of an integrated server)
     */
    public void setServerOwner(String owner)
    {
        this.serverOwner = owner;
    }

    public boolean func_71264_H()
    {
        return this.serverOwner != null;
    }

    public String getFolderName()
    {
        return this.folderName;
    }

    public void setFolderName(String name)
    {
        this.folderName = name;
    }

    public void setWorldName(String p_71246_1_)
    {
        this.worldName = p_71246_1_;
    }

    public String getWorldName()
    {
        return this.worldName;
    }

    public void setKeyPair(KeyPair keyPair)
    {
        this.serverKeyPair = keyPair;
    }

    public void func_147139_a(EnumDifficulty difficulty)
    {
        for (int i = 0; i < this.field_71305_c.length; ++i)
        {
            World world = this.field_71305_c[i];

            if (world != null)
            {
                if (world.func_72912_H().isHardcoreModeEnabled())
                {
                    world.func_72912_H().setDifficulty(EnumDifficulty.HARD);
                    world.setAllowedSpawnTypes(true, true);
                }
                else if (this.func_71264_H())
                {
                    world.func_72912_H().setDifficulty(difficulty);
                    world.setAllowedSpawnTypes(world.getDifficulty() != EnumDifficulty.PEACEFUL, true);
                }
                else
                {
                    world.func_72912_H().setDifficulty(difficulty);
                    world.setAllowedSpawnTypes(this.allowSpawnMonsters(), this.canSpawnAnimals);
                }
            }
        }
    }

    protected boolean allowSpawnMonsters()
    {
        return true;
    }

    /**
     * Gets whether this is a demo or not.
     */
    public boolean isDemo()
    {
        return this.isDemo;
    }

    /**
     * Sets whether this is a demo or not.
     */
    public void setDemo(boolean demo)
    {
        this.isDemo = demo;
    }

    public void canCreateBonusChest(boolean enable)
    {
        this.enableBonusChest = enable;
    }

    public ISaveFormat getActiveAnvilConverter()
    {
        return this.anvilConverterForAnvilFile;
    }

    /**
     * WARNING : directly calls
     * getActiveAnvilConverter().deleteWorldDirectory(theWorldServer[0].getSaveHandler().getWorldDirectoryName());
     */
    public void deleteWorldAndStopServer()
    {
        this.worldIsBeingDeleted = true;
        this.getActiveAnvilConverter().flushCache();

        for (int i = 0; i < this.field_71305_c.length; ++i)
        {
            WorldServer worldserver = this.field_71305_c[i];

            if (worldserver != null)
            {
                worldserver.flush();
            }
        }

        this.getActiveAnvilConverter().deleteWorldDirectory(this.field_71305_c[0].getSaveHandler().getWorldDirectoryName());
        this.initiateShutdown();
    }

    public String getResourcePackUrl()
    {
        return this.resourcePackUrl;
    }

    public String getResourcePackHash()
    {
        return this.resourcePackHash;
    }

    public void setResourcePack(String url, String hash)
    {
        this.resourcePackUrl = url;
        this.resourcePackHash = hash;
    }

    public void addServerStatsToSnooper(PlayerUsageSnooper playerSnooper)
    {
        playerSnooper.addClientStat("whitelist_enabled", Boolean.valueOf(false));
        playerSnooper.addClientStat("whitelist_count", Integer.valueOf(0));

        if (this.serverConfigManager != null)
        {
            playerSnooper.addClientStat("players_current", Integer.valueOf(this.func_71233_x()));
            playerSnooper.addClientStat("players_max", Integer.valueOf(this.func_71275_y()));
            playerSnooper.addClientStat("players_seen", Integer.valueOf(this.serverConfigManager.func_72373_m().length));
        }

        playerSnooper.addClientStat("uses_auth", Boolean.valueOf(this.onlineMode));
        playerSnooper.addClientStat("gui_state", this.getGuiEnabled() ? "enabled" : "disabled");
        playerSnooper.addClientStat("run_time", Long.valueOf((func_130071_aq() - playerSnooper.getMinecraftStartTimeMillis()) / 60L * 1000L));
        playerSnooper.addClientStat("avg_tick_ms", Integer.valueOf((int)(MathHelper.average(this.tickTimeArray) * 1.0E-6D)));
        int i = 0;

        if (this.field_71305_c != null)
        {
            for (int j = 0; j < this.field_71305_c.length; ++j)
            {
                if (this.field_71305_c[j] != null)
                {
                    WorldServer worldserver = this.field_71305_c[j];
                    WorldInfo worldinfo = worldserver.func_72912_H();
                    playerSnooper.addClientStat("world[" + i + "][dimension]", Integer.valueOf(worldserver.provider.getDimensionId()));
                    playerSnooper.addClientStat("world[" + i + "][mode]", worldinfo.getGameType());
                    playerSnooper.addClientStat("world[" + i + "][difficulty]", worldserver.getDifficulty());
                    playerSnooper.addClientStat("world[" + i + "][hardcore]", Boolean.valueOf(worldinfo.isHardcoreModeEnabled()));
                    playerSnooper.addClientStat("world[" + i + "][generator_name]", worldinfo.getTerrainType().getWorldTypeName());
                    playerSnooper.addClientStat("world[" + i + "][generator_version]", Integer.valueOf(worldinfo.getTerrainType().getGeneratorVersion()));
                    playerSnooper.addClientStat("world[" + i + "][height]", Integer.valueOf(this.buildLimit));
                    playerSnooper.addClientStat("world[" + i + "][chunks_loaded]", Integer.valueOf(worldserver.getChunkProvider().getLoadedChunkCount()));
                    ++i;
                }
            }
        }

        playerSnooper.addClientStat("worlds", Integer.valueOf(i));
    }

    public void addServerTypeToSnooper(PlayerUsageSnooper playerSnooper)
    {
        playerSnooper.addStatToSnooper("singleplayer", Boolean.valueOf(this.func_71264_H()));
        playerSnooper.addStatToSnooper("server_brand", this.getServerModName());
        playerSnooper.addStatToSnooper("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        playerSnooper.addStatToSnooper("dedicated", Boolean.valueOf(this.isDedicatedServer()));
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return true;
    }

    public abstract boolean isDedicatedServer();

    public boolean isServerInOnlineMode()
    {
        return this.onlineMode;
    }

    public void setOnlineMode(boolean online)
    {
        this.onlineMode = online;
    }

    public boolean getCanSpawnAnimals()
    {
        return this.canSpawnAnimals;
    }

    public void setCanSpawnAnimals(boolean spawnAnimals)
    {
        this.canSpawnAnimals = spawnAnimals;
    }

    public boolean getCanSpawnNPCs()
    {
        return this.canSpawnNPCs;
    }

    public abstract boolean func_181035_ah();

    public void setCanSpawnNPCs(boolean spawnNpcs)
    {
        this.canSpawnNPCs = spawnNpcs;
    }

    public boolean isPVPEnabled()
    {
        return this.pvpEnabled;
    }

    public void setAllowPvp(boolean allowPvp)
    {
        this.pvpEnabled = allowPvp;
    }

    public boolean isFlightAllowed()
    {
        return this.allowFlight;
    }

    public void setAllowFlight(boolean allow)
    {
        this.allowFlight = allow;
    }

    /**
     * Return whether command blocks are enabled.
     */
    public abstract boolean isCommandBlockEnabled();

    public String getMOTD()
    {
        return this.motd;
    }

    public void setMOTD(String motdIn)
    {
        this.motd = motdIn;
    }

    public int getBuildLimit()
    {
        return this.buildLimit;
    }

    public void setBuildLimit(int maxBuildHeight)
    {
        this.buildLimit = maxBuildHeight;
    }

    public boolean isServerStopped()
    {
        return this.serverStopped;
    }

    public ServerConfigurationManager func_71203_ab()
    {
        return this.serverConfigManager;
    }

    public void setConfigManager(ServerConfigurationManager configManager)
    {
        this.serverConfigManager = configManager;
    }

    /**
     * Sets the game type for all worlds.
     */
    public void setGameType(WorldSettings.GameType gameMode)
    {
        for (int i = 0; i < this.field_71305_c.length; ++i)
        {
            func_71276_C().field_71305_c[i].func_72912_H().setGameType(gameMode);
        }
    }

    public NetworkSystem getNetworkSystem()
    {
        return this.networkSystem;
    }

    public boolean serverIsInRunLoop()
    {
        return this.serverIsRunning;
    }

    public boolean getGuiEnabled()
    {
        return false;
    }

    /**
     * On dedicated does nothing. On integrated, sets commandsAllowedForAll, gameType and allows external connections.
     */
    public abstract String shareToLAN(WorldSettings.GameType type, boolean allowCheats);

    public int func_71259_af()
    {
        return this.tickCounter;
    }

    public void func_71223_ag()
    {
        this.startProfiling = true;
    }

    public PlayerUsageSnooper getPlayerUsageSnooper()
    {
        return this.usageSnooper;
    }

    /**
     * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    public BlockPos func_180425_c()
    {
        return BlockPos.ORIGIN;
    }

    /**
     * Get the position vector. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return 0.0D,
     * 0.0D, 0.0D
     */
    public Vec3 func_174791_d()
    {
        return new Vec3(0.0D, 0.0D, 0.0D);
    }

    /**
     * Get the world, if available. <b>{@code null} is not allowed!</b> If you are not an entity in the world, return
     * the overworld
     */
    public World func_130014_f_()
    {
        return this.field_71305_c[0];
    }

    /**
     * Returns the entity associated with the command sender. MAY BE NULL!
     */
    public Entity func_174793_f()
    {
        return null;
    }

    /**
     * Return the spawn protection area's size.
     */
    public int getSpawnProtectionSize()
    {
        return 16;
    }

    public boolean isBlockProtected(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        return false;
    }

    public boolean getForceGamemode()
    {
        return this.isGamemodeForced;
    }

    public Proxy getServerProxy()
    {
        return this.serverProxy;
    }

    public static long func_130071_aq()
    {
        return System.currentTimeMillis();
    }

    public int getMaxPlayerIdleMinutes()
    {
        return this.maxPlayerIdleMinutes;
    }

    public void func_143006_e(int idleTimeout)
    {
        this.maxPlayerIdleMinutes = idleTimeout;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public IChatComponent func_145748_c_()
    {
        return new ChatComponentText(this.func_70005_c_());
    }

    public boolean isAnnouncingPlayerAchievements()
    {
        return true;
    }

    public MinecraftSessionService getMinecraftSessionService()
    {
        return this.sessionService;
    }

    public GameProfileRepository getGameProfileRepository()
    {
        return this.profileRepo;
    }

    public PlayerProfileCache func_152358_ax()
    {
        return this.profileCache;
    }

    public ServerStatusResponse getServerStatusResponse()
    {
        return this.statusResponse;
    }

    public void refreshStatusNextTick()
    {
        this.nanoTimeSinceStatusRefresh = 0L;
    }

    public Entity func_175576_a(UUID uuid)
    {
        for (WorldServer worldserver : this.field_71305_c)
        {
            if (worldserver != null)
            {
                Entity entity = worldserver.getEntityFromUuid(uuid);

                if (entity != null)
                {
                    return entity;
                }
            }
        }

        return null;
    }

    /**
     * Returns true if the command sender should be sent feedback about executed commands
     */
    public boolean func_174792_t_()
    {
        return func_71276_C().field_71305_c[0].func_82736_K().func_82766_b("sendCommandFeedback");
    }

    public void func_174794_a(CommandResultStats.Type type, int amount)
    {
    }

    public int getMaxWorldSize()
    {
        return 29999984;
    }

    public <V> ListenableFuture<V> callFromMainThread(Callable<V> callable) throws Exception {
        return Futures.immediateFuture(callable.call());
    }

    public ListenableFuture<Object> addScheduledTask(Runnable runnableToSchedule) throws Exception {
        Validate.notNull(runnableToSchedule);
        return this.<Object>callFromMainThread(Executors.callable(runnableToSchedule));
    }

    public boolean isCallingFromMinecraftThread()
    {
        return Thread.currentThread() == this.serverThread;
    }

    /**
     * The compression treshold. If the packet is larger than the specified amount of bytes, it will be compressed
     */
    public int getNetworkCompressionTreshold()
    {
        return 256;
    }
}
