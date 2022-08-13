package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ModelSlime extends ModelBase {

    /**
     * The slime's bodies, both the inside box and the outside box
     */
    ModelRenderer slimeBodies;

    /**
     * The slime's right eye
     */
    ModelRenderer slimeRightEye;

    /**
     * The slime's left eye
     */
    ModelRenderer slimeLeftEye;

    /**
     * The slime's mouth
     */
    ModelRenderer slimeMouth;

    /**
     *
     */
    public ModelSlime(int p_i1157_1_) {
        
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