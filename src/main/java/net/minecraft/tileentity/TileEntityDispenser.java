package net.minecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Random;

/**
 *
 */
public class TileEntityDispenser extends TileEntityLockable implements IInventory {

    /**
     *
     */
    private static final java.util.Random RNG = new Random();

    /**
     *
     */
    private ItemStack[] stacks;

    /**
     *
     */
    protected java.lang.String customName;

    /**
     *
     */
    public TileEntityDispenser() {
        
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
     *
     */
    public int getDispenseSlot() {
        return 0;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void func_70299_a(int index,
                             ItemStack stack) {
        return;
    }

    /**
     * Add the given ItemStack to this Dispenser. Return the Slot the Item was placed in or -1 if no free slot is
     * available.
     */
    public int addItemStack(ItemStack stack) {
        return 0;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName() {
        return null;
    }

    /**
     *
     */
    public void setCustomName(String customName) {
        return;
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName() {
        return true;
    }

    /**
     *
     */
    @Override
    public void func_145839_a(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    @Override
    public void func_145841_b(NBTTagCompound compound) {
        return;
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit() {
        return 0;
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
    public String getGuiID() {
        return null;
    }

    /**
     *
     */
    public Container createContainer(InventoryPlayer playerInventory,
                                     EntityPlayer playerIn) {
        return null;
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