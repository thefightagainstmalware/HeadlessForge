package net.minecraft.entity.ai;

import net.minecraft.world.World;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIOcelotAttack extends EntityAIBase {

    /**
     *
     */
    World theWorld;

    /**
     *
     */
    EntityLiving theEntity;

    /**
     *
     */
    EntityLivingBase theVictim;

    /**
     *
     */
    int attackCountdown;

    /**
     *
     */
    public EntityAIOcelotAttack(EntityLiving theEntityIn) {
        
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
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

}