package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.block.BlockDoor;

/**
 *
 */
public class EntityAIBreakDoor extends EntityAIDoorInteract {

    /**
     *
     */
    private int breakingTime;

    /**
     *
     */
    private int previousBreakProgress;

    /**
     *
     */
    public EntityAIBreakDoor(EntityLiving entityIn) {
        super(entityIn);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
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