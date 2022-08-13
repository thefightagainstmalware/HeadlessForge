package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class ContainerChest extends Container {

    /**
     *
     */
    private IInventory lowerChestInventory;

    /**
     *
     */
    private int numRows;

    /**
     *
     */
    public ContainerChest(IInventory playerInventory,
                          IInventory chestInventory,
                          EntityPlayer player) {
        
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
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        return;
    }

    /**
     * Return this chest container's lower chest inventory.
     */
    public IInventory getLowerChestInventory() {
        return null;
    }

}