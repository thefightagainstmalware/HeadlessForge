package net.minecraft.entity.ai;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.passive.EntityVillager;

/**
 *
 */
public class EntityAIHarvestFarmland extends EntityAIMoveToBlock {

    /**
     * Villager that is harvesting
     */
    private final EntityVillager theVillager;

    /**
     *
     */
    private boolean hasFarmItem;

    /**
     *
     */
    private boolean field_179503_e;

    /**
     *
     */
    private int field_179501_f;

    /**
     *
     */
    public EntityAIHarvestFarmland(EntityVillager theVillagerIn,
                                   double speedIn) {
        super(theVillagerIn, speedIn, 16);
        this.theVillager = theVillagerIn;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
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
     * Return true to set given position as destination
     */
    protected boolean shouldMoveTo(World worldIn,
                                   BlockPos pos) {
        return true;
    }

}