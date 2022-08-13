package net.minecraft.item.crafting;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class FurnaceRecipes
{
    private static final FurnaceRecipes smeltingBase = new FurnaceRecipes();
    private Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
    private Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static FurnaceRecipes instance()
    {
        return smeltingBase;
    }

    private FurnaceRecipes()
    {
        this.addSmeltingRecipeForBlock(Blocks.field_150366_p, new ItemStack(Items.iron_ingot), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.field_150352_o, new ItemStack(Items.gold_ingot), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.field_150482_ag, new ItemStack(Items.field_151045_i), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.sand, new ItemStack(Blocks.glass), 0.1F);
        this.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35F);
        this.addSmelting(Items.beef, new ItemStack(Items.cooked_beef), 0.35F);
        this.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
        this.addSmelting(Items.rabbit, new ItemStack(Items.cooked_rabbit), 0.35F);
        this.addSmelting(Items.mutton, new ItemStack(Items.cooked_mutton), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.field_150347_e, new ItemStack(Blocks.field_150348_b), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.DEFAULT_META), new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.CRACKED_META), 0.1F);
        this.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
        this.addSmeltingRecipeForBlock(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.cactus, new ItemStack(Items.field_151100_aR, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.log, new ItemStack(Items.field_151044_h, 1, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.log2, new ItemStack(Items.field_151044_h, 1, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.field_150412_bA, new ItemStack(Items.emerald), 1.0F);
        this.addSmelting(Items.potato, new ItemStack(Items.baked_potato), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.sponge, 1, 1), new ItemStack(Blocks.sponge, 1, 0), 0.15F);

        for (ItemFishFood.FishType itemfishfood$fishtype : ItemFishFood.FishType.values())
        {
            if (itemfishfood$fishtype.canCook())
            {
                this.addSmeltingRecipe(new ItemStack(Items.field_151115_aP, 1, itemfishfood$fishtype.getMetadata()), new ItemStack(Items.cooked_fish, 1, itemfishfood$fishtype.getMetadata()), 0.35F);
            }
        }

        this.addSmeltingRecipeForBlock(Blocks.field_150365_q, new ItemStack(Items.field_151044_h), 0.1F);
        this.addSmeltingRecipeForBlock(Blocks.field_150450_ax, new ItemStack(Items.redstone), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.field_150369_x, new ItemStack(Items.field_151100_aR, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.field_150449_bY, new ItemStack(Items.field_151128_bU), 0.2F);
    }

    /**
     * Adds a smelting recipe, where the input item is an instance of Block.
     */
    public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addSmelting(Item.func_150898_a(input), stack, experience);
    }

    /**
     * Adds a smelting recipe using an Item as the input item.
     */
    public void addSmelting(Item input, ItemStack stack, float experience)
    {
        this.addSmeltingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addSmeltingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        this.smeltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue();
            }
        }

        return null;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.func_77973_b() == stack1.func_77973_b() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
}
