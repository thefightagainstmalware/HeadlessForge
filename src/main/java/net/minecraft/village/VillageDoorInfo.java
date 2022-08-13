package net.minecraft.village;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class VillageDoorInfo extends Object {

    /**
     * a block representing the door. Could be either upper or lower part
     */
    private final BlockPos doorBlockPos;

    /**
     *
     */
    private final BlockPos insideBlock;

    /**
     * the inside direction is where can see less sky
     */
    private final EnumFacing insideDirection;

    /**
     *
     */
    private int lastActivityTimestamp;

    /**
     *
     */
    private boolean isDetachedFromVillageFlag;

    /**
     *
     */
    private int doorOpeningRestrictionCounter;

    /**
     *
     */
    public VillageDoorInfo(BlockPos p_i45871_1_,
                           int p_i45871_2_,
                           int p_i45871_3_,
                           int p_i45871_4_) {
        this(p_i45871_1_, EnumFacing.getFront(p_i45871_2_), p_i45871_3_);
    }

    /**
     *
     */
    public VillageDoorInfo(BlockPos p_i45872_1_,
                           EnumFacing p_i45872_2_,
                           int p_i45872_3_) {
        this.doorBlockPos = p_i45872_1_;
        this.insideBlock = p_i45872_1_.offset(p_i45872_2_);
        this.insideDirection = p_i45872_2_;
    }

    /**
     *
     */
    private static EnumFacing getFaceDirection(int deltaX,
                                               int deltaZ) {
        return null;
    }

    /**
     * Returns the squared distance between this door and the given coordinate.
     */
    public int getDistanceSquared(int p_75474_1_,
                                  int p_75474_2_,
                                  int p_75474_3_) {
        return 0;
    }

    /**
     *
     */
    public int getDistanceToDoorBlockSq(BlockPos p_179848_1_) {
        return 0;
    }

    /**
     *
     */
    public int getDistanceToInsideBlockSq(BlockPos p_179846_1_) {
        return 0;
    }

    /**
     *
     */
    public boolean func_179850_c(BlockPos p_179850_1_) {
        return true;
    }

    /**
     *
     */
    public void resetDoorOpeningRestrictionCounter() {
        return;
    }

    /**
     *
     */
    public void incrementDoorOpeningRestrictionCounter() {
        return;
    }

    /**
     *
     */
    public int getDoorOpeningRestrictionCounter() {
        return 0;
    }

    /**
     *
     */
    public BlockPos getDoorBlockPos() {
        return null;
    }

    /**
     *
     */
    public BlockPos getInsideBlockPos() {
        return null;
    }

    /**
     *
     */
    public int getInsideOffsetX() {
        return 0;
    }

    /**
     *
     */
    public int getInsideOffsetZ() {
        return 0;
    }

    /**
     *
     */
    public int getInsidePosY() {
        return 0;
    }

    /**
     *
     */
    public void func_179849_a(int p_179849_1_) {
        return;
    }

    /**
     *
     */
    public boolean getIsDetachedFromVillageFlag() {
        return true;
    }

    /**
     *
     */
    public void setIsDetachedFromVillageFlag(boolean p_179853_1_) {
        return;
    }

}