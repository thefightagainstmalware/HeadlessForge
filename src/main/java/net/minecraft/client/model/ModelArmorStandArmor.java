package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ModelArmorStandArmor extends ModelBiped {

    /**
     *
     */
    public ModelArmorStandArmor() {
        
    }

    /**
     *
     */
    public ModelArmorStandArmor(float modelSize) {
        
    }

    /**
     *
     */
    protected ModelArmorStandArmor(float modelSize,
                                   int textureWidthIn,
                                   int textureHeightIn) {
        
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