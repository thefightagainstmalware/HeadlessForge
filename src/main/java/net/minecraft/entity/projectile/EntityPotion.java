package net.minecraft.entity.projectile;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityPotion extends EntityThrowable {

    /**
     * The damage value of the thrown potion that this EntityPotion represents.
     */
    private ItemStack potionDamage;

    /**
     *
     */
    public EntityPotion(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityPotion(World worldIn,
                        EntityLivingBase throwerIn,
                        int meta) {
        super(worldIn, throwerIn);
    }

    /**
     *
     */
    public EntityPotion(World worldIn,
                        EntityLivingBase throwerIn,
                        ItemStack potionDamageIn) {
        super(worldIn, throwerIn);
    }

    /**
     *
     */
    public EntityPotion(World worldIn,
                        double x,
                        double y,
                        double z,
                        int p_i1791_8_) {
        super(worldIn, x, y, z);
    }

    /**
     *
     */
    public EntityPotion(World worldIn,
                        double x,
                        double y,
                        double z,
                        ItemStack potionDamageIn) {
        super(worldIn, x, y, z);
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    @Override
    protected float getGravityVelocity() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected float getVelocity() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected float getInaccuracy() {
        return 0;
    }

    /**
     * Sets the PotionEffect by the given id of the potion effect.
     */
    public void setPotionDamage(int potionId) {
        return;
    }

    /**
     * Returns the damage value of the thrown potion that this EntityPotion represents.
     */
    public int getPotionDamage() {
        return 0;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_) {
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
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

}