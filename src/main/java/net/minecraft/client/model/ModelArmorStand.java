package net.minecraft.client.model;

import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public class ModelArmorStand extends ModelArmorStandArmor {

    /**
     *
     */
    public ModelRenderer standRightSide;

    /**
     *
     */
    public ModelRenderer standLeftSide;

    /**
     *
     */
    public ModelRenderer standWaist;

    /**
     *
     */
    public ModelRenderer standBase;

    /**
     *
     */
    public ModelArmorStand() {
        
    }

    /**
     *
     */
    public ModelArmorStand(float p_i46306_1_) {
        
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
    @Override
    public void postRenderArm(float scale) {
        return;
    }

}