package net.minecraft.item;

import java.util.List;
import java.util.Random;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.WeightedRandomChestContent;

public class ItemEnchantedBook extends Item
{
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack stack)
    {
        return false;
    }

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack stack)
    {
        return this.getEnchantments(stack).func_74745_c() > 0 ? EnumRarity.UNCOMMON : super.getRarity(stack);
    }

    public NBTTagList getEnchantments(ItemStack stack)
    {
        NBTTagCompound nbttagcompound = stack.func_77978_p();
        return nbttagcompound != null && nbttagcompound.func_150297_b("StoredEnchantments", 9) ? (NBTTagList)nbttagcompound.getTag("StoredEnchantments") : new NBTTagList();
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        super.addInformation(stack, playerIn, tooltip, advanced);
        NBTTagList nbttaglist = this.getEnchantments(stack);

        if (nbttaglist != null)
        {
            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                int j = nbttaglist.func_150305_b(i).func_74765_d("id");
                int k = nbttaglist.func_150305_b(i).func_74765_d("lvl");

                if (Enchantment.func_180306_c(j) != null)
                {
                    tooltip.add(Enchantment.func_180306_c(j).func_77316_c(k));
                }
            }
        }
    }

    /**
     * Adds an stored enchantment to an enchanted book ItemStack
     */
    public void addEnchantment(ItemStack stack, EnchantmentData enchantment)
    {
        NBTTagList nbttaglist = this.getEnchantments(stack);
        boolean flag = true;

        for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.func_150305_b(i);

            if (nbttagcompound.func_74765_d("id") == enchantment.enchantmentobj.field_77352_x)
            {
                if (nbttagcompound.func_74765_d("lvl") < enchantment.enchantmentLevel)
                {
                    nbttagcompound.setShort("lvl", (short)enchantment.enchantmentLevel);
                }

                flag = false;
                break;
            }
        }

        if (flag)
        {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setShort("id", (short)enchantment.enchantmentobj.field_77352_x);
            nbttagcompound1.setShort("lvl", (short)enchantment.enchantmentLevel);
            nbttaglist.func_74742_a(nbttagcompound1);
        }

        if (!stack.func_77942_o())
        {
            stack.func_77982_d(new NBTTagCompound());
        }

        stack.func_77978_p().func_74782_a("StoredEnchantments", nbttaglist);
    }

    /**
     * Returns the ItemStack of an enchanted version of this item.
     */
    public ItemStack getEnchantedItemStack(EnchantmentData data)
    {
        ItemStack itemstack = new ItemStack(this);
        this.addEnchantment(itemstack, data);
        return itemstack;
    }

    public void getAll(Enchantment enchantment, List<ItemStack> list)
    {
        for (int i = enchantment.func_77319_d(); i <= enchantment.func_77325_b(); ++i)
        {
            list.add(this.getEnchantedItemStack(new EnchantmentData(enchantment, i)));
        }
    }

    public WeightedRandomChestContent getRandom(Random rand)
    {
        return this.getRandom(rand, 1, 1, 1);
    }

    public WeightedRandomChestContent getRandom(Random rand, int minChance, int maxChance, int weight)
    {
        ItemStack itemstack = new ItemStack(Items.book, 1, 0);
        EnchantmentHelper.addRandomEnchantment(rand, itemstack, 30);
        return new WeightedRandomChestContent(itemstack, minChance, maxChance, weight);
    }
}
