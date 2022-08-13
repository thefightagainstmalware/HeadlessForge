package net.minecraft.world.chunk.storage;

import net.minecraft.world.World;
import net.minecraft.world.MinecraftException;
import java.io.IOException;
import net.minecraft.world.chunk.Chunk;

/**
 *
 */
public interface IChunkLoader {

    /**
     * Loads the specified(XZ) chunk into the specified world.
     * @throws java.io.IOException
     */
    Chunk loadChunk(World worldIn,
                    int x,
                    int z)
             throws java.io.IOException;

    /**
     * 
     * @throws MinecraftException
     * @throws java.io.IOException
     */
    void saveChunk(World worldIn,
                   Chunk chunkIn)
            throws MinecraftException,
                   java.io.IOException;

    /**
     * Save extra data associated with this Chunk not normally saved during autosave, only during chunk unload.
     * Currently unused.
     * @throws java.io.IOException
     */
    void saveExtraChunkData(World worldIn,
                            Chunk chunkIn)
                     throws java.io.IOException;

    /**
     * Called every World.tick()
     */
    void chunkTick();

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unused.
     */
    void saveExtraData();

}