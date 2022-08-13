package net.minecraft.client.util;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.Minecraft;

/**
 *
 */
public class Timer extends Object {

    /**
     * The number of timer ticks per second of real time
     */
    float ticksPerSecond;

    /**
     * The time reported by the high-resolution clock at the last call of updateTimer(), in seconds
     */
    private double lastHRTime;

    /**
     * How many full ticks have turned over since the last call to updateTimer(), capped at 10.
     */
    public int elapsedTicks;

    /**
     * How much time has elapsed since the last tick, in ticks, for use by display rendering routines (range: 0.0 -
     * 1.0).  This field is frozen if the display is paused to eliminate jitter.
     */
    public float renderPartialTicks;

    /**
     * A multiplier to make the timer (and therefore the game) go faster or slower.  0.5 makes the game run at half-
     * speed.
     */
    public float timerSpeed;

    /**
     * How much time has elapsed since the last tick, in ticks (range: 0.0 - 1.0).
     */
    public float elapsedPartialTicks;

    /**
     * The time reported by the system clock at the last sync, in milliseconds
     */
    private long lastSyncSysClock;

    /**
     * The time reported by the high-resolution clock at the last sync, in milliseconds
     */
    private long lastSyncHRClock;

    /**
     *
     */
    private long field_74285_i;

    /**
     * A ratio used to sync the high-resolution clock to the system clock, updated once per second
     */
    private double timeSyncAdjustment;

    /**
     *
     */
    public Timer(float p_i1018_1_) {
        
    }

    /**
     * Updates all fields of the Timer using the current time
     */
    public void updateTimer() {
        return;
    }

}