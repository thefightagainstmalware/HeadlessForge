package net.minecraft.entity.ai;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;

/**
 *
 */
public class EntityAIWatchClosest extends EntityAIBase {

    /**
     *
     */
    protected EntityLiving theWatcher;

    /**
     * The closest entity which is being watched by this one.
     */
    protected Entity closestEntity;

    /**
     * This is the Maximum distance that the AI will look for the Entity
     */
    protected float maxDistanceForPlayer;

    /**
     *
     */
    private int lookTime;

    /**
     *
     */
    private float chance;

    /**
     *
     */
    protected java.lang.Class<? extends Entity> watchedClass;

    /**
     *
     */
    public EntityAIWatchClosest(EntityLiving entitylivingIn,
                                Class<? extends Entity> watchTargetClass,
                                float maxDistance) {
        
    }

    /**
     *
     */
    public EntityAIWatchClosest(EntityLiving entitylivingIn,
                                Class<? extends Entity> watchTargetClass,
                                float maxDistance,
                                float chanceIn) {
        
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        return true;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return true;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        return;
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        return;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

}