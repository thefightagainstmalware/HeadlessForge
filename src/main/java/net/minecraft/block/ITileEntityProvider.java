package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.tileentity.TileEntity;

/**
 *
 */
public interface ITileEntityProvider {

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    TileEntity createNewTileEntity(World worldIn,
                                   int meta);

}