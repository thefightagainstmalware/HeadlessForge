package net.minecraft.item.crafting;

import net.minecraft.init.Items;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemDye;
import com.google.common.collect.Lists;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.nbt.NBTTagList;

/**
 *
 */
public class RecipeFireworks extends Object implements IRecipe {

    /**
     *
     */
    private ItemStack field_92102_a;

    /**
     *
     */
    public RecipeFireworks() {
        
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting inv,
                           World worldIn) {
        return true;
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return null;
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize() {
        return 0;
    }

    /**
     *
     */
    public ItemStack getRecipeOutput() {
        return null;
    }

    /**
     *
     */
    public ItemStack[] getRemainingItems(InventoryCrafting inv) {
        return null;
    }

}