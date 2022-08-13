package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class BlockMushroom extends BlockBush implements IGrowable {

    /**
     *
     */
    protected BlockMushroom() {
        
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
    @Override
    public boolean canPlaceBlockAt(World worldIn,
                                   BlockPos pos) {
        return true;
    }

    /**
     * is the block grass, dirt or farmland
     */
    @Override
    protected boolean canPlaceBlockOn(Block ground) {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean canBlockStay(World worldIn,
                                BlockPos pos,
                                IBlockState state) {
        return true;
    }

    /**
     *
     */
    public boolean generateBigMushroom(World worldIn,
                                       BlockPos pos,
                                       IBlockState state,
                                       java.util.Random rand) {
        return true;
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(World worldIn,
                           BlockPos pos,
                           IBlockState state,
                           boolean isClient) {
        return true;
    }

    /**
     *
     */
    public boolean canUseBonemeal(World worldIn,
                                  java.util.Random rand,
                                  BlockPos pos,
                                  IBlockState state) {
        return true;
    }

    /**
     *
     */
    public void grow(World worldIn,
                     java.util.Random rand,
                     BlockPos pos,
                     IBlockState state) {
        return;
    }

}