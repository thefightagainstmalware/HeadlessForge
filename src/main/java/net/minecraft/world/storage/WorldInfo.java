package net.minecraft.world.storage;

import net.minecraft.util.BlockPos;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldType;
import net.minecraft.world.WorldSettings;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.GameRules;

/**
 *
 */
public class WorldInfo extends Object {

    /**
     *
     */
    public static final EnumDifficulty DEFAULT_DIFFICULTY = EnumDifficulty.NORMAL;

    /**
     * Holds the seed of the currently world.
     */
    private long randomSeed;

    /**
     *
     */
    private WorldType terrainType;

    /**
     *
     */
    private java.lang.String generatorOptions;

    /**
     * The spawn zone position X coordinate.
     */
    private int spawnX;

    /**
     * The spawn zone position Y coordinate.
     */
    private int spawnY;

    /**
     * The spawn zone position Z coordinate.
     */
    private int spawnZ;

    /**
     * Total time for this world.
     */
    private long totalTime;

    /**
     * The current world time in ticks, ranging from 0 to 23999.
     */
    private long worldTime;

    /**
     * The last time the player was in this world.
     */
    private long lastTimePlayed;

    /**
     * The size of entire save of current world on the disk, isn't exactly.
     */
    private long sizeOnDisk;

    /**
     *
     */
    private NBTTagCompound playerTag;

    /**
     *
     */
    private int dimension;

    /**
     * The name of the save defined at world creation.
     */
    private java.lang.String levelName;

    /**
     * Introduced in beta 1.3, is the save version for future control.
     */
    private int saveVersion;

    /**
     *
     */
    private int cleanWeatherTime;

    /**
     * True if it's raining, false otherwise.
     */
    private boolean raining;

    /**
     * Number of ticks until next rain.
     */
    private int rainTime;

    /**
     * Is thunderbolts failing now?
     */
    private boolean thundering;

    /**
     * Number of ticks untils next thunderbolt.
     */
    private int thunderTime;

    /**
     * The Game Type.
     */
    private WorldSettings.GameType theGameType;

    /**
     * Whether the map features (e.g. strongholds) generation is enabled or disabled.
     */
    private boolean mapFeaturesEnabled;

    /**
     * Hardcore mode flag
     */
    private boolean hardcore;

    /**
     *
     */
    private boolean allowCommands;

    /**
     *
     */
    private boolean initialized;

    /**
     *
     */
    private EnumDifficulty difficulty;

    /**
     *
     */
    private boolean difficultyLocked;

    /**
     *
     */
    private double borderCenterX;

    /**
     *
     */
    private double borderCenterZ;

    /**
     *
     */
    private double borderSize;

    /**
     *
     */
    private long borderSizeLerpTime;

    /**
     *
     */
    private double borderSizeLerpTarget;

    /**
     *
     */
    private double borderSafeZone;

    /**
     *
     */
    private double borderDamagePerBlock;

    /**
     *
     */
    private int borderWarningDistance;

    /**
     *
     */
    private int borderWarningTime;

    /**
     *
     */
    private GameRules theGameRules;

    /**
     *
     */
    private java.util.Map<java.lang.String, NBTBase> additionalProperties;

    /**
     *
     */
    protected WorldInfo() {
        
    }

    /**
     *
     */
    public WorldInfo(NBTTagCompound nbt) {
        
    }

    /**
     *
     */
    public WorldInfo(WorldSettings settings,
                     String name) {
        
    }

    /**
     *
     */
    public WorldInfo(WorldInfo worldInformation) {
        
    }

    /**
     *
     */
    public void populateFromWorldSettings(WorldSettings settings) {
        return;
    }

    /**
     * Gets the NBTTagCompound for the worldInfo
     */
    public NBTTagCompound getNBTTagCompound() {
        return null;
    }

    /**
     * Creates a new NBTTagCompound for the world, with the given NBTTag as the "Player"
     */
    public NBTTagCompound cloneNBTCompound(NBTTagCompound nbt) {
        return null;
    }

    /**
     *
     */
    private void updateTagCompound(NBTTagCompound nbt,
                                   NBTTagCompound playerNbt) {
        return;
    }

    /**
     * Returns the seed of current world.
     */
    public long getSeed() {
        return 0;
    }

    /**
     * Returns the x spawn position
     */
    public int getSpawnX() {
        return 0;
    }

    /**
     * Return the Y axis spawning point of the player.
     */
    public int getSpawnY() {
        return 0;
    }

    /**
     * Returns the z spawn position
     */
    public int getSpawnZ() {
        return 0;
    }

    /**
     *
     */
    public long func_82573_f() {
        return 0;
    }

    /**
     * Get current world time
     */
    public long getWorldTime() {
        return 0;
    }

    /**
     *
     */
    public long getSizeOnDisk() {
        return 0;
    }

    /**
     * Returns the player's NBTTagCompound to be loaded
     */
    public NBTTagCompound getPlayerNBTTagCompound() {
        return null;
    }

    /**
     * Set the x spawn position to the passed in value
     */
    public void setSpawnX(int x) {
        return;
    }

    /**
     * Sets the y spawn position
     */
    public void setSpawnY(int y) {
        return;
    }

    /**
     *
     */
    public void setWorldTotalTime(long time) {
        return;
    }

    /**
     * Set the z spawn position to the passed in value
     */
    public void setSpawnZ(int z) {
        return;
    }

    /**
     * Set current world time
     */
    public void func_72877_b(long time) {
        return;
    }

    /**
     *
     */
    public void setSpawn(BlockPos spawnPoint) {
        return;
    }

    /**
     * Get current world name
     */
    public String getWorldName() {
        return null;
    }

    /**
     *
     */
    public void setWorldName(String worldName) {
        return;
    }

    /**
     * Returns the save version of this world
     */
    public int getSaveVersion() {
        return 0;
    }

    /**
     * Sets the save version of the world
     */
    public void setSaveVersion(int version) {
        return;
    }

    /**
     * Return the last time the player was in this world.
     */
    public long getLastTimePlayed() {
        return 0;
    }

    /**
     *
     */
    public int getCleanWeatherTime() {
        return 0;
    }

    /**
     *
     */
    public void func_176142_i(int cleanWeatherTimeIn) {
        return;
    }

    /**
     * Returns true if it is thundering, false otherwise.
     */
    public boolean isThundering() {
        return true;
    }

    /**
     * Sets whether it is thundering or not.
     */
    public void func_76069_a(boolean thunderingIn) {
        return;
    }

    /**
     * Returns the number of ticks until next thunderbolt.
     */
    public int getThunderTime() {
        return 0;
    }

    /**
     * Defines the number of ticks until next thunderbolt.
     */
    public void func_76090_f(int time) {
        return;
    }

    /**
     * Returns true if it is raining, false otherwise.
     */
    public boolean func_76059_o() {
        return true;
    }

    /**
     * Sets whether it is raining or not.
     */
    public void func_76084_b(boolean isRaining) {
        return;
    }

    /**
     * Return the number of ticks until rain.
     */
    public int getRainTime() {
        return 0;
    }

    /**
     * Sets the number of ticks until rain.
     */
    public void func_76080_g(int time) {
        return;
    }

    /**
     * Gets the GameType.
     */
    public WorldSettings.GameType getGameType() {
        return null;
    }

    /**
     * Get whether the map features (e.g. strongholds) generation is enabled or disabled.
     */
    public boolean isMapFeaturesEnabled() {
        return true;
    }

    /**
     *
     */
    public void setMapFeaturesEnabled(boolean enabled) {
        return;
    }

    /**
     * Sets the GameType.
     */
    public void setGameType(WorldSettings.GameType type) {
        return;
    }

    /**
     * Returns true if hardcore mode is enabled, otherwise false
     */
    public boolean isHardcoreModeEnabled() {
        return true;
    }

    /**
     *
     */
    public void setHardcore(boolean hardcoreIn) {
        return;
    }

    /**
     *
     */
    public WorldType getTerrainType() {
        return null;
    }

    /**
     *
     */
    public void setTerrainType(WorldType type) {
        return;
    }

    /**
     *
     */
    public String getGeneratorOptions() {
        return null;
    }

    /**
     * Returns true if commands are allowed on this World.
     */
    public boolean areCommandsAllowed() {
        return true;
    }

    /**
     *
     */
    public void setAllowCommands(boolean allow) {
        return;
    }

    /**
     * Returns true if the World is initialized.
     */
    public boolean isInitialized() {
        return true;
    }

    /**
     * Sets the initialization status of the World.
     */
    public void setServerInitialized(boolean initializedIn) {
        return;
    }

    /**
     * Gets the GameRules class Instance.
     */
    public GameRules getGameRulesInstance() {
        return null;
    }

    /**
     * Returns the border center X position
     */
    public double getBorderCenterX() {
        return 0;
    }

    /**
     * Returns the border center Z position
     */
    public double getBorderCenterZ() {
        return 0;
    }

    /**
     *
     */
    public double getBorderSize() {
        return 0;
    }

    /**
     * Sets the border size
     */
    public void setBorderSize(double size) {
        return;
    }

    /**
     * Returns the border lerp time
     */
    public long getBorderLerpTime() {
        return 0;
    }

    /**
     * Sets the border lerp time
     */
    public void setBorderLerpTime(long time) {
        return;
    }

    /**
     * Returns the border lerp target
     */
    public double getBorderLerpTarget() {
        return 0;
    }

    /**
     * Sets the border lerp target
     */
    public void setBorderLerpTarget(double lerpSize) {
        return;
    }

    /**
     * Sets the border center Z position
     */
    public void getBorderCenterZ(double posZ) {
        return;
    }

    /**
     * Sets the border center X position
     */
    public void getBorderCenterX(double posX) {
        return;
    }

    /**
     * Returns the border safe zone
     */
    public double getBorderSafeZone() {
        return 0;
    }

    /**
     * Sets the border safe zone
     */
    public void setBorderSafeZone(double amount) {
        return;
    }

    /**
     * Returns the border damage per block
     */
    public double getBorderDamagePerBlock() {
        return 0;
    }

    /**
     * Sets the border damage per block
     */
    public void setBorderDamagePerBlock(double damage) {
        return;
    }

    /**
     * Returns the border warning distance
     */
    public int getBorderWarningDistance() {
        return 0;
    }

    /**
     * Returns the border warning time
     */
    public int getBorderWarningTime() {
        return 0;
    }

    /**
     * Sets the border warning distance
     */
    public void setBorderWarningDistance(int amountOfBlocks) {
        return;
    }

    /**
     * Sets the border warning time
     */
    public void setBorderWarningTime(int ticks) {
        return;
    }

    /**
     *
     */
    public EnumDifficulty getDifficulty() {
        return null;
    }

    /**
     *
     */
    public void setDifficulty(EnumDifficulty newDifficulty) {
        return;
    }

    /**
     *
     */
    public boolean isDifficultyLocked() {
        return true;
    }

    /**
     *
     */
    public void setDifficultyLocked(boolean locked) {
        return;
    }

    /**
     * Adds this WorldInfo instance to the crash report.
     */
    public void addToCrashReport(CrashReportCategory category) {
        return;
    }

    /**
     * Allow access to additional mod specific world based properties
     * Used by FML to store mod list associated with a world, and maybe an id map
     * Used by Forge to store the dimensions available to a world
     * @param additionalProperties
     */
    public void setAdditionalProperties(java.util.Map<String,NBTBase> additionalProperties) {
        return;
    }

    /**
     *
     */
    public NBTBase getAdditionalProperty(String additionalProperty) {
        return null;
    }

}