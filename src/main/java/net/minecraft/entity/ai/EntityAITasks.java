package net.minecraft.entity.ai;

import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.Logger;
import net.minecraft.profiler.Profiler;

/**
 *
 */
public class EntityAITasks extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    public java.util.List<EntityAITasks.EntityAITaskEntry> taskEntries;

    /**
     *
     */
    private java.util.List<EntityAITasks.EntityAITaskEntry> executingTaskEntries;

    /**
     * Instance of Profiler.
     */
    private final Profiler theProfiler;

    /**
     *
     */
    private int tickCount;

    /**
     *
     */
    private int tickRate;

    /**
     *
     */
    public EntityAITasks(Profiler profilerIn) {
        this.theProfiler = profilerIn;
    }

    /**
     * Add a now AITask. Args : priority, task
     */
    public void addTask(int priority,
                        EntityAIBase task) {
        return;
    }

    /**
     * removes the indicated task from the entity's AI tasks.
     */
    public void removeTask(EntityAIBase task) {
        return;
    }

    /**
     *
     */
    public void onUpdateTasks() {
        return;
    }

    /**
     * Determine if a specific AI Task should continue being executed.
     */
    private boolean canContinue(EntityAITasks.EntityAITaskEntry taskEntry) {
        return true;
    }

    /**
     * Determine if a specific AI Task can be executed, which means that all running higher (= lower int value) priority
     * tasks are compatible with it or all lower priority tasks can be interrupted.
     */
    private boolean canUse(EntityAITasks.EntityAITaskEntry taskEntry) {
        return true;
    }

    /**
     * Returns whether two EntityAITaskEntries can be executed concurrently
     */
    private boolean areTasksCompatible(EntityAITasks.EntityAITaskEntry taskEntry1,
                                       EntityAITasks.EntityAITaskEntry taskEntry2) {
        return true;
    }

    public class EntityAITaskEntry {
    }
}