package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class BlockBreakable extends Block {

    /**
     *
     */
    private boolean ignoreSimilarity;

    /**
     *
     */
    protected BlockBreakable(Material materialIn,
                             boolean ignoreSimilarityIn) {
        super(materialIn);
    }

    /**
     *
     */
    protected BlockBreakable(Material p_i46393_1_,
                             boolean p_i46393_2_,
                             MapColor p_i46393_3_) {
        super(p_i46393_1_, p_i46393_3_);
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