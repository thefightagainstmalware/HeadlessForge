package net.minecraft.enchantment;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class EnchantmentDigging extends Enchantment {

    /**
     *
     */
    protected EnchantmentDigging(int enchID,
                                 ResourceLocation enchName,
                                 int enchWeight) {
        super(enchID, enchName, enchWeight ,EnumEnchantmentType.DIGGER);
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 0;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return 0;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    @Override
    public int func_77325_b() {
        return 0;
    }

    /**
     * Determines if this enchantment can be applied to a specific ItemStack.
     */
    @Override
    public boolean func_92089_a(ItemStack stack) {
        return true;
    }

}