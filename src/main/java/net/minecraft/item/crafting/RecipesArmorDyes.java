package net.minecraft.item.crafting;

import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntitySheep;
import java.util.List;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.item.EnumDyeColor;
import com.google.common.collect.Lists;
import net.minecraft.inventory.InventoryCrafting;

/**
 *
 */
public class RecipesArmorDyes extends Object implements IRecipe {

    /**
     *
     */
    public RecipesArmorDyes() {
        
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