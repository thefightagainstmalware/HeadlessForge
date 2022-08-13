package net.minecraft.world.storage;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagShort;
import java.util.List;
import com.google.common.collect.Maps;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.minecraft.nbt.NBTBase;
import java.io.File;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import net.minecraft.nbt.NBTTagCompound;
import java.io.DataOutputStream;
import net.minecraft.world.WorldSavedData;

/**
 *
 */
public class MapStorage extends Object {

    /**
     *
     */
    private ISaveHandler saveHandler;

    /**
     *
     */
    protected java.util.Map<java.lang.String,WorldSavedData> loadedDataMap;

    /**
     *
     */
    private java.util.List<WorldSavedData> loadedDataList;

    /**
     *
     */
    private java.util.Map<java.lang.String,java.lang.Short> idCounts;

    /**
     *
     */
    public MapStorage(ISaveHandler saveHandlerIn) {
        
    }

    /**
     * Loads an existing MapDataBase corresponding to the given String id from disk, instantiating the given Class, or
     * returns null if none such file exists. args: Class to instantiate, String dataid
     */
    public WorldSavedData loadData(Class<? extends WorldSavedData> clazz,
                                   String dataIdentifier) {
        return null;
    }

    /**
     * Assigns the given String id to the given MapDataBase, removing any existing ones of the same id.
     */
    public void setData(String dataIdentifier,
                        WorldSavedData data) {
        return;
    }

    /**
     * Saves all dirty loaded MapDataBases to disk.
     */
    public void saveAllData() {
        return;
    }

    /**
     * Saves the given MapDataBase to disk.
     */
    private void saveData(WorldSavedData p_75747_1_) {
        return;
    }

    /**
     * Loads the idCounts Map from the 'idcounts' file.
     */
    private void loadIdCounts() {
        return;
    }

    /**
     * Returns an unique new data id for the given prefix and saves the idCounts map to the 'idcounts' file.
     */
    public int getUniqueDataId(String key) {
        return 0;
    }

}