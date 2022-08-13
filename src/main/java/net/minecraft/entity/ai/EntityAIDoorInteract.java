package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockPos;
import net.minecraft.block.BlockDoor;

/**
 *
 */
public abstract class EntityAIDoorInteract extends EntityAIBase {

    /**
     *
     */
    protected EntityLiving theEntity;

    /**
     *
     */
    protected BlockPos doorPosition;

    /**
     * The wooden door block
     */
    protected BlockDoor doorBlock;

    /**
     * If is true then the Entity has stopped Door Interaction and compoleted the task.
     */
    boolean hasStoppedDoorInteraction;

    /**
     *
     */
    float entityPositionX;

    /**
     *
     */
    float entityPositionZ;

    /**
     *
     */
    public EntityAIDoorInteract(EntityLiving entityIn) {
        
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
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

    /**
     *
     */
    private BlockDoor getBlockDoor(BlockPos pos) {
        return null;
    }

}