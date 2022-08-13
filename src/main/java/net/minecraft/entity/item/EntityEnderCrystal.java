package net.minecraft.entity.item;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class EntityEnderCrystal extends Entity {

    /**
     * Used to create the rotation animation when rendering the crystal.
     */
    public int innerRotation;

    /**
     *
     */
    public int health;

    /**
     *
     */
    public EntityEnderCrystal(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityEnderCrystal(World worldIn,
                              double p_i1699_2_,
                              double p_i1699_4_,
                              double p_i1699_6_) {
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
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
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