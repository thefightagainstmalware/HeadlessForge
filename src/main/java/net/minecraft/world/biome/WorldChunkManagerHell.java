package net.minecraft.world.biome;

import net.minecraft.util.BlockPos;

/**
 *
 */
public class WorldChunkManagerHell extends WorldChunkManager {

    /**
     * The biome generator object.
     */
    private BiomeGenBase biomeGenerator;

    /**
     * The rainfall in the world
     */
    private float rainfall;

    /**
     *
     */
    public WorldChunkManagerHell(BiomeGenBase p_i45374_1_,
                                 float p_i45374_2_) {
        
    }

    /**
     * Returns the biome generator
     */
    @Override
    public BiomeGenBase getBiomeGenerator(BlockPos pos) {
        return null;
    }

    /**
     * Returns an array of biomes for the location input.
     */
    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes,
                                                 int x,
                                                 int z,
                                                 int width,
                                                 int height) {
        return null;
    }

    /**
     * Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
     */
    @Override
    public float[] getRainfall(float[] listToReuse,
                               int x,
                               int z,
                               int width,
                               int length) {
        return null;
    }

    /**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
    @Override
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
    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse,
                                        int x,
                                        int z,
                                        int width,
                                        int length,
                                        boolean cacheFlag) {
        return null;
    }

    /**
     *
     */
    @Override
    public BlockPos findBiomePosition(int x,
                                      int z,
                                      int range,
                                      java.util.List<BiomeGenBase> biomes,
                                      java.util.Random random) {
        return null;
    }

    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    @Override
    public boolean areBiomesViable(int p_76940_1_,
                                   int p_76940_2_,
                                   int p_76940_3_,
                                   java.util.List<BiomeGenBase> p_76940_4_) {
        return true;
    }

}