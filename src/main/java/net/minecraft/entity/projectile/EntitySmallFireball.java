package net.minecraft.entity.projectile;

import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntitySmallFireball extends EntityFireball {

    /**
     *
     */
    public EntitySmallFireball(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntitySmallFireball(World worldIn,
                               EntityLivingBase shooter,
                               double accelX,
                               double accelY,
                               double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    /**
     *
     */
    public EntitySmallFireball(World worldIn,
                               double x,
                               double y,
                               double z,
                               double accelX,
                               double accelY,
                               double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition movingObject) {
        return;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source,
                                    float amount) {
        return true;
    }

}