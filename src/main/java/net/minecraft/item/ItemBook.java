package net.minecraft.item;

/**
 *
 */
public class ItemBook extends Item {

    /**
     *
     */
    public ItemBook() {
        
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    @Override
    public boolean isItemTool(ItemStack stack) {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability() {
        return 0;
    }

}