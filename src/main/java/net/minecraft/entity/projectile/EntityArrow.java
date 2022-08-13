package net.minecraft.entity.projectile;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.IProjectile;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;

/**
 *
 */
public class EntityArrow extends Entity implements IProjectile {

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
    private int inData;

    /**
     *
     */
    private boolean inGround;

    /**
     * 1 if the player can pick up the arrow
     */
    public int canBePickedUp;

    /**
     * Seems to be some sort of timer for animating an arrow.
     */
    public int arrowShake;

    /**
     * The owner of this arrow.
     */
    public Entity shootingEntity;

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
    private double damage;

    /**
     * The amount of knockback an arrow applies when it hits a mob.
     */
    private int knockbackStrength;

    /**
     *
     */
    public EntityArrow(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityArrow(World worldIn,
                       double x,
                       double y,
                       double z) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityArrow(World worldIn,
                       EntityLivingBase shooter,
                       EntityLivingBase p_i1755_3_,
                       float p_i1755_4_,
                       float p_i1755_5_) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityArrow(World worldIn,
                       EntityLivingBase shooter,
                       float velocity) {
        super(worldIn);
    }

    /**
     *
     */
    protected void entityInit() {
        return;
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
     *
     */
    @Override
    public void setPositionAndRotation2(double x,
                                        double y,
                                        double z,
                                        float yaw,
                                        float pitch,
                                        int posRotationIncrements,
                                        boolean p_180426_10_) {
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
     * Called by a player entity when they collide with an entity
     */
    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {
        return;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    @Override
    protected boolean canTriggerWalking() {
        return true;
    }

    /**
     *
     */
    public void setDamage(double damageIn) {
        return;
    }

    /**
     *
     */
    public double getDamage() {
        return 0;
    }

    /**
     * Sets the amount of knockback the arrow applies when it hits a mob.
     */
    public void setKnockbackStrength(int knockbackStrengthIn) {
        return;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    @Override
    public boolean canAttackWithItem() {
        return true;
    }

    /**
     *
     */
    @Override
    public float getEyeHeight() {
        return 0;
    }

    /**
     * Whether the arrow has a stream of critical hit particles flying behind it.
     */
    public void setIsCritical(boolean critical) {
        return;
    }

    /**
     * Whether the arrow has a stream of critical hit particles flying behind it.
     */
    public boolean getIsCritical() {
        return true;
    }

}