package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.stats.StatList;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 */
public class ItemEnderPearl extends Item {

    /**
     *
     */
    public ItemEnderPearl() {
        
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