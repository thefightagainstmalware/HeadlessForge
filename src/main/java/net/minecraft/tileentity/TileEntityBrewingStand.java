package net.minecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.Container;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.Item;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.IItemHandler;

/**
 *
 */
public class TileEntityBrewingStand extends TileEntityLockable implements ITickable, ISidedInventory {

    /**
     * an array of the input slot indices
     */
    private static final int[] inputSlots = new int[4];

    /**
     * an array of the output slot indices
     */
    private static final int[] outputSlots = new int[1];

    /**
     * The ItemStacks currently placed in the slots of the brewing stand
     */
    private ItemStack[] brewingItemStacks;

    /**
     *
     */
    private int brewTime;

    /**
     * an integer with each bit specifying whether that slot of the stand contains a potion
     */
    private boolean[] filledSlots;

    /**
     * used to check if the current ingredient has been removed from the brewing stand during brewing
     */
    private Item ingredientID;

    /**
     *
     */
    private java.lang.String customName;

    /**
     *
     */
    IItemHandler handlerInput;

    /**
     *
     */
    IItemHandler handlerOutput;

    /**
     *
     */
    public TileEntityBrewingStand() {
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
     *
     */
    public void setName(String name) {
        return;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int func_70302_i_() {
        return 0;
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update() {
        return;
    }

    /**
     *
     */
    private boolean canBrew() {
        return true;
    }

    /**
     *
     */
    private void brewPotions() {
        return;
    }

    /**
     * The result of brewing a potion of the specified damage value with an ingredient itemstack.
     */
    private int getPotionResult(int meta,
                                ItemStack stack) {
        return 0;
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
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void func_70299_a(int index,
                             ItemStack stack) {
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
    public boolean[] func_174902_m() {
        return null;
    }

    /**
     *
     */
    public int[] getSlotsForFace(EnumFacing side) {
        return null;
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: slot, item,
     * side
     */
    public boolean canInsertItem(int index,
                                 ItemStack itemStackIn,
                                 EnumFacing direction) {
        return true;
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: slot, item,
     * side
     */
    public boolean canExtractItem(int index,
                                  ItemStack stack,
                                  EnumFacing direction) {
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

    /**
     * Retrieves the handler for the capability requested on the specific side.
     * The return value CAN be null if the object does not support the capability.
     * The return value CAN be the same for multiple faces.
     * @param capability The capability to check
     * @param facing The Side to check from:
     *    CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return True if this object supports the capability.
     */
    @Override
    public <T> T getCapability(Capability<T> capability,
                               EnumFacing facing) {
        return null;
    }

}