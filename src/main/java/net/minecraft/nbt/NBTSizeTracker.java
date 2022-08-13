package net.minecraft.nbt;

/**
 *
 */
public class NBTSizeTracker extends Object {

    /**
     *
     */
    public static final NBTSizeTracker INFINITE = new NBTSizeTracker(0L);

    /**
     *
     */
    private final long max;

    /**
     *
     */
    private long read;

    /**
     *
     */
    public NBTSizeTracker(long max) {
        this.max = max;
    }

    /**
     * Tracks the reading of the given amount of bits(!)
     */
    public void read(long bits) {
        return;
    }

    /**
     *
     */
    public static void readUTF(NBTSizeTracker tracker,
                               String data) {
        return;
    }

}