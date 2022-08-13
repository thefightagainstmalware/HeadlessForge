package net.minecraft.realms;

import net.minecraft.world.storage.SaveFormatComparator;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class RealmsLevelSummary extends Object implements Comparable<RealmsLevelSummary> {

    /**
     *
     */
    private SaveFormatComparator levelSummary;

    /**
     *
     */
    public RealmsLevelSummary(SaveFormatComparator p_i1109_1_) {
        
    }

    /**
     *
     */
    public int getGameMode() {
        return 0;
    }

    /**
     *
     */
    public String getLevelId() {
        return null;
    }

    /**
     *
     */
    public boolean hasCheats() {
        return true;
    }

    /**
     *
     */
    public boolean isHardcore() {
        return true;
    }

    /**
     *
     */
    public boolean isRequiresConversion() {
        return true;
    }

    /**
     *
     */
    public String getLevelName() {
        return null;
    }

    /**
     *
     */
    public long getLastPlayed() {
        return 0;
    }

    /**
     *
     */
    public int compareTo(SaveFormatComparator p_compareTo_1_) {
        return 0;
    }

    /**
     *
     */
    public long getSizeOnDisk() {
        return 0;
    }

    /**
     *
     */
    public int compareTo(RealmsLevelSummary p_compareTo_1_) {
        return 0;
    }

}