package net.minecraft.entity.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.StatCollector;

/**
 *
 */
public class EntityItem extends Entity {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * The age of this EntityItem (used to animate it up and down as well as expire it)
     */
    private int age;

    /**
     *
     */
    private int delayBeforeCanPickup;

    /**
     * The health of this EntityItem. (For example, damage for tools)
     */
    private int health;

    /**
     *
     */
    private java.lang.String thrower;

    /**
     *
     */
    private java.lang.String owner;

    /**
     * The EntityItem's random initial float height.
     */
    public float hoverStart;

    /**
     * The maximum age of this EntityItem.  The item is expired once this is reached.
     */
    public int lifespan;

    /**
     *
     */
    public EntityItem(World worldIn,
                      double x,
                      double y,
                      double z) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityItem(World worldIn,
                      double x,
                      double y,
                      double z,
                      ItemStack stack) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityItem(World worldIn) {
        super(worldIn);
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
    protected void entityInit() {
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
     * Looks for other itemstacks nearby and tries to stack them together
     */
    private void searchForOtherItemsNearby() {
        return;
    }

    /**
     * Tries to merge this item with the item passed as the parameter. Returns true if successful. Either this item or
     * the other item will  be removed from the world.
     */
    private boolean combineItems(EntityItem other) {
        return true;
    }

    /**
     * sets the age of the item so that it'll despawn one minute after it has been dropped (instead of five). Used when
     * items are dropped from players in creative mode
     */
    public void setAgeToCreativeDespawnTime() {
        return;
    }

    /**
     * Returns if this entity is in water and will end up adding the waters velocity to the entity
     */
    @Override
    public boolean handleWaterMovement() {
        return true;
    }

    /**
     * Will deal the specified amount of damage to the entity if the entity isn't immune to fire damage. Args:
     * amountDamage
     */
    @Override
    protected void dealFireDamage(int amount) {
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
     * Called by a player entity when they collide with an entity
     */
    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {
        return;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @Override
    public String func_70005_c_() {
        return null;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    @Override
    public boolean canAttackWithItem() {
        return true;
    }

    /**
     * Teleports the entity to another dimension. Params: Dimension number to teleport to
     */
    @Override
    public void travelToDimension(int dimensionId) {
        return;
    }

    /**
     * Returns the ItemStack corresponding to the Entity (Note: if no item exists, will log an error but still return an
     * ItemStack containing Block.stone)
     */
    public ItemStack getEntityItem() {
        return null;
    }

    /**
     * Sets the ItemStack for this entity
     */
    public void setEntityItemStack(ItemStack stack) {
        return;
    }

    /**
     *
     */
    public String getOwner() {
        return null;
    }

    /**
     *
     */
    public void func_145797_a(String owner) {
        return;
    }

    /**
     *
     */
    public String getThrower() {
        return null;
    }

    /**
     *
     */
    public void setThrower(String thrower) {
        return;
    }

    /**
     *
     */
    public int getAge() {
        return 0;
    }

    /**
     *
     */
    public void setDefaultPickupDelay() {
        return;
    }

    /**
     *
     */
    public void func_174868_q() {
        return;
    }

    /**
     *
     */
    public void setInfinitePickupDelay() {
        return;
    }

    /**
     *
     */
    public void setPickupDelay(int ticks) {
        return;
    }

    /**
     *
     */
    public boolean cannotPickup() {
        return true;
    }

    /**
     *
     */
    public void setNoDespawn() {
        return;
    }

    /**
     *
     */
    public void func_174870_v() {
        return;
    }

}