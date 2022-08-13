package net.minecraft.enchantment;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentUntouching extends Enchantment
{
    protected EnchantmentUntouching(int p_i45763_1_, ResourceLocation p_i45763_2_, int p_i45763_3_)
    {
        super(p_i45763_1_, p_i45763_2_, p_i45763_3_, EnumEnchantmentType.DIGGER);
        this.setName("untouching");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 15;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int func_77325_b()
    {
        return 1;
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    public boolean func_77326_a(Enchantment ench)
    {
        return super.func_77326_a(ench) && ench.field_77352_x != fortune.field_77352_x;
    }

    /**
     * Determines if this enchantment can be applied to a specific ItemStack.
     */
    public boolean func_92089_a(ItemStack stack)
    {
        return stack.func_77973_b() == Items.shears ? true : super.func_92089_a(stack);
    }
}
