package net.minecraft.entity;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;

import java.util.UUID;

/**
 *
 */
public abstract class EntityCreature extends EntityLiving {

    /**
     *
     */
    public static final java.util.UUID FLEEING_SPEED_MODIFIER_UUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");

    /**
     *
     */
    public static final AttributeModifier FLEEING_SPEED_MODIFIER = (new AttributeModifier(FLEEING_SPEED_MODIFIER_UUID, "Fleeing speed boost", 0.3D, 0)).setSaved(false);

    /**
     *
     */
    private BlockPos homePosition;

    /**
     * If -1 there is no maximum distance
     */
    private float maximumHomeDistance;

    /**
     *
     */
    private EntityAIBase aiBase;

    /**
     *
     */
    private boolean isMovementAITaskSet;

    /**
     *
     */
    public EntityCreature(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public float getBlockPathWeight(BlockPos pos) {
        return 0;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    /**
     * if the entity got a PathEntity it returns true, else false
     */
    public boolean hasPath() {
        return true;
    }

    /**
     *
     */
    public boolean isWithinHomeDistanceCurrentPosition() {
        return true;
    }

    /**
     *
     */
    public boolean isWithinHomeDistanceFromPosition(BlockPos pos) {
        return true;
    }

    /**
     * Sets home position and max distance for it
     */
    public void setHomePosAndDistance(BlockPos pos,
                                      int distance) {
        return;
    }

    /**
     *
     */
    public BlockPos getHomePosition() {
        return null;
    }

    /**
     *
     */
    public float getMaximumHomeDistance() {
        return 0;
    }

    /**
     *
     */
    public void detachHome() {
        return;
    }

    /**
     * Returns whether a home area is defined for this entity.
     */
    public boolean hasHome() {
        return true;
    }

    /**
     * Applies logic related to leashes, for example dragging the entity or breaking the leash.
     */
    @Override
    protected void updateLeashedState() {
        return;
    }

    /**
     *
     */
    protected void func_142017_o(float p_142017_1_) {
        return;
    }

}