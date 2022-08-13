package net.minecraft.village;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item;

/**
 *
 */
public class MerchantRecipe extends Object {

    /**
     * Item the Villager buys.
     */
    private ItemStack itemToBuy;

    /**
     * Second Item the Villager buys.
     */
    private ItemStack secondItemToBuy;

    /**
     * Item the Villager sells.
     */
    private ItemStack itemToSell;

    /**
     * Saves how much has been tool used when put into to slot to be enchanted.
     */
    private int toolUses;

    /**
     * Maximum times this trade can be used.
     */
    private int maxTradeUses;

    /**
     *
     */
    private boolean rewardsExp;

    /**
     *
     */
    public MerchantRecipe(NBTTagCompound tagCompound) {
        
    }

    /**
     *
     */
    public MerchantRecipe(ItemStack buy1,
                          ItemStack buy2,
                          ItemStack sell) {
        
    }

    /**
     *
     */
    public MerchantRecipe(ItemStack buy1,
                          ItemStack buy2,
                          ItemStack sell,
                          int toolUsesIn,
                          int maxTradeUsesIn) {
        
    }

    /**
     *
     */
    public MerchantRecipe(ItemStack buy1,
                          ItemStack sell) {
        
    }

    /**
     *
     */
    public MerchantRecipe(ItemStack buy1,
                          Item sellItem) {
        
    }

    /**
     * Gets the itemToBuy.
     */
    public ItemStack getItemToBuy() {
        return null;
    }

    /**
     * Gets secondItemToBuy.
     */
    public ItemStack getSecondItemToBuy() {
        return null;
    }

    /**
     * Gets if Villager has secondItemToBuy.
     */
    public boolean hasSecondItemToBuy() {
        return true;
    }

    /**
     * Gets itemToSell.
     */
    public ItemStack getItemToSell() {
        return null;
    }

    /**
     *
     */
    public int getToolUses() {
        return 0;
    }

    /**
     *
     */
    public int getMaxTradeUses() {
        return 0;
    }

    /**
     *
     */
    public void incrementToolUses() {
        return;
    }

    /**
     *
     */
    public void increaseMaxTradeUses(int increment) {
        return;
    }

    /**
     *
     */
    public boolean isRecipeDisabled() {
        return true;
    }

    /**
     * Compensates <a href="../../../net/minecraft/village/MerchantRecipe.html#toolUses"><code>toolUses</code></a> with <a href="../../../net/minecraft/village/MerchantRecipe.html#maxTradeUses"><code>maxTradeUses</code></a>
     */
    public void compensateToolUses() {
        return;
    }

    /**
     *
     */
    public boolean getRewardsExp() {
        return true;
    }

    /**
     *
     */
    public void readFromTags(NBTTagCompound tagCompound) {
        return;
    }

    /**
     *
     */
    public NBTTagCompound writeToTags() {
        return null;
    }

}