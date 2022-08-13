package ibxm;

import java.io.*;

/**
 *
 */
public class FastTracker2 extends Object {

    /**
     *
     */
    public FastTracker2() {
        
    }

    /**
     *
     */
    public static boolean is_xm(byte[] header_60_bytes) {
        return true;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static Module load_xm(byte[] header_60_bytes,
                                 java.io.DataInput data_input)
                          throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static Pattern read_xm_pattern(java.io.DataInput data_input,
                                           int num_channels)
                                    throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static Instrument read_xm_instrument(java.io.DataInput data_input,
                                                 boolean delta_env)
                                          throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static Sample read_xm_sample(byte[] sample_headers,
                                         int sample_idx,
                                         java.io.DataInput data_input)
                                  throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    private static int unsigned_short_le(byte[] buffer,
                                         int offset) {
        return 0;
    }

    /**
     *
     */
    private static int int_le(byte[] buffer,
                              int offset) {
        return 0;
    }

    /**
     *
     */
    private static String ascii_text(byte[] buffer,
                                               int offset,
                                               int length) {
        return null;
    }

}