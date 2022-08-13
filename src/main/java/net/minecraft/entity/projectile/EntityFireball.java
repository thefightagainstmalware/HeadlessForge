package net.minecraft.entity.projectile;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public abstract class EntityFireball extends Entity {

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
    private boolean inGround;

    /**
     *
     */
    public EntityLivingBase shootingEntity;

    /**
     *
     */
    private int ticksAlive;

    /**
     *
     */
    private int ticksInAir;

    /**
     *
     */
    public double accelerationX;

    /**
     *
     */
    public double accelerationY;

    /**
     *
     */
    public double accelerationZ;

    /**
     *
     */
    public EntityFireball(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFireball(World worldIn,
                          double x,
                          double y,
                          double z,
                          double accelX,
                          double accelY,
                          double accelZ) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFireball(World worldIn,
                          EntityLivingBase shooter,
                          double accelX,
                          double accelY,
                          double accelZ) {
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
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    protected float getMotionFactor() {
        return 0;
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected abstract void onImpact(MovingObjectPosition movingObject);

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
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    /**
     *
     */
    @Override
    public float getCollisionBorderSize() {
        return 0;
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
     * Gets how bright this entity is.
     */
    @Override
    public float getBrightness(float partialTicks) {
        return 0;
    }

    /**
     *
     */
    @Override
    public int getBrightnessForRender(float partialTicks) {
        return 0;
    }

}