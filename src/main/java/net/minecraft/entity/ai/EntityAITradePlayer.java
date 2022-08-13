package net.minecraft.entity.ai;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.entity.passive.EntityVillager;

/**
 *
 */
public class EntityAITradePlayer extends EntityAIBase {

    /**
     *
     */
    private EntityVillager villager;

    /**
     *
     */
    public EntityAITradePlayer(EntityVillager villagerIn) {
        
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

}