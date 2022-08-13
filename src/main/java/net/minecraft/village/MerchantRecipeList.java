package net.minecraft.village;

import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import java.io.IOException;
import net.minecraft.nbt.NBTTagList;

/**
 *
 */
public class MerchantRecipeList extends java.util.ArrayList<MerchantRecipe> {

    /**
     *
     */
    public MerchantRecipeList() {
        
    }

    /**
     *
     */
    public MerchantRecipeList(NBTTagCompound compound) {
        
    }

    /**
     * can par1,par2 be used to in crafting recipe par3
     */
    public MerchantRecipe canRecipeBeUsed(ItemStack p_77203_1_,
                                          ItemStack p_77203_2_,
                                          int p_77203_3_) {
        return null;
    }

    /**
     *
     */
    private boolean func_181078_a(ItemStack p_181078_1_,
                                  ItemStack p_181078_2_) {
        return true;
    }

    /**
     *
     */
    public void writeToBuf(PacketBuffer buffer) {
        return;
    }

    /**
     *
     */
    public void readRecipiesFromTags(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    public NBTTagCompound getRecipiesAsTags() {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static MerchantRecipeList readFromBuf(PacketBuffer buffer)
                                          throws java.io.IOException {
        return null;
    }

}