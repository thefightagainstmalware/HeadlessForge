package net.minecraft.entity.ai;

import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;

/**
 *
 */
public class EntityAILookAtVillager extends EntityAIBase {

    /**
     *
     */
    private EntityIronGolem theGolem;

    /**
     *
     */
    private EntityVillager theVillager;

    /**
     *
     */
    private int lookTime;

    /**
     *
     */
    public EntityAILookAtVillager(EntityIronGolem theGolemIn) {
        
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

}