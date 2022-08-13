package net.minecraft.entity.ai;

import net.minecraft.village.Village;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.MathHelper;
import net.minecraft.village.VillageDoorInfo;
import net.minecraft.pathfinding.PathEntity;

/**
 *
 */
public class EntityAIMoveThroughVillage extends EntityAIBase {

    /**
     *
     */
    private EntityCreature theEntity;

    /**
     *
     */
    private double movementSpeed;

    /**
     * The PathNavigate of our entity.
     */
    private PathEntity entityPathNavigate;

    /**
     *
     */
    private VillageDoorInfo doorInfo;

    /**
     *
     */
    private boolean isNocturnal;

    /**
     *
     */
    private java.util.List<VillageDoorInfo> doorList;

    /**
     *
     */
    public EntityAIMoveThroughVillage(EntityCreature theEntityIn,
                                      double movementSpeedIn,
                                      boolean isNocturnalIn) {
        
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
    private VillageDoorInfo findNearestDoor(Village villageIn) {
        return null;
    }

    /**
     *
     */
    private boolean doesDoorListContain(VillageDoorInfo doorInfoIn) {
        return true;
    }

    /**
     *
     */
    private void resizeDoorList() {
        return;
    }

}