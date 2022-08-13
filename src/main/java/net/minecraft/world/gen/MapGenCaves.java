package net.minecraft.world.gen;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class MapGenCaves extends MapGenBase {

    /**
     *
     */
    public MapGenCaves() {
        
    }

    /**
     *
     */
    protected void func_180703_a(long p_180703_1_,
                                 int p_180703_3_,
                                 int p_180703_4_,
                                 ChunkPrimer p_180703_5_,
                                 double p_180703_6_,
                                 double p_180703_8_,
                                 double p_180703_10_) {
        return;
    }

    /**
     *
     */
    protected void func_180702_a(long p_180702_1_,
                                 int p_180702_3_,
                                 int p_180702_4_,
                                 ChunkPrimer p_180702_5_,
                                 double p_180702_6_,
                                 double p_180702_8_,
                                 double p_180702_10_,
                                 float p_180702_12_,
                                 float p_180702_13_,
                                 float p_180702_14_,
                                 int p_180702_15_,
                                 int p_180702_16_,
                                 double p_180702_17_) {
        return;
    }

    /**
     *
     */
    protected boolean func_175793_a(IBlockState p_175793_1_,
                                    IBlockState p_175793_2_) {
        return true;
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
                            boolean foundTop,
                            IBlockState state,
                            IBlockState up) {
        return;
    }

}