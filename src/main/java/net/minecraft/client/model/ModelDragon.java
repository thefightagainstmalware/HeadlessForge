package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelDragon extends ModelBase {

    /**
     * The head Model renderer of the dragon
     */
    private ModelRenderer head;

    /**
     * The spine Model renderer of the dragon
     */
    private ModelRenderer spine;

    /**
     * The jaw Model renderer of the dragon
     */
    private ModelRenderer jaw;

    /**
     * The body Model renderer of the dragon
     */
    private ModelRenderer body;

    /**
     * The rear leg Model renderer of the dragon
     */
    private ModelRenderer rearLeg;

    /**
     * The front leg Model renderer of the dragon
     */
    private ModelRenderer frontLeg;

    /**
     * The rear leg tip Model renderer of the dragon
     */
    private ModelRenderer rearLegTip;

    /**
     * The front leg tip Model renderer of the dragon
     */
    private ModelRenderer frontLegTip;

    /**
     * The rear foot Model renderer of the dragon
     */
    private ModelRenderer rearFoot;

    /**
     * The front foot Model renderer of the dragon
     */
    private ModelRenderer frontFoot;

    /**
     * The wing Model renderer of the dragon
     */
    private ModelRenderer wing;

    /**
     * The wing tip Model renderer of the dragon
     */
    private ModelRenderer wingTip;

    /**
     *
     */
    private float partialTicks;

    /**
     *
     */
    public ModelDragon(float p_i46360_1_) {
        
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

    /**
     * Updates the rotations in the parameters for rotations greater than 180 degrees or less than -180 degrees. It adds
     * or subtracts 360 degrees, so that the appearance is the same, although the numbers are then simplified to range -
     * 180 to 180
     */
    private float updateRotations(double p_78214_1_) {
        return 0;
    }

}