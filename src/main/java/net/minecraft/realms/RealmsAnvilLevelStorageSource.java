package net.minecraft.realms;

import net.minecraft.util.IProgressUpdate;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.world.storage.ISaveFormat;

/**
 *
 */
public class RealmsAnvilLevelStorageSource extends Object {

    /**
     *
     */
    private ISaveFormat levelStorageSource;

    /**
     *
     */
    public RealmsAnvilLevelStorageSource(ISaveFormat levelStorageSourceIn) {
        
    }

    /**
     *
     */
    public String getName() {
        return null;
    }

    /**
     *
     */
    public boolean levelExists(String p_levelExists_1_) {
        return true;
    }

    /**
     *
     */
    public boolean convertLevel(String p_convertLevel_1_,
                                IProgressUpdate p_convertLevel_2_) {
        return true;
    }

    /**
     *
     */
    public boolean requiresConversion(String p_requiresConversion_1_) {
        return true;
    }

    /**
     *
     */
    public boolean isNewLevelIdAcceptable(String p_isNewLevelIdAcceptable_1_) {
        return true;
    }

    /**
     *
     */
    public boolean deleteLevel(String p_deleteLevel_1_) {
        return true;
    }

    /**
     *
     */
    public boolean isConvertible(String p_isConvertible_1_) {
        return true;
    }

    /**
     *
     */
    public void renameLevel(String p_renameLevel_1_,
                            String p_renameLevel_2_) {
        return;
    }

    /**
     *
     */
    public void clearAll() {
        return;
    }

    /**
     * 
     * @throws AnvilConverterException
     */
    public java.util.List<RealmsLevelSummary> getLevelList()
                                                    throws AnvilConverterException {
        return null;
    }

}