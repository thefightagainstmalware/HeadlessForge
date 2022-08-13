package net.minecraft.entity.boss;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public final class BossStatus extends Object {

    /**
     *
     */
    public static float healthScale;

    /**
     *
     */
    public static int statusBarTime;

    /**
     *
     */
    public static java.lang.String bossName;

    /**
     *
     */
    public static boolean hasColorModifier;

    /**
     *
     */
    public BossStatus() {
        
    }

    /**
     *
     */
    public static void setBossStatus(IBossDisplayData displayData,
                                     boolean hasColorModifierIn) {
        return;
    }

}