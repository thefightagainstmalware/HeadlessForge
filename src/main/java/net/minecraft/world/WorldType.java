package net.minecraft.world;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class WorldType extends Object {

    /**
     * List of world types.
     */
    public static WorldType[] worldTypes;

    /**
     * Default world type.
     */
    public static final WorldType field_77137_b = (new WorldType(0, "default", 1)).setVersioned();

    /**
     * Flat world type.
     */
    public static final WorldType FLAT = (new WorldType(1, "flat"));

    /**
     * Large Biome world Type.
     */
    public static final WorldType LARGE_BIOMES = (new WorldType(2, "largeBiomes")).setCanBeCreated(false);

    /**
     * amplified world type
     */
    public static final WorldType AMPLIFIED = (new WorldType(3, "amplified", 2)).setCanBeCreated(false);

    /**
     *
     */
    public static final WorldType CUSTOMIZED = (new WorldType(4, "customized")).setCanBeCreated(false);

    /**
     *
     */
    public static final WorldType DEBUG_WORLD = (new WorldType(5, "debug_all_block_states")).setCanBeCreated(false);

    /**
     * Default (1.1) world type.
     */
    public static final WorldType DEFAULT_1_1 = (new WorldType(6, "default_1_1", 3)).setCanBeCreated(false);

    /**
     * ID for this world type.
     */
    private final int worldTypeId;

    /**
     *
     */
    private final java.lang.String worldType;

    /**
     * The int version of the ChunkProvider that generated this world.
     */
    private final int generatorVersion;

    /**
     * Whether this world type can be generated. Normally true; set to false for out-of-date generator versions.
     */
    private boolean canBeCreated;

    /**
     * Whether this WorldType has a version or not.
     */
    private boolean isWorldTypeVersioned;

    /**
     *
     */
    private boolean hasNotificationData;

    /**
     *
     */
    private WorldType(int id,
                      String name) {
        this.worldTypeId = id;
        this.worldType = name;
        this.generatorVersion = 0;
    }

    /**
     *
     */
    private WorldType(int id,
                      String name,
                      int version) {
        this.worldTypeId = id;
        this.worldType = name;
        this.generatorVersion = version;
    }

    /**
     * Creates a new world type, the ID is hidden and should not be referenced by modders.
     * It will automatically expand the underlying workdType array if there are no IDs left.
     * @param name
     */
    public WorldType(String name) {
        this.worldType = name;
        this.worldTypeId = worldTypes.length;
        this.generatorVersion = 0;
    }

    /**
     *
     */
    public String getWorldTypeName() {
        return null;
    }

    /**
     * Gets the translation key for the name of this world type.
     */
    public String getTranslateName() {
        return null;
    }

    /**
     *
     */
    public String func_151359_c() {
        return null;
    }

    /**
     * Returns generatorVersion.
     */
    public int getGeneratorVersion() {
        return 0;
    }

    /**
     *
     */
    public WorldType getWorldTypeForGeneratorVersion(int version) {
        return null;
    }

    /**
     * Sets canBeCreated to the provided value, and returns this.
     */
    private WorldType setCanBeCreated(boolean enable) {
        return null;
    }

    /**
     * Gets whether this WorldType can be used to generate a new world.
     */
    public boolean getCanBeCreated() {
        return true;
    }

    /**
     * Flags this world type as having an associated version.
     */
    private WorldType setVersioned() {
        return null;
    }

    /**
     * Returns true if this world Type has a version associated with it.
     */
    public boolean isVersioned() {
        return true;
    }

    /**
     *
     */
    public static WorldType parseWorldType(String type) {
        return null;
    }

    /**
     *
     */
    public int getWorldTypeID() {
        return 0;
    }

    /**
     * returns true if selecting this worldtype from the customize menu should display the generator.[worldtype].info
     * message
     */
    public boolean showWorldInfoNotice() {
        return true;
    }

    /**
     * enables the display of generator.[worldtype].info message on the customize world menu
     */
    private WorldType setNotificationData() {
        return null;
    }

    /**
     *
     */
    public WorldChunkManager getChunkManager(World world) {
        return null;
    }

    /**
     *
     */
    public IChunkProvider getChunkGenerator(World world,
                                            String generatorOptions) {
        return null;
    }

    /**
     *
     */
    public int getMinimumSpawnHeight(World world) {
        return 0;
    }

    /**
     *
     */
    public double getHorizon(World world) {
        return 0;
    }

    /**
     *
     */
    public double voidFadeMagnitude() {
        return 0;
    }

    /**
     *
     */
    public boolean handleSlimeSpawnReduction(java.util.Random random,
                                             World world) {
        return true;
    }

    /**
     *
     */
    private static int getNextID() {
        return 0;
    }

    /**
     * Called when 'Create New World' button is pressed before starting game
     */
    public void onGUICreateWorldPress() {
        return;
    }

    /**
     * Gets the spawn fuzz for players who join the world.
     * Useful for void world types.
     * @return Fuzz for entity initial spawn in blocks.
     */
    public int getSpawnFuzz() {
        return 0;
    }

    /**
     * Called when the 'Customize' button is pressed on world creation GUI
     * @param mc The Minecraft instance
     * @param guiCreateWorld the createworld GUI
     */
    public void onCustomizeButton(Minecraft mc,
                                  GuiCreateWorld guiCreateWorld) {
        return;
    }

    /**
     * Should world creation GUI show 'Customize' button for this world type?
     * @return if this world type has customization parameters
     */
    public boolean isCustomizable() {
        return true;
    }

    /**
     * Get the height to render the clouds for this world type
     * @return The height to render clouds at
     */
    public float getCloudHeight() {
        return 0;
    }

    /**
     * Creates the GenLayerBiome used for generating the world with the specified ChunkProviderSettings JSON String
     * *IF AND ONLY IF* this WorldType == WorldType.CUSTOMIZED.
     * @param worldSeed The world seed
     * @param parentLayer The parent layer to feed into any layer you return
     * @param chunkProviderSettingsJson The JSON string to use when initializing ChunkProviderSettings.Factory
     * @return A GenLayer that will return ints representing the Biomes to be generated, see GenLayerBiome
     */
    public GenLayer getBiomeLayer(long worldSeed,
                                  GenLayer parentLayer,
                                  String chunkProviderSettingsJson) {
        return null;
    }

}