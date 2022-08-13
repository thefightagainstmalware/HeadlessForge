package ibxm;

import java.io.*;

/**
 *
 */
public class ProTracker extends Object {

    /**
     *
     */
    public ProTracker() {
        
    }

    /**
     *
     */
    public static boolean is_mod(byte[] header_1084_bytes) {
        return true;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static Module load_mod(byte[] header_1084_bytes,
                                  java.io.DataInput data_input)
                           throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    private static int calculate_num_patterns(byte[] module_header) {
        return 0;
    }

    /**
     *
     */
    private static int calculate_num_channels(byte[] module_header) {
        return 0;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static Pattern read_mod_pattern(java.io.DataInput data_input,
                                            int num_channels)
                                     throws java.io.IOException {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static Instrument read_mod_instrument(byte[] mod_header,
                                                  int idx,
                                                  java.io.DataInput data_input)
                                           throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    private static byte to_key(int period) {
        return 0;
    }

    /**
     *
     */
    private static int unsigned_short_be(byte[] buf,
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