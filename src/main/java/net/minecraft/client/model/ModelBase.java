package net.minecraft.client.model;

import java.util.List;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.google.common.collect.Lists;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public abstract class ModelBase extends Object {

    /**
     *
     */
    public float swingProgress;

    /**
     *
     */
    public boolean isRiding;

    /**
     *
     */
    public boolean isChild;

    /**
     *
     */
    public java.util.List<ModelRenderer> boxList;

    /**
     *
     */
    private java.util.Map<java.lang.String,TextureOffset> modelTextureMap;

    /**
     *
     */
    public int textureWidth;

    /**
     *
     */
    public int textureHeight;

    /**
     *
     */
    public ModelBase() {
        
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
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
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn,
                                    float p_78086_2_,
                                    float p_78086_3_,
                                    float partialTickTime) {
        return;
    }

    /**
     *
     */
    public ModelRenderer getRandomModelBox(java.util.Random rand) {
        return null;
    }

    /**
     *
     */
    protected void setTextureOffset(String partName,
                                    int x,
                                    int y) {
        return;
    }

    /**
     *
     */
    public TextureOffset getTextureOffset(String partName) {
        return null;
    }

    /**
     * Copies the angles from one object to another. This is used when objects should stay aligned with each other, like
     * the hair over a players head.
     */
    public static void copyModelAngles(ModelRenderer source,
                                       ModelRenderer dest) {
        return;
    }

    /**
     *
     */
    public void setModelAttributes(ModelBase model) {
        return;
    }

}