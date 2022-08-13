package net.minecraft.entity.ai;

import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityVillager;

/**
 *
 */
public class EntityAIVillagerMate extends EntityAIBase {

    /**
     *
     */
    private EntityVillager villagerObj;

    /**
     *
     */
    private EntityVillager mate;

    /**
     *
     */
    private World worldObj;

    /**
     *
     */
    private int matingTimeout;

    /**
     *
     */
    Village villageObj;

    /**
     *
     */
    public EntityAIVillagerMate(EntityVillager villagerIn) {
        
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

    /**
     *
     */
    private boolean checkSufficientDoorsPresentForNewVillager() {
        return true;
    }

    /**
     *
     */
    private void giveBirth() {
        return;
    }

}