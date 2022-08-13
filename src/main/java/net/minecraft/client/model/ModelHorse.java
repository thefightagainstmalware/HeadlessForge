package net.minecraft.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ModelHorse extends ModelBase {

    /**
     *
     */
    private ModelRenderer head;

    /**
     *
     */
    private ModelRenderer field_178711_b;

    /**
     *
     */
    private ModelRenderer field_178712_c;

    /**
     *
     */
    private ModelRenderer horseLeftEar;

    /**
     *
     */
    private ModelRenderer horseRightEar;

    /**
     * The left ear box for the mule model.
     */
    private ModelRenderer muleLeftEar;

    /**
     * The right ear box for the mule model.
     */
    private ModelRenderer muleRightEar;

    /**
     *
     */
    private ModelRenderer neck;

    /**
     * The box for the horse's ropes on its face.
     */
    private ModelRenderer horseFaceRopes;

    /**
     *
     */
    private ModelRenderer mane;

    /**
     *
     */
    private ModelRenderer body;

    /**
     *
     */
    private ModelRenderer tailBase;

    /**
     *
     */
    private ModelRenderer tailMiddle;

    /**
     *
     */
    private ModelRenderer tailTip;

    /**
     *
     */
    private ModelRenderer backLeftLeg;

    /**
     *
     */
    private ModelRenderer backLeftShin;

    /**
     *
     */
    private ModelRenderer backLeftHoof;

    /**
     *
     */
    private ModelRenderer backRightLeg;

    /**
     *
     */
    private ModelRenderer backRightShin;

    /**
     *
     */
    private ModelRenderer backRightHoof;

    /**
     *
     */
    private ModelRenderer frontLeftLeg;

    /**
     *
     */
    private ModelRenderer frontLeftShin;

    /**
     *
     */
    private ModelRenderer frontLeftHoof;

    /**
     *
     */
    private ModelRenderer frontRightLeg;

    /**
     *
     */
    private ModelRenderer frontRightShin;

    /**
     *
     */
    private ModelRenderer frontRightHoof;

    /**
     * The left chest box on the mule model.
     */
    private ModelRenderer muleLeftChest;

    /**
     * The right chest box on the mule model.
     */
    private ModelRenderer muleRightChest;

    /**
     *
     */
    private ModelRenderer horseSaddleBottom;

    /**
     *
     */
    private ModelRenderer horseSaddleFront;

    /**
     *
     */
    private ModelRenderer horseSaddleBack;

    /**
     *
     */
    private ModelRenderer horseLeftSaddleRope;

    /**
     *
     */
    private ModelRenderer horseLeftSaddleMetal;

    /**
     *
     */
    private ModelRenderer horseRightSaddleRope;

    /**
     *
     */
    private ModelRenderer horseRightSaddleMetal;

    /**
     * The left metal connected to the horse's face ropes.
     */
    private ModelRenderer horseLeftFaceMetal;

    /**
     * The right metal connected to the horse's face ropes.
     */
    private ModelRenderer horseRightFaceMetal;

    /**
     *
     */
    private ModelRenderer horseLeftRein;

    /**
     *
     */
    private ModelRenderer horseRightRein;

    /**
     *
     */
    public ModelHorse() {
        
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
     * Sets the rotations for a ModelRenderer in the ModelHorse class.
     */
    private void setBoxRotation(ModelRenderer p_110682_1_,
                                float p_110682_2_,
                                float p_110682_3_,
                                float p_110682_4_) {
        return;
    }

    /**
     * Fixes and offsets a rotation in the ModelHorse class.
     */
    private float updateHorseRotation(float p_110683_1_,
                                      float p_110683_2_,
                                      float p_110683_3_) {
        return 0;
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