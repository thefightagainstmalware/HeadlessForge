package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

/**
 *
 */
public class EntityAITempt extends EntityAIBase {

    /**
     * The entity using this AI that is tempted by the player.
     */
    private EntityCreature temptedEntity;

    /**
     *
     */
    private double speed;

    /**
     * X position of player tempting this mob
     */
    private double targetX;

    /**
     * Y position of player tempting this mob
     */
    private double targetY;

    /**
     * Z position of player tempting this mob
     */
    private double targetZ;

    /**
     * Tempting player's pitch
     */
    private double pitch;

    /**
     * Tempting player's yaw
     */
    private double yaw;

    /**
     * The player that is tempting the entity that is using this AI.
     */
    private EntityPlayer temptingPlayer;

    /**
     * A counter that is decremented each time the shouldExecute method is called. The shouldExecute method will always
     * return false if delayTemptCounter is greater than 0.
     */
    private int delayTemptCounter;

    /**
     * True if this EntityAITempt task is running
     */
    private boolean isRunning;

    /**
     *
     */
    private Item temptItem;

    /**
     * Whether the entity using this AI will be scared by the tempter's sudden movement.
     */
    private boolean scaredByPlayerMovement;

    /**
     *
     */
    private boolean avoidWater;

    /**
     *
     */
    public EntityAITempt(EntityCreature temptedEntityIn,
                         double speedIn,
                         Item temptItemIn,
                         boolean scaredByPlayerMovementIn) {
        
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
    public boolean isRunning() {
        return true;
    }

}