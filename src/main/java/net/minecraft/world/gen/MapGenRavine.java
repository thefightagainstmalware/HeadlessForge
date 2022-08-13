package net.minecraft.world.gen;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

/**
 *
 */
public class MapGenRavine extends MapGenBase {

    /**
     *
     */
    private float[] field_75046_d;

    /**
     *
     */
    public MapGenRavine() {
        
    }

    /**
     *
     */
    protected void func_180707_a(long p_180707_1_,
                                 int p_180707_3_,
                                 int p_180707_4_,
                                 ChunkPrimer p_180707_5_,
                                 double p_180707_6_,
                                 double p_180707_8_,
                                 double p_180707_10_,
                                 float p_180707_12_,
                                 float p_180707_13_,
                                 float p_180707_14_,
                                 int p_180707_15_,
                                 int p_180707_16_,
                                 double p_180707_17_) {
        return;
    }

    /**
     * Recursively called by generate()
     */
    @Override
    protected void recursiveGenerate(World worldIn,
                                     int chunkX,
                                     int chunkZ,
                                     int p_180701_4_,
                                     int p_180701_5_,
                                     ChunkPrimer chunkPrimerIn) {
        return;
    }

    /**
     *
     */
    protected boolean isOceanBlock(ChunkPrimer data,
                                   int x,
                                   int y,
                                   int z,
                                   int chunkX,
                                   int chunkZ) {
        return true;
    }

    /**
     *
     */
    private boolean isExceptionBiome(BiomeGenBase biome) {
        return true;
    }

    /**
     *
     */
    private boolean isTopBlock(ChunkPrimer data,
                               int x,
                               int y,
                               int z,
                               int chunkX,
                               int chunkZ) {
        return true;
    }

    /**
     * Digs out the current block, default implementation removes stone, filler, and top block
     * Sets the block to lava if y is less then 10, and air other wise.
     * If setting to air, it also checks to see if we've broken the surface and if so
     * tries to make the floor the biome's top block
     * @param data Block data array
     * @param index Pre-calculated index into block data
     * @param x local X position
     * @param y local Y position
     * @param z local Z position
     * @param chunkX Chunk X position
     * @param chunkZ Chunk Y position
     * @param foundTop True if we've encountered the biome's top block. Ideally if we've broken the surface.
     */
    protected void digBlock(ChunkPrimer data,
                            int x,
                            int y,
                            int z,
                            int chunkX,
                            int chunkZ,
                            boolean foundTop) {
        return;
    }

}