package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelRabbit extends ModelBase {

    /**
     * The Rabbit's Left Foot
     */
    ModelRenderer rabbitLeftFoot;

    /**
     * The Rabbit's Right Foot
     */
    ModelRenderer rabbitRightFoot;

    /**
     * The Rabbit's Left Thigh
     */
    ModelRenderer rabbitLeftThigh;

    /**
     * The Rabbit's Right Thigh
     */
    ModelRenderer rabbitRightThigh;

    /**
     * The Rabbit's Body
     */
    ModelRenderer rabbitBody;

    /**
     * The Rabbit's Left Arm
     */
    ModelRenderer rabbitLeftArm;

    /**
     * The Rabbit's Right Arm
     */
    ModelRenderer rabbitRightArm;

    /**
     * The Rabbit's Head
     */
    ModelRenderer rabbitHead;

    /**
     * The Rabbit's Right Ear
     */
    ModelRenderer rabbitRightEar;

    /**
     * The Rabbit's Left Ear
     */
    ModelRenderer rabbitLeftEar;

    /**
     * The Rabbit's Tail
     */
    ModelRenderer rabbitTail;

    /**
     * The Rabbit's Nose
     */
    ModelRenderer rabbitNose;

    /**
     *
     */
    private float field_178701_m;

    /**
     *
     */
    private float field_178699_n;

    /**
     *
     */
    public ModelRabbit() {
        
    }

    /**
     *
     */
    private void setRotationOffset(ModelRenderer p_178691_1_,
                                   float p_178691_2_,
                                   float p_178691_3_,
                                   float p_178691_4_) {
        return;
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