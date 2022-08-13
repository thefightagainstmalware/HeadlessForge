package net.minecraft.world;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;

/**
 *
 */
public interface IInteractionObject extends IWorldNameable {

    /**
     *
     */
    Container createContainer(InventoryPlayer playerInventory,
                              EntityPlayer playerIn);

    /**
     *
     */
    String getGuiID();

}