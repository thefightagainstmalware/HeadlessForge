package net.minecraft.world;

import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public abstract class WorldSavedData extends Object {

    /**
     * The name of the map data nbt
     */
    public final java.lang.String mapName ;

    /**
     * Whether this MapDataBase needs saving to disk.
     */
    private boolean dirty;

    /**
     *
     */
    public WorldSavedData(String name) {
        this.mapName = name;
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public abstract void readFromNBT(NBTTagCompound nbt);

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public abstract void writeToNBT(NBTTagCompound nbt);

    /**
     * Marks this MapDataBase dirty, to be saved to disk when the level next saves.
     */
    public void markDirty() {
        return;
    }

    /**
     * Sets the dirty state of this MapDataBase, whether it needs saving to disk.
     */
    public void setDirty(boolean isDirty) {
        return;
    }

    /**
     * Whether this MapDataBase needs saving to disk.
     */
    public boolean isDirty() {
        return true;
    }

}