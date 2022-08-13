package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 *
 */
public class BlockDragonEgg extends Block {

    /**
     *
     */
    public BlockDragonEgg() {
        super(Material.dragonEgg);
    }

    /**
     *
     */
    @Override
    public void onBlockAdded(World worldIn,
                             BlockPos pos,
                             IBlockState state) {
        return;
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
    private void checkFall(World worldIn,
                           BlockPos pos) {
        return;
    }

    /**
     *
     */
    @Override
    public boolean onBlockActivated(World worldIn,
                                    BlockPos pos,
                                    IBlockState state,
                                    EntityPlayer playerIn,
                                    EnumFacing side,
                                    float hitX,
                                    float hitY,
                                    float hitZ) {
        return true;
    }

    /**
     *
     */
    @Override
    public void onBlockClicked(World worldIn,
                               BlockPos pos,
                               EntityPlayer playerIn) {
        return;
    }

    /**
     *
     */
    private void teleport(World worldIn,
                          BlockPos pos) {
        return;
    }

    /**
     * How many world ticks before ticking
     */
    @Override
    public int tickRate(World worldIn) {
        return 0;
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
    public boolean func_149686_d() {
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

    /**
     *
     */
    @Override
    public Item getItem(World worldIn,
                        BlockPos pos) {
        return null;
    }

}