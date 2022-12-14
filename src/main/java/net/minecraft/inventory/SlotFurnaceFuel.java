package net.minecraft.inventory;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class SlotFurnaceFuel extends Slot {

    /**
     *
     */
    public SlotFurnaceFuel(IInventory inventoryIn,
                           int slotIndex,
                           int xPosition,
                           int yPosition) {
        super(inventoryIn, slotIndex, xPosition, yPosition);
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack stack) {
        return true;
    }

    /**
     *
     */
    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 0;
    }

    /**
     *
     */
    public static boolean isBucket(ItemStack stack) {
        return true;
    }

}