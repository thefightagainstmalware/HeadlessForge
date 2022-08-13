package net.minecraft.item;

import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.stats.StatList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.storage.MapData;

/**
 *
 */
public class ItemEmptyMap extends ItemMapBase {

    /**
     *
     */
    protected ItemEmptyMap() {
        
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