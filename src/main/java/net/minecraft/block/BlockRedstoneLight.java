package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 *
 */
public class BlockRedstoneLight extends Block {

    /**
     *
     */
    private final boolean isOn;

    /**
     *
     */
    public BlockRedstoneLight(boolean isOn) {
        super(Material.circuits);
        this.isOn = isOn;
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
    public Item getItem(World worldIn,
                        BlockPos pos) {
        return null;
    }

    /**
     *
     */
    @Override
    protected ItemStack createStackedBlock(IBlockState state) {
        return null;
    }

}