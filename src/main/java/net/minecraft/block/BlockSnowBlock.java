package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 *
 */
public class BlockSnowBlock extends Block {

    /**
     *
     */
    protected BlockSnowBlock() {
        super(Material.snow);
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

}