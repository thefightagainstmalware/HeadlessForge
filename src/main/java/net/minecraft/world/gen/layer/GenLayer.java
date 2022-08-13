package net.minecraft.world.gen.layer;

import net.minecraft.world.WorldType;

/**
 *
 */
public abstract class GenLayer extends Object {

    /**
     * seed from World#getWorldSeed that is used in the LCG prng
     */
    private long worldGenSeed;

    /**
     * parent GenLayer that was provided via the constructor
     */
    protected GenLayer parent;

    /**
     * final part of the LCG prng that uses the chunk X, Z coords along with the other two seeds to generate
     * pseudorandom numbers
     */
    private long chunkSeed;

    /**
     * base seed to the LCG prng provided via the constructor
     */
    protected long baseSeed;

    /**
     *
     */
    public GenLayer(long p_i2125_1_) {
        
    }

    /**
     *
     */
    public static GenLayer[] initializeAllBiomeGenerators(long seed,
                                                          WorldType p_180781_2_,
                                                          String p_180781_3_) {
        return null;
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    public void initWorldGenSeed(long seed) {
        return;
    }

    /**
     * Initialize layer's current chunkSeed based on the local worldGenSeed and the (x,z) chunk coordinates.
     */
    public void initChunkSeed(long p_75903_1_,
                              long p_75903_3_) {
        return;
    }

    /**
     * returns a LCG pseudo random number from [0, x). Args: int x
     */
    protected int nextInt(int p_75902_1_) {
        return 0;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public abstract int[] getInts(int areaX,
                                  int areaY,
                                  int areaWidth,
                                  int areaHeight);

    /**
     *
     */
    protected static boolean biomesEqualOrMesaPlateau(int biomeIDA,
                                                      int biomeIDB) {
        return true;
    }

    /**
     * returns true if the biomeId is one of the various ocean biomes.
     */
    protected static boolean isBiomeOceanic(int p_151618_0_) {
        return true;
    }

    /**
     * selects a random integer from a set of provided integers
     */
    protected int selectRandom(int... p_151619_1_) {
        return 0;
    }

    /**
     * returns the most frequently occurring number of the set, or a random number from those provided
     */
    protected int selectModeOrRandom(int p_151617_1_,
                                     int p_151617_2_,
                                     int p_151617_3_,
                                     int p_151617_4_) {
        return 0;
    }

    /**
     *
     */
    protected long nextLong(long par1) {
        return 0;
    }

    /**
     *
     */
    public static int getModdedBiomeSize(WorldType worldType,
                                         int original) {
        return 0;
    }

}