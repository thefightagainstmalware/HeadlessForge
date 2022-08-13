package net.minecraft.world;

import net.minecraft.util.BlockPos;

/**
 *
 */
public class ChunkCoordIntPair extends Object {

    /**
     * The X position of this Chunk Coordinate Pair
     */
    public final int chunkXPos;

    /**
     * The Z position of this Chunk Coordinate Pair
     */
    public final int chunkZPos;

    /**
     *
     */
    public ChunkCoordIntPair(int x,
                             int z) {
        this.chunkXPos = x;
        this.chunkZPos = z;
    }

    /**
     * converts a chunk coordinate pair to an integer (suitable for hashing)
     */
    public static long chunkXZ2Int(int x,
                                   int z) {
        return 0;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     *
     */
    public int getCenterXPos() {
        return 0;
    }

    /**
     *
     */
    public int getCenterZPosition() {
        return 0;
    }

    /**
     * Get the first world X coordinate that belongs to this Chunk
     */
    public int getXStart() {
        return 0;
    }

    /**
     * Get the first world Z coordinate that belongs to this Chunk
     */
    public int getZStart() {
        return 0;
    }

    /**
     * Get the last world X coordinate that belongs to this Chunk
     */
    public int getXEnd() {
        return 0;
    }

    /**
     * Get the last world Z coordinate that belongs to this Chunk
     */
    public int getZEnd() {
        return 0;
    }

    /**
     * Get the World coordinates of the Block with the given Chunk coordinates relative to this chunk
     */
    public BlockPos getBlock(int x,
                             int y,
                             int z) {
        return null;
    }

    /**
     * Get the coordinates of the Block in the center of this chunk with the given Y coordinate
     */
    public BlockPos getCenterBlock(int y) {
        return null;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

}