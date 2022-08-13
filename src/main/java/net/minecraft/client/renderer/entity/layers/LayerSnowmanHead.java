package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class LayerSnowmanHead implements LayerRenderer<EntitySnowman>
{
    private final RenderSnowMan snowManRenderer;

    public LayerSnowmanHead(RenderSnowMan snowManRendererIn)
    {
        this.snowManRenderer = snowManRendererIn;
    }

    public void doRenderLayer(EntitySnowman entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale)
    {

    }

    public boolean shouldCombineTextures()
    {
        return true;
    }
}
