package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelMagmaCube extends ModelBase {

    /**
     *
     */
    ModelRenderer[] segments;

    /**
     *
     */
    ModelRenderer core;

    /**
     *
     */
    public ModelMagmaCube() {
        
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

}