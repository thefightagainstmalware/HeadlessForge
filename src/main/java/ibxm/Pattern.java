package ibxm;

/**
 *
 */
public class Pattern extends Object {

    /**
     *
     */
    public int num_rows;

    /**
     *
     */
    private int data_offset;

    /**
     *
     */
    private int note_index;

    /**
     *
     */
    private byte[] pattern_data;

    /**
     *
     */
    public Pattern() {
        
    }

    /**
     *
     */
    public void set_pattern_data(byte[] data) {
        return;
    }

    /**
     *
     */
    public void get_note(int[] note,
                         int index) {
        return;
    }

    /**
     *
     */
    public int next_note(int data_offset,
                         int[] note) {
        return 0;
    }

}