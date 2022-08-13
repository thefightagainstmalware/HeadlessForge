package net.minecraft.entity;

import net.minecraft.util.MathHelper;

/**
 *
 */
public class EntityBodyHelper extends Object {

    /**
     * Instance of EntityLiving.
     */
    private EntityLivingBase theLiving;

    /**
     * Used to progressively ajust the rotation of the body to the rotation of the head
     */
    private int rotationTickCounter;

    /**
     *
     */
    private float prevRenderYawHead;

    /**
     *
     */
    public EntityBodyHelper(EntityLivingBase p_i1611_1_) {
        
    }

    /**
     * Update the Head and Body rendenring angles
     */
    public void updateRenderAngles() {
        return;
    }

    /**
     * Return the new angle2 such that the difference between angle1 and angle2 is lower than angleMax. Args : angle1,
     * angle2, angleMax
     */
    private float computeAngleWithBound(float p_75665_1_,
                                        float p_75665_2_,
                                        float p_75665_3_) {
        return 0;
    }

}