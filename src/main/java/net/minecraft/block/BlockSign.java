package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 *
 */
public class BlockSign extends BlockContainer {

    /**
     *
     */
    protected BlockSign() {
        super(Material.wood);
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
    public AxisAlignedBB getSelectedBoundingBox(World worldIn,
                                                BlockPos pos) {
        return null;
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
    public boolean isPassable(IBlockAccess worldIn,
                              BlockPos pos) {
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
    public boolean func_181623_g() {
        return true;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn,
                                          int meta) {
        return null;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state,
                               java.util.Random rand,
                               int fortune) {
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
     *
     */
    @Override
    public Item getItem(World worldIn,
                        BlockPos pos) {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean canPlaceBlockAt(World worldIn,
                                   BlockPos pos) {
        return true;
    }

}