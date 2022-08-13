package net.minecraft.entity.ai;

import net.minecraft.entity.passive.EntityAnimal;
import java.util.List;

/**
 *
 */
public class EntityAIFollowParent extends EntityAIBase {

    /**
     * The child that is following its parent.
     */
    EntityAnimal childAnimal;

    /**
     *
     */
    EntityAnimal parentAnimal;

    /**
     *
     */
    double moveSpeed;

    /**
     *
     */
    private int delayCounter;

    /**
     *
     */
    public EntityAIFollowParent(EntityAnimal animal,
                                double speed) {
        
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