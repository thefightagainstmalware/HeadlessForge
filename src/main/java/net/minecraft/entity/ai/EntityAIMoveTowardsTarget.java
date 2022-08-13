package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIMoveTowardsTarget extends EntityAIBase {

    /**
     *
     */
    private EntityCreature theEntity;

    /**
     *
     */
    private EntityLivingBase targetEntity;

    /**
     *
     */
    private double movePosX;

    /**
     *
     */
    private double movePosY;

    /**
     *
     */
    private double movePosZ;

    /**
     *
     */
    private double speed;

    /**
     * If the distance to the target entity is further than this, this AI task will not run.
     */
    private float maxTargetDistance;

    /**
     *
     */
    public EntityAIMoveTowardsTarget(EntityCreature creature,
                                     double speedIn,
                                     float targetMaxDistance) {
        
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
     * Resets the task
     */
    @Override
    public void resetTask() {
        return;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        return;
    }

}