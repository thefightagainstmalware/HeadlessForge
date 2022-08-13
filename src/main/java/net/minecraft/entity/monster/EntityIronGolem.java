package net.minecraft.entity.monster;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.village.Village;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.block.Block;

/**
 *
 */
public class EntityIronGolem extends EntityGolem {

    /**
     * deincrements, and a distance-to-home check is done at 0
     */
    private int homeCheckTimer;

    /**
     *
     */
    Village villageObj;

    /**
     *
     */
    private int attackTimer;

    /**
     *
     */
    private int holdRoseTick;

    /**
     *
     */
    public EntityIronGolem(World worldIn) {
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
    protected void updateAITasks() {
        return;
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     * Decrements the entity's air supply when underwater
     */
    @Override
    protected int decreaseAirSupply(int p_70682_1_) {
        return 0;
    }

    /**
     *
     */
    @Override
    protected void collideWithEntity(Entity p_82167_1_) {
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
     * Returns true if this entity can attack entities of the specified class.
     */
    @Override
    public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
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
     *
     */
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return true;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     *
     */
    public Village getVillage() {
        return null;
    }

    /**
     *
     */
    public int getAttackTimer() {
        return 0;
    }

    /**
     *
     */
    public void setHoldingRose(boolean p_70851_1_) {
        return;
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
     * Drop 0-2 items of this living's type
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_,
                                int p_70628_2_) {
        return;
    }

    /**
     *
     */
    public int getHoldRoseTick() {
        return 0;
    }

    /**
     *
     */
    public boolean isPlayerCreated() {
        return true;
    }

    /**
     *
     */
    public void setPlayerCreated(boolean p_70849_1_) {
        return;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource cause) {
        return;
    }

}