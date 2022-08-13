package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIHurtByTarget extends EntityAITarget {

    /**
     *
     */
    private boolean entityCallsForHelp;

    /**
     * Store the previous revengeTimer value
     */
    private int revengeTimerOld;

    /**
     *
     */
    private final java.lang.Class[] targetClasses;

    /**
     *
     */
    public EntityAIHurtByTarget(EntityCreature creatureIn,
                                boolean entityCallsForHelpIn,
                                Class... targetClassesIn) {
        super(creatureIn, true);
        this.entityCallsForHelp = entityCallsForHelpIn;
        this.targetClasses = targetClassesIn;
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
     *
     */
    protected void setEntityAttackTarget(EntityCreature creatureIn,
                                         EntityLivingBase entityLivingBaseIn) {
        return;
    }

}