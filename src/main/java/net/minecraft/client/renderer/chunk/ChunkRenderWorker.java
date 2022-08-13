package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkRenderWorker implements Runnable
{
    private static final Logger LOGGER = LogManager.getLogger();
    private final ChunkRenderDispatcher chunkRenderDispatcher;
    private final RegionRenderCacheBuilder regionRenderCacheBuilder;

    public ChunkRenderWorker(ChunkRenderDispatcher p_i46201_1_)
    {
        this(p_i46201_1_, (RegionRenderCacheBuilder)null);
    }

    public ChunkRenderWorker(ChunkRenderDispatcher chunkRenderDispatcherIn, RegionRenderCacheBuilder regionRenderCacheBuilderIn)
    {
        this.chunkRenderDispatcher = chunkRenderDispatcherIn;
        this.regionRenderCacheBuilder = regionRenderCacheBuilderIn;
    }

    public void run() {}

    protected void processTask(final ChunkCompileTaskGenerator generator) throws InterruptedException {}

    private RegionRenderCacheBuilder getRegionRenderCacheBuilder() throws InterruptedException
    {
        return this.regionRenderCacheBuilder != null ? this.regionRenderCacheBuilder : this.chunkRenderDispatcher.allocateRenderBuilder();
    }

    private void freeRenderBuilder(ChunkCompileTaskGenerator taskGenerator)
    {
        if (this.regionRenderCacheBuilder == null)
        {
            this.chunkRenderDispatcher.freeRenderBuilder(taskGenerator.getRegionRenderCacheBuilder());
        }
    }
}
