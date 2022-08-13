package net.minecraft.block;

import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class BlockIce extends BlockBreakable {

    /**
     *
     */
    public BlockIce() {
        super(Material.ice, false);
    }

    /**
     *
     */
    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return null;
    }

    /**
     *
     */
    @Override
    public void harvestBlock(World worldIn,
                             EntityPlayer player,
                             BlockPos pos,
                             IBlockState state,
                             TileEntity te) {
        return;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(java.util.Random random) {
        return 0;
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
    public int getMobilityFlag() {
        return 0;
    }

}