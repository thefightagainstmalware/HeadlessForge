package net.minecraft.entity.ai;

import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityAIFollowOwner extends EntityAIBase {

    /**
     *
     */
    private EntityTameable thePet;

    /**
     *
     */
    private EntityLivingBase theOwner;

    /**
     *
     */
    World theWorld;

    /**
     *
     */
    private double followSpeed;

    /**
     *
     */
    private PathNavigate petPathfinder;

    /**
     *
     */
    private int field_75343_h;

    /**
     *
     */
    float maxDist;

    /**
     *
     */
    float minDist;

    /**
     *
     */
    private boolean field_75344_i;

    /**
     *
     */
    public EntityAIFollowOwner(EntityTameable thePetIn,
                               double followSpeedIn,
                               float minDistIn,
                               float maxDistIn) {
        
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
     *
     */
    private boolean func_181065_a(BlockPos p_181065_1_) {
        return true;
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        return;
    }

}