package net.minecraft.client.audio;

import com.google.common.collect.*;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.List;
import java.util.Map;

public class SoundManager
{
    /** The marker used for logging */
    private static final Marker LOG_MARKER = MarkerManager.getMarker("SOUNDS");
    private static final Logger logger = LogManager.getLogger();

    /** A reference to the sound handler. */
    private final SoundHandler sndHandler;

    /** Reference to the GameSettings object. */
    private final GameSettings options;

    /** A reference to the sound system. */
    private SoundManager.SoundSystemStarterThread sndSystem;

    /** Set to true when the SoundManager has been initialised. */
    private boolean loaded;

    /** A counter for how long the sound manager has been running */
    private int playTime = 0;
    private final Map<String, ISound> playingSounds = HashBiMap.<String, ISound>create();
    private final Map<ISound, String> invPlayingSounds;
    private Map<ISound, SoundPoolEntry> playingSoundPoolEntries;
    private final Multimap<SoundCategory, String> categorySounds;
    private final List<ITickableSound> tickableSounds;
    private final Map<ISound, Integer> delayedSounds;
    private final Map<String, Integer> playingSoundsStopTime;

    public SoundManager(SoundHandler p_i45119_1_, GameSettings p_i45119_2_)
    {
        this.invPlayingSounds = ((BiMap)this.playingSounds).inverse();
        this.playingSoundPoolEntries = Maps.<ISound, SoundPoolEntry>newHashMap();
        this.categorySounds = HashMultimap.<SoundCategory, String>create();
        this.tickableSounds = Lists.<ITickableSound>newArrayList();
        this.delayedSounds = Maps.<ISound, Integer>newHashMap();
        this.playingSoundsStopTime = Maps.<String, Integer>newHashMap();
        this.sndHandler = p_i45119_1_;
        this.options = p_i45119_2_;


    }

    public void reloadSoundSystem()
    {
        this.unloadSoundSystem();
        this.loadSoundSystem();
    }

    /**
     * Tries to add the paulscode library and the relevant codecs. If it fails, the master volume  will be set to zero.
     */
    private synchronized void loadSoundSystem()
    {

    }

    /**
     * Returns the sound level (between 0.0 and 1.0) for a category, but 1.0 for the master sound category
     */
    private float getSoundCategoryVolume(SoundCategory category)
    {
        return category != null && category != SoundCategory.MASTER ? this.options.getSoundLevel(category) : 1.0F;
    }

    /**
     * Adjusts volume for currently playing sounds in this category
     */
    public void setSoundCategoryVolume(SoundCategory category, float volume)
    {

    }

    /**
     * Cleans up the Sound System
     */
    public void unloadSoundSystem()
    {
        if (this.loaded)
        {
            this.stopAllSounds();
            this.loaded = false;
        }
    }

    /**
     * Stops all currently playing sounds
     */
    public void stopAllSounds()
    {

    }

    public void updateAllSounds()
    {

    }

    /**
     * Returns true if the sound is playing or still within time
     */
    public boolean isSoundPlaying(ISound sound)
    {
        if (!this.loaded)
        {
            return false;
        }
        else
        {
            String s = (String)this.invPlayingSounds.get(sound);
            return s == null ? false : this.sndSystem.playing(s) || this.playingSoundsStopTime.containsKey(s) && ((Integer)this.playingSoundsStopTime.get(s)).intValue() <= this.playTime;
        }
    }

    public void stopSound(ISound sound)
    {
    }

    public void playSound(ISound sound)
    {

    }

    /**
     * Normalizes pitch from parameters and clamps to [0.5, 2.0]
     */
    private float getNormalizedPitch(ISound sound, SoundPoolEntry entry)
    {
        return (float)MathHelper.clamp_double((double)sound.getPitch() * entry.getPitch(), 0.5D, 2.0D);
    }

    /**
     * Normalizes volume level from parameters.  Range [0.0, 1.0]
     */
    private float getNormalizedVolume(ISound sound, SoundPoolEntry entry, SoundCategory category)
    {
        return (float)MathHelper.clamp_double((double)sound.getVolume() * entry.getVolume(), 0.0D, 1.0D) * this.getSoundCategoryVolume(category);
    }

    /**
     * Pauses all currently playing sounds
     */
    public void pauseAllSounds()
    {
    }

    /**
     * Resumes playing all currently playing sounds (after pauseAllSounds)
     */
    public void resumeAllSounds()
    {

    }

    /**
     * Adds a sound to play in n tick
     */
    public void playDelayedSound(ISound sound, int delay)
    {
        this.delayedSounds.put(sound, Integer.valueOf(this.playTime + delay));
    }

    private static URL getURLForSoundResource(final ResourceLocation p_148612_0_)
    {
        String s = String.format("%s:%s:%s", new Object[] {"mcsounddomain", p_148612_0_.func_110624_b(), p_148612_0_.func_110623_a()});
        URLStreamHandler urlstreamhandler = new URLStreamHandler()
        {
            protected URLConnection openConnection(final URL p_openConnection_1_)
            {
                return new URLConnection(p_openConnection_1_)
                {
                    public void connect() throws IOException
                    {
                    }
                    public InputStream getInputStream() throws IOException
                    {
                        return null;
                    }
                };
            }
        };

        try
        {
            return new URL((URL)null, s, urlstreamhandler);
        }
        catch (MalformedURLException var4)
        {
            throw new Error("TODO: Sanely handle url exception! :D");
        }
    }

    /**
     * Sets the listener of sounds
     */
    public void setListener(EntityPlayer player, float p_148615_2_)
    {

    }

    class SoundSystemStarterThread {
        private SoundSystemStarterThread()
        {
        }

        public boolean playing(String p_playing_1_)
        {
            return false;
        }
    }
}
