package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ModelChest extends ModelBase {

    /**
     * The chest lid in the chest's model.
     */
    public ModelRenderer chestLid;

    /**
     * The model of the bottom of the chest.
     */
    public ModelRenderer chestBelow;

    /**
     * The chest's knob in the chest model.
     */
    public ModelRenderer chestKnob;

    /**
     *
     */
    public ModelChest() {
        
    }

    /**
     * This method renders out all parts of the chest model.
     */
    public void renderAll() {
        return;
    }

}