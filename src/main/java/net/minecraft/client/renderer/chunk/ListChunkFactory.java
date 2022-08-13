package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class ListChunkFactory extends Object implements IRenderChunkFactory {

    /**
     *
     */
    public ListChunkFactory() {
        
    }

    /**
     *
     */
    public RenderChunk makeRenderChunk(World worldIn,
                                       RenderGlobal globalRenderer,
                                       BlockPos pos,
                                       int index) {
        return null;
    }

}