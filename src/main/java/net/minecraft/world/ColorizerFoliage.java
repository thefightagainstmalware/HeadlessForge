package net.minecraft.world;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ColorizerFoliage extends Object {

    /**
     * Color buffer for foliage
     */
    private static int[] foliageBuffer;

    /**
     *
     */
    public ColorizerFoliage() {
        
    }

    /**
     *
     */
    public static void setFoliageBiomeColorizer(int[] p_77467_0_) {
        return;
    }

    /**
     * Gets foliage color from temperature and humidity. Args: temperature, humidity
     */
    public static int getFoliageColor(double p_77470_0_,
                                      double p_77470_2_) {
        return 0;
    }

    /**
     * Gets the foliage color for pine type (metadata 1) trees
     */
    public static int getFoliageColorPine() {
        return 0;
    }

    /**
     * Gets the foliage color for birch type (metadata 2) trees
     */
    public static int getFoliageColorBirch() {
        return 0;
    }

    /**
     *
     */
    public static int getFoliageColorBasic() {
        return 0;
    }

}