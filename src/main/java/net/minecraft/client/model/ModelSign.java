package net.minecraft.client.model;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ModelSign extends ModelBase {

    /**
     * The board on a sign that has the writing on it.
     */
    public ModelRenderer signBoard;

    /**
     * The stick a sign stands on.
     */
    public ModelRenderer signStick;

    /**
     *
     */
    public ModelSign() {
        
    }

    /**
     * Renders the sign model through TileEntitySignRenderer
     */
    public void renderSign() {
        return;
    }

}