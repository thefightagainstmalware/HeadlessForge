package net.minecraft.entity;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public abstract class EntityHanging extends Entity {

    /**
     *
     */
    private int tickCounter1;

    /**
     *
     */
    protected BlockPos hangingPosition;

    /**
     * The direction the entity is facing
     */
    public EnumFacing facingDirection;

    /**
     *
     */
    public EntityHanging(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityHanging(World worldIn,
                         BlockPos hangingPositionIn) {
        super(worldIn);
    }

    /**
     *
     */
    protected void entityInit() {
        return;
    }

    /**
     * Updates facing and bounding box based on it
     */
    protected void updateFacingWithBoundingBox(EnumFacing facingDirectionIn) {
        return;
    }

    /**
     * Updates the entity bounding box based on current facing
     */
    private void updateBoundingBox() {
        return;
    }

    /**
     *
     */
    private double func_174858_a(int p_174858_1_) {
        return 0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * checks to make sure painting can be placed there
     */
    public boolean onValidSurface() {
        return true;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    /**
     * Called when a player attacks an entity. If this returns true the attack will not happen.
     */
    @Override
    public boolean hitByEntity(Entity entityIn) {
        return true;
    }

    /**
     *
     */
    @Override
    public EnumFacing getHorizontalFacing() {
        return null;
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
     * Tries to moves the entity by the passed in displacement. Args: x, y, z
     */
    @Override
    public void moveEntity(double x,
                           double y,
                           double z) {
        return;
    }

    /**
     * Adds to the current velocity of the entity. Args: x, y, z
     */
    @Override
    public void addVelocity(double x,
                            double y,
                            double z) {
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
     *
     */
    public abstract int getWidthPixels();

    /**
     *
     */
    public abstract int getHeightPixels();

    /**
     * Called when this entity is broken. Entity parameter may be null.
     */
    public abstract void onBroken(Entity brokenEntity);

    /**
     *
     */
    @Override
    protected boolean shouldSetPosAfterLoading() {
        return true;
    }

    /**
     * Sets the x,y,z of the entity from the given parameters. Also seems to set up a bounding box.
     */
    @Override
    public void setPosition(double x,
                            double y,
                            double z) {
        return;
    }

    /**
     *
     */
    public BlockPos getHangingPosition() {
        return null;
    }

}