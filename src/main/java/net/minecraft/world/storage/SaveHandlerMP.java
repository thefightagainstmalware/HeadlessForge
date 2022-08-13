package net.minecraft.world.storage;

import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.File;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class SaveHandlerMP extends Object implements ISaveHandler {

    /**
     *
     */
    public SaveHandlerMP() {
        
    }

    /**
     * Loads and returns the world info
     */
    public WorldInfo loadWorldInfo() {
        return null;
    }

    /**
     * Checks the session lock to prevent save collisions
     * @throws MinecraftException
     */
    public void checkSessionLock()
                          throws MinecraftException {
        return;
    }

    /**
     * initializes and returns the chunk loader for the specified world provider
     */
    public IChunkLoader getChunkLoader(WorldProvider provider) {
        return null;
    }

    /**
     * Saves the given World Info with the given NBTTagCompound as the Player.
     */
    public void saveWorldInfoWithPlayer(WorldInfo worldInformation,
                                        NBTTagCompound tagCompound) {
        return;
    }

    /**
     * used to update level.dat from old format to MCRegion format
     */
    public void saveWorldInfo(WorldInfo worldInformation) {
        return;
    }

    /**
     *
     */
    public IPlayerFileData getPlayerNBTManager() {
        return null;
    }

    /**
     * Called to flush all changes to disk, waiting for them to complete.
     */
    public void flush() {
        return;
    }

    /**
     * Gets the file location of the given map
     */
    public java.io.File getMapFileFromName(String mapName) {
        return null;
    }

    /**
     * Returns the name of the directory where world information is saved.
     */
    public String getWorldDirectoryName() {
        return null;
    }

    /**
     * Gets the File object corresponding to the base directory of this world.
     */
    public java.io.File getWorldDirectory() {
        return null;
    }

}