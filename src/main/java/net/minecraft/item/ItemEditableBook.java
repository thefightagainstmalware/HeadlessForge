package net.minecraft.item;

import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.StringUtils;
import net.minecraft.util.IChatComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;

/**
 *
 */
public class ItemEditableBook extends Item {

    /**
     *
     */
    public ItemEditableBook() {
        
    }

    /**
     *
     */
    public static boolean validBookTagContents(NBTTagCompound nbt) {
        return true;
    }

    /**
     * Gets the generation of the book (how many times it has been cloned)
     */
    public static int getGeneration(ItemStack book) {
        return 0;
    }

    /**
     *
     */
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
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
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn,
                                      World worldIn,
                                      EntityPlayer playerIn) {
        return null;
    }

    /**
     *
     */
    private void resolveContents(ItemStack stack,
                                 EntityPlayer player) {
        return;
    }

    /**
     *
     */
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}