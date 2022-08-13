package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;

/**
 *
 */
public class EntityAIMoveTowardsRestriction extends EntityAIBase {

    /**
     *
     */
    private EntityCreature theEntity;

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
    private double movementSpeed;

    /**
     *
     */
    public EntityAIMoveTowardsRestriction(EntityCreature creatureIn,
                                          double speedIn) {
        
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

}