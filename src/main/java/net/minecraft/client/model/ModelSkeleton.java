package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelSkeleton extends ModelZombie {

    /**
     *
     */
    public ModelSkeleton() {
        
    }

    /**
     *
     */
    public ModelSkeleton(float p_i46303_1_,
                         boolean p_i46303_2_) {
        
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