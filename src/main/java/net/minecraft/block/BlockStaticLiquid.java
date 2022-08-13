package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class BlockStaticLiquid extends BlockLiquid {

    /**
     *
     */
    protected BlockStaticLiquid(Material materialIn) {
        super(materialIn);
    }

    /**
     * Called when a neighboring block changes.
     */
    @Override
    public void onNeighborBlockChange(World worldIn,
                                      BlockPos pos,
                                      IBlockState state,
                                      Block neighborBlock) {
        return;
    }

    /**
     *
     */
    private void updateLiquid(World worldIn,
                              BlockPos pos,
                              IBlockState state) {
        return;
    }

    /**
     *
     */
    @Override
    public void updateTick(World worldIn,
                           BlockPos pos,
                           IBlockState state,
                           java.util.Random rand) {
        return;
    }

    /**
     *
     */
    protected boolean isSurroundingBlockFlammable(World worldIn,
                                                  BlockPos pos) {
        return true;
    }

    /**
     *
     */
    private boolean getCanBlockBurn(World worldIn,
                                    BlockPos pos) {
        return true;
    }

}