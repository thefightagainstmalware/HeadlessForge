package net.minecraft.item;

import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.stats.StatList;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 */
public class ItemBucketMilk extends Item {

    /**
     *
     */
    public ItemBucketMilk() {
        
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    @Override
    public ItemStack onItemUseFinish(ItemStack stack,
                                     World worldIn,
                                     EntityPlayer playerIn) {
        return null;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 0;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return null;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn,
                                      World worldIn,
                                      EntityPlayer playerIn) {
        return null;
    }

}