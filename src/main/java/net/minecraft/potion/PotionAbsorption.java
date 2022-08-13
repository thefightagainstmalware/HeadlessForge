package net.minecraft.potion;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class PotionAbsorption extends Potion {

    /**
     *
     */
    protected PotionAbsorption(int potionID,
                               ResourceLocation location,
                               boolean badEffect,
                               int potionColor) {
        super(potionID, location, badEffect, potionColor);
    }

    /**
     *
     */
    @Override
    public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn,
                                                    BaseAttributeMap p_111187_2_,
                                                    int amplifier) {
        return;
    }

    /**
     *
     */
    @Override
    public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn,
                                                 BaseAttributeMap p_111185_2_,
                                                 int amplifier) {
        return;
    }

}