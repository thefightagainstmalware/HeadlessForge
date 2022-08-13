package net.minecraft.entity.ai;

import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityWolf;

/**
 *
 */
public class EntityAIBeg extends EntityAIBase {

    /**
     *
     */
    private EntityWolf theWolf;

    /**
     *
     */
    private EntityPlayer thePlayer;

    /**
     *
     */
    private World worldObject;

    /**
     *
     */
    private float minPlayerDistance;

    /**
     *
     */
    private int timeoutCounter;

    /**
     *
     */
    public EntityAIBeg(EntityWolf wolf,
                       float minDistance) {
        
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
     * Gets if the Player has the Bone in the hand.
     */
    private boolean hasPlayerGotBoneInHand(EntityPlayer player) {
        return true;
    }

}