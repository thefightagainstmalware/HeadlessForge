package net.minecraft.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.Container;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.IItemHandler;

/**
 *
 */
public class TileEntityHopper extends TileEntityLockable implements IHopper, ITickable {

    /**
     *
     */
    private ItemStack[] inventory;

    /**
     *
     */
    private java.lang.String customName;

    /**
     *
     */
    private int transferCooldown;

    /**
     *
     */
    public TileEntityHopper() {
        
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
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void func_70296_d() {
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
    public void setCustomName(String customNameIn) {
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
     * Like the old updateEntity(), except more generic.
     */
    public void update() {
        return;
    }

    /**
     *
     */
    public boolean updateHopper() {
        return true;
    }

    /**
     *
     */
    private boolean isEmpty() {
        return true;
    }

    /**
     *
     */
    private boolean isFull() {
        return true;
    }

    /**
     *
     */
    private boolean transferItemsOut() {
        return true;
    }

    /**
     * Returns false if the inventory has any room to place items in
     */
    private boolean isInventoryFull(IInventory inventoryIn,
                                    EnumFacing side) {
        return true;
    }

    /**
     * Returns false if the specified IInventory contains any items
     */
    private static boolean isInventoryEmpty(IInventory inventoryIn,
                                            EnumFacing side) {
        return true;
    }

    /**
     *
     */
    public static boolean captureDroppedItems(IHopper p_145891_0_) {
        return true;
    }

    /**
     * Pulls from the specified slot in the inventory and places in any available slot in the hopper. Returns true if
     * the entire stack was moved
     */
    private static boolean pullItemFromSlot(IHopper hopper,
                                            IInventory inventoryIn,
                                            int index,
                                            EnumFacing direction) {
        return true;
    }

    /**
     * Attempts to place the passed EntityItem's stack into the inventory using as many slots as possible. Returns false
     * if the stackSize of the drop was not depleted.
     */
    public static boolean putDropInInventoryAllSlots(IInventory p_145898_0_,
                                                     EntityItem itemIn) {
        return true;
    }

    /**
     * Attempts to place the passed stack in the inventory, using as many slots as required. Returns leftover items
     */
    public static ItemStack putStackInInventoryAllSlots(IInventory inventoryIn,
                                                        ItemStack stack,
                                                        EnumFacing side) {
        return null;
    }

    /**
     * Can this hopper insert the specified item from the specified slot on the specified side?
     */
    private static boolean canInsertItemInSlot(IInventory inventoryIn,
                                               ItemStack stack,
                                               int index,
                                               EnumFacing side) {
        return true;
    }

    /**
     * Can this hopper extract the specified item from the specified slot on the specified side?
     */
    private static boolean canExtractItemFromSlot(IInventory inventoryIn,
                                                  ItemStack stack,
                                                  int index,
                                                  EnumFacing side) {
        return true;
    }

    /**
     * Insert the specified stack to the specified inventory and return any leftover items
     */
    private static ItemStack insertStack(IInventory inventoryIn,
                                         ItemStack stack,
                                         int index,
                                         EnumFacing side) {
        return null;
    }

    /**
     * Returns the IInventory that this hopper is pointing into
     */
    private IInventory getInventoryForHopperTransfer() {
        return null;
    }

    /**
     * Returns the IInventory for the specified hopper
     */
    public static IInventory getHopperInventory(IHopper hopper) {
        return null;
    }

    /**
     *
     */
    public static java.util.List<EntityItem> func_181556_a(World p_181556_0_,
                                                           double p_181556_1_,
                                                           double p_181556_3_,
                                                           double p_181556_5_) {
        return null;
    }

    /**
     * Returns the IInventory (if applicable) of the TileEntity at the specified position
     */
    public static IInventory getInventoryAtPosition(World worldIn,
                                                    double x,
                                                    double y,
                                                    double z) {
        return null;
    }

    /**
     *
     */
    private static boolean canCombine(ItemStack stack1,
                                      ItemStack stack2) {
        return true;
    }

    /**
     * Gets the world X position for this hopper entity.
     */
    public double getXPos() {
        return 0;
    }

    /**
     * Gets the world Y position for this hopper entity.
     */
    public double getYPos() {
        return 0;
    }

    /**
     * Gets the world Z position for this hopper entity.
     */
    public double getZPos() {
        return 0;
    }

    /**
     *
     */
    public void setTransferCooldown(int ticks) {
        return;
    }

    /**
     *
     */
    public boolean isOnTransferCooldown() {
        return true;
    }

    /**
     *
     */
    public boolean mayTransfer() {
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
     *
     */
    @Override
    protected IItemHandler createUnSidedHandler() {
        return null;
    }

}