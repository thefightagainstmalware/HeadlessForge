package net.minecraft.entity.passive;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public abstract class EntityAnimal extends EntityAgeable implements IAnimals {

    /**
     *
     */
    protected Block spawnableBlock;

    /**
     *
     */
    private int inLove;

    /**
     *
     */
    private EntityPlayer playerInLove;

    /**
     *
     */
    public EntityAnimal(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected void updateAITasks() {
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
    @Override
    public float getBlockPathWeight(BlockPos pos) {
        return 0;
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
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    @Override
    public int getTalkInterval() {
        return 0;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return true;
    }

    /**
     * Get the experience points the entity currently has.
     */
    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return 0;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack) {
        return true;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player) {
        return true;
    }

    /**
     * Decreases ItemStack size by one
     */
    protected void consumeItemFromStack(EntityPlayer player,
                                        ItemStack stack) {
        return;
    }

    /**
     *
     */
    public void setInLove(EntityPlayer player) {
        return;
    }

    /**
     *
     */
    public EntityPlayer getPlayerInLove() {
        return null;
    }

    /**
     * Returns if the entity is currently in 'love mode'.
     */
    public boolean isInLove() {
        return true;
    }

    /**
     *
     */
    public void resetInLove() {
        return;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal otherAnimal) {
        return true;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

}