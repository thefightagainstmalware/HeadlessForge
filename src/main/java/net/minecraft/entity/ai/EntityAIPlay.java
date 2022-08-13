package net.minecraft.entity.ai;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIPlay extends EntityAIBase {

    /**
     *
     */
    private EntityVillager villagerObj;

    /**
     *
     */
    private EntityLivingBase targetVillager;

    /**
     *
     */
    private double speed;

    /**
     *
     */
    private int playTime;

    /**
     *
     */
    public EntityAIPlay(EntityVillager villagerObjIn,
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