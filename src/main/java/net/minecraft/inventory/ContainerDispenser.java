package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class ContainerDispenser extends Container {

    /**
     *
     */
    private IInventory dispenserInventory;

    /**
     *
     */
    public ContainerDispenser(IInventory playerInventory,
                              IInventory dispenserInventoryIn) {
        
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

}