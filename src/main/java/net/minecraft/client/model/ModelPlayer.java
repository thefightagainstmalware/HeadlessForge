package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ModelPlayer extends ModelBiped {

    /**
     *
     */
    public ModelRenderer bipedLeftArmwear;

    /**
     *
     */
    public ModelRenderer bipedRightArmwear;

    /**
     *
     */
    public ModelRenderer bipedLeftLegwear;

    /**
     *
     */
    public ModelRenderer bipedRightLegwear;

    /**
     *
     */
    public ModelRenderer bipedBodyWear;

    /**
     *
     */
    private ModelRenderer bipedCape;

    /**
     *
     */
    private ModelRenderer bipedDeadmau5Head;

    /**
     *
     */
    private boolean smallArms;

    /**
     *
     */
    public ModelPlayer(float p_i46304_1_,
                       boolean p_i46304_2_) {
        
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(Entity entityIn,
                       float p_78088_2_,
                       float p_78088_3_,
                       float p_78088_4_,
                       float p_78088_5_,
                       float p_78088_6_,
                       float scale) {
        return;
    }

    /**
     *
     */
    public void renderDeadmau5Head(float p_178727_1_) {
        return;
    }

    /**
     *
     */
    public void renderCape(float p_178728_1_) {
        return;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    @Override
    public void setRotationAngles(float p_78087_1_,
                                  float p_78087_2_,
                                  float p_78087_3_,
                                  float p_78087_4_,
                                  float p_78087_5_,
                                  float p_78087_6_,
                                  Entity entityIn) {
        return;
    }

    /**
     *
     */
    public void renderRightArm() {
        return;
    }

    /**
     *
     */
    public void renderLeftArm() {
        return;
    }

    /**
     *
     */
    @Override
    public void setInvisible(boolean invisible) {
        return;
    }

    /**
     *
     */
    @Override
    public void postRenderArm(float scale) {
        return;
    }

}