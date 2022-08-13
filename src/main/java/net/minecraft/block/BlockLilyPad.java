package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class BlockLilyPad extends BlockBush {

    /**
     *
     */
    protected BlockLilyPad() {
        
    }

    /**
     * Add all collision boxes of this Block to the list that intersect with the given mask.
     */
    @Override
    public void addCollisionBoxesToList(World worldIn,
                                        BlockPos pos,
                                        IBlockState state,
                                        AxisAlignedBB mask,
                                        java.util.List<AxisAlignedBB> list,
                                        Entity collidingEntity) {
        return;
    }

    /**
     *
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn,
                                                 BlockPos pos,
                                                 IBlockState state) {
        return null;
    }

    /**
     *
     */
    @Override
    public int getBlockColor() {
        return 0;
    }

    /**
     *
     */
    @Override
    public int getRenderColor(IBlockState state) {
        return 0;
    }

    /**
     *
     */
    @Override
    public int colorMultiplier(IBlockAccess worldIn,
                               BlockPos pos,
                               int renderPass) {
        return 0;
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
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int func_176201_c(IBlockState state) {
        return 0;
    }

}