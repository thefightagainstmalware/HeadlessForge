package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class VboChunkFactory extends Object implements IRenderChunkFactory {

    /**
     *
     */
    public VboChunkFactory() {
        
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