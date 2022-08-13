package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;
import net.minecraft.util.Vec3;

/**
 *
 */
public class EntityAIFleeSun extends EntityAIBase {

    /**
     *
     */
    private EntityCreature theCreature;

    /**
     *
     */
    private double shelterX;

    /**
     *
     */
    private double shelterY;

    /**
     *
     */
    private double shelterZ;

    /**
     *
     */
    private double movementSpeed;

    /**
     *
     */
    private World theWorld;

    /**
     *
     */
    public EntityAIFleeSun(EntityCreature theCreatureIn,
                           double movementSpeedIn) {
        
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
     *
     */
    private Vec3 findPossibleShelter() {
        return null;
    }

}