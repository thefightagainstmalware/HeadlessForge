package net.minecraft.util;

/**
 *
 */
public interface IThreadListener {

    /**
     *
     * @return
     */
    Object addScheduledTask(Runnable runnableToSchedule) throws Exception;

    /**
     *
     */
    boolean isCallingFromMinecraftThread();

}