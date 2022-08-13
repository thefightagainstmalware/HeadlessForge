package net.minecraft.stats;

import com.google.common.collect.Maps;
import net.minecraft.util.TupleIntJsonSerializable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IJsonSerializable;

/**
 *
 */
public class StatFileWriter extends Object {

    /**
     *
     */
    protected final java.util.Map<StatBase,TupleIntJsonSerializable> statsData = Maps.newHashMap();

    /**
     *
     */
    public StatFileWriter() {
        
    }

    /**
     * Returns true if the achievement has been unlocked.
     */
    public boolean func_77443_a(Achievement achievementIn) {
        return true;
    }

    /**
     * Returns true if the parent has been unlocked, or there is no parent
     */
    public boolean canUnlockAchievement(Achievement achievementIn) {
        return true;
    }

    /**
     *
     */
    public void increaseStat(EntityPlayer player,
                             StatBase stat,
                             int amount) {
        return;
    }

    /**
     *
     */
    public int func_150874_c(Achievement p_150874_1_) {
        return 0;
    }

    /**
     * Triggers the logging of an achievement and attempts to announce to server
     */
    public void unlockAchievement(EntityPlayer playerIn,
                                  StatBase statIn,
                                  int p_150873_3_) {
        return;
    }

    /**
     * Reads the given stat and returns its value as an int.
     */
    public int readStat(StatBase stat) {
        return 0;
    }

    /**
     *
     */
    public <T extends IJsonSerializable> T func_150870_b(StatBase p_150870_1_) {
        return null;
    }

    /**
     *
     */
    public <T extends IJsonSerializable> T func_150872_a(StatBase p_150872_1_,
                                                         T p_150872_2_) {
        return null;
    }

}