package net.minecraft.entity.ai;

import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAISit extends EntityAIBase {

    /**
     *
     */
    private EntityTameable theEntity;

    /**
     * If the EntityTameable is sitting.
     */
    private boolean isSitting;

    /**
     *
     */
    public EntityAISit(EntityTameable entityIn) {
        
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
     * Sets the sitting flag.
     */
    public void setSitting(boolean sitting) {
        return;
    }

}