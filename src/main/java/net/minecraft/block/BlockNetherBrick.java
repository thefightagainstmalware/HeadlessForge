package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 */
public class BlockNetherBrick extends Block {

    /**
     *
     */
    public BlockNetherBrick() {
        super(Material.rock);
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
    public MapColor getMapColor(IBlockState state) {
        return null;
    }

}