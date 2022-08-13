package net.minecraft.client.renderer.entity.layers;

import java.util.Random;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.boss.EntityDragon;

/**
 *
 */
public class LayerEnderDragonDeath extends Object implements LayerRenderer<EntityDragon> {

    /**
     *
     */
    public LayerEnderDragonDeath() {
        
    }

    /**
     *
     */
    public void doRenderLayer(EntityDragon entitylivingbaseIn,
                              float p_177141_2_,
                              float p_177141_3_,
                              float partialTicks,
                              float p_177141_5_,
                              float p_177141_6_,
                              float p_177141_7_,
                              float scale) {
        return;
    }

    /**
     *
     */
    public boolean shouldCombineTextures() {
        return true;
    }

}