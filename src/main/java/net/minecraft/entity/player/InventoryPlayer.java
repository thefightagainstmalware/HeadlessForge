package net.minecraft.entity.player;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class InventoryPlayer extends Object implements IInventory {

    /**
     * An array of 36 item stacks indicating the main player inventory (including the visible bar).
     */
    public ItemStack[] mainInventory;

    /**
     * An array of 4 item stacks containing the currently worn armor pieces.
     */
    public ItemStack[] armorInventory;

    /**
     * The index of the currently held item (0-8).
     */
    public int currentItem;

    /**
     * The player whose inventory this is.
     */
    public EntityPlayer player;

    /**
     *
     */
    private ItemStack itemStack;

    /**
     * Set true whenever the inventory changes. Nothing sets it false so you will have to write your own code to check
     * it and reset the value.
     */
    public boolean inventoryChanged;

    /**
     *
     */
    public InventoryPlayer(EntityPlayer playerIn) {
        
    }

    /**
     * Returns the item stack currently held by the player.
     */
    public ItemStack getCurrentItem() {
        return null;
    }

    /**
     * Get the size of the player hotbar inventory
     */
    public static int getHotbarSize() {
        return 0;
    }

    /**
     *
     */
    private int getInventorySlotContainItem(Item itemIn) {
        return 0;
    }

    /**
     *
     */
    private int getInventorySlotContainItemAndDamage(Item itemIn,
                                                     int p_146024_2_) {
        return 0;
    }

    /**
     * stores an itemstack in the users inventory
     */
    private int storeItemStack(ItemStack itemStackIn) {
        return 0;
    }

    /**
     * Returns the first item stack that is empty.
     */
    public int getFirstEmptyStack() {
        return 0;
    }

    /**
     *
     */
    public void setCurrentItem(Item itemIn,
                               int p_146030_2_,
                               boolean p_146030_3_,
                               boolean p_146030_4_) {
        return;
    }

    /**
     * Removes matching items from the inventory.
     * @param itemIn The item to match, null ignores.
     * @param metadataIn The metadata to match, -1 ignores.
     * @param removeCount The number of items to remove. If less than 1, removes all matching items.
     * @param itemNBT The NBT data to match, null ignores.
     * @return The number of items removed from the inventory.
     */
    public int func_174925_a(Item itemIn,
                             int metadataIn,
                             int removeCount,
                             NBTTagCompound itemNBT) {
        return 0;
    }

    /**
     * Switch the current item to the next one or the previous one
     */
    public void changeCurrentItem(int p_70453_1_) {
        return;
    }

    /**
     * This function stores as many items of an ItemStack as possible in a matching slot and returns the quantity of
     * left over items.
     */
    private int storePartialItemStack(ItemStack itemStackIn) {
        return 0;
    }

    /**
     * Decrement the number of animations remaining. Only called on client side. This is used to handle the animation of
     * receiving a block.
     */
    public void decrementAnimations() {
        return;
    }

    /**
     * removed one item of specified Item from inventory (if it is in a stack, the stack size will reduce with 1)
     */
    public boolean consumeInventoryItem(Item itemIn) {
        return true;
    }

    /**
     * Checks if a specified Item is inside the inventory
     */
    public boolean hasItem(Item itemIn) {
        return true;
    }

    /**
     * Adds the item stack to the inventory, returns false if it is impossible.
     */
    public boolean func_70441_a(ItemStack itemStackIn) {
        return true;
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index,
                                   int count) {
        return null;
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void func_70299_a(int index,
                             ItemStack stack) {
        return;
    }

    /**
     *
     */
    public float getStrVsBlock(Block blockIn) {
        return 0;
    }

    /**
     * Writes the inventory out as a list of compound tags. This is where the slot indices are used (+100 for armor, +80
     * for crafting).
     */
    public NBTTagList writeToNBT(NBTTagList p_70442_1_) {
        return null;
    }

    /**
     * Reads from the given tag list and fills the slots in the inventory with the correct items.
     */
    public void readFromNBT(NBTTagList p_70443_1_) {
        return;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int func_70302_i_() {
        return 0;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index) {
        return null;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName() {
        return null;
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName() {
        return true;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     * @return
     */
    public IChatComponent getDisplayName() {
        return null;
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit() {
        return 0;
    }

    /**
     *
     */
    public boolean canHeldItemHarvest(Block blockIn) {
        return true;
    }

    /**
     * returns a player armor item (as itemstack) contained in specified armor slot.
     */
    public ItemStack armorItemInSlot(int p_70440_1_) {
        return null;
    }

    /**
     * Based on the damage values and maximum damage values of each armor item, returns the current armor value.
     */
    public int getTotalArmorValue() {
        return 0;
    }

    /**
     * Damages armor in each slot by the specified amount.
     */
    public void damageArmor(float damage) {
        return;
    }

    /**
     * Drop all armor and main inventory items.
     */
    public void dropAllItems() {
        return;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void func_147985_d() {
        return;
    }

    /**
     * Set the stack helds by mouse, used in GUI/Container
     */
    public void setItemStack(ItemStack itemStackIn) {
        return;
    }

    /**
     * Stack helds by mouse, used in GUI and Containers
     */
    public ItemStack getItemStack() {
        return null;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    /**
     * Returns true if the specified ItemStack exists in the inventory.
     */
    public boolean hasItemStack(ItemStack itemStackIn) {
        return true;
    }

    /**
     *
     */
    public void openInventory(EntityPlayer player) {
        return;
    }

    /**
     *
     */
    public void closeInventory(EntityPlayer player) {
        return;
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index,
                                      ItemStack stack) {
        return true;
    }

    /**
     * Copy the ItemStack contents from another InventoryPlayer instance
     */
    public void copyInventory(InventoryPlayer playerInventory) {
        return;
    }

    /**
     *
     */
    public int getField(int id) {
        return 0;
    }

    /**
     *
     */
    public void setField(int id,
                         int value) {
        return;
    }

    /**
     *
     */
    public int getFieldCount() {
        return 0;
    }

    /**
     *
     */
    public void func_174888_l() {
        return;
    }

}