package net.minecraft.world.biome;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.WorldType;

/**
 *
 */
public class WorldChunkManager extends Object {

    /**
     *
     */
    public static java.util.List<BiomeGenBase> allowedBiomes;

    /**
     *
     */
    private GenLayer genBiomes;

    /**
     * A GenLayer containing the indices into BiomeGenBase.biomeList[]
     */
    private GenLayer biomeIndexLayer;

    /**
     * The biome list.
     */
    private BiomeCache biomeCache;

    /**
     *
     */
    private java.util.List<BiomeGenBase> biomesToSpawnIn;

    /**
     *
     */
    private java.lang.String field_180301_f;

    /**
     *
     */
    protected WorldChunkManager() {
        
    }

    /**
     *
     */
    public WorldChunkManager(long seed,
                             WorldType p_i45744_3_,
                             String p_i45744_4_) {
        
    }

    /**
     *
     */
    public WorldChunkManager(World worldIn) {
        
    }

    /**
     *
     */
    public java.util.List<BiomeGenBase> getBiomesToSpawnIn() {
        return null;
    }

    /**
     * Returns the biome generator
     */
    public BiomeGenBase getBiomeGenerator(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    public BiomeGenBase getBiomeGenerator(BlockPos pos,
                                          BiomeGenBase biomeGenBaseIn) {
        return null;
    }

    /**
     * Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
     */
    public float[] getRainfall(float[] listToReuse,
                               int x,
                               int z,
                               int width,
                               int length) {
        return null;
    }

    /**
     * Return an adjusted version of a given temperature based on the y height
     */
    public float getTemperatureAtHeight(float p_76939_1_,
                                        int p_76939_2_) {
        return 0;
    }

    /**
     * Returns an array of biomes for the location input.
     */
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes,
                                                 int x,
                                                 int z,
                                                 int width,
                                                 int height) {
        return null;
    }

    /**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] oldBiomeList,
                                                 int x,
                                                 int z,
                                                 int width,
                                                 int depth) {
        return null;
    }

    /**
     * Return a list of biomes for the specified blocks. Args: listToReuse, x, y, width, length, cacheFlag (if false,
     * don't check biomeCache to avoid infinite loop in BiomeCacheBlock)
     */
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse,
                                        int x,
                                        int z,
                                        int width,
                                        int length,
                                        boolean cacheFlag) {
        return null;
    }

    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    public boolean areBiomesViable(int p_76940_1_,
                                   int p_76940_2_,
                                   int p_76940_3_,
                                   java.util.List<BiomeGenBase> p_76940_4_) {
        return true;
    }

    /**
     *
     */
    public BlockPos findBiomePosition(int x,
                                      int z,
                                      int range,
                                      java.util.List<BiomeGenBase> biomes,
                                      java.util.Random random) {
        return null;
    }

    /**
     * Calls the WorldChunkManager's biomeCache.cleanupCache()
     */
    public void cleanupCache() {
        return;
    }

    /**
     *
     */
    public GenLayer[] getModdedBiomeGenerators(WorldType worldType,
                                               long seed,
                                               GenLayer[] original) {
        return null;
    }

}