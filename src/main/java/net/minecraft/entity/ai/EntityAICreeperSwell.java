package net.minecraft.entity.ai;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAICreeperSwell extends EntityAIBase {

    /**
     * The creeper that is swelling.
     */
    EntityCreeper swellingCreeper;

    /**
     * The creeper's attack target. This is used for the changing of the creeper's state.
     */
    EntityLivingBase creeperAttackTarget;

    /**
     *
     */
    public EntityAICreeperSwell(EntityCreeper entitycreeperIn) {
        
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
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

}