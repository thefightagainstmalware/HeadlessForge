package net.minecraft.enchantment;

import net.minecraft.util.ResourceLocation;

/**
 *
 */
public class EnchantmentWaterWorker extends Enchantment {

    /**
     *
     */
    public EnchantmentWaterWorker(int p_i45761_1_,
                                  ResourceLocation p_i45761_2_,
                                  int p_i45761_3_) {
        super(p_i45761_1_, p_i45761_2_, p_i45761_3_, EnumEnchantmentType.BREAKABLE);
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

}