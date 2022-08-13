package ibxm;

/**
 *
 */
public class ScreamTracker3 extends Object {

    /**
     *
     */
    private static final int[] effect_map = new int[0];

    /**
     *
     */
    private static final int[] effect_s_map = new int[0];

    /**
     *
     */
    public ScreamTracker3() {
        
    }

    /**
     *
     */
    public static boolean is_s3m(byte[] header_96_bytes) {
        return true;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static Module load_s3m(byte[] header_96_bytes,
                                  java.io.DataInput data_input)
                           throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    private static int[] read_s3m_sequence(byte[] s3m_file) {
        return null;
    }

    /**
     *
     */
    private static Instrument read_s3m_instrument(byte[] s3m_file,
                                                  int instrument_idx,
                                                  boolean signed_samples) {
        return null;
    }

    /**
     *
     */
    private static Pattern read_s3m_pattern(byte[] s3m_file,
                                            int pattern_idx,
                                            int[] channel_map) {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static byte[] read_s3m_file(byte[] header_96_bytes,
                                        java.io.DataInput data_input)
                                 throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    private static int get_num_pattern_orders(byte[] s3m_file) {
        return 0;
    }

    /**
     *
     */
    private static int get_num_instruments(byte[] s3m_file) {
        return 0;
    }

    /**
     *
     */
    private static int get_num_patterns(byte[] s3m_file) {
        return 0;
    }

    /**
     *
     */
    private static int get_instrument_offset(byte[] s3m_file,
                                             int instrument_idx) {
        return 0;
    }

    /**
     *
     */
    private static int get_sample_data_offset(byte[] s3m_file,
                                              int instrument_offset) {
        return 0;
    }

    /**
     *
     */
    private static int get_sample_data_length(byte[] s3m_file,
                                              int instrument_offset) {
        return 0;
    }

    /**
     *
     */
    private static int get_pattern_offset(byte[] s3m_file,
                                          int pattern_idx) {
        return 0;
    }

    /**
     *
     */
    private static int get_pattern_length(byte[] s3m_file,
                                          int pattern_offset) {
        return 0;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    private static byte[] read_more(byte[] old_data,
                                    int new_length,
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
    private static String ascii_text(byte[] buffer,
                                               int offset,
                                               int length) {
        return null;
    }

}