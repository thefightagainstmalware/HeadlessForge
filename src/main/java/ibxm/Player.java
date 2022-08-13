package ibxm;

import javax.sound.sampled.*;
import java.io.*;

/**
 *
 */
public class Player extends Object {

    /**
     *
     */
    private java.lang.Thread play_thread;

    /**
     *
     */
    private IBXM ibxm;

    /**
     *
     */
    private Module module;

    /**
     *
     */
    private int song_duration;

    /**
     *
     */
    private int play_position;

    /**
     *
     */
    private boolean running;

    /**
     *
     */
    private boolean loop;

    /**
     *
     */
    private byte[] output_buffer;

    /**
     *
     */
    private javax.sound.sampled.SourceDataLine output_line;

    /**
     * Instantiate a new Player.
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public Player()
           throws javax.sound.sampled.LineUnavailableException {
        
    }

    /**
     * Simple command-line test player.
     * @throws java.lang.Exception
     */
    public static void main(String[] args)
                     throws Exception {
        return;
    }

    /**
     * Decode the data in the specified InputStream into a Module instance.
     * @param input an InputStream containing the module file to be decoded.
     * @throws java.lang.IllegalArgumentException if the data is not recognised as a module file.
     * @throws java.io.IOException
     */
    public static Module load_module(java.io.InputStream input)
                              throws IllegalArgumentException,
                                     java.io.IOException {
        return null;
    }

    /**
     * Set the Module instance to be played.
     */
    public void set_module(Module m) {
        return;
    }

    /**
     * If loop is true, playback will continue indefinitely,
     *                otherwise the module will play through once and stop.
     */
    public void set_loop(boolean loop) {
        return;
    }

    /**
     * Open the audio device and begin playback.
     *                If a module is already playing it will be restarted.
     */
    public void play() {
        return;
    }

    /**
     * Stop playback and close the audio device.
     */
    public void stop() {
        return;
    }

}