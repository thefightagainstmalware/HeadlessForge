package net.minecraft.item;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ItemPickaxe extends ItemTool
{
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.activator_rail, Blocks.field_150365_q, Blocks.field_150347_e, Blocks.detector_rail, Blocks.field_150484_ah, Blocks.field_150482_ag, Blocks.double_stone_slab, Blocks.golden_rail, Blocks.gold_block, Blocks.field_150352_o, Blocks.ice, Blocks.iron_block, Blocks.field_150366_p, Blocks.lapis_block, Blocks.field_150369_x, Blocks.field_150439_ay, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.packed_ice, Blocks.rail, Blocks.field_150450_ax, Blocks.sandstone, Blocks.red_sandstone, Blocks.field_150348_b, Blocks.stone_slab});

    protected ItemPickaxe(Item.ToolMaterial material)
    {
        super(2.0F, material, EFFECTIVE_ON);
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(Block blockIn)
    {
        return blockIn == Blocks.field_150343_Z ? this.toolMaterial.getHarvestLevel() == 3 : (blockIn != Blocks.field_150484_ah && blockIn != Blocks.field_150482_ag ? (blockIn != Blocks.field_150412_bA && blockIn != Blocks.emerald_block ? (blockIn != Blocks.gold_block && blockIn != Blocks.field_150352_o ? (blockIn != Blocks.iron_block && blockIn != Blocks.field_150366_p ? (blockIn != Blocks.lapis_block && blockIn != Blocks.field_150369_x ? (blockIn != Blocks.field_150450_ax && blockIn != Blocks.field_150439_ay ? (blockIn.func_149688_o() == Material.rock ? true : (blockIn.func_149688_o() == Material.iron ? true : blockIn.func_149688_o() == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.func_149688_o() != Material.iron && block.func_149688_o() != Material.anvil && block.func_149688_o() != Material.rock ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
}
