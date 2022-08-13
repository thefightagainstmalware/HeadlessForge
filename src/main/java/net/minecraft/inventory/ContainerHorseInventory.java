package net.minecraft.inventory;

import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public class ContainerHorseInventory extends Container {

    /**
     *
     */
    private IInventory horseInventory;

    /**
     *
     */
    private EntityHorse theHorse;

    /**
     *
     */
    public ContainerHorseInventory(IInventory playerInventory,
                                   IInventory horseInventoryIn,
                                   EntityHorse horse,
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

}