package net.minecraft.entity.passive;

import net.minecraft.village.MerchantRecipe;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.entity.INpc;
import net.minecraft.world.World;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.item.Item;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class EntityVillager extends EntityAgeable implements IMerchant, INpc {

    /**
     *
     */
    private int randomTickDivider;

    /**
     *
     */
    private boolean isMating;

    /**
     *
     */
    private boolean isPlaying;

    /**
     *
     */
    Village villageObj;

    /**
     * This villager's current customer.
     */
    private EntityPlayer buyingPlayer;

    /**
     * Initialises the MerchantRecipeList.java
     */
    private MerchantRecipeList buyingList;

    /**
     *
     */
    private int timeUntilReset;

    /**
     * addDefaultEquipmentAndRecipies is called if this is true
     */
    private boolean needsInitilization;

    /**
     *
     */
    private boolean isWillingToMate;

    /**
     *
     */
    private int wealth;

    /**
     * Last player to trade with this villager, used for aggressivity.
     */
    private java.lang.String lastBuyingPlayer;

    /**
     *
     */
    private int careerId;

    /**
     * This is the EntityVillager's career level value
     */
    private int careerLevel;

    /**
     *
     */
    private boolean isLookingForHome;

    /**
     *
     */
    private boolean areAdditionalTasksSet;

    /**
     *
     */
    private InventoryBasic villagerInventory;

    /**
     * <span class="deprecatedLabel">Deprecated.</span>
     */
    @Deprecated
    private static final EntityVillager.ITradeList[][][][] DEFAULT_TRADE_LIST_MAP = null;

    /**
     *
     */
    public EntityVillager(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityVillager(World worldIn,
                          int professionId) {
        super(worldIn);
    }

    /**
     *
     */
    private void setAdditionalAItasks() {
        return;
    }

    /**
     * This is called when Entity's growing age timer reaches 0 (negative values are considered as a child, positive as
     * an adult)
     */
    @Override
    protected void onGrowingAdult() {
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
    protected void updateAITasks() {
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
    protected void entityInit() {
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
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
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
    public void setProfession(int professionId) {
        return;
    }

    /**
     *
     */
    public int getProfession() {
        return 0;
    }

    /**
     *
     */
    public boolean isMating() {
        return true;
    }

    /**
     *
     */
    public void setMating(boolean mating) {
        return;
    }

    /**
     *
     */
    public void setPlaying(boolean playing) {
        return;
    }

    /**
     *
     */
    public boolean isPlaying() {
        return true;
    }

    /**
     *
     */
    @Override
    public void setRevengeTarget(EntityLivingBase livingBase) {
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
     *
     */
    public void setCustomer(EntityPlayer p_70932_1_) {
        return;
    }

    /**
     *
     */
    public EntityPlayer getCustomer() {
        return null;
    }

    /**
     *
     */
    public boolean isTrading() {
        return true;
    }

    /**
     * Returns current or updated value of <a href="../../../../net/minecraft/entity/passive/EntityVillager.html#isWillingToMate"><code>isWillingToMate</code></a>
     */
    public boolean getIsWillingToMate(boolean updateFirst) {
        return true;
    }

    /**
     *
     */
    public void setIsWillingToMate(boolean willingToTrade) {
        return;
    }

    /**
     *
     */
    public void useRecipe(MerchantRecipe recipe) {
        return;
    }

    /**
     * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
     * being played depending if the suggested itemstack is not null.
     */
    public void verifySellingItem(ItemStack stack) {
        return;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    @Override
    public IChatComponent getDisplayName() {
        return null;
    }

    /**
     *
     */
    public MerchantRecipeList getRecipes(EntityPlayer p_70934_1_) {
        return null;
    }

    /**
     *
     */
    private void populateBuyingList() {
        return;
    }

    /**
     *
     */
    public void setRecipes(MerchantRecipeList recipeList) {
        return;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    @Override
    public IChatComponent func_145748_c_() {
        return null;
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
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     *
     */
    private void spawnParticles(EnumParticleTypes particleType) {
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
     *
     */
    public void setLookingForHome() {
        return;
    }

    /**
     *
     */
    public EntityVillager createChild(EntityAgeable ageable) {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean allowLeashing() {
        return true;
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    @Override
    public void onStruckByLightning(EntityLightningBolt lightningBolt) {
        return;
    }

    /**
     *
     */
    public InventoryBasic getVillagerInventory() {
        return null;
    }

    /**
     * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
     * better.
     */
    @Override
    protected void updateEquipmentIfNeeded(EntityItem itemEntity) {
        return;
    }

    /**
     *
     */
    private boolean canVillagerPickupItem(Item itemIn) {
        return true;
    }

    /**
     *
     */
    public boolean func_175553_cp() {
        return true;
    }

    /**
     * Used by <a href="../../../../net/minecraft/entity/ai/EntityAIVillagerInteract.html" title="class in net.minecraft.entity.ai"><code>EntityAIVillagerInteract</code></a> to check if the
     * villager can give some items from an inventory to another villager.
     */
    public boolean canAbondonItems() {
        return true;
    }

    /**
     *
     */
    public boolean func_175557_cr() {
        return true;
    }

    /**
     * Returns true if villager has enough items in inventory
     */
    private boolean hasEnoughItems(int multiplier) {
        return true;
    }

    /**
     * Returns true if villager has seeds, potatoes or carrots in inventory
     */
    public boolean isFarmItemInInventory() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean func_174820_d(int inventorySlot,
                                 ItemStack itemStackIn) {
        return true;
    }

    public class ITradeList {
    }
}