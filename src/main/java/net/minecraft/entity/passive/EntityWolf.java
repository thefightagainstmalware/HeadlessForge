package net.minecraft.entity.passive;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.EnumDyeColor;

/**
 *
 */
public class EntityWolf extends EntityTameable {

    /**
     * Float used to smooth the rotation of the wolf head
     */
    private float headRotationCourse;

    /**
     *
     */
    private float headRotationCourseOld;

    /**
     * true is the wolf is wet else false
     */
    private boolean isWet;

    /**
     * True if the wolf is shaking else False
     */
    private boolean isShaking;

    /**
     * This time increases while wolf is shaking and emitting water particles.
     */
    private float timeWolfIsShaking;

    /**
     *
     */
    private float prevTimeWolfIsShaking;

    /**
     *
     */
    public EntityWolf(World worldIn) {
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
     * Sets the active target the Task system uses for tracking
     */
    @Override
    public void setAttackTarget(EntityLivingBase entitylivingbaseIn) {
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
    protected void entityInit() {
        return;
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
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
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
     * True if the wolf is wet
     */
    public boolean isWolfWet() {
        return true;
    }

    /**
     * Used when calculating the amount of shading to apply while the wolf is wet.
     */
    public float getShadingWhileWet(float p_70915_1_) {
        return 0;
    }

    /**
     *
     */
    public float getShakeAngle(float p_70923_1_,
                               float p_70923_2_) {
        return 0;
    }

    /**
     *
     */
    public float getInterestedAngle(float p_70917_1_) {
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
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    @Override
    public int getVerticalFaceSpeed() {
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
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return true;
    }

    /**
     *
     */
    @Override
    public void setTamed(boolean tamed) {
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
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     *
     */
    public float getTailRotation() {
        return 0;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return true;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk() {
        return 0;
    }

    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry() {
        return true;
    }

    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean angry) {
        return;
    }

    /**
     *
     */
    public EnumDyeColor getCollarColor() {
        return null;
    }

    /**
     *
     */
    public void setCollarColor(EnumDyeColor collarcolor) {
        return;
    }

    /**
     *
     */
    public EntityWolf createChild(EntityAgeable ageable) {
        return null;
    }

    /**
     *
     */
    public void setBegging(boolean beg) {
        return;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMateWith(EntityAnimal otherAnimal) {
        return true;
    }

    /**
     *
     */
    public boolean isBegging() {
        return true;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean shouldAttackEntity(EntityLivingBase p_142018_1_,
                                      EntityLivingBase p_142018_2_) {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean allowLeashing() {
        return true;
    }

}