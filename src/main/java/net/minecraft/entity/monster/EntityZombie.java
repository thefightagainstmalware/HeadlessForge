package net.minecraft.entity.monster;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;

import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.IEntityLivingData;

/**
 *
 */
public class EntityZombie extends EntityMob {

    /**
     * The attribute which determines the chance that this mob will spawn reinforcements
     */
    protected static final IAttribute reinforcementChance = (new RangedAttribute((IAttribute)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");

    /**
     *
     */
    private static final java.util.UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");

    /**
     *
     */
    private static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5D, 1);

    /**
     *
     */
    private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);

    /**
     * Ticker used to determine the time remaining for this zombie to convert into a villager when cured.
     */
    private int conversionTime;

    /**
     *
     */
    private boolean isBreakDoorsTaskSet;

    /**
     * The width of the entity
     */
    private float zombieWidth;

    /**
     * The height of the the entity.
     */
    private float zombieHeight;

    /**
     *
     */
    public EntityZombie(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    protected void applyEntityAI() {
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
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getTotalArmorValue() {
        return 0;
    }

    /**
     *
     */
    public boolean isBreakDoorsTaskSet() {
        return true;
    }

    /**
     * Sets or removes EntityAIBreakDoor task
     */
    public void setBreakDoorsAItask(boolean par1) {
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
     * Get the experience points the entity currently has.
     */
    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return 0;
    }

    /**
     * Set whether this zombie is a child.
     */
    public void setChild(boolean childZombie) {
        return;
    }

    /**
     * Return whether this zombie is a villager.
     */
    public boolean isVillager() {
        return true;
    }

    /**
     * Set whether this zombie is a villager.
     */
    public void setVillager(boolean villager) {
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
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
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
     *
     */
    @Override
    protected Item getDropItem() {
        return null;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return null;
    }

    /**
     * Causes this Entity to drop a random item.
     */
    @Override
    protected void addRandomDrop() {
        return;
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */
    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
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
     * This method gets called when the entity kills another one.
     */
    @Override
    public void onKillEntity(EntityLivingBase entityLivingIn) {
        return;
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
    protected boolean func_175448_a(ItemStack stack) {
        return true;
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
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    @Override
    public boolean interact(EntityPlayer player) {
        return true;
    }

    /**
     * Starts converting this zombie into a villager. The zombie converts into a villager after the specified time in
     * ticks.
     */
    protected void startConversion(int ticks) {
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
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return true;
    }

    /**
     * Returns whether this zombie is in the process of converting to a villager
     */
    public boolean isConverting() {
        return true;
    }

    /**
     * Convert this zombie into a villager.
     */
    protected void convertToVillager() {
        return;
    }

    /**
     * Return the amount of time decremented from conversionTime every tick.
     */
    protected int getConversionTimeBoost() {
        return 0;
    }

    /**
     * sets the size of the entity to be half of its current size if true.
     */
    public void setChildSize(boolean isChild) {
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
     * Multiplies the height and width by the provided float.
     */
    protected final void multiplySize(float size) {
        return;
    }

    /**
     * Returns the Y Offset of this entity.
     */
    @Override
    public double getYOffset() {
        return 0;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource cause) {
        return;
    }

}