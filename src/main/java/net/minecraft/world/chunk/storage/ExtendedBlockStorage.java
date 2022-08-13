package net.minecraft.world.chunk.storage;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.NibbleArray;

/**
 *
 */
public class ExtendedBlockStorage extends Object {

    /**
     * Contains the bottom-most Y block represented by this ExtendedBlockStorage. Typically a multiple of 16.
     */
    private int yBase;

    /**
     * A total count of the number of non-air blocks in this block storage's Chunk.
     */
    private int blockRefCount;

    /**
     * Contains the number of blocks in this block storage's parent chunk that require random ticking. Used to cull the
     * Chunk from random tick updates for performance reasons.
     */
    private int tickRefCount;

    /**
     *
     */
    private char[] data;

    /**
     * The NibbleArray containing a block of Block-light data.
     */
    private NibbleArray blocklightArray;

    /**
     * The NibbleArray containing a block of Sky-light data.
     */
    private NibbleArray skylightArray;

    /**
     *
     */
    public ExtendedBlockStorage(int y,
                                boolean storeSkylight) {
        
    }

    /**
     *
     */
    public IBlockState get(int x,
                           int y,
                           int z) {
        return null;
    }

    /**
     *
     */
    public void set(int x,
                    int y,
                    int z,
                    IBlockState state) {
        return;
    }

    /**
     * Returns the block for a location in a chunk, with the extended ID merged from a byte array and a NibbleArray to
     * form a full 12-bit block ID.
     */
    public Block getBlockByExtId(int x,
                                 int y,
                                 int z) {
        return null;
    }

    /**
     * Returns the metadata associated with the block at the given coordinates in this ExtendedBlockStorage.
     */
    public int getExtBlockMetadata(int x,
                                   int y,
                                   int z) {
        return 0;
    }

    /**
     * Returns whether or not this block storage's Chunk is fully empty, based on its internal reference count.
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Returns whether or not this block storage's Chunk will require random ticking, used to avoid looping through
     * random block ticks when there are no blocks that would randomly tick.
     */
    public boolean getNeedsRandomTick() {
        return true;
    }

    /**
     * Returns the Y location of this ExtendedBlockStorage.
     */
    public int getYLocation() {
        return 0;
    }

    /**
     * Sets the saved Sky-light value in the extended block storage structure.
     */
    public void setExtSkylightValue(int x,
                                    int y,
                                    int z,
                                    int value) {
        return;
    }

    /**
     * Gets the saved Sky-light value in the extended block storage structure.
     */
    public int getExtSkylightValue(int x,
                                   int y,
                                   int z) {
        return 0;
    }

    /**
     * Sets the saved Block-light value in the extended block storage structure.
     */
    public void setExtBlocklightValue(int x,
                                      int y,
                                      int z,
                                      int value) {
        return;
    }

    /**
     * Gets the saved Block-light value in the extended block storage structure.
     */
    public int getExtBlocklightValue(int x,
                                     int y,
                                     int z) {
        return 0;
    }

    /**
     *
     */
    public void removeInvalidBlocks() {
        return;
    }

    /**
     *
     */
    public char[] getData() {
        return null;
    }

    /**
     *
     */
    public void setData(char[] dataArray) {
        return;
    }

    /**
     * Returns the NibbleArray instance containing Block-light data.
     */
    public NibbleArray getBlocklightArray() {
        return null;
    }

    /**
     * Returns the NibbleArray instance containing Sky-light data.
     */
    public NibbleArray getSkylightArray() {
        return null;
    }

    /**
     * Sets the NibbleArray instance used for Block-light values in this particular storage block.
     */
    public void setBlocklightArray(NibbleArray newBlocklightArray) {
        return;
    }

    /**
     * Sets the NibbleArray instance used for Sky-light values in this particular storage block.
     */
    public void setSkylightArray(NibbleArray newSkylightArray) {
        return;
    }

}