package net.minecraft.entity.monster;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.pathfinding.PathNavigate;

/**
 *
 */
public class EntityGuardian extends EntityMob {

    /**
     *
     */
    private float field_175482_b;

    /**
     *
     */
    private float field_175484_c;

    /**
     *
     */
    private float field_175483_bk;

    /**
     *
     */
    private float field_175485_bl;

    /**
     *
     */
    private float field_175486_bm;

    /**
     *
     */
    private EntityLivingBase targetedEntity;

    /**
     *
     */
    private int field_175479_bo;

    /**
     *
     */
    private boolean field_175480_bp;

    /**
     *
     */
    private EntityAIWander wander;

    /**
     *
     */
    public EntityGuardian(World worldIn) {
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

    /**
     * Returns new PathNavigateGround instance
     */
    @Override
    protected PathNavigate getNewNavigator(World worldIn) {
        return null;
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * Returns true if given flag is set
     */
    private boolean isSyncedFlagSet(int flagId) {
        return true;
    }

    /**
     * Sets a flag state "on/off" on both sides (client/server) by using DataWatcher
     */
    private void setSyncedFlag(int flagId,
                               boolean state) {
        return;
    }

    /**
     *
     */
    public boolean func_175472_n() {
        return true;
    }

    /**
     *
     */
    private void func_175476_l(boolean p_175476_1_) {
        return;
    }

    /**
     *
     */
    public int func_175464_ck() {
        return 0;
    }

    /**
     *
     */
    public boolean isElder() {
        return true;
    }

    /**
     * Sets this Guardian to be an elder or not.
     */
    public void setElder(boolean elder) {
        return;
    }

    /**
     *
     */
    public void setElder() {
        return;
    }

    /**
     *
     */
    private void setTargetedEntity(int entityId) {
        return;
    }

    /**
     *
     */
    public boolean hasTargetedEntity() {
        return true;
    }

    /**
     *
     */
    public EntityLivingBase getTargetedEntity() {
        return null;
    }

    /**
     *
     */
    @Override
    public void onDataWatcherUpdate(int dataID) {
        return;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    @Override
    public int getTalkInterval() {
        return 0;
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
    @Override
    public float getEyeHeight() {
        return 0;
    }

    /**
     *
     */
    @Override
    public float getBlockPathWeight(BlockPos pos) {
        return 0;
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
     *
     */
    public float func_175471_a(float p_175471_1_) {
        return 0;
    }

    /**
     *
     */
    public float func_175469_o(float p_175469_1_) {
        return 0;
    }

    /**
     *
     */
    public float func_175477_p(float p_175477_1_) {
        return 0;
    }

    /**
     *
     */
    @Override
    protected void updateAITasks() {
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
     * Causes this Entity to drop a random item.
     */
    @Override
    protected void addRandomDrop() {
        return;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    @Override
    public boolean isNotColliding() {
        return true;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere() {
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

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    @Override
    public int getVerticalFaceSpeed() {
        return 0;
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    @Override
    public void moveEntityWithHeading(float strafe,
                                      float forward) {
        return;
    }

}