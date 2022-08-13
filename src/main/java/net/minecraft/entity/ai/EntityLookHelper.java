package net.minecraft.entity.ai;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;

/**
 *
 */
public class EntityLookHelper extends Object {

    /**
     *
     */
    private EntityLiving entity;

    /**
     * The amount of change that is made each update for an entity facing a direction.
     */
    private float deltaLookYaw;

    /**
     * The amount of change that is made each update for an entity facing a direction.
     */
    private float deltaLookPitch;

    /**
     * Whether or not the entity is trying to look at something.
     */
    private boolean isLooking;

    /**
     *
     */
    private double posX;

    /**
     *
     */
    private double posY;

    /**
     *
     */
    private double posZ;

    /**
     *
     */
    public EntityLookHelper(EntityLiving entitylivingIn) {
        
    }

    /**
     * Sets position to look at using entity
     */
    public void setLookPositionWithEntity(Entity entityIn,
                                          float deltaYaw,
                                          float deltaPitch) {
        return;
    }

    /**
     * Sets position to look at
     */
    public void setLookPosition(double x,
                                double y,
                                double z,
                                float deltaYaw,
                                float deltaPitch) {
        return;
    }

    /**
     * Updates look
     */
    public void onUpdateLook() {
        return;
    }

    /**
     *
     */
    private float updateRotation(float p_75652_1_,
                                 float p_75652_2_,
                                 float p_75652_3_) {
        return 0;
    }

    /**
     *
     */
    public boolean getIsLooking() {
        return true;
    }

    /**
     *
     */
    public double getLookPosX() {
        return 0;
    }

    /**
     *
     */
    public double getLookPosY() {
        return 0;
    }

    /**
     *
     */
    public double getLookPosZ() {
        return 0;
    }

}