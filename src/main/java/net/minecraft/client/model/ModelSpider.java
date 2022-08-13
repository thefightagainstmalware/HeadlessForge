package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;

/**
 *
 */
public class ModelSpider extends ModelBase {

    /**
     * The spider's head box
     */
    public ModelRenderer spiderHead;

    /**
     * The spider's neck box
     */
    public ModelRenderer spiderNeck;

    /**
     * The spider's body box
     */
    public ModelRenderer spiderBody;

    /**
     * Spider's first leg
     */
    public ModelRenderer spiderLeg1;

    /**
     * Spider's second leg
     */
    public ModelRenderer spiderLeg2;

    /**
     * Spider's third leg
     */
    public ModelRenderer spiderLeg3;

    /**
     * Spider's fourth leg
     */
    public ModelRenderer spiderLeg4;

    /**
     * Spider's fifth leg
     */
    public ModelRenderer spiderLeg5;

    /**
     * Spider's sixth leg
     */
    public ModelRenderer spiderLeg6;

    /**
     * Spider's seventh leg
     */
    public ModelRenderer spiderLeg7;

    /**
     * Spider's eight leg
     */
    public ModelRenderer spiderLeg8;

    /**
     *
     */
    public ModelSpider() {
        
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