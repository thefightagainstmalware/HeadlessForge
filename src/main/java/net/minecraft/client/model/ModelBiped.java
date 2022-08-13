package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;

/**
 *
 */
public class ModelBiped extends ModelBase {

    /**
     *
     */
    public ModelRenderer bipedHead;

    /**
     * The Biped's Headwear. Used for the outer layer of player skins.
     */
    public ModelRenderer bipedHeadwear;

    /**
     *
     */
    public ModelRenderer bipedBody;

    /**
     * The Biped's Right Arm
     */
    public ModelRenderer bipedRightArm;

    /**
     * The Biped's Left Arm
     */
    public ModelRenderer bipedLeftArm;

    /**
     * The Biped's Right Leg
     */
    public ModelRenderer bipedRightLeg;

    /**
     * The Biped's Left Leg
     */
    public ModelRenderer bipedLeftLeg;

    /**
     * Records whether the model should be rendered holding an item in the left hand, and if that item is a block.
     */
    public int heldItemLeft;

    /**
     * Records whether the model should be rendered holding an item in the right hand, and if that item is a block.
     */
    public int heldItemRight;

    /**
     *
     */
    public boolean isSneak;

    /**
     * Records whether the model should be rendered aiming a bow.
     */
    public boolean aimedBow;

    /**
     *
     */
    public ModelBiped() {
        
    }

    /**
     *
     */
    public ModelBiped(float modelSize) {
        
    }

    /**
     *
     */
    public ModelBiped(float modelSize,
                      float p_i1149_2_,
                      int textureWidthIn,
                      int textureHeightIn) {
        
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
    @Override
    public void setModelAttributes(ModelBase model) {
        return;
    }

    /**
     *
     */
    public void setInvisible(boolean invisible) {
        return;
    }

    /**
     *
     */
    public void postRenderArm(float scale) {
        return;
    }

}