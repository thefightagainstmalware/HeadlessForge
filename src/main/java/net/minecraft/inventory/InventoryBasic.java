package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class InventoryBasic extends Object implements IInventory {

    /**
     *
     */
    private java.lang.String inventoryTitle;

    /**
     *
     */
    private int slotsCount;

    /**
     *
     */
    private ItemStack[] inventoryContents;

    /**
     *
     */
    private java.util.List<IInvBasic> field_70480_d;

    /**
     *
     */
    private boolean hasCustomName;

    /**
     *
     */
    public InventoryBasic(String title,
                          boolean customName,
                          int slotCount) {
        
    }

    /**
     *
     */
    public InventoryBasic(IChatComponent title,
                          int slotCount) {
        
    }

    /**
     *
     */
    public void func_110134_a(IInvBasic p_110134_1_) {
        return;
    }

    /**
     *
     */
    public void func_110132_b(IInvBasic p_110132_1_) {
        return;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index) {
        return null;
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index,
                                   int count) {
        return null;
    }

    /**
     *
     */
    public ItemStack func_174894_a(ItemStack stack) {
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
     * Returns the number of slots in the inventory.
     */
    public int func_70302_i_() {
        return 0;
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
     * Sets the name of this inventory. This is displayed to the client on opening.
     */
    public void setCustomName(String inventoryTitleIn) {
        return;
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
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void func_147985_d() {
        return;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player) {
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