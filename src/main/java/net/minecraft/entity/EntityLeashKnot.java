package net.minecraft.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class EntityLeashKnot extends EntityHanging {

    /**
     *
     */
    public EntityLeashKnot(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityLeashKnot(World worldIn,
                           BlockPos hangingPositionIn) {
        super(worldIn, hangingPositionIn);
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * Updates facing and bounding box based on it
     */
    @Override
    public void updateFacingWithBoundingBox(EnumFacing facingDirectionIn) {
        return;
    }

    /**
     *
     */
    public int getWidthPixels() {
        return 0;
    }

    /**
     *
     */
    public int getHeightPixels() {
        return 0;
    }

    /**
     *
     */
    @Override
    public float getEyeHeight() {
        return 0;
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
     * Called when this entity is broken. Entity parameter may be null.
     */
    public void onBroken(Entity brokenEntity) {
        return;
    }

    /**
     * Either write this entity to the NBT tag given and return true, or return false without doing anything. If this
     * returns false the entity is not saved on disk. Ridden entities return false here as they are saved with their
     * rider.
     */
    @Override
    public boolean writeToNBTOptional(NBTTagCompound tagCompund) {
        return true;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     * First layer of player interaction
     */
    @Override
    public boolean interactFirst(EntityPlayer playerIn) {
        return true;
    }

    /**
     * checks to make sure painting can be placed there
     */
    @Override
    public boolean onValidSurface() {
        return true;
    }

    /**
     *
     */
    public static EntityLeashKnot createKnot(World worldIn,
                                             BlockPos fence) {
        return null;
    }

    /**
     *
     */
    public static EntityLeashKnot getKnotForPosition(World worldIn,
                                                     BlockPos pos) {
        return null;
    }

}