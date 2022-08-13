package net.minecraft.client.renderer.culling;

import net.minecraft.util.AxisAlignedBB;

/**
 *
 */
public class Frustum extends Object implements ICamera {

    /**
     *
     */
    private ClippingHelper clippingHelper;

    /**
     *
     */
    private double xPosition;

    /**
     *
     */
    private double yPosition;

    /**
     *
     */
    private double zPosition;

    /**
     *
     */
    public Frustum() {
        
    }

    /**
     *
     */
    public Frustum(ClippingHelper p_i46196_1_) {
        
    }

    /**
     *
     */
    public void setPosition(double p_78547_1_,
                            double p_78547_3_,
                            double p_78547_5_) {
        return;
    }

    /**
     * Calls the clipping helper. Returns true if the box is inside all 6 clipping planes, otherwise returns false.
     */
    public boolean isBoxInFrustum(double p_78548_1_,
                                  double p_78548_3_,
                                  double p_78548_5_,
                                  double p_78548_7_,
                                  double p_78548_9_,
                                  double p_78548_11_) {
        return true;
    }

    /**
     * Returns true if the bounding box is inside all 6 clipping planes, otherwise returns false.
     */
    public boolean isBoundingBoxInFrustum(AxisAlignedBB p_78546_1_) {
        return true;
    }

}