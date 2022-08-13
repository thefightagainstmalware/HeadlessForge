package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ModelMinecart extends ModelBase {

    /**
     *
     */
    public ModelRenderer[] sideModels;

    /**
     *
     */
    public ModelMinecart() {
        
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