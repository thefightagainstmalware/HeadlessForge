package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;

/**
 *
 */
public class EntityAIWander extends EntityAIBase {

    /**
     *
     */
    private EntityCreature entity;

    /**
     *
     */
    private double xPosition;

    /**
     *
     */
    private double yPosition;

    /**
     *
     */
    private double zPosition;

    /**
     *
     */
    private double speed;

    /**
     *
     */
    private int executionChance;

    /**
     *
     */
    private boolean mustUpdate;

    /**
     *
     */
    public EntityAIWander(EntityCreature creatureIn,
                          double speedIn) {
        
    }

    /**
     *
     */
    public EntityAIWander(EntityCreature creatureIn,
                          double speedIn,
                          int chance) {
        
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
     * Makes task to bypass chance
     */
    public void makeUpdate() {
        return;
    }

    /**
     * Changes task random possibility for execution
     */
    public void setExecutionChance(int newchance) {
        return;
    }

}