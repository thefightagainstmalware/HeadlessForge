package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIAttackOnCollide extends EntityAIBase {

    /**
     *
     */
    World worldObj;

    /**
     *
     */
    protected EntityCreature attacker;

    /**
     * An amount of decrementing ticks that allows the entity to attack once the tick reaches 0.
     */
    int attackTick;

    /**
     * The speed with which the mob will approach the target
     */
    double speedTowardsTarget;

    /**
     * When true, the mob will continue chasing its target, even if it can't find a path to them right now.
     */
    boolean longMemory;

    /**
     * The PathEntity of our entity.
     */
    PathEntity entityPathEntity;

    /**
     *
     */
    java.lang.Class<? extends Entity> classTarget;

    /**
     *
     */
    private int delayCounter;

    /**
     *
     */
    private double targetX;

    /**
     *
     */
    private double targetY;

    /**
     *
     */
    private double targetZ;

    /**
     *
     */
    private int failedPathFindingPenalty;

    /**
     *
     */
    private boolean canPenalize;

    /**
     *
     */
    public EntityAIAttackOnCollide(EntityCreature creature,
                                   Class<? extends Entity> targetClass,
                                   double speedIn,
                                   boolean useLongMemory) {
        
    }

    /**
     *
     */
    public EntityAIAttackOnCollide(EntityCreature creature,
                                   double speedIn,
                                   boolean useLongMemory) {
        
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

    /**
     *
     */
    protected double func_179512_a(EntityLivingBase attackTarget) {
        return 0;
    }

}