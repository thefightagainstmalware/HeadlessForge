package net.minecraft.realms;

import net.minecraft.util.MathHelper;

/**
 *
 */
public class RealmsSliderButton extends RealmsButton {

    /**
     *
     */
    public float value;

    /**
     *
     */
    public boolean sliding;

    /**
     *
     */
    private final float minValue = 0.0F;

    /**
     *
     */
    private final float maxValue = 1.0F;

    /**
     *
     */
    private int steps;

    /**
     *
     */
    public RealmsSliderButton(int p_i1056_1_,
                              int p_i1056_2_,
                              int p_i1056_3_,
                              int p_i1056_4_,
                              int p_i1056_5_,
                              int p_i1056_6_) {
        super(p_i1056_1_, p_i1056_2_, p_i1056_3_, "");
    }

    /**
     *
     */
    public RealmsSliderButton(int p_i1057_1_,
                              int p_i1057_2_,
                              int p_i1057_3_,
                              int p_i1057_4_,
                              int p_i1057_5_,
                              int p_i1057_6_,
                              float p_i1057_7_,
                              float p_i1057_8_) {
        super(p_i1057_1_, p_i1057_2_, p_i1057_3_, "");
    }

    /**
     *
     */
    public String getMessage() {
        return null;
    }

    /**
     *
     */
    public float toPct(float p_toPct_1_) {
        return 0;
    }

    /**
     *
     */
    public float toValue(float p_toValue_1_) {
        return 0;
    }

    /**
     *
     */
    public float clamp(float p_clamp_1_) {
        return 0;
    }

    /**
     *
     */
    protected float clampSteps(float p_clampSteps_1_) {
        return 0;
    }

    /**
     *
     */
    @Override
    public int getYImage(boolean p_getYImage_1_) {
        return 0;
    }

    /**
     *
     */
    @Override
    public void renderBg(int p_renderBg_1_,
                         int p_renderBg_2_) {
        return;
    }

    /**
     *
     */
    @Override
    public void clicked(int p_clicked_1_,
                        int p_clicked_2_) {
        return;
    }

    /**
     *
     */
    public void clicked(float p_clicked_1_) {
        return;
    }

    /**
     *
     */
    @Override
    public void released(int p_released_1_,
                         int p_released_2_) {
        return;
    }

}