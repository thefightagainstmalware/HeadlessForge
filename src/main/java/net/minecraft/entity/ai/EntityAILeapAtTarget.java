package net.minecraft.entity.ai;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAILeapAtTarget extends EntityAIBase {

    /**
     * The entity that is leaping.
     */
    EntityLiving leaper;

    /**
     * The entity that the leaper is leaping towards.
     */
    EntityLivingBase leapTarget;

    /**
     * The entity's motionY after leaping.
     */
    float leapMotionY;

    /**
     *
     */
    public EntityAILeapAtTarget(EntityLiving leapingEntity,
                                float leapMotionYIn) {
        
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

}