package net.minecraft.stats;

import com.google.common.collect.Sets;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.TupleIntJsonSerializable;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IJsonSerializable;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class StatisticsFile extends StatFileWriter {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private final MinecraftServer mcServer;

    /**
     *
     */
    private final java.io.File statsFile;

    /**
     *
     */
    private final java.util.Set<StatBase> field_150888_e = Sets.newHashSet();

    /**
     *
     */
    private int field_150885_f;

    /**
     *
     */
    private boolean field_150886_g;

    /**
     *
     */
    public StatisticsFile(MinecraftServer serverIn,
                          java.io.File statsFileIn) {
        this.mcServer = serverIn;
        this.statsFile = statsFileIn;

    }

    /**
     *
     */
    public void readStatFile() {
        return;
    }

    /**
     *
     */
    public void saveStatFile() {
        return;
    }

    /**
     * Triggers the logging of an achievement and attempts to announce to server
     */
    @Override
    public void unlockAchievement(EntityPlayer playerIn,
                                  StatBase statIn,
                                  int p_150873_3_) {
        return;
    }

    /**
     *
     */
    public java.util.Set<StatBase> func_150878_c() {
        return null;
    }

    /**
     *
     */
    public java.util.Map<StatBase,TupleIntJsonSerializable> parseJson(String p_150881_1_) {
        return null;
    }

    /**
     *
     */
    public static String dumpJson(java.util.Map<StatBase,TupleIntJsonSerializable> p_150880_0_) {
        return null;
    }

    /**
     *
     */
    public void func_150877_d() {
        return;
    }

    /**
     *
     */
    public void func_150876_a(EntityPlayerMP p_150876_1_) {
        return;
    }

    /**
     *
     */
    public void sendAchievements(EntityPlayerMP player) {
        return;
    }

    /**
     *
     */
    public boolean func_150879_e() {
        return true;
    }

}