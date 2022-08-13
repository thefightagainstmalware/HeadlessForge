package net.minecraft.item;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemAppleGold extends ItemFood
{
    public ItemAppleGold(int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);
        this.setHasSubtypes(true);
    }

    public boolean hasEffect(ItemStack stack)
    {
        return stack.getMetadata() > 0;
    }

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack stack)
    {
        return stack.getMetadata() == 0 ? EnumRarity.RARE : EnumRarity.EPIC;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            player.func_70690_d(new PotionEffect(Potion.absorption.field_76415_H, 2400, 0));
        }

        if (stack.getMetadata() > 0)
        {
            if (!worldIn.isRemote)
            {
                player.func_70690_d(new PotionEffect(Potion.regeneration.field_76415_H, 600, 4));
                player.func_70690_d(new PotionEffect(Potion.resistance.field_76415_H, 6000, 0));
                player.func_70690_d(new PotionEffect(Potion.fireResistance.field_76415_H, 6000, 0));
            }
        }
        else
        {
            super.onFoodEaten(stack, worldIn, player);
        }
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        subItems.add(new ItemStack(itemIn, 1, 0));
        subItems.add(new ItemStack(itemIn, 1, 1));
    }
}
