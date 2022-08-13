package net.minecraft.entity.passive;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 *
 */
public class EntityCow extends EntityAnimal {

    /**
     *
     */
    public EntityCow(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        return null;
    }

    /**
     *
     */
    @Override
    protected void playStepSound(BlockPos pos,
                                 Block blockIn) {
        return;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected Item getDropItem() {
        return null;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_,
                                int p_70628_2_) {
        return;
    }

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
    public EntityCow createChild(EntityAgeable ageable) {
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