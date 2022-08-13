package net.minecraft.client.renderer;

import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class RegionRenderCache extends ChunkCache {

    /**
     *
     */
    private static final IBlockState DEFAULT_STATE = Blocks.field_150350_a.func_176223_P();

    /**
     *
     */
    private final BlockPos position = new BlockPos(0, 0, 0);

    /**
     *
     */
    private int[] combinedLights;

    /**
     *
     */
    private IBlockState[] blockStates;

    /**
     *
     */
    public RegionRenderCache(World worldIn,
                             BlockPos posFromIn,
                             BlockPos posToIn,
                             int subIn) {
        super(worldIn, posFromIn, posToIn, subIn);
    }

    /**
     *
     */
    @Override
    public TileEntity func_175625_s(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    @Override
    public int getCombinedLight(BlockPos pos,
                                int lightValue) {
        return 0;
    }

    /**
     *
     */
    @Override
    public IBlockState func_180495_p(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    private IBlockState getBlockStateRaw(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    private int getPositionIndex(BlockPos p_175630_1_) {
        return 0;
    }

}