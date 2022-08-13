package net.minecraft.entity.item;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityTNTPrimed extends Entity {

    /**
     * How long the fuse is
     */
    public int fuse;

    /**
     *
     */
    private EntityLivingBase tntPlacedBy;

    /**
     *
     */
    public EntityTNTPrimed(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityTNTPrimed(World worldIn,
                           double p_i1730_2_,
                           double p_i1730_4_,
                           double p_i1730_6_,
                           EntityLivingBase p_i1730_8_) {
        super(worldIn);
    }

    /**
     *
     */
    protected void entityInit() {
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
    private void explode() {
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
     * returns null or the entityliving it was placed or ignited by
     */
    public EntityLivingBase getTntPlacedBy() {
        return null;
    }

    /**
     *
     */
    @Override
    public float getEyeHeight() {
        return 0;
    }

}