package net.minecraft.entity;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public abstract class EntityAgeable extends EntityCreature {

    /**
     *
     */
    protected int growingAge;

    /**
     *
     */
    protected int field_175502_b;

    /**
     *
     */
    protected int field_175503_c;

    /**
     *
     */
    private float ageWidth;

    /**
     *
     */
    private float ageHeight;

    /**
     *
     */
    public EntityAgeable(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public abstract EntityAgeable createChild(EntityAgeable ageable);

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player) {
        return true;
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * The age value may be negative or positive or zero. If it's negative, it get's incremented on each tick, if it's
     * positive, it get's decremented each tick. Don't confuse this with EntityLiving.getAge. With a negative value the
     * Entity is considered a child.
     */
    public int getGrowingAge() {
        return 0;
    }

    /**
     *
     */
    public void func_175501_a(int p_175501_1_,
                              boolean p_175501_2_) {
        return;
    }

    /**
     * "Adds the value of the parameter times 20 to the age of this entity. If the entity is an adult (if the entity's
     * age is greater than 0), it will have no effect."
     */
    public void addGrowth(int growth) {
        return;
    }

    /**
     * The age value may be negative or positive or zero. If it's negative, it get's incremented on each tick, if it's
     * positive, it get's decremented each tick. With a negative value the Entity is considered a child.
     */
    public void setGrowingAge(int age) {
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
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        return;
    }

    /**
     * This is called when Entity's growing age timer reaches 0 (negative values are considered as a child, positive as
     * an adult)
     */
    protected void onGrowingAdult() {
        return;
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    @Override
    public boolean isChild() {
        return true;
    }

    /**
     * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
     */
    public void setScaleForAge(boolean p_98054_1_) {
        return;
    }

    /**
     * Sets the width and height of the entity. Args: width, height
     */
    @Override
    protected final void setSize(float width,
                                 float height) {
        return;
    }

    /**
     *
     */
    protected final void setScale(float scale) {
        return;
    }

}