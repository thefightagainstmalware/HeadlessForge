package net.minecraft.world.gen;

import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.World;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ChunkProviderServer extends Object implements IChunkProvider {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private java.util.Set<java.lang.Long> droppedChunksSet;

    /**
     * a dummy chunk, returned in place of an actual chunk.
     */
    private Chunk dummyChunk;

    /**
     * chunk generator object. Calls to load nonexistent chunks are forwarded to this object.
     */
    public IChunkProvider serverChunkGenerator;

    /**
     *
     */
    public IChunkLoader chunkLoader;

    /**
     * if set, this flag forces a request to load a chunk to load the chunk rather than defaulting to the dummy if
     * possible
     */
    public boolean chunkLoadOverride;

    /**
     *
     */
    public LongHashMap<Chunk> id2ChunkMap;

    /**
     *
     */
    public java.util.List<Chunk> loadedChunks;

    /**
     *
     */
    public WorldServer worldObj;

    /**
     *
     */
    private java.util.Set<java.lang.Long> loadingChunks;

    /**
     *
     */
    public ChunkProviderServer(WorldServer p_i1520_1_,
                               IChunkLoader p_i1520_2_,
                               IChunkProvider p_i1520_3_) {
        
    }

    /**
     * Checks to see if a chunk exists at x, z
     */
    public boolean chunkExists(int x,
                               int z) {
        return true;
    }

    /**
     *
     */
    public java.util.List<Chunk> func_152380_a() {
        return null;
    }

    /**
     *
     */
    public void dropChunk(int x,
                          int z) {
        return;
    }

    /**
     * marks all chunks for unload, ignoring those near the spawn
     */
    public void unloadAllChunks() {
        return;
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int p_73158_1_,
                           int p_73158_2_) {
        return null;
    }

    /**
     *
     */
    public Chunk loadChunk(int par1,
                           int par2,
                           Runnable runnable) {
        return null;
    }

    /**
     *
     */
    public Chunk originalLoadChunk(int p_73158_1_,
                                   int p_73158_2_) {
        return null;
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
     *
     */
    private Chunk loadChunkFromFile(int x,
                                    int z) {
        return null;
    }

    /**
     *
     */
    private void saveChunkExtraData(Chunk p_73243_1_) {
        return;
    }

    /**
     *
     */
    private void saveChunkData(Chunk p_73242_1_) {
        return;
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