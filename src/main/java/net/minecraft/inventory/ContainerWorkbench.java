package net.minecraft.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 *
 */
public class ContainerWorkbench extends Container {

    /**
     * The crafting matrix inventory (3x3).
     */
    public InventoryCrafting craftMatrix;

    /**
     *
     */
    public IInventory craftResult;

    /**
     *
     */
    private World worldObj;

    /**
     * Position of the workbench
     */
    private BlockPos pos;

    /**
     *
     */
    public ContainerWorkbench(InventoryPlayer playerInventory,
                              World worldIn,
                              BlockPos posIn) {
        
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        return;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        return;
    }

    /**
     *
     */
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn,
                                         int index) {
        return null;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canMergeSlot(ItemStack stack,
                                Slot p_94530_2_) {
        return true;
    }

}