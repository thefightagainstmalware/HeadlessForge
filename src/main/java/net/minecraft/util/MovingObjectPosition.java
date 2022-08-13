package net.minecraft.util;

import net.minecraft.entity.Entity;

public class MovingObjectPosition
{
    private BlockPos blockPos;

    /** What type of ray trace hit was this? 0 = block, 1 = entity */
    public MovingObjectPosition.MovingObjectType typeOfHit;
    public EnumFacing sideHit;

    /** The vector position of the hit */
    public Vec3 hitVec;

    /** The hit entity */
    public Entity entityHit;

    public MovingObjectPosition(Vec3 hitVecIn, EnumFacing facing, BlockPos blockPosIn)
    {
        this(MovingObjectPosition.MovingObjectType.BLOCK, hitVecIn, facing, blockPosIn);
    }

    public MovingObjectPosition(Vec3 p_i45552_1_, EnumFacing facing)
    {
        this(MovingObjectPosition.MovingObjectType.BLOCK, p_i45552_1_, facing, BlockPos.ORIGIN);
    }

    public MovingObjectPosition(Entity p_i2304_1_)
    {
        this(p_i2304_1_, new Vec3(p_i2304_1_.field_70165_t, p_i2304_1_.field_70163_u, p_i2304_1_.field_70161_v));
    }

    public MovingObjectPosition(MovingObjectPosition.MovingObjectType typeOfHitIn, Vec3 hitVecIn, EnumFacing sideHitIn, BlockPos blockPosIn)
    {
        this.typeOfHit = typeOfHitIn;
        this.blockPos = blockPosIn;
        this.sideHit = sideHitIn;
        this.hitVec = new Vec3(hitVecIn.field_72450_a, hitVecIn.field_72448_b, hitVecIn.field_72449_c);
    }

    public MovingObjectPosition(Entity entityHitIn, Vec3 hitVecIn)
    {
        this.typeOfHit = MovingObjectPosition.MovingObjectType.ENTITY;
        this.entityHit = entityHitIn;
        this.hitVec = hitVecIn;
    }

    public BlockPos getBlockPos()
    {
        return this.blockPos;
    }

    public String toString()
    {
        return "HitResult{type=" + this.typeOfHit + ", blockpos=" + this.blockPos + ", f=" + this.sideHit + ", pos=" + this.hitVec + ", entity=" + this.entityHit + '}';
    }

    public static enum MovingObjectType
    {
        MISS,
        BLOCK,
        ENTITY;
    }
}
