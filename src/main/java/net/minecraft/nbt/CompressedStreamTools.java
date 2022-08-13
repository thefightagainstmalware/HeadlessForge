package net.minecraft.nbt;

/**
 *
 */
public class CompressedStreamTools extends Object {

    /**
     *
     */
    public CompressedStreamTools() {
        
    }

    /**
     * Load the gzipped compound from the inputstream.
     * @throws java.io.IOException
     */
    public static NBTTagCompound readCompressed(java.io.InputStream is)
                                         throws java.io.IOException {
        return null;
    }

    /**
     * Write the compound, gzipped, to the outputstream.
     * @throws java.io.IOException
     */
    public static void writeCompressed(NBTTagCompound p_74799_0_,
                                       java.io.OutputStream outputStream)
                                throws java.io.IOException {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static void safeWrite(NBTTagCompound p_74793_0_,
                                 java.io.File p_74793_1_)
                          throws java.io.IOException {
        return;
    }

    /**
     * Reads from a CompressedStream.
     * @throws java.io.IOException
     */
    public static NBTTagCompound read(java.io.DataInputStream inputStream)
                               throws java.io.IOException {
        return null;
    }

    /**
     * Reads the given DataInput, constructs, and returns an NBTTagCompound with the data from the DataInput
     * @throws java.io.IOException
     */
    public static NBTTagCompound read(java.io.DataInput p_152456_0_,
                                      NBTSizeTracker p_152456_1_)
                               throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static void write(NBTTagCompound p_74800_0_,
                             java.io.DataOutput p_74800_1_)
                      throws java.io.IOException {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static void writeTag(NBTBase p_150663_0_,
                                 java.io.DataOutput p_150663_1_)
                          throws java.io.IOException {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static NBTBase func_152455_a(java.io.DataInput p_152455_0_,
                                         int p_152455_1_,
                                         NBTSizeTracker p_152455_2_)
                                  throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static void write(NBTTagCompound p_74795_0_,
                             java.io.File p_74795_1_)
                      throws java.io.IOException {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static NBTTagCompound read(java.io.File p_74797_0_)
                               throws java.io.IOException {
        return null;
    }

}