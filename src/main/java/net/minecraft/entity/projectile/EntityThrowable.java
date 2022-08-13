package net.minecraft.entity.projectile;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.IProjectile;
import net.minecraft.block.Block;
import net.minecraft.util.MovingObjectPosition;

/**
 *
 */
public abstract class EntityThrowable extends Entity implements IProjectile {

    /**
     *
     */
    private int xTile;

    /**
     *
     */
    private int yTile;

    /**
     *
     */
    private int zTile;

    /**
     *
     */
    private Block inTile;

    /**
     *
     */
    protected boolean inGround;

    /**
     *
     */
    public int throwableShake;

    /**
     * The entity that threw this throwable item.
     */
    private EntityLivingBase thrower;

    /**
     *
     */
    private java.lang.String throwerName;

    /**
     *
     */
    private int ticksInGround;

    /**
     *
     */
    private int ticksInAir;

    /**
     *
     */
    public EntityThrowable(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityThrowable(World worldIn,
                           EntityLivingBase throwerIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityThrowable(World worldIn,
                           double x,
                           double y,
                           double z) {
        super(worldIn);
    }

    /**
     *
     */
    protected void entityInit() {
        return;
    }

    /**
     * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
     * length * 64 * renderDistanceWeight Args: distance
     */
    @Override
    public boolean isInRangeToRenderDist(double distance) {
        return true;
    }

    /**
     *
     */
    protected float getVelocity() {
        return 0;
    }

    /**
     *
     */
    protected float getInaccuracy() {
        return 0;
    }

    /**
     * Similar to setArrowHeading, it's point the throwable entity to a x, y, z direction.
     */
    public void setThrowableHeading(double x,
                                    double y,
                                    double z,
                                    float velocity,
                                    float inaccuracy) {
        return;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    @Override
    public void setVelocity(double x,
                            double y,
                            double z) {
        return;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity() {
        return 0;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected abstract void onImpact(MovingObjectPosition p_70184_1_);

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     *
     */
    public EntityLivingBase getThrower() {
        return null;
    }

}