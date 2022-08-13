package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.model.ModelBiped;

/**
 *
 */
public class LayerBipedArmor extends LayerArmorBase<ModelBiped> {

    /**
     *
     */
    public LayerBipedArmor(RendererLivingEntity<?> rendererIn) {
        super(rendererIn);
    }

    /**
     *
     */
    protected void initArmor() {
        return;
    }

    /**
     *
     */
    protected void func_177179_a(ModelBiped p_177179_1_,
                                 int p_177179_2_) {
        return;
    }

    /**
     *
     */
    protected void func_177194_a(ModelBiped p_177194_1_) {
        return;
    }

    /**
     * Hook to allow item-sensitive armor model. for LayerBipedArmor.
     */
    @Override
    protected ModelBiped getArmorModelHook(EntityLivingBase entity,
                                           ItemStack itemStack,
                                           int slot,
                                           ModelBiped model) {
        return null;
    }

}