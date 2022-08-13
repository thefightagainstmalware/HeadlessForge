package net.minecraft.block;

import net.minecraft.util.BlockPos;

/**
 *
 */
public class BlockEventData extends Object {

    /**
     *
     */
    private BlockPos position;

    /**
     *
     */
    private Block blockType;

    /**
     * Different for each blockID
     */
    private int eventID;

    /**
     *
     */
    private int eventParameter;

    /**
     *
     */
    public BlockEventData(BlockPos pos,
                          Block blockType,
                          int eventId,
                          int p_i45756_4_) {
        
    }

    /**
     *
     */
    public BlockPos getPosition() {
        return null;
    }

    /**
     * Get the Event ID (different for each BlockID)
     */
    public int getEventID() {
        return 0;
    }

    /**
     *
     */
    public int getEventParameter() {
        return 0;
    }

    /**
     *
     */
    public Block getBlock() {
        return null;
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
    @Override
    public String toString() {
        return null;
    }

}