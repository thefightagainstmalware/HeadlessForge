package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.pathfinding.PathNavigateGround;

/**
 *
 */
public class EntityAIRestrictSun extends EntityAIBase {

    /**
     *
     */
    private EntityCreature theEntity;

    /**
     *
     */
    public EntityAIRestrictSun(EntityCreature p_i1652_1_) {
        
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
     * Resets the task
     */
    @Override
    public void resetTask() {
        return;
    }

}