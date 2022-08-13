package net.minecraft.entity.passive;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.Item;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.inventory.AnimalChest;

/**
 *
 */
public class EntityHorse extends EntityAnimal implements IInvBasic {

    /**
     *
     */
    private static final Object horseBreedingSelector = null;

    /**
     *
     */
    private static final IAttribute horseJumpStrength = null;

    /**
     *
     */
    private static final java.lang.String[] horseArmorTextures = new String[0];

    /**
     *
     */
    private static final java.lang.String[] HORSE_ARMOR_TEXTURES_ABBR = new String[0];

    /**
     *
     */
    private static final int[] armorValues = new int[0];

    /**
     *
     */
    private static final java.lang.String[] horseTextures = new String[0];

    /**
     *
     */
    private static final java.lang.String[] HORSE_TEXTURES_ABBR = new String[0];

    /**
     *
     */
    private static final java.lang.String[] horseMarkingTextures = new String[0];

    /**
     *
     */
    private static final java.lang.String[] HORSE_MARKING_TEXTURES_ABBR = new String[0];

    /**
     *
     */
    private int eatingHaystackCounter;

    /**
     *
     */
    private int openMouthCounter;

    /**
     *
     */
    private int jumpRearingCounter;

    /**
     *
     */
    public int field_110278_bp;

    /**
     *
     */
    public int field_110279_bq;

    /**
     *
     */
    protected boolean horseJumping;

    /**
     *
     */
    private AnimalChest horseChest;

    /**
     *
     */
    private boolean hasReproduced;

    /**
     * "The higher this value, the more likely the horse is to be tamed next time a player rides it."
     */
    protected int temper;

    /**
     *
     */
    protected float jumpPower;

    /**
     *
     */
    private boolean field_110294_bI;

    /**
     *
     */
    private float headLean;

    /**
     *
     */
    private float prevHeadLean;

    /**
     *
     */
    private float rearingAmount;

    /**
     *
     */
    private float prevRearingAmount;

    /**
     *
     */
    private float mouthOpenness;

    /**
     *
     */
    private float prevMouthOpenness;

    /**
     * Used to determine the sound that the horse should make when it steps
     */
    private int gallopTime;

    /**
     *
     */
    private java.lang.String texturePrefix;

    /**
     *
     */
    private java.lang.String[] horseTexturesArray;

    /**
     *
     */
    private boolean field_175508_bO;

    /**
     *
     */
    public EntityHorse(World worldIn) {
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
    public void setHorseType(int type) {
        return;
    }

    /**
     * Returns the horse type. 0 = Normal, 1 = Donkey, 2 = Mule, 3 = Undead Horse, 4 = Skeleton Horse
     */
    public int getHorseType() {
        return 0;
    }

    /**
     *
     */
    public void setHorseVariant(int variant) {
        return;
    }

    /**
     *
     */
    public int getHorseVariant() {
        return 0;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @Override
    public String func_70005_c_() {
        return null;
    }

    /**
     *
     */
    private boolean getHorseWatchableBoolean(int p_110233_1_) {
        return true;
    }

    /**
     *
     */
    private void setHorseWatchableBoolean(int p_110208_1_,
                                          boolean p_110208_2_) {
        return;
    }

    /**
     *
     */
    public boolean isAdultHorse() {
        return true;
    }

    /**
     *
     */
    public boolean isTame() {
        return true;
    }

    /**
     *
     */
    public boolean func_110253_bW() {
        return true;
    }

    /**
     * Gets the horse's owner
     */
    public String getOwnerId() {
        return null;
    }

    /**
     *
     */
    public void setOwnerId(String id) {
        return;
    }

    /**
     *
     */
    public float getHorseSize() {
        return 0;
    }

    /**
     * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
     */
    @Override
    public void setScaleForAge(boolean p_98054_1_) {
        return;
    }

    /**
     *
     */
    public boolean isHorseJumping() {
        return true;
    }

    /**
     *
     */
    public void setHorseTamed(boolean tamed) {
        return;
    }

    /**
     *
     */
    public void setHorseJumping(boolean jumping) {
        return;
    }

    /**
     *
     */
    @Override
    public boolean allowLeashing() {
        return true;
    }

    /**
     *
     */
    @Override
    protected void func_142017_o(float p_142017_1_) {
        return;
    }

    /**
     *
     */
    public boolean isChested() {
        return true;
    }

    /**
     * Returns type of armor from DataWatcher (0 = iron, 1 = gold, 2 = diamond)
     */
    public int getHorseArmorIndexSynced() {
        return 0;
    }

    /**
     * 0 = iron, 1 = gold, 2 = diamond
     */
    private int getHorseArmorIndex(ItemStack itemStackIn) {
        return 0;
    }

    /**
     *
     */
    public boolean isEatingHaystack() {
        return true;
    }

    /**
     *
     */
    public boolean isRearing() {
        return true;
    }

    /**
     *
     */
    public boolean isBreeding() {
        return true;
    }

    /**
     *
     */
    public boolean getHasReproduced() {
        return true;
    }

    /**
     * Set horse armor stack (for example: new ItemStack(Items.iron_horse_armor))
     */
    public void setHorseArmorStack(ItemStack itemStackIn) {
        return;
    }

    /**
     *
     */
    public void setBreeding(boolean breeding) {
        return;
    }

    /**
     *
     */
    public void setChested(boolean chested) {
        return;
    }

    /**
     *
     */
    public void setHasReproduced(boolean hasReproducedIn) {
        return;
    }

    /**
     *
     */
    public void setHorseSaddled(boolean saddled) {
        return;
    }

    /**
     *
     */
    public int getTemper() {
        return 0;
    }

    /**
     *
     */
    public void setTemper(int temperIn) {
        return;
    }

    /**
     *
     */
    public int increaseTemper(int p_110198_1_) {
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
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getTotalArmorValue() {
        return 0;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    @Override
    public boolean canBePushed() {
        return true;
    }

    /**
     *
     */
    public boolean prepareChunkForSpawn() {
        return true;
    }

    /**
     *
     */
    public void dropChests() {
        return;
    }

    /**
     *
     */
    private void func_110266_cB() {
        return;
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
     * Returns number of slots depending horse type
     */
    private int getChestSize() {
        return 0;
    }

    /**
     *
     */
    private void initHorseChest() {
        return;
    }

    /**
     * Updates the items in the saddle and armor slots of the horse's inventory.
     */
    private void updateHorseSlots() {
        return;
    }

    /**
     * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
     */
    public void onInventoryChanged(InventoryBasic p_76316_1_) {
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
     *
     */
    protected EntityHorse getClosestHorse(Entity entityIn,
                                          double distance) {
        return null;
    }

    /**
     *
     */
    public double getHorseJumpStrength() {
        return 0;
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
    protected Item getDropItem() {
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
     *
     */
    public boolean isHorseSaddled() {
        return true;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
        return null;
    }

    /**
     *
     */
    protected String getAngrySoundName() {
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
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    @Override
    public int getMaxSpawnedInChunk() {
        return 0;
    }

    /**
     *
     */
    public int getMaxTemper() {
        return 0;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 0;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    @Override
    public int getTalkInterval() {
        return 0;
    }

    /**
     *
     */
    public boolean func_110239_cn() {
        return true;
    }

    /**
     *
     */
    private void resetTexturePrefix() {
        return;
    }

    /**
     *
     */
    public boolean func_175507_cI() {
        return true;
    }

    /**
     *
     */
    private void setHorseTexturePaths() {
        return;
    }

    /**
     *
     */
    public String getHorseTexture() {
        return null;
    }

    /**
     *
     */
    public String[] getVariantTexturePaths() {
        return null;
    }

    /**
     *
     */
    public void openGUI(EntityPlayer playerEntity) {
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
    private void mountTo(EntityPlayer player) {
        return;
    }

    /**
     * Return true if the horse entity can wear an armor
     */
    public boolean canWearArmor() {
        return true;
    }

    /**
     * Return true if the horse entity can carry a chest.
     */
    public boolean canCarryChest() {
        return true;
    }

    /**
     * Dead and sleeping entities cannot move
     */
    @Override
    protected boolean isMovementBlocked() {
        return true;
    }

    /**
     * Used to know if the horse can be leashed, if he can mate, or if we can interact with him
     */
    public boolean isUndead() {
        return true;
    }

    /**
     * Return true if the horse entity is sterile (Undead || Mule)
     */
    public boolean isSterile() {
        return true;
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
    private void func_110210_cH() {
        return;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource cause) {
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
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     *
     */
    private void openHorseMouth() {
        return;
    }

    /**
     * Return true if the horse entity ready to mate. (no rider, not riding, tame, adult, not steril...)
     */
    private boolean canMate() {
        return true;
    }

    /**
     *
     */
    @Override
    public void setEating(boolean eating) {
        return;
    }

    /**
     *
     */
    public void setEatingHaystack(boolean p_110227_1_) {
        return;
    }

    /**
     *
     */
    public void setRearing(boolean rearing) {
        return;
    }

    /**
     *
     */
    private void makeHorseRear() {
        return;
    }

    /**
     *
     */
    public void makeHorseRearWithSound() {
        return;
    }

    /**
     *
     */
    public void dropChestItems() {
        return;
    }

    /**
     *
     */
    private void dropItemsInChest(Entity entityIn,
                                  AnimalChest animalChestIn) {
        return;
    }

    /**
     *
     */
    public boolean setTamedBy(EntityPlayer player) {
        return true;
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    @Override
    public void moveEntityWithHeading(float strafe,
                                      float forward) {
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
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMateWith(EntityAnimal otherAnimal) {
        return true;
    }

    /**
     *
     */
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
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
     *
     */
    public float getGrassEatingAmount(float p_110258_1_) {
        return 0;
    }

    /**
     *
     */
    public float getRearingAmount(float p_110223_1_) {
        return 0;
    }

    /**
     *
     */
    public float getMouthOpennessAngle(float p_110201_1_) {
        return 0;
    }

    /**
     *
     */
    public void setJumpPower(int jumpPowerIn) {
        return;
    }

    /**
     * "Spawns particles for the horse entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
     */
    protected void spawnHorseParticles(boolean p_110216_1_) {
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
     *
     */
    @Override
    public void updateRiderPosition() {
        return;
    }

    /**
     * Returns randomized max health
     */
    private float getModifiedMaxHealth() {
        return 0;
    }

    /**
     * Returns randomized jump strength
     */
    private double getModifiedJumpStrength() {
        return 0;
    }

    /**
     * Returns randomized movement speed
     */
    private double getModifiedMovementSpeed() {
        return 0;
    }

    /**
     * Returns true if given item is horse armor
     */
    public static boolean isArmorItem(Item p_146085_0_) {
        return true;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    @Override
    public boolean isOnLadder() {
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
    public boolean func_174820_d(int inventorySlot,
                                 ItemStack itemStackIn) {
        return true;
    }

}