package net.minecraft.client.renderer.culling;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ClippingHelper extends Object {

    /**
     *
     */
    public float[][] frustum;

    /**
     *
     */
    public float[] projectionMatrix;

    /**
     *
     */
    public float[] modelviewMatrix;

    /**
     *
     */
    public float[] clippingMatrix;

    /**
     *
     */
    public ClippingHelper() {
        
    }

    /**
     *
     */
    private double dot(float[] p_178624_1_,
                       double p_178624_2_,
                       double p_178624_4_,
                       double p_178624_6_) {
        return 0;
    }

    /**
     * Returns true if the box is inside all 6 clipping planes, otherwise returns false.
     */
    public boolean isBoxInFrustum(double p_78553_1_,
                                  double p_78553_3_,
                                  double p_78553_5_,
                                  double p_78553_7_,
                                  double p_78553_9_,
                                  double p_78553_11_) {
        return true;
    }

}