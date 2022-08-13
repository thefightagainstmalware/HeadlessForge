package net.minecraft.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraft.util.HttpUtil;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 *
 */
public class BlockBeacon extends BlockContainer {

    /**
     *
     */
    public BlockBeacon() {
        super(Material.iron);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn,
                                          int meta) {
        return null;
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
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    @Override
    public int getRenderType() {
        return 0;
    }

    /**
     * Called by ItemBlocks after a block is set in the world, to allow post-place logic
     */
    @Override
    public void onBlockPlacedBy(World worldIn,
                                BlockPos pos,
                                IBlockState state,
                                EntityLivingBase placer,
                                ItemStack stack) {
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
    public EnumWorldBlockLayer getBlockLayer() {
        return null;
    }

    /**
     *
     */
    public static void updateColorAsync(World worldIn,
                                        BlockPos glassPos) {
        return;
    }

}