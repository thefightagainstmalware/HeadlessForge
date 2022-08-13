package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;

/**
 *
 */
public class EntityAILookIdle extends EntityAIBase {

    /**
     * The entity that is looking idle.
     */
    private EntityLiving idleEntity;

    /**
     * X offset to look at
     */
    private double lookX;

    /**
     * Z offset to look at
     */
    private double lookZ;

    /**
     * A decrementing tick that stops the entity from being idle once it reaches 0.
     */
    private int idleTime;

    /**
     *
     */
    public EntityAILookIdle(EntityLiving entitylivingIn) {
        
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
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

}