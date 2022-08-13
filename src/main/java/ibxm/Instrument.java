package ibxm;

/**
 *
 */
public class Instrument extends Object {

    /**
     *
     */
    public java.lang.String name;

    /**
     *
     */
    public int vibrato_type;

    /**
     *
     */
    public int vibrato_sweep;

    /**
     *
     */
    public int vibrato_depth;

    /**
     *
     */
    public int vibrato_rate;

    /**
     *
     */
    public boolean volume_envelope_active;

    /**
     *
     */
    public boolean panning_envelope_active;

    /**
     *
     */
    public int volume_fade_out;

    /**
     *
     */
    private Envelope volume_envelope;

    /**
     *
     */
    private Envelope panning_envelope;

    /**
     *
     */
    private int[] key_to_sample;

    /**
     *
     */
    private Sample[] samples;

    /**
     *
     */
    public Instrument() {
        
    }

    /**
     *
     */
    public Envelope get_volume_envelope() {
        return null;
    }

    /**
     *
     */
    public void set_volume_envelope(Envelope envelope) {
        return;
    }

    /**
     *
     */
    public Envelope get_panning_envelope() {
        return null;
    }

    /**
     *
     */
    public void set_panning_envelope(Envelope envelope) {
        return;
    }

    /**
     *
     */
    public Sample get_sample_from_key(int key) {
        return null;
    }

    /**
     *
     */
    public void set_key_to_sample(int key,
                                  int sample) {
        return;
    }

    /**
     *
     */
    public int get_num_samples() {
        return 0;
    }

    /**
     *
     */
    public void set_num_samples(int num_samples) {
        return;
    }

    /**
     *
     */
    public Sample get_sample(int sample_index) {
        return null;
    }

    /**
     *
     */
    public void set_sample(int sample_index,
                           Sample sample) {
        return;
    }

}