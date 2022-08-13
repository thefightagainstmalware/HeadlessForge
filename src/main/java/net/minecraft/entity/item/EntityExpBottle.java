package net.minecraft.entity.item;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityExpBottle extends EntityThrowable {

    /**
     *
     */
    public EntityExpBottle(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityExpBottle(World worldIn,
                           EntityLivingBase p_i1786_2_) {
        super(worldIn, p_i1786_2_);
    }

    /**
     *
     */
    public EntityExpBottle(World worldIn,
                           double p_i1787_2_,
                           double p_i1787_4_,
                           double p_i1787_6_) {
        super(worldIn, p_i1787_2_, p_i1787_4_, p_i1787_6_);
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    @Override
    protected float getGravityVelocity() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected float getVelocity() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected float getInaccuracy() {
        return 0;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_) {
        return;
    }

}