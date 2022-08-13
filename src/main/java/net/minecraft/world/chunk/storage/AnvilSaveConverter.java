package net.minecraft.world.chunk.storage;

import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraft.world.storage.SaveFormatOld;
import net.minecraft.client.AnvilConverterException;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class AnvilSaveConverter extends SaveFormatOld {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    public AnvilSaveConverter(java.io.File p_i2144_1_) {
        super(p_i2144_1_);
    }

    /**
     * Returns the name of the save format.
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * 
     * @throws AnvilConverterException
     */
    @Override
    public java.util.List<SaveFormatComparator> getSaveList()
                                                     throws AnvilConverterException {
        return null;
    }

    /**
     *
     */
    protected int getSaveVersion() {
        return 0;
    }

    /**
     *
     */
    @Override
    public void flushCache() {
        return;
    }

    /**
     * Returns back a loader for the specified save directory
     */
    @Override
    public ISaveHandler getSaveLoader(String saveName,
                                      boolean storePlayerdata) {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean func_154334_a(String saveName) {
        return true;
    }

    /**
     * gets if the map is old chunk saving (true) or McRegion (false)
     */
    @Override
    public boolean isOldMapFormat(String saveName) {
        return true;
    }

    /**
     * converts the map to mcRegion
     */
    @Override
    public boolean convertMapFormat(String filename,
                                    IProgressUpdate progressCallback) {
        return true;
    }

    /**
     * par: filename for the level.dat_mcr backup
     */
    private void createFile(String filename) {
        return;
    }

    /**
     *
     */
    private void convertFile(java.io.File p_75813_1_,
                             Iterable<java.io.File> p_75813_2_,
                             WorldChunkManager p_75813_3_,
                             int p_75813_4_,
                             int p_75813_5_,
                             IProgressUpdate p_75813_6_) {
        return;
    }

    /**
     * copies a 32x32 chunk set from par2File to par1File, via AnvilConverterData
     */
    private void convertChunks(java.io.File p_75811_1_,
                               java.io.File p_75811_2_,
                               WorldChunkManager p_75811_3_,
                               int p_75811_4_,
                               int p_75811_5_,
                               IProgressUpdate progressCallback) {
        return;
    }

    /**
     * filters the files in the par1 directory, and adds them to the par2 collections
     */
    private void addRegionFilesToCollection(java.io.File worldDir,
                                            java.util.Collection<java.io.File> collection) {
        return;
    }

}