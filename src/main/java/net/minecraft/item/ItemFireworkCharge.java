package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

/**
 *
 */
public class ItemFireworkCharge extends Item {

    /**
     *
     */
    public ItemFireworkCharge() {
        
    }

    /**
     *
     */
    @Override
    public int getColorFromItemStack(ItemStack stack,
                                     int renderPass) {
        return 0;
    }

    /**
     *
     */
    public static NBTBase getExplosionTag(ItemStack stack,
                                          String key) {
        return null;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    public void addInformation(ItemStack stack,
                               EntityPlayer playerIn,
                               java.util.List<String> tooltip,
                               boolean advanced) {
        return;
    }

    /**
     *
     */
    public static void addExplosionInfo(NBTTagCompound nbt,
                                        java.util.List<String> tooltip) {
        return;
    }

}