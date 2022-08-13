package net.minecraft.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.tileentity.TileEntity;
import com.google.common.collect.Sets;

/**
 *
 */
public abstract class Container extends Object {

    /**
     *
     */
    public java.util.List<ItemStack> inventoryItemStacks;

    /**
     *
     */
    public java.util.List<Slot> inventorySlots;

    /**
     *
     */
    public int windowId;

    /**
     *
     */
    private short transactionID;

    /**
     * The current drag mode (0 : evenly split, 1 : one item by slot, 2 : not used ?)
     */
    private int dragMode;

    /**
     * The current drag event (0 : start, 1 : add slot : 2 : end)
     */
    private int dragEvent;

    /**
     *
     */
    private final java.util.Set<Slot> dragSlots = Sets.newHashSet();

    /**
     *
     */
    protected java.util.List<ICrafting> crafters;

    /**
     *
     */
    private java.util.Set<EntityPlayer> playerList;

    /**
     *
     */
    public Container() {
        
    }

    /**
     * Adds an item slot to this container
     */
    protected Slot addSlotToContainer(Slot slotIn) {
        return null;
    }

    /**
     *
     */
    public void onCraftGuiOpened(ICrafting listener) {
        return;
    }

    /**
     *
     */
    public java.util.List<ItemStack> getInventory() {
        return null;
    }

    /**
     * Remove the given Listener. Method name is for legacy.
     */
    public void removeCraftingFromCrafters(ICrafting listeners) {
        return;
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void func_75142_b() {
        return;
    }

    /**
     * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
     */
    public boolean enchantItem(EntityPlayer playerIn,
                               int id) {
        return true;
    }

    /**
     *
     */
    public Slot getSlotFromInventory(IInventory inv,
                                     int slotIn) {
        return null;
    }

    /**
     *
     */
    public Slot getSlot(int slotId) {
        return null;
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn,
                                         int index) {
        return null;
    }

    /**
     * Handles slot click.
     */
    public ItemStack slotClick(int slotId,
                               int clickedButton,
                               int mode,
                               EntityPlayer playerIn) {
        return null;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack stack,
                                Slot p_94530_2_) {
        return true;
    }

    /**
     * Retries slotClick() in case of failure
     */
    protected void retrySlotClick(int slotId,
                                  int clickedButton,
                                  boolean mode,
                                  EntityPlayer playerIn) {
        return;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn) {
        return;
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        return;
    }

    /**
     * args: slotID, itemStack to put in slot
     */
    public void putStackInSlot(int slotID,
                               ItemStack stack) {
        return;
    }

    /**
     * places itemstacks in first x slots, x being aitemstack.lenght
     */
    public void putStacksInSlots(ItemStack[] p_75131_1_) {
        return;
    }

    /**
     *
     */
    public void updateProgressBar(int id,
                                  int data) {
        return;
    }

    /**
     * Gets a unique transaction ID. Parameter is unused.
     */
    public short getNextTransactionID(InventoryPlayer p_75136_1_) {
        return 0;
    }

    /**
     * gets whether or not the player can craft in this inventory or not
     */
    public boolean getCanCraft(EntityPlayer p_75129_1_) {
        return true;
    }

    /**
     * sets whether the player can craft in this inventory or not
     */
    public void setCanCraft(EntityPlayer p_75128_1_,
                            boolean p_75128_2_) {
        return;
    }

    /**
     *
     */
    public abstract boolean canInteractWith(EntityPlayer playerIn);

    /**
     * Merges provided ItemStack with the first avaliable one in the container/player inventor between minIndex
     * (included) and maxIndex (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the Container
     * implementation do not check if the item is valid for the slot
     */
    protected boolean mergeItemStack(ItemStack stack,
                                     int startIndex,
                                     int endIndex,
                                     boolean reverseDirection) {
        return true;
    }

    /**
     * Extracts the drag mode. Args : eventButton. Return (0 : evenly split, 1 : one item by slot, 2 : not used ?)
     */
    public static int extractDragMode(int p_94529_0_) {
        return 0;
    }

    /**
     * Args : clickedButton, Returns (0 : start drag, 1 : add slot, 2 : end drag)
     */
    public static int getDragEvent(int p_94532_0_) {
        return 0;
    }

    /**
     *
     */
    public static int func_94534_d(int p_94534_0_,
                                   int p_94534_1_) {
        return 0;
    }

    /**
     *
     */
    public static boolean isValidDragMode(int dragModeIn,
                                          EntityPlayer player) {
        return true;
    }

    /**
     * Reset the drag fields
     */
    protected void resetDrag() {
        return;
    }

    /**
     * Checks if it's possible to add the given itemstack to the given slot.
     */
    public static boolean canAddItemToSlot(Slot slotIn,
                                           ItemStack stack,
                                           boolean stackSizeMatters) {
        return true;
    }

    /**
     * Compute the new stack size, Returns the stack with the new size. Args : dragSlots, dragMode, dragStack,
     * slotStackSize
     */
    public static void computeStackSize(java.util.Set<Slot> p_94525_0_,
                                        int p_94525_1_,
                                        ItemStack p_94525_2_,
                                        int p_94525_3_) {
        return;
    }

    /**
     * Returns true if the player can "drag-spilt" items into this slot,. returns true by default. Called to check if
     * the slot can be added to a list of Slots to split the held ItemStack across.
     */
    public boolean canDragIntoSlot(Slot p_94531_1_) {
        return true;
    }

    /**
     * Like the version that takes an inventory. If the given TileEntity is not an Inventory, 0 is returned instead.
     */
    public static int calcRedstone(TileEntity te) {
        return 0;
    }

    /**
     *
     */
    public static int calcRedstoneFromInventory(IInventory inv) {
        return 0;
    }

}