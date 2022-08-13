package net.minecraft.item;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ItemAxe extends ItemTool
{
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.field_150344_f, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.field_150486_ae, Blocks.field_150423_aK, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder});

    protected ItemAxe(Item.ToolMaterial material)
    {
        super(3.0F, material, EFFECTIVE_ON);
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.func_149688_o() != Material.wood && block.func_149688_o() != Material.plants && block.func_149688_o() != Material.vine ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
}
