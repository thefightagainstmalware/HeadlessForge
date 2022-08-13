package net.minecraft.world;

import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class ChunkCache extends Object implements IBlockAccess {

    /**
     *
     */
    protected int chunkX;

    /**
     *
     */
    protected int chunkZ;

    /**
     *
     */
    protected Chunk[][] chunkArray;

    /**
     * set by !chunk.getAreLevelsEmpty
     */
    protected boolean hasExtendedLevels;

    /**
     * Reference to the World object.
     */
    protected World worldObj;

    /**
     *
     */
    public ChunkCache(World worldIn,
                      BlockPos posFromIn,
                      BlockPos posToIn,
                      int subIn) {
        
    }

    /**
     * set by !chunk.getAreLevelsEmpty
     */
    public boolean extendedLevelsInChunkCache() {
        return true;
    }

    /**
     *
     */
    public TileEntity func_175625_s(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    public int getCombinedLight(BlockPos pos,
                                int lightValue) {
        return 0;
    }

    /**
     *
     */
    public IBlockState func_180495_p(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    public BiomeGenBase getBiomeGenForCoords(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    private int getLightForExt(EnumSkyBlock p_175629_1_,
                               BlockPos pos) {
        return 0;
    }

    /**
     * Checks to see if an air block exists at the provided location. Note that this only checks to see if the blocks
     * material is set to air, meaning it is possible for non-vanilla blocks to still pass this check.
     */
    public boolean func_175623_d(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    public int getLightFor(EnumSkyBlock p_175628_1_,
                           BlockPos pos) {
        return 0;
    }

    /**
     *
     */
    public int getStrongPower(BlockPos pos,
                              EnumFacing direction) {
        return 0;
    }

    /**
     *
     */
    public WorldType getWorldType() {
        return null;
    }

    /**
     * FORGE: isSideSolid, pulled up from <a href="../../../net/minecraft/world/World.html" title="class in net.minecraft.world"><code>World</code></a>
     * @param pos Position
     * @param side Side
     * @param _default default return value
     * @return if the block is solid on the side
     */
    public boolean isSideSolid(BlockPos pos,
                               EnumFacing side,
                               boolean _default) {
        return true;
    }

}