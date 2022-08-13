package net.minecraft.entity;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.World;

/**
 *
 */
public abstract class EntityLivingBase extends Entity {

    /**
     *
     */
    private static final java.util.UUID sprintingSpeedBoostModifierUUID = java.util.UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");

    /**
     *
     */
    private static final AttributeModifier sprintingSpeedBoostModifier = new AttributeModifier(sprintingSpeedBoostModifierUUID, "Sprinting speed boost", 0.30000001192092896D, 0);

    /**
     *
     */
    private BaseAttributeMap attributeMap;

    /**
     *
     */
    private final CombatTracker _combatTracker = new CombatTracker(this);

    /**
     *
     */
    private final java.util.Map<java.lang.Integer,PotionEffect> activePotionsMap = new java.util.HashMap<java.lang.Integer,PotionEffect>();

    /**
     * The equipment this mob was previously wearing, used for syncing.
     */
    private final ItemStack[] previousEquipment = new ItemStack[5];

    /**
     * Whether an arm swing is currently in progress.
     */
    public boolean isSwingInProgress;

    /**
     *
     */
    public int swingProgressInt;

    /**
     *
     */
    public int arrowHitTimer;

    /**
     * The amount of time remaining this entity should act 'hurt'. (Visual appearance of red tint)
     */
    public int hurtTime;

    /**
     * What the hurt time was max set to last.
     */
    public int maxHurtTime;

    /**
     * The yaw at which this entity was last attacked from.
     */
    public float attackedAtYaw;

    /**
     * The amount of time remaining this entity should act 'dead', i.e. have a corpse in the world.
     */
    public int deathTime;

    /**
     *
     */
    public float prevSwingProgress;

    /**
     *
     */
    public float swingProgress;

    /**
     *
     */
    public float prevLimbSwingAmount;

    /**
     *
     */
    public float limbSwingAmount;

    /**
     * Only relevant when limbYaw is not 0(the entity is moving). Influences where in its swing legs and arms currently
     * are.
     */
    public float limbSwing;

    /**
     *
     */
    public int maxHurtResistantTime;

    /**
     *
     */
    public float prevCameraPitch;

    /**
     *
     */
    public float cameraPitch;

    /**
     *
     */
    public float field_70769_ao;

    /**
     *
     */
    public float field_70770_ap;

    /**
     *
     */
    public float renderYawOffset;

    /**
     *
     */
    public float prevRenderYawOffset;

    /**
     * Entity head rotation yaw
     */
    public float rotationYawHead;

    /**
     * Entity head rotation yaw at previous tick
     */
    public float prevRotationYawHead;

    /**
     * A factor used to determine how far this entity will move each tick if it is jumping or falling.
     */
    public float jumpMovementFactor;

    /**
     * The most recent player that has attacked this entity
     */
    protected EntityPlayer attackingPlayer;

    /**
     * Set to 60 when hit by the player or the player's wolf, then decrements. Used to determine whether the entity
     * should drop items on death.
     */
    protected int recentlyHit;

    /**
     * This gets set on entity death, but never used. Looks like a duplicate of isDead
     */
    protected boolean dead;

    /**
     * The age of this EntityLiving (used to determine when it dies)
     */
    protected int entityAge;

    /**
     *
     */
    protected float prevOnGroundSpeedFactor;

    /**
     *
     */
    protected float onGroundSpeedFactor;

    /**
     *
     */
    protected float movedDistance;

    /**
     *
     */
    protected float prevMovedDistance;

    /**
     *
     */
    protected float field_70741_aB;

    /**
     * The score value of the Mob, the amount of points the mob is worth.
     */
    protected int scoreValue;

    /**
     * Damage taken in the last hit. Mobs are resistant to damage less than this for a short time after taking damage.
     */
    protected float lastDamage;

    /**
     * used to check whether entity is jumping.
     */
    protected boolean isJumping;

    /**
     *
     */
    public float moveStrafing;

    /**
     *
     */
    public float moveForward;

    /**
     *
     */
    protected float randomYawVelocity;

    /**
     * The number of updates over which the new position and rotation are to be applied to the entity.
     */
    protected int newPosRotationIncrements;

    /**
     * The new X position to be applied to the entity.
     */
    protected double newPosX;

    /**
     * The new Y position to be applied to the entity.
     */
    protected double newPosY;

    /**
     *
     */
    protected double newPosZ;

    /**
     * The new yaw rotation to be applied to the entity.
     */
    protected double newRotationYaw;

    /**
     * The new yaw rotation to be applied to the entity.
     */
    protected double newRotationPitch;

    /**
     * Whether the DataWatcher needs to be updated with the active potions
     */
    private boolean potionsNeedUpdate;

    /**
     * is only being set, has no uses as of MC 1.1
     */
    private EntityLivingBase entityLivingToAttack;

    /**
     *
     */
    private int revengeTimer;

    /**
     *
     */
    private EntityLivingBase lastAttacker;

    /**
     * Holds the value of ticksExisted when setLastAttacker was last called.
     */
    private int lastAttackerTime;

    /**
     * A factor used to determine how far this entity will move each tick if it is walking on land. Adjusted by speed,
     * and slipperiness of the current block.
     */
    private float landMovementFactor;

    /**
     * Number of ticks since last jump
     */
    private int jumpTicks;

    /**
     *
     */
    private float absorptionAmount;

    /**
     *
     */
    public EntityLivingBase(World worldIn) {
        super(worldIn);
    }

    /**
     * Called by the /kill command.
     */
    @Override
    public void func_174812_G() {
        return;
    }

    /**
     *
     */
    protected void entityInit() {
        return;
    }

    /**
     *
     */
    protected void applyEntityAttributes() {
        return;
    }

    /**
     *
     */
    @Override
    protected void updateFallState(double y,
                                   boolean onGroundIn,
                                   Block blockIn,
                                   BlockPos pos) {
        return;
    }

    /**
     *
     */
    public boolean canBreatheUnderwater() {
        return true;
    }

    /**
     * Gets called every tick from main Entity class
     */
    @Override
    public void onEntityUpdate() {
        return;
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    public boolean isChild() {
        return true;
    }

    /**
     * handles entity death timer, experience orb and particle creation
     */
    protected void onDeathUpdate() {
        return;
    }

    /**
     * Entity won't drop items or experience points if this returns false
     */
    protected boolean canDropLoot() {
        return true;
    }

    /**
     * Decrements the entity's air supply when underwater
     */
    protected int decreaseAirSupply(int p_70682_1_) {
        return 0;
    }

    /**
     * Get the experience points the entity currently has.
     */
    protected int getExperiencePoints(EntityPlayer player) {
        return 0;
    }

    /**
     * Only use is to identify if class is an instance of player for experience dropping
     */
    protected boolean isPlayer() {
        return true;
    }

    /**
     *
     */
    public java.util.Random func_70681_au() {
        return null;
    }

    /**
     *
     */
    public EntityLivingBase getAITarget() {
        return null;
    }

    /**
     *
     */
    public int getRevengeTimer() {
        return 0;
    }

    /**
     *
     */
    public void setRevengeTarget(EntityLivingBase livingBase) {
        return;
    }

    /**
     *
     */
    public EntityLivingBase getLastAttacker() {
        return null;
    }

    /**
     *
     */
    public int getLastAttackerTime() {
        return 0;
    }

    /**
     *
     */
    public void setLastAttacker(Entity entityIn) {
        return;
    }

    /**
     *
     */
    public int getAge() {
        return 0;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     *
     */
    protected void updatePotionEffects() {
        return;
    }

    /**
     * Clears potion metadata values if the entity has no potion effects. Otherwise, updates potion effect color,
     * ambience, and invisibility metadata values
     */
    protected void updatePotionMetadata() {
        return;
    }

    /**
     * Resets the potion effect color and ambience metadata values
     */
    protected void resetPotionEffectMetadata() {
        return;
    }

    /**
     *
     */
    public void func_70674_bp() {
        return;
    }

    /**
     *
     */
    public java.util.Collection<PotionEffect> func_70651_bq() {
        return null;
    }

    /**
     *
     */
    public boolean func_82165_m(int potionId) {
        return true;
    }

    /**
     *
     */
    public boolean isPotionActive(Potion potionIn) {
        return true;
    }

    /**
     * returns the PotionEffect for the supplied Potion if it is active, null otherwise.
     */
    public PotionEffect getActivePotionEffect(Potion potionIn) {
        return null;
    }

    /**
     * adds a PotionEffect to the entity
     */
    public void func_70690_d(PotionEffect potioneffectIn) {
        return;
    }

    /**
     *
     */
    public boolean isPotionApplicable(PotionEffect potioneffectIn) {
        return true;
    }

    /**
     * Returns true if this entity is undead.
     */
    public boolean isEntityUndead() {
        return true;
    }

    /**
     * Remove the speified potion effect from this entity.
     */
    public void removePotionEffectClient(int potionId) {
        return;
    }

    /**
     * Remove the specified potion effect from this entity.
     */
    public void func_82170_o(int potionId) {
        return;
    }

    /**
     *
     */
    protected void onNewPotionEffect(PotionEffect id) {
        return;
    }

    /**
     *
     */
    protected void onChangedPotionEffect(PotionEffect id,
                                         boolean p_70695_2_) {
        return;
    }

    /**
     *
     */
    protected void onFinishedPotionEffect(PotionEffect p_70688_1_) {
        return;
    }

    /**
     * Heal living entity (param: amount of half-hearts)
     */
    public void heal(float healAmount) {
        return;
    }

    /**
     *
     */
    public final float getHealth() {
        return 0;
    }

    /**
     *
     */
    public void setHealth(float health) {
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
     * Renders broken item particles using the given ItemStack
     */
    public void renderBrokenItemStack(ItemStack stack) {
        return;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause) {
        return;
    }

    /**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean p_82160_1_,
                                 int p_82160_2_) {
        return;
    }

    /**
     * knocks back this entity
     */
    public void knockBack(Entity entityIn,
                          float p_70653_2_,
                          double p_70653_3_,
                          double p_70653_5_) {
        return;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound() {
        return null;
    }

    /**
     * Causes this Entity to drop a random item.
     */
    protected void addRandomDrop() {
        return;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean p_70628_1_,
                                int p_70628_2_) {
        return;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder() {
        return true;
    }

    /**
     * Checks whether target entity is alive.
     */
    @Override
    public boolean isEntityAlive() {
        return true;
    }

    /**
     *
     */
    @Override
    public void fall(float distance,
                     float damageMultiplier) {
        return;
    }

    /**
     *
     */
    protected String getFallSoundString(int damageValue) {
        return null;
    }

    /**
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    @Override
    public void performHurtAnimation() {
        return;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue() {
        return 0;
    }

    /**
     *
     */
    protected void damageArmor(float p_70675_1_) {
        return;
    }

    /**
     * Reduces damage, depending on armor
     */
    protected float applyArmorCalculations(DamageSource source,
                                           float damage) {
        return 0;
    }

    /**
     * Reduces damage, depending on potions
     */
    protected float applyPotionDamageCalculations(DamageSource source,
                                                  float damage) {
        return 0;
    }

    /**
     * Deals damage to the entity. If its a EntityPlayer then will take damage from the armor first and then health
     * second with the reduced value. Args: damageAmount
     */
    protected void damageEntity(DamageSource damageSrc,
                                float damageAmount) {
        return;
    }

    /**
     *
     */
    public CombatTracker getCombatTracker() {
        return null;
    }

    /**
     *
     */
    public EntityLivingBase func_94060_bK() {
        return null;
    }

    /**
     *
     */
    public final float getMaxHealth() {
        return 0;
    }

    /**
     * counts the amount of arrows stuck in the entity. getting hit by arrows increases this, used in rendering
     */
    public final int getArrowCountInEntity() {
        return 0;
    }

    /**
     * sets the amount of arrows stuck in the entity. used for rendering those
     */
    public final void setArrowCountInEntity(int count) {
        return;
    }

    /**
     * Returns an integer indicating the end point of the swing animation, used by <a href="../../../net/minecraft/entity/EntityLivingBase.html#swingProgress"><code>swingProgress</code></a> to provide a
     * progress indicator. Takes dig speed enchantments into account.
     */
    private int getArmSwingAnimationEnd() {
        return 0;
    }

    /**
     * Swings the item the player is holding.
     */
    public void swingItem() {
        return;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     * sets the dead flag. Used when you fall off the bottom of the world.
     */
    @Override
    protected void kill() {
        return;
    }

    /**
     * Updates the arm swing progress counters and animation progress
     */
    protected void updateArmSwingProgress() {
        return;
    }

    /**
     *
     */
    public IAttributeInstance getEntityAttribute(IAttribute attribute) {
        return null;
    }

    /**
     *
     */
    public BaseAttributeMap getAttributeMap() {
        return null;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute() {
        return null;
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public abstract ItemStack getHeldItem();

    /**
     * 0: Tool in Hand; 1-4: Armor
     */
    public abstract ItemStack getEquipmentInSlot(int slotIn);

    /**
     *
     */
    public abstract ItemStack getCurrentArmor(int slotIn);

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    @Override
    public abstract void setCurrentItemOrArmor(int slotIn,
                                               ItemStack stack);

    /**
     * Set sprinting switch for Entity.
     */
    @Override
    public void setSprinting(boolean sprinting) {
        return;
    }

    /**
     * returns the inventory of this entity (only used in EntityPlayerMP it seems)
     */
    @Override
    public abstract ItemStack[] getInventory();

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0;
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getSoundPitch() {
        return 0;
    }

    /**
     * Dead and sleeping entities cannot move
     */
    protected boolean isMovementBlocked() {
        return true;
    }

    /**
     * Moves the entity to a position out of the way of its mount.
     */
    public void dismountEntity(Entity p_110145_1_) {
        return;
    }

    /**
     *
     */
    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }

    /**
     *
     */
    protected float getJumpUpwardsMotion() {
        return 0;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump() {
        return;
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick() {
        return;
    }

    /**
     *
     */
    protected void handleJumpLava() {
        return;
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float strafe,
                                      float forward) {
        return;
    }

    /**
     * the movespeed used for the new AI system
     */
    public float getAIMoveSpeed() {
        return 0;
    }

    /**
     * set the movespeed used for the new AI system
     */
    public void setAIMoveSpeed(float speedIn) {
        return;
    }

    /**
     *
     */
    public boolean attackEntityAsMob(Entity entityIn) {
        return true;
    }

    /**
     * Returns whether player is sleeping or not
     */
    public boolean isPlayerSleeping() {
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
    protected float func_110146_f(float p_110146_1_,
                                  float p_110146_2_) {
        return 0;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate() {
        return;
    }

    /**
     *
     */
    protected void updateEntityActionState() {
        return;
    }

    /**
     *
     */
    protected void collideWithNearbyEntities() {
        return;
    }

    /**
     *
     */
    protected void collideWithEntity(Entity p_82167_1_) {
        return;
    }

    /**
     * Called when a player mounts an entity. e.g. mounts a pig, mounts a boat.
     */
    @Override
    public void func_70078_a(Entity entityIn) {
        return;
    }

    /**
     * Handles updating while being ridden by an entity
     */
    @Override
    public void updateRidden() {
        return;
    }

    /**
     *
     */
    @Override
    public void setPositionAndRotation2(double x,
                                        double y,
                                        double z,
                                        float yaw,
                                        float pitch,
                                        int posRotationIncrements,
                                        boolean p_180426_10_) {
        return;
    }

    /**
     *
     */
    public void setJumping(boolean p_70637_1_) {
        return;
    }

    /**
     * Called whenever an item is picked up from walking over it. Args: pickedUpEntity, stackSize
     */
    public void onItemPickup(Entity p_71001_1_,
                             int p_71001_2_) {
        return;
    }

    /**
     * returns true if the entity provided in the argument can be seen. (Raytrace)
     */
    public boolean canEntityBeSeen(Entity entityIn) {
        return true;
    }

    /**
     * returns a (normalized) vector of where this entity is looking
     */
    @Override
    public Vec3 getLookVec() {
        return null;
    }

    /**
     * interpolated look vector
     */
    @Override
    public Vec3 getLook(float partialTicks) {
        return null;
    }

    /**
     * Returns where in the swing animation the living entity is (from 0 to 1).  Args: partialTickTime
     */
    public float getSwingProgress(float partialTickTime) {
        return 0;
    }

    /**
     * Returns whether the entity is in a server world
     */
    public boolean isServerWorld() {
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
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    @Override
    public boolean canBePushed() {
        return true;
    }

    /**
     * Sets that this entity has been attacked.
     */
    @Override
    protected void setBeenAttacked() {
        return;
    }

    /**
     *
     */
    @Override
    public float getRotationYawHead() {
        return 0;
    }

    /**
     * Sets the head's yaw rotation of the entity.
     */
    @Override
    public void func_70034_d(float rotation) {
        return;
    }

    /**
     *
     */
    @Override
    public void func_181013_g(float p_181013_1_) {
        return;
    }

    /**
     *
     */
    public float getAbsorptionAmount() {
        return 0;
    }

    /**
     *
     */
    public void setAbsorptionAmount(float amount) {
        return;
    }

    /**
     *
     */
    public Team func_96124_cp() {
        return null;
    }

    /**
     *
     */
    public boolean isOnSameTeam(EntityLivingBase otherEntity) {
        return true;
    }

    /**
     * Returns true if the entity is on a specific team.
     */
    public boolean isOnTeam(Team p_142012_1_) {
        return true;
    }

    /**
     * Sends an ENTER_COMBAT packet to the client
     */
    public void sendEnterCombat() {
        return;
    }

    /**
     * Sends an END_COMBAT packet to the client
     */
    public void sendEndCombat() {
        return;
    }

    /**
     *
     */
    protected void markPotionsDirty() {
        return;
    }

    /**
     * Removes all potion effects that have curativeItem as a curative item for its effect
     * @param curativeItem The itemstack we are using to cure potion effects
     */
    public void curePotionEffects(ItemStack curativeItem) {
        return;
    }

    /**
     * Returns true if the entity's rider (EntityPlayer) should face forward when mounted.
     * currently only used in vanilla code by pigs.
     * @param player The player who is riding the entity.
     * @return If the player should orient the same direction as this entity.
     */
    public boolean shouldRiderFaceForward(EntityPlayer player) {
        return true;
    }

}