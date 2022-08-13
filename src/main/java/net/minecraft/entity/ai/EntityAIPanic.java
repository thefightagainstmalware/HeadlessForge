package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;

/**
 *
 */
public class EntityAIPanic extends EntityAIBase {

    /**
     *
     */
    private EntityCreature theEntityCreature;

    /**
     *
     */
    protected double speed;

    /**
     *
     */
    private double randPosX;

    /**
     *
     */
    private double randPosY;

    /**
     *
     */
    private double randPosZ;

    /**
     *
     */
    public EntityAIPanic(EntityCreature creature,
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

}