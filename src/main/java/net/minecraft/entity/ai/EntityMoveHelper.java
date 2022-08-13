package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

/**
 *
 */
public class EntityMoveHelper extends Object {

    /**
     * The EntityLiving that is being moved
     */
    protected EntityLiving entity;

    /**
     *
     */
    protected double posX;

    /**
     *
     */
    protected double posY;

    /**
     *
     */
    protected double posZ;

    /**
     * The speed at which the entity should move
     */
    protected double speed;

    /**
     *
     */
    protected boolean update;

    /**
     *
     */
    public EntityMoveHelper(EntityLiving entitylivingIn) {
        
    }

    /**
     *
     */
    public boolean isUpdating() {
        return true;
    }

    /**
     *
     */
    public double getSpeed() {
        return 0;
    }

    /**
     * Sets the speed and location to move to
     */
    public void setMoveTo(double x,
                          double y,
                          double z,
                          double speedIn) {
        return;
    }

    /**
     *
     */
    public void onUpdateMoveHelper() {
        return;
    }

    /**
     * Limits the given angle to a upper and lower limit.
     */
    protected float limitAngle(float p_75639_1_,
                               float p_75639_2_,
                               float p_75639_3_) {
        return 0;
    }

    /**
     *
     */
    public double getX() {
        return 0;
    }

    /**
     *
     */
    public double getY() {
        return 0;
    }

    /**
     *
     */
    public double getZ() {
        return 0;
    }

}