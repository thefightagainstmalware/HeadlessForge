package net.minecraft.world.gen;

import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

/**
 *
 */
public class MapGenBase extends Object {

    /**
     * The number of Chunks to gen-check in any given direction.
     */
    protected int range;

    /**
     * The RNG used by the MapGen classes.
     */
    protected java.util.Random rand;

    /**
     * This world object.
     */
    protected World worldObj;

    /**
     *
     */
    public MapGenBase() {
        
    }

    /**
     *
     */
    public void generate(IChunkProvider chunkProviderIn,
                         World worldIn,
                         int x,
                         int z,
                         ChunkPrimer chunkPrimerIn) {
        return;
    }

    /**
     * Recursively called by generate()
     */
    protected void recursiveGenerate(World worldIn,
                                     int chunkX,
                                     int chunkZ,
                                     int p_180701_4_,
                                     int p_180701_5_,
                                     ChunkPrimer chunkPrimerIn) {
        return;
    }

}