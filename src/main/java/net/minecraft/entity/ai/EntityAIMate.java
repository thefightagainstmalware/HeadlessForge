package net.minecraft.entity.ai;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.entity.passive.EntityAnimal;

/**
 *
 */
public class EntityAIMate extends EntityAIBase {

    /**
     *
     */
    private EntityAnimal theAnimal;

    /**
     *
     */
    World theWorld;

    /**
     *
     */
    private EntityAnimal targetMate;

    /**
     * Delay preventing a baby from spawning immediately when two mate-able animals find each other.
     */
    int spawnBabyDelay;

    /**
     * The speed the creature moves at during mating behavior.
     */
    double moveSpeed;

    /**
     *
     */
    public EntityAIMate(EntityAnimal animal,
                        double speedIn) {
        
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
     * Loops through nearby animals and finds another animal of the same type that can be mated with. Returns the first
     * valid mate found.
     */
    private EntityAnimal getNearbyMate() {
        return null;
    }

    /**
     * Spawns a baby animal of the same type.
     */
    private void spawnBaby() {
        return;
    }

}