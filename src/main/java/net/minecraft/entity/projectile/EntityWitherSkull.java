package net.minecraft.entity.projectile;

import net.minecraft.world.Explosion;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityWitherSkull extends EntityFireball {

    /**
     *
     */
    public EntityWitherSkull(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityWitherSkull(World worldIn,
                             EntityLivingBase shooter,
                             double accelX,
                             double accelY,
                             double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    /**
     *
     */
    public EntityWitherSkull(World worldIn,
                             double x,
                             double y,
                             double z,
                             double accelX,
                             double accelY,
                             double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    /**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    @Override
    protected float getMotionFactor() {
        return 0;
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    @Override
    public boolean isBurning() {
        return true;
    }

    /**
     * Explosion resistance of a block relative to this entity
     */
    @Override
    public float getExplosionResistance(Explosion explosionIn,
                                        World worldIn,
                                        BlockPos pos,
                                        IBlockState blockStateIn) {
        return 0;
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

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * Return whether this skull comes from an invulnerable (aura) wither boss.
     */
    public boolean isInvulnerable() {
        return true;
    }

    /**
     * Set whether this skull comes from an invulnerable (aura) wither boss.
     */
    public void setInvulnerable(boolean invulnerable) {
        return;
    }

}