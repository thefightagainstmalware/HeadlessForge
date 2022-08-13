package ibxm;

/**
 *
 */
public class Module extends Object {

    /**
     *
     */
    public java.lang.String song_title;

    /**
     *
     */
    public boolean linear_periods;

    /**
     *
     */
    public boolean fast_volume_slides;

    /**
     *
     */
    public boolean pal;

    /**
     *
     */
    public int global_volume;

    /**
     *
     */
    public int channel_gain;

    /**
     *
     */
    public int default_speed;

    /**
     *
     */
    public int default_tempo;

    /**
     *
     */
    public int restart_sequence_index;

    /**
     *
     */
    private int[] initial_panning;

    /**
     *
     */
    private int[] sequence;

    /**
     *
     */
    private Pattern[] patterns;

    /**
     *
     */
    private Instrument[] instruments;

    /**
     *
     */
    private Pattern default_pattern;

    /**
     *
     */
    private Instrument default_instrument;

    /**
     *
     */
    public Module() {
        
    }

    /**
     *
     */
    public int get_num_channels() {
        return 0;
    }

    /**
     *
     */
    public void set_num_channels(int num_channels) {
        return;
    }

    /**
     *
     */
    public int get_initial_panning(int channel) {
        return 0;
    }

    /**
     *
     */
    public void set_initial_panning(int channel,
                                    int panning) {
        return;
    }

    /**
     *
     */
    public int get_sequence_length() {
        return 0;
    }

    /**
     *
     */
    public void set_sequence_length(int sequence_length) {
        return;
    }

    /**
     *
     */
    public void set_sequence(int sequence_index,
                             int pattern_index) {
        return;
    }

    /**
     *
     */
    public int get_num_patterns() {
        return 0;
    }

    /**
     *
     */
    public void set_num_patterns(int num_patterns) {
        return;
    }

    /**
     *
     */
    public Pattern get_pattern_from_sequence(int sequence_index) {
        return null;
    }

    /**
     *
     */
    public Pattern get_pattern(int pattern_index) {
        return null;
    }

    /**
     *
     */
    public void set_pattern(int pattern_index,
                            Pattern pattern) {
        return;
    }

    /**
     *
     */
    public int get_num_instruments() {
        return 0;
    }

    /**
     *
     */
    public void set_num_instruments(int num_instruments) {
        return;
    }

    /**
     *
     */
    public Instrument get_instrument(int instrument_index) {
        return null;
    }

    /**
     *
     */
    public void set_instrument(int instrument_index,
                               Instrument instrument) {
        return;
    }

}