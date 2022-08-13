package net.minecraft.client.renderer;

import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.client.renderer.chunk.RenderChunk;

/**
 *
 */
public abstract class ChunkRenderContainer extends Object {

    /**
     *
     */
    private double viewEntityX;

    /**
     *
     */
    private double viewEntityY;

    /**
     *
     */
    private double viewEntityZ;

    /**
     *
     */
    protected java.util.List<RenderChunk> renderChunks;

    /**
     *
     */
    protected boolean initialized;

    /**
     *
     */
    public ChunkRenderContainer() {
        
    }

    /**
     *
     */
    public void initialize(double viewEntityXIn,
                           double viewEntityYIn,
                           double viewEntityZIn) {
        return;
    }

    /**
     *
     */
    public void preRenderChunk(RenderChunk renderChunkIn) {
        return;
    }

    /**
     *
     */
    public void addRenderChunk(RenderChunk renderChunkIn,
                               EnumWorldBlockLayer layer) {
        return;
    }

    /**
     *
     */
    public abstract void renderChunkLayer(EnumWorldBlockLayer layer);

}