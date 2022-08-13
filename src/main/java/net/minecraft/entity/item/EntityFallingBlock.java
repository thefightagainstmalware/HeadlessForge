package net.minecraft.entity.item;

import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.crash.CrashReportCategory;

/**
 *
 */
public class EntityFallingBlock extends Entity {

    /**
     *
     */
    private IBlockState fallTile;

    /**
     *
     */
    public int fallTime;

    /**
     *
     */
    public boolean shouldDropItem;

    /**
     *
     */
    private boolean canSetAsBlock;

    /**
     *
     */
    private boolean hurtEntities;

    /**
     *
     */
    private int fallHurtMax;

    /**
     *
     */
    private float fallHurtAmount;

    /**
     *
     */
    public NBTTagCompound tileEntityData;

    /**
     *
     */
    public EntityFallingBlock(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityFallingBlock(World worldIn,
                              double x,
                              double y,
                              double z,
                              IBlockState fallingBlockState) {
        super(worldIn);
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
    protected void entityInit() {
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
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
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
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     *
     */
    public void setHurtEntities(boolean p_145806_1_) {
        return;
    }

    /**
     *
     */
    @Override
    public void addEntityCrashInfo(CrashReportCategory category) {
        return;
    }

    /**
     *
     */
    public World getWorldObj() {
        return null;
    }

    /**
     * Return whether this entity should be rendered as on fire.
     */
    @Override
    public boolean canRenderOnFire() {
        return true;
    }

    /**
     *
     */
    public IBlockState getBlock() {
        return null;
    }

}