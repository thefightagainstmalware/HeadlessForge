package net.minecraft.server.integrated;

import net.minecraft.command.ServerCommandManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import net.minecraft.util.HttpUtil;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.CryptManager;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldType;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.Util;

import java.io.File;
import java.net.Proxy;

/**
 *
 */
public class IntegratedServer extends MinecraftServer {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * The Minecraft instance.
     */
    private final Minecraft mc;

    /**
     *
     */
    private final WorldSettings theWorldSettings;

    /**
     *
     */
    private boolean isGamePaused;

    /**
     *
     */
    private boolean isPublic;

    /**
     *
     */
    private ThreadLanServerPing lanServerPing;

    /**
     *
     */
    public IntegratedServer(Minecraft mcIn) {
        super(Proxy.NO_PROXY, new File("."));
        this.mc = mcIn;
        this.theWorldSettings = null;
    }

    /**
     *
     */
    public IntegratedServer(Minecraft mcIn,
                            String folderName,
                            String worldName,
                            WorldSettings settings) {
        super(Proxy.NO_PROXY, new File(folderName));
        this.mc = mcIn;
        this.theWorldSettings = settings;
    }

    /**
     *
     */
    @Override
    protected ServerCommandManager createNewCommandManager() {
        return null;
    }

    /**
     *
     */
    @Override
    protected void loadAllWorlds(String p_71247_1_,
                                 String p_71247_2_,
                                 long seed,
                                 WorldType type,
                                 String p_71247_6_) {
        return;
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
     * Main function called by run() every loop.
     */
    @Override
    public void tick() {
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
    public java.io.File getDataDirectory() {
        return null;
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
     *
     */
    @Override
    public void func_147139_a(EnumDifficulty difficulty) {
        return;
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
     * On dedicated does nothing. On integrated, sets commandsAllowedForAll, gameType and allows external connections.
     */
    public String shareToLAN(WorldSettings.GameType type,
                                       boolean allowCheats) {
        return null;
    }

    /**
     * Saves all necessary data as preparation for stopping the server.
     */
    @Override
    public void stopServer() {
        return;
    }

    /**
     * Sets the serverRunning variable to false, in order to get the server to shut down.
     */
    @Override
    public void initiateShutdown() {
        return;
    }

    /**
     *
     */
    public void setStaticInstance() {
        return;
    }

    /**
     * Returns true if this integrated server is open to LAN
     */
    public boolean getPublic() {
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
     * Return whether command blocks are enabled.
     */
    public boolean isCommandBlockEnabled() {
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

}