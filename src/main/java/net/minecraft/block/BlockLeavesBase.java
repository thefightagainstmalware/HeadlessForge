package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class BlockLeavesBase extends Block {

    /**
     *
     */
    protected boolean fancyGraphics;

    /**
     *
     */
    protected BlockLeavesBase(Material materialIn,
                              boolean fancyGraphics) {
        super(materialIn);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn,
                                        BlockPos pos,
                                        EnumFacing side) {
        return true;
    }

}