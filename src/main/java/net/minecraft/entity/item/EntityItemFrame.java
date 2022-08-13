package net.minecraft.entity.item;

import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class EntityItemFrame extends EntityHanging {

    /**
     * Chance for this item frame's item to drop from the frame.
     */
    private float itemDropChance;

    /**
     *
     */
    public EntityItemFrame(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityItemFrame(World worldIn,
                           BlockPos p_i45852_2_,
                           EnumFacing p_i45852_3_) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
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
     *
     */
    public void dropItemOrSelf(Entity p_146065_1_,
                               boolean p_146065_2_) {
        return;
    }

    /**
     * Removes the dot representing this frame's position from the map when the item frame is broken.
     */
    private void removeFrameFromMap(ItemStack p_110131_1_) {
        return;
    }

    /**
     *
     */
    public ItemStack getDisplayedItem() {
        return null;
    }

    /**
     *
     */
    public void setDisplayedItem(ItemStack p_82334_1_) {
        return;
    }

    /**
     *
     */
    private void setDisplayedItemWithUpdate(ItemStack p_174864_1_,
                                            boolean p_174864_2_) {
        return;
    }

    /**
     * Return the rotation of the item currently on this frame.
     */
    public int getRotation() {
        return 0;
    }

    /**
     *
     */
    public void setItemRotation(int p_82336_1_) {
        return;
    }

    /**
     *
     */
    private void func_174865_a(int p_174865_1_,
                               boolean p_174865_2_) {
        return;
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
     *
     */
    public int func_174866_q() {
        return 0;
    }

}