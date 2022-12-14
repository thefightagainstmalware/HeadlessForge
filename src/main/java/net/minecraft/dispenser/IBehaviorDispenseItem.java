package net.minecraft.dispenser;

import net.minecraft.item.ItemStack;

/**
 *
 */
public interface IBehaviorDispenseItem {

    /**
     *
     */
    IBehaviorDispenseItem itemDispenseBehaviorProvider = new BehaviorDefaultDispenseItem();

    /**
     * Dispenses the specified ItemStack from a dispenser.
     */
    ItemStack dispense(IBlockSource source,
                       ItemStack stack);

}