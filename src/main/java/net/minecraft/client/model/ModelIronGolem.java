package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelIronGolem extends ModelBase {

    /**
     * The head model for the iron golem.
     */
    public ModelRenderer ironGolemHead;

    /**
     * The body model for the iron golem.
     */
    public ModelRenderer ironGolemBody;

    /**
     * The right arm model for the iron golem.
     */
    public ModelRenderer ironGolemRightArm;

    /**
     * The left arm model for the iron golem.
     */
    public ModelRenderer ironGolemLeftArm;

    /**
     * The left leg model for the Iron Golem.
     */
    public ModelRenderer ironGolemLeftLeg;

    /**
     * The right leg model for the Iron Golem.
     */
    public ModelRenderer ironGolemRightLeg;

    /**
     *
     */
    public ModelIronGolem() {
        
    }

    /**
     *
     */
    public ModelIronGolem(float p_i1161_1_) {
        
    }

    /**
     *
     */
    public ModelIronGolem(float p_i46362_1_,
                          float p_i46362_2_) {
        
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

    /**
     *
     */
    private float func_78172_a(float p_78172_1_,
                               float p_78172_2_) {
        return 0;
    }

}