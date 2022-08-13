package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.stats.StatList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 *
 */
public class ItemWritableBook extends Item {

    /**
     *
     */
    public ItemWritableBook() {
        
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

    /**
     * this method returns true if the book's NBT Tag List "pages" is valid
     */
    public static boolean isNBTValid(NBTTagCompound nbt) {
        return true;
    }

}