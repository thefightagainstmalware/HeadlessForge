package net.minecraft.nbt;

import java.io.DataOutput;
import java.io.DataInput;
import java.io.IOException;

/**
 *
 */
public class NBTTagEnd extends NBTBase {

    /**
     *
     */
    public NBTTagEnd() {
        
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
     * Write the actual data contents of the tag, implemented in NBT extension classes
     * @throws java.io.IOException
     */
    void write(java.io.DataOutput output)
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

}