package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class NextTickListEntry extends Object implements Comparable<NextTickListEntry> {

    /**
     * The id number for the next tick entry
     */
    private static long nextTickEntryID;

    /**
     *
     */
    private final Block block;

    /**
     *
     */
    public final BlockPos field_180282_a;

    /**
     * Time this tick is scheduled to occur at
     */
    public long field_77180_e;

    /**
     *
     */
    public int field_82754_f;

    /**
     * The id of the tick entry
     */
    private long tickEntryID;

    /**
     *
     */
    public NextTickListEntry(BlockPos p_i45745_1_,
                             Block p_i45745_2_) {
        this.block = p_i45745_2_;
        this.field_180282_a = p_i45745_1_;
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
    public int hashCode() {
        return 0;
    }

    /**
     * Sets the scheduled time for this tick entry
     */
    public NextTickListEntry setScheduledTime(long p_77176_1_) {
        return null;
    }

    /**
     *
     */
    public void setPriority(int p_82753_1_) {
        return;
    }

    /**
     *
     */
    public int compareTo(NextTickListEntry p_compareTo_1_) {
        return 0;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     *
     */
    public Block func_151351_a() {
        return null;
    }

}