package net.minecraft.entity.ai;

import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIOwnerHurtByTarget extends EntityAITarget {

    /**
     *
     */
    EntityTameable theDefendingTameable;

    /**
     *
     */
    EntityLivingBase theOwnerAttacker;

    /**
     *
     */
    private int field_142051_e;

    /**
     *
     */
    public EntityAIOwnerHurtByTarget(EntityTameable theDefendingTameableIn) {
        super(theDefendingTameableIn, false);
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

}