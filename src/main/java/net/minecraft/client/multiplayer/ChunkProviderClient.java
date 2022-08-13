package net.minecraft.client.multiplayer;

import net.minecraft.util.IProgressUpdate;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.BiomeGenBase;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ChunkProviderClient extends Object implements IChunkProvider {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * The completely empty chunk used by ChunkProviderClient when field_73236_b doesn't contain the requested
     * coordinates.
     */
    private Chunk blankChunk;

    /**
     *
     */
    private LongHashMap<Chunk> chunkMapping;

    /**
     *
     */
    private java.util.List<Chunk> chunkListing;

    /**
     * Reference to the World object.
     */
    private World worldObj;

    /**
     *
     */
    public ChunkProviderClient(World worldIn) {
        
    }

    /**
     * Checks to see if a chunk exists at x, z
     */
    public boolean chunkExists(int x,
                               int z) {
        return true;
    }

    /**
     * Unload chunk from ChunkProviderClient's hashmap. Called in response to a Packet50PreChunk with its mode field set
     * to false
     */
    public void unloadChunk(int p_73234_1_,
                            int p_73234_2_) {
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
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int x,
                              int z) {
        return null;
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