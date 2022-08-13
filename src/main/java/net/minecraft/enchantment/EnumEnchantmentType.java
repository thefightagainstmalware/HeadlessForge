package net.minecraft.enchantment;

import net.minecraft.item.ItemBow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemFishingRod;

/**
 *
 */
public enum EnumEnchantmentType {
    ALL , ARMOR , ARMOR_FEET , ARMOR_HEAD , ARMOR_LEGS , ARMOR_TORSO , BOW , BREAKABLE , DIGGER , FISHING_ROD , WEAPON;

    /**
     * Return true if the item passed can be enchanted by a enchantment of this type.
     */
    public boolean canEnchantItem(Item p_77557_1_) {
        return true;
    }

}