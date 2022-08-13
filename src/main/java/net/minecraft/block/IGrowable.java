package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;

/**
 *
 */
public interface IGrowable {

    /**
     * Whether this IGrowable can grow
     */
    boolean canGrow(World worldIn,
                    BlockPos pos,
                    IBlockState state,
                    boolean isClient);

    /**
     *
     */
    boolean canUseBonemeal(World worldIn,
                           java.util.Random rand,
                           BlockPos pos,
                           IBlockState state);

    /**
     *
     */
    void grow(World worldIn,
              java.util.Random rand,
              BlockPos pos,
              IBlockState state);

}