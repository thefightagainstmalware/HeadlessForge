package net.minecraft.entity.ai;

import net.minecraft.entity.passive.EntityHorse;

/**
 *
 */
public class EntityAIRunAroundLikeCrazy extends EntityAIBase {

    /**
     *
     */
    private EntityHorse horseHost;

    /**
     *
     */
    private double speed;

    /**
     *
     */
    private double targetX;

    /**
     *
     */
    private double targetY;

    /**
     *
     */
    private double targetZ;

    /**
     *
     */
    public EntityAIRunAroundLikeCrazy(EntityHorse horse,
                                      double speedIn) {
        
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
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
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return true;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

}