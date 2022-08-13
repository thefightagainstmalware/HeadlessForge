package net.minecraft.world.gen;

import net.minecraft.util.IProgressUpdate;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

/**
 *
 */
public class ChunkProviderEnd extends Object implements IChunkProvider {

    /**
     *
     */
    private java.util.Random endRNG;

    /**
     *
     */
    private NoiseGeneratorOctaves noiseGen1;

    /**
     *
     */
    private NoiseGeneratorOctaves noiseGen2;

    /**
     *
     */
    private NoiseGeneratorOctaves noiseGen3;

    /**
     *
     */
    public NoiseGeneratorOctaves noiseGen4;

    /**
     *
     */
    public NoiseGeneratorOctaves noiseGen5;

    /**
     *
     */
    private World endWorld;

    /**
     *
     */
    private double[] densities;

    /**
     * The biomes that are used to generate the chunk
     */
    private BiomeGenBase[] biomesForGeneration;

    /**
     *
     */
    double[] noiseData1;

    /**
     *
     */
    double[] noiseData2;

    /**
     *
     */
    double[] noiseData3;

    /**
     *
     */
    double[] noiseData4;

    /**
     *
     */
    double[] noiseData5;

    /**
     *
     */
    private int chunkX;

    /**
     *
     */
    private int chunkZ;

    /**
     *
     */
    public ChunkProviderEnd(World worldIn,
                            long p_i2007_2_) {
        
    }

    /**
     *
     */
    public void func_180520_a(int p_180520_1_,
                              int p_180520_2_,
                              ChunkPrimer p_180520_3_) {
        return;
    }

    /**
     *
     */
    public void func_180519_a(ChunkPrimer p_180519_1_) {
        return;
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int x,
                              int z) {
        return null;
    }

    /**
     * generates a subset of the level's terrain data. Takes 7 arguments: the [empty] noise array, the position, and the
     * size.
     */
    private double[] initializeNoiseField(double[] p_73187_1_,
                                          int p_73187_2_,
                                          int p_73187_3_,
                                          int p_73187_4_,
                                          int p_73187_5_,
                                          int p_73187_6_,
                                          int p_73187_7_) {
        return null;
    }

    /**
     * Checks to see if a chunk exists at x, z
     */
    public boolean chunkExists(int x,
                               int z) {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider p_73153_1_,
                         int p_73153_2_,
                         int p_73153_3_) {
        return;
    }

    /**
     *
     */
    public boolean func_177460_a(IChunkProvider p_177460_1_,
                                 Chunk p_177460_2_,
                                 int p_177460_3_,
                                 int p_177460_4_) {
        return true;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean p_73151_1_,
                              IProgressUpdate progressCallback) {
        return true;
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unimplemented.
     */
    public void saveExtraData() {
        return;
    }

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks() {
        return true;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave() {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString() {
        return null;
    }

    /**
     *
     */
    public java.util.List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType,
                                                                            BlockPos pos) {
        return null;
    }

    /**
     *
     */
    public BlockPos getStrongholdGen(World worldIn,
                                     String structureName,
                                     BlockPos position) {
        return null;
    }

    /**
     *
     */
    public int getLoadedChunkCount() {
        return 0;
    }

    /**
     *
     */
    public void recreateStructures(Chunk p_180514_1_,
                                   int p_180514_2_,
                                   int p_180514_3_) {
        return;
    }

    /**
     *
     */
    public Chunk provideChunk(BlockPos blockPosIn) {
        return null;
    }

}