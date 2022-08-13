package net.minecraft.client.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class MovingObjectPosition extends Object {

    /**
     *
     */
    private BlockPos blockPos;

    /**
     * What type of ray trace hit was this? 0 = block, 1 = entity
     */
    public MovingObjectPosition.MovingObjectType typeOfHit;

    /**
     *
     */
    public EnumFacing sideHit;

    /**
     * The vector position of the hit
     */
    public Vec3 hitVec;

    /**
     * The hit entity
     */
    public Entity entityHit;

    /**
     * Used to determine what sub-segment is hit
     */
    public int subHit;

    /**
     * Used to add extra hit info
     */
    public java.lang.Object hitInfo;

    /**
     *
     */
    public MovingObjectPosition(Vec3 hitVecIn,
                                EnumFacing facing,
                                BlockPos blockPosIn) {
        
    }

    /**
     *
     */
    public MovingObjectPosition(Vec3 p_i45552_1_,
                                EnumFacing facing) {
        
    }

    /**
     *
     */
    public MovingObjectPosition(Entity p_i2304_1_) {
        
    }

    /**
     *
     */
    public MovingObjectPosition(MovingObjectPosition.MovingObjectType typeOfHitIn,
                                Vec3 hitVecIn,
                                EnumFacing sideHitIn,
                                BlockPos blockPosIn) {
        
    }

    /**
     *
     */
    public MovingObjectPosition(Entity entityHitIn,
                                Vec3 hitVecIn) {
        
    }

    /**
     *
     */
    public BlockPos getBlockPos() {
        return null;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

    public class MovingObjectType {
    }
}