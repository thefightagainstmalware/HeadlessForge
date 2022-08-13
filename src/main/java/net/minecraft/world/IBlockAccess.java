package net.minecraft.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;

/**
 *
 */
public interface IBlockAccess {

    /**
     *
     */
    TileEntity func_175625_s(BlockPos pos);

    /**
     *
     */
    int getCombinedLight(BlockPos pos,
                         int lightValue);

    /**
     *
     */
    IBlockState func_180495_p(BlockPos pos);

    /**
     * Checks to see if an air block exists at the provided location. Note that this only checks to see if the blocks
     * material is set to air, meaning it is possible for non-vanilla blocks to still pass this check.
     */
    boolean func_175623_d(BlockPos pos);

    /**
     *
     */
    BiomeGenBase getBiomeGenForCoords(BlockPos pos);

    /**
     * set by !chunk.getAreLevelsEmpty
     */
    boolean extendedLevelsInChunkCache();

    /**
     *
     */
    int getStrongPower(BlockPos pos,
                       EnumFacing direction);

    /**
     *
     */
    WorldType getWorldType();

    /**
     * FORGE: isSideSolid, pulled up from <a href="../../../net/minecraft/world/World.html" title="class in net.minecraft.world"><code>World</code></a>
     * @param pos Position
     * @param side Side
     * @param _default default return value
     * @return if the block is solid on the side
     */
    boolean isSideSolid(BlockPos pos,
                        EnumFacing side,
                        boolean _default);

}