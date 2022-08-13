package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 */
public class NBTTagString extends NBTBase {

    /**
     * The string value for the tag (cannot be empty).
     */
    private java.lang.String data;

    /**
     *
     */
    public NBTTagString() {
        
    }

    /**
     *
     */
    public NBTTagString(String data) {
        
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
     * Return whether this compound has no tags.
     */
    @Override
    public boolean hasNoTags() {
        return true;
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
    @Override
    public String getString() {
        return null;
    }

}