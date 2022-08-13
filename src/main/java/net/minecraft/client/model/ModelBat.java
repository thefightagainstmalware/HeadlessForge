package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;

/**
 *
 */
public class ModelBat extends ModelBase {

    /**
     *
     */
    private ModelRenderer batHead;

    /**
     * The body box of the bat model.
     */
    private ModelRenderer batBody;

    /**
     * The inner right wing box of the bat model.
     */
    private ModelRenderer batRightWing;

    /**
     * The inner left wing box of the bat model.
     */
    private ModelRenderer batLeftWing;

    /**
     * The outer right wing box of the bat model.
     */
    private ModelRenderer batOuterRightWing;

    /**
     * The outer left wing box of the bat model.
     */
    private ModelRenderer batOuterLeftWing;

    /**
     *
     */
    public ModelBat() {
        
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

}