package net.minecraft.enchantment;

import net.minecraft.util.ResourceLocation;

public class EnchantmentArrowInfinite extends Enchantment
{
    public EnchantmentArrowInfinite(int enchID, ResourceLocation enchName, int enchWeight)
    {
        super(enchID, enchName, enchWeight, EnumEnchantmentType.BOW);
        this.setName("arrowInfinite");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 20;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int func_77325_b()
    {
        return 1;
    }
}
