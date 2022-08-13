package net.minecraft.entity.passive;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.Entity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.IEntityLivingData;

/**
 *
 */
public class EntityRabbit extends EntityAnimal {

    /**
     *
     */
    private EntityRabbit.AIAvoidEntity<EntityWolf> aiAvoidWolves;

    /**
     *
     */
    private int field_175540_bm;

    /**
     *
     */
    private int field_175535_bn;

    /**
     *
     */
    private boolean field_175536_bo;

    /**
     *
     */
    private boolean field_175537_bp;

    /**
     *
     */
    private int currentMoveTypeDuration;

    /**
     *
     */
    private EntityRabbit.EnumMoveType moveType;

    /**
     *
     */
    private int carrotTicks;

    /**
     *
     */
    private EntityPlayer field_175543_bt;

    /**
     *
     */
    public EntityRabbit(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected float getJumpUpwardsMotion() {
        return 0;
    }

    /**
     *
     */
    public void setMoveType(EntityRabbit.EnumMoveType type) {
        return;
    }

    /**
     *
     */
    public float func_175521_o(float p_175521_1_) {
        return 0;
    }

    /**
     *
     */
    public void setMovementSpeed(double newSpeed) {
        return;
    }

    /**
     *
     */
    public void setJumping(boolean jump,
                           EntityRabbit.EnumMoveType moveTypeIn) {
        return;
    }

    /**
     *
     */
    public void doMovementAction(EntityRabbit.EnumMoveType movetype) {
        return;
    }

    /**
     *
     */
    public boolean func_175523_cj() {
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
     *
     */
    @Override
    public void updateAITasks() {
        return;
    }

    /**
     * Attempts to create sprinting particles if the entity is sprinting and not in water.
     */
    @Override
    public void spawnRunningParticles() {
        return;
    }

    /**
     *
     */
    private void calculateRotationYaw(double x,
                                      double z) {
        return;
    }

    /**
     *
     */
    private void func_175518_cr() {
        return;
    }

    /**
     *
     */
    private void func_175520_cs() {
        return;
    }

    /**
     *
     */
    private void updateMoveTypeDuration() {
        return;
    }

    /**
     *
     */
    private void func_175517_cu() {
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
     *
     */
    @Override
    protected void applyEntityAttributes() {
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
     *
     */
    protected String getJumpingSound() {
        return null;
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
    public boolean attackEntityAsMob(Entity entityIn) {
        return true;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getTotalArmorValue() {
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
     * Causes this Entity to drop a random item.
     */
    @Override
    protected void addRandomDrop() {
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
    private boolean isRabbitBreedingItem(Item itemIn) {
        return true;
    }

    /**
     *
     */
    public EntityRabbit createChild(EntityAgeable ageable) {
        return null;
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
     *
     */
    public int getRabbitType() {
        return 0;
    }

    /**
     *
     */
    public void setRabbitType(int rabbitTypeId) {
        return;
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Override
    public IEntityLivingData func_180482_a(DifficultyInstance difficulty,
                                           IEntityLivingData livingdata) {
        return null;
    }

    /**
     * Returns true if <a href="../../../../net/minecraft/entity/passive/EntityRabbit.html#carrotTicks"><code>carrotTicks</code></a> has reached zero
     */
    private boolean isCarrotEaten() {
        return true;
    }

    /**
     * Returns duration of the current <a href="../../../../net/minecraft/entity/passive/EntityRabbit.EnumMoveType.html" title="enum in net.minecraft.entity.passive"><code>move type</code></a>
     */
    protected int getMoveTypeDuration() {
        return 0;
    }

    /**
     *
     */
    protected void createEatingParticles() {
        return;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    public enum EnumMoveType {}

    public class AIAvoidEntity<T> {
    }
}