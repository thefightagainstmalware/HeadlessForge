package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;

/**
 *
 */
public interface IRenderChunkFactory {

    /**
     *
     */
    RenderChunk makeRenderChunk(World worldIn,
                                RenderGlobal globalRenderer,
                                BlockPos pos,
                                int index);

}