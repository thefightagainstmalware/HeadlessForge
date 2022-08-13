package net.minecraft.block;

import net.minecraft.util.MathHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
 *
 */
public class BlockSeaLantern extends Block {

    /**
     *
     */
    public BlockSeaLantern(Material materialIn) {
        super(materialIn);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(java.util.Random random) {
        return 0;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    @Override
    public int quantityDroppedWithBonus(int fortune,
                                        java.util.Random random) {
        return 0;
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
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
    public MapColor getMapColor(IBlockState state) {
        return null;
    }

    /**
     *
     */
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }

}