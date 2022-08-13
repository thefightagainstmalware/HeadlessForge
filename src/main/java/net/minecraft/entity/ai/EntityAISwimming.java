package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigateGround;

/**
 *
 */
public class EntityAISwimming extends EntityAIBase {

    /**
     *
     */
    private EntityLiving theEntity;

    /**
     *
     */
    public EntityAISwimming(EntityLiving entitylivingIn) {
        
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
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