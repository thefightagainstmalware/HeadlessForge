package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;

/**
 *
 */
public class EntityAIOpenDoor extends EntityAIDoorInteract {

    /**
     * If the entity close the door
     */
    boolean closeDoor;

    /**
     * The temporisation before the entity close the door (in ticks, always 20 = 1 second)
     */
    int closeDoorTemporisation;

    /**
     *
     */
    public EntityAIOpenDoor(EntityLiving entitylivingIn,
                            boolean shouldClose) {
        super(entitylivingIn);
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