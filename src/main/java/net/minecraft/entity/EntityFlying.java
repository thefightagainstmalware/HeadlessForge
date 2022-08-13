package net.minecraft.entity;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.MathHelper;

/**
 *
 */
public abstract class EntityFlying extends EntityLiving {

    /**
     *
     */
    public EntityFlying(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    public void fall(float distance,
                     float damageMultiplier) {
        return;
    }

    /**
     *
     */
    @Override
    protected void updateFallState(double y,
                                   boolean onGroundIn,
                                   Block blockIn,
                                   BlockPos pos) {
        return;
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    @Override
    public void moveEntityWithHeading(float strafe,
                                      float forward) {
        return;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean isOnLadder() {
        return true;
    }

}