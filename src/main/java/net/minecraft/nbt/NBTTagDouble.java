package net.minecraft.nbt;

import net.minecraft.util.MathHelper;

/**
 *
 */
public class NBTTagDouble extends NBTBase.NBTPrimitive {

    /**
     * The double value for the tag.
     */
    private double data;

    /**
     *
     */
    NBTTagDouble() {
        
    }

    /**
     *
     */
    public NBTTagDouble(double data) {
        
    }

    /**
     * Write the actual data contents of the tag, implemented in NBT extension classes
     * @throws java.io.IOException
     */
    void write(java.io.DataOutput output)
        throws java.io.IOException {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    void read(java.io.DataInput input,
              int depth,
              NBTSizeTracker sizeTracker)
       throws java.io.IOException {
        return;
    }

    /**
     * Gets the type byte for the tag.
     */
    public byte getId() {
        return 0;
    }

    /**
     *
     */
    public String toString() {
        return null;
    }

    /**
     * Creates a clone of the tag.
     */
    public NBTBase func_74737_b() {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    public long getLong() {
        return 0;
    }

    /**
     *
     */
    public int getInt() {
        return 0;
    }

    /**
     *
     */
    public short getShort() {
        return 0;
    }

    /**
     *
     */
    public byte getByte() {
        return 0;
    }

    /**
     *
     */
    public double getDouble() {
        return 0;
    }

    /**
     *
     */
    public float getFloat() {
        return 0;
    }

}