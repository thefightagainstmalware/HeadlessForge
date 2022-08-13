package net.minecraft.entity;

import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.inventory.InventoryMerchant;

/**
 *
 */
public class NpcMerchant extends Object implements IMerchant {

    /**
     * Instance of Merchants Inventory.
     */
    private InventoryMerchant theMerchantInventory;

    /**
     * This merchant's current player customer.
     */
    private EntityPlayer customer;

    /**
     * The MerchantRecipeList instance.
     */
    private MerchantRecipeList recipeList;

    /**
     *
     */
    private IChatComponent field_175548_d;

    /**
     *
     */
    public NpcMerchant(EntityPlayer p_i45817_1_,
                       IChatComponent p_i45817_2_) {
        
    }

    /**
     *
     */
    public EntityPlayer getCustomer() {
        return null;
    }

    /**
     *
     */
    public void setCustomer(EntityPlayer p_70932_1_) {
        return;
    }

    /**
     *
     */
    public MerchantRecipeList getRecipes(EntityPlayer p_70934_1_) {
        return null;
    }

    /**
     *
     */
    public void setRecipes(MerchantRecipeList recipeList) {
        return;
    }

    /**
     *
     */
    public void useRecipe(MerchantRecipe recipe) {
        return;
    }

    /**
     * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
     * being played depending if the suggested itemstack is not null.
     */
    public void verifySellingItem(ItemStack stack) {
        return;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public IChatComponent getDisplayName() {
        return null;
    }

}