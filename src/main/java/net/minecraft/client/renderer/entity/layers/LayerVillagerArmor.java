package net.minecraft.client.renderer.entity.layers;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.model.ModelZombieVillager;

/**
 *
 */
public class LayerVillagerArmor extends LayerBipedArmor {

    /**
     *
     */
    public LayerVillagerArmor(RendererLivingEntity<?> rendererIn) {
        super(rendererIn);
    }

    /**
     *
     */
    @Override
    protected void initArmor() {
        return;
    }

}