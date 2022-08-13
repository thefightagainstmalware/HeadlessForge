package net.minecraft.world.gen.layer;

import com.google.common.collect.Lists;
import java.util.List;

/**
 *
 */
public class IntCache extends Object {

    /**
     *
     */
    private static int intCacheSize;

    /**
     *
     */
    private static java.util.List<int[]> freeSmallArrays;

    /**
     *
     */
    private static java.util.List<int[]> inUseSmallArrays;

    /**
     *
     */
    private static java.util.List<int[]> freeLargeArrays;

    /**
     *
     */
    private static java.util.List<int[]> inUseLargeArrays;

    /**
     *
     */
    public IntCache() {
        
    }

    /**
     *
     */
    public static int[] getIntCache(int p_76445_0_) {
        return null;
    }

    /**
     * Mark all pre-allocated arrays as available for re-use by moving them to the appropriate free lists.
     */
    public static void resetIntCache() {
        return;
    }

    /**
     * Gets a human-readable string that indicates the sizes of all the cache fields.  Basically a synchronized static
     * toString.
     */
    public static String getCacheSizes() {
        return null;
    }

}