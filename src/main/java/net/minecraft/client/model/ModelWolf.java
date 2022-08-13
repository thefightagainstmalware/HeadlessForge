package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelWolf extends ModelBase {

    /**
     * main box for the wolf head
     */
    public ModelRenderer wolfHeadMain;

    /**
     * The wolf's body
     */
    public ModelRenderer wolfBody;

    /**
     * Wolf'se first leg
     */
    public ModelRenderer wolfLeg1;

    /**
     * Wolf's second leg
     */
    public ModelRenderer wolfLeg2;

    /**
     * Wolf's third leg
     */
    public ModelRenderer wolfLeg3;

    /**
     * Wolf's fourth leg
     */
    public ModelRenderer wolfLeg4;

    /**
     * The wolf's tail
     */
    ModelRenderer wolfTail;

    /**
     * The wolf's mane
     */
    ModelRenderer wolfMane;

    /**
     *
     */
    public ModelWolf() {
        
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
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn,
                                    float p_78086_2_,
                                    float p_78086_3_,
                                    float partialTickTime) {
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