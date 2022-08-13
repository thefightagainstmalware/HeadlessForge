package net.minecraft.server.dedicated;

import com.google.common.collect.Lists;
import net.minecraft.util.IChatComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.server.ServerEula;
import net.minecraft.network.rcon.RConThreadMain;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.network.rcon.IServer;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.World;
import net.minecraft.command.ServerCommand;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.CryptManager;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;
import net.minecraft.network.rcon.RConThreadQuery;

import java.net.Proxy;

/**
 *
 */
public class DedicatedServer extends MinecraftServer implements IServer {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    public final java.util.List<ServerCommand> pendingCommandList = Lists.newArrayList();

    /**
     *
     */
    private RConThreadQuery theRConThreadQuery;

    /**
     *
     */
    private RConThreadMain theRConThreadMain;

    /**
     *
     */
    private PropertyManager settings;

    /**
     *
     */
    private ServerEula eula;

    /**
     *
     */
    private boolean canSpawnStructures;

    /**
     *
     */
    private WorldSettings.GameType gameType;

    /**
     *
     */
    private boolean guiIsEnabled;

    /**
     *
     */
    public static boolean allowPlayerLogins;

    /**
     *
     */
    public DedicatedServer(java.io.File workDir) {
        super(Proxy.NO_PROXY, workDir);
    }

    /**
     * Initialises the server and starts it.
     * @throws java.io.IOException
     */
    protected boolean startServer()
                           throws java.io.IOException {
        return true;
    }

    /**
     * Sets the game type for all worlds.
     */
    @Override
    public void setGameType(WorldSettings.GameType gameMode) {
        return;
    }

    /**
     *
     */
    public boolean canStructuresSpawn() {
        return true;
    }

    /**
     *
     */
    public WorldSettings.GameType getGameType() {
        return null;
    }

    /**
     * Get the server's difficulty
     */
    public EnumDifficulty getDifficulty() {
        return null;
    }

    /**
     * Defaults to false.
     */
    public boolean isHardcore() {
        return true;
    }

    /**
     * Called on exit from the main run() loop.
     */
    @Override
    protected void finalTick(CrashReport report) {
        return;
    }

    /**
     * Adds the server info, including from theWorldServer, to the crash report.
     */
    @Override
    public CrashReport addServerInfoToCrashReport(CrashReport report) {
        return null;
    }

    /**
     * Directly calls System.exit(0), instantly killing the program.
     */
    @Override
    protected void systemExitNow() {
        return;
    }

    /**
     *
     */
    @Override
    public void updateTimeLightAndEntities() {
        return;
    }

    /**
     *
     */
    @Override
    public boolean getAllowNether() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean allowSpawnMonsters() {
        return true;
    }

    /**
     *
     */
    @Override
    public void addServerStatsToSnooper(PlayerUsageSnooper playerSnooper) {
        return;
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    @Override
    public boolean isSnooperEnabled() {
        return true;
    }

    /**
     *
     */
    public void addPendingCommand(String input,
                                  ICommandSender sender) {
        return;
    }

    /**
     *
     */
    public void executePendingCommands() {
        return;
    }

    /**
     *
     */
    public boolean isDedicatedServer() {
        return true;
    }

    @Override
    public boolean func_181035_ah() {
        return false;
    }

    /**
     * Get if native transport should be used. Native transport means linux server performance improvements and
     * optimized packet sending/receiving on linux
     */
    public boolean shouldUseNativeTransport() {
        return true;
    }

    /**
     *
     */
    @Override
    public DedicatedPlayerList func_71203_ab() {
        return null;
    }

    /**
     * Gets an integer property. If it does not exist, set it to the specified value.
     */
    public int getIntProperty(String key,
                              int defaultValue) {
        return 0;
    }

    /**
     * Gets a string property. If it does not exist, set it to the specified value.
     */
    public String getStringProperty(String key,
                                              String defaultValue) {
        return null;
    }

    /**
     * Gets a boolean property. If it does not exist, set it to the specified value.
     */
    public boolean getBooleanProperty(String key,
                                      boolean defaultValue) {
        return true;
    }

    /**
     * Saves an Object with the given property name.
     */
    public void setProperty(String key,
                            Object value) {
        return;
    }

    /**
     * Saves all of the server properties to the properties file.
     */
    public void saveProperties() {
        return;
    }

    /**
     * Returns the filename where server properties are stored
     */
    public String getSettingsFilename() {
        return null;
    }

    /**
     * Returns the server's hostname.
     */
    public String getHostname() {
        return null;
    }

    /**
     * Never used, but "getServerPort" is already taken.
     */
    public int getPort() {
        return 0;
    }

    /**
     * Returns the server message of the day
     */
    public String getMotd() {
        return null;
    }

    /**
     *
     */
    public void setGuiEnabled() {
        return;
    }

    /**
     *
     */
    @Override
    public boolean getGuiEnabled() {
        return true;
    }

    /**
     * On dedicated does nothing. On integrated, sets commandsAllowedForAll, gameType and allows external connections.
     */
    public String shareToLAN(WorldSettings.GameType type,
                                       boolean allowCheats) {
        return null;
    }

    /**
     * Return whether command blocks are enabled.
     */
    public boolean isCommandBlockEnabled() {
        return true;
    }

    /**
     * Return the spawn protection area's size.
     */
    @Override
    public int getSpawnProtectionSize() {
        return 0;
    }

    /**
     *
     */
    @Override
    public boolean isBlockProtected(World worldIn,
                                    BlockPos pos,
                                    EntityPlayer playerIn) {
        return true;
    }

    /**
     *
     */
    public int getOpPermissionLevel() {
        return 0;
    }

    @Override
    public boolean func_181034_q() {
        return false;
    }

    @Override
    public boolean func_183002_r() {
        return false;
    }

    /**
     *
     */
    @Override
    public void func_143006_e(int idleTimeout) {
        return;
    }

    /**
     * Get if RCON command events should be broadcast to ops
     */
    public boolean shouldBroadcastRconToOps() {
        return true;
    }

    /**
     * Get if console command events should be broadcast to ops
     */
    public boolean shouldBroadcastConsoleToOps() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean isAnnouncingPlayerAchievements() {
        return true;
    }

    /**
     *
     */
    @Override
    public int getMaxWorldSize() {
        return 0;
    }

    /**
     * The compression treshold. If the packet is larger than the specified amount of bytes, it will be compressed
     */
    @Override
    public int getNetworkCompressionTreshold() {
        return 0;
    }

    /**
     *
     * @throws java.io.IOException
     */
    protected boolean convertFiles()
                            throws java.io.IOException {
        return true;
    }

    /**
     *
     */
    private void sleepFiveSeconds() {
        return;
    }

    /**
     *
     */
    public long getMaxTickTime() {
        return 0;
    }

    /**
     * Used by RCon's Query in the form of "MajorServerMod 1.2.3: MyPlugin 1.3; AnotherPlugin 2.1; AndSoForth 1.0".
     */
    public String getPlugins() {
        return null;
    }

    /**
     * Handle a command received by an RCon instance
     */
    public String handleRConCommand(String command) {
        return null;
    }

    /**
     * Returns true if debugging is enabled, false otherwise.
     */
    public boolean isDebuggingEnabled() {
        return false;
    }

    /**
     * Logs the message with a level of INFO.
     *
     * @param msg
     */
    public void logInfo(String msg) {
        logger.info(msg);
    }

    /**
     * Logs the error message with a level of SEVERE.
     *
     * @param msg
     */
    public void logSevere(String msg) {
        logger.fatal(msg);
    }

    /**
     * If isDebuggingEnabled(), logs the message with a level of INFO.
     *
     * @param msg
     */
    public void logDebug(String msg) {
        if (isDebuggingEnabled()) {
            logger.info(msg);
        }
    }

    /**
     * Send a chat message to the CommandSender
     */
    @Override
    public void func_145747_a(IChatComponent message) {
        return;
    }

    @Override
    public int func_71327_a(String p_71327_1_, int p_71327_2_) {
        return 0;
    }

    @Override
    public String func_71330_a(String p_71330_1_, String p_71330_2_) {
        return null;
    }

    @Override
    public void func_71328_a(String p_71328_1_, Object p_71328_2_) {

    }

    @Override
    public void func_71326_a() {

    }

    @Override
    public String func_71329_c() {
        return null;
    }

    @Override
    public String func_71277_t() {
        return null;
    }

    @Override
    public int func_71234_u() {
        return 0;
    }

    @Override
    public String func_71274_v() {
        return null;
    }

    @Override
    public String func_71249_w() {
        return null;
    }

    @Override
    public int func_71233_x() {
        return 0;
    }

    @Override
    public int func_71275_y() {
        return 0;
    }

    @Override
    public String[] func_71213_z() {
        return new String[0];
    }

    @Override
    public String func_71270_I() {
        return null;
    }

    @Override
    public String func_71258_A() {
        return null;
    }

    @Override
    public String func_71252_i(String p_71252_1_) {
        return null;
    }

    @Override
    public boolean func_71239_B() {
        return false;
    }

    @Override
    public void func_71244_g(String p_71244_1_) {

    }

    @Override
    public void func_71236_h(String p_71236_1_) {

    }

    @Override
    public void func_71201_j(String p_71201_1_) {

    }

    @Override
    public void func_71198_k(String p_71198_1_) {

    }
}