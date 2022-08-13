package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.village.VillageDoorInfo;

/**
 *
 */
public class EntityAIRestrictOpenDoor extends EntityAIBase {

    /**
     *
     */
    private EntityCreature entityObj;

    /**
     *
     */
    private VillageDoorInfo frontDoor;

    /**
     *
     */
    public EntityAIRestrictOpenDoor(EntityCreature creatureIn) {
        
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