package net.minecraft.tileentity;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraft.util.ITickable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.VanillaDoubleChestItemHandler;

/**
 *
 */
public class TileEntityChest extends TileEntityLockable implements ITickable, IInventory {

    /**
     *
     */
    private ItemStack[] chestContents;

    /**
     * Determines if the check for adjacent chests has taken place.
     */
    public boolean adjacentChestChecked;

    /**
     * Contains the chest tile located adjacent to this one (if any)
     */
    public TileEntityChest adjacentChestZNeg;

    /**
     * Contains the chest tile located adjacent to this one (if any)
     */
    public TileEntityChest adjacentChestXPos;

    /**
     * Contains the chest tile located adjacent to this one (if any)
     */
    public TileEntityChest adjacentChestXNeg;

    /**
     * Contains the chest tile located adjacent to this one (if any)
     */
    public TileEntityChest adjacentChestZPos;

    /**
     * The current angle of the lid (between 0 and 1)
     */
    public float lidAngle;

    /**
     * The angle of the lid last tick
     */
    public float prevLidAngle;

    /**
     * The number of players currently using this chest
     */
    public int numPlayersUsing;

    /**
     * Server sync counter (once per 20 ticks)
     */
    private int ticksSinceSync;

    /**
     *
     */
    private int cachedChestType;

    /**
     *
     */
    private java.lang.String customName;

    /**
     *
     */
    public VanillaDoubleChestItemHandler doubleChestHandler;

    /**
     *
     */
    public TileEntityChest() {
        
    }

    /**
     *
     */
    public TileEntityChest(int chestType) {
        
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
    public void setCustomName(String name) {
        return;
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
    @Override
    public void updateContainingBlockInfo() {
        return;
    }

    /**
     *
     */
    private void func_174910_a(TileEntityChest chestTe,
                               EnumFacing side) {
        return;
    }

    /**
     * Performs the check for adjacent chests to determine if this chest is double or not.
     */
    public void checkForAdjacentChests() {
        return;
    }

    /**
     *
     */
    protected TileEntityChest getAdjacentChest(EnumFacing side) {
        return null;
    }

    /**
     *
     */
    private boolean isChestAt(BlockPos posIn) {
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
    @Override
    public boolean receiveClientEvent(int id,
                                      int type) {
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
     * invalidates a tile entity
     */
    @Override
    public void invalidate() {
        return;
    }

    /**
     *
     */
    public int getChestType() {
        return 0;
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

    /**
     *
     */
    public IItemHandler getSingleChestHandler() {
        return null;
    }

}