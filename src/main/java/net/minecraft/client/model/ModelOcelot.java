package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelOcelot extends ModelBase {

    /**
     * The back left leg model for the Ocelot.
     */
    ModelRenderer ocelotBackLeftLeg;

    /**
     * The back right leg model for the Ocelot.
     */
    ModelRenderer ocelotBackRightLeg;

    /**
     * The front left leg model for the Ocelot.
     */
    ModelRenderer ocelotFrontLeftLeg;

    /**
     * The front right leg model for the Ocelot.
     */
    ModelRenderer ocelotFrontRightLeg;

    /**
     * The tail model for the Ocelot.
     */
    ModelRenderer ocelotTail;

    /**
     * The second part of tail model for the Ocelot.
     */
    ModelRenderer ocelotTail2;

    /**
     * The head model for the Ocelot.
     */
    ModelRenderer ocelotHead;

    /**
     * The body model for the Ocelot.
     */
    ModelRenderer ocelotBody;

    /**
     *
     */
    int field_78163_i;

    /**
     *
     */
    public ModelOcelot() {
        
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

}