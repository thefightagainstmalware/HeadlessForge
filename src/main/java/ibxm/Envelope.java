package ibxm;

/**
 *
 */
public class Envelope extends Object {

    /**
     *
     */
    public boolean sustain;

    /**
     *
     */
    public boolean looped;

    /**
     *
     */
    private int sustain_tick;

    /**
     *
     */
    private int loop_start_tick;

    /**
     *
     */
    private int loop_end_tick;

    /**
     *
     */
    private int[] ticks;

    /**
     *
     */
    private int[] ampls;

    /**
     *
     */
    public Envelope() {
        
    }

    /**
     *
     */
    public void set_num_points(int num_points) {
        return;
    }

    /**
     *
     */
    public void set_point(int point,
                          int tick,
                          int ampl,
                          boolean delta) {
        return;
    }

    /**
     *
     */
    public void set_sustain_point(int point) {
        return;
    }

    /**
     *
     */
    public void set_loop_points(int start,
                                int end) {
        return;
    }

    /**
     *
     */
    public int next_tick(int tick,
                         boolean key_on) {
        return 0;
    }

    /**
     *
     */
    public int calculate_ampl(int tick) {
        return 0;
    }

    /**
     *
     */
    public void dump() {
        return;
    }

}