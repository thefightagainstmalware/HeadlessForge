package net.minecraft.world.gen.structure;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

/**
 *
 */
public class MapGenStructureData extends WorldSavedData {

    /**
     *
     */
    private NBTTagCompound tagCompound;

    /**
     *
     */
    public MapGenStructureData(String name) {
        super(name);
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     * Writes the NBT tag of an instance of this structure type to the internal NBT tag, using the chunkcoordinates as
     * the key
     */
    public void writeInstance(NBTTagCompound tagCompoundIn,
                              int chunkX,
                              int chunkZ) {
        return;
    }

    /**
     *
     */
    public static String formatChunkCoords(int chunkX,
                                                     int chunkZ) {
        return null;
    }

    /**
     *
     */
    public NBTTagCompound getTagCompound() {
        return null;
    }

}