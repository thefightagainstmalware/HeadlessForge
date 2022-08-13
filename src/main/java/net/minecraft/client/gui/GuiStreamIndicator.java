package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class GuiStreamIndicator
{
    private static final ResourceLocation locationStreamIndicator = new ResourceLocation("textures/gui/stream_indicator.png");
    private final Minecraft mc;
    private float field_152443_c = 1.0F;
    private int field_152444_d = 1;

    public GuiStreamIndicator(Minecraft mcIn)
    {
        this.mc = mcIn;
    }

    public void render(int p_152437_1_, int p_152437_2_)
    {}

    private void render(int p_152436_1_, int p_152436_2_, int p_152436_3_, int p_152436_4_)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.65F + 0.35000002F * this.field_152443_c);
        this.mc.func_110434_K().func_110577_a(locationStreamIndicator);
        float f = 150.0F;
        float f1 = 0.0F;
        float f2 = (float)p_152436_3_ * 0.015625F;
        float f3 = 1.0F;
        float f4 = (float)(p_152436_3_ + 16) * 0.015625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(p_152436_1_ - 16 - p_152436_4_), (double)(p_152436_2_ + 16), (double)f).tex((double)f1, (double)f4).endVertex();
        worldrenderer.pos((double)(p_152436_1_ - p_152436_4_), (double)(p_152436_2_ + 16), (double)f).tex((double)f3, (double)f4).endVertex();
        worldrenderer.pos((double)(p_152436_1_ - p_152436_4_), (double)(p_152436_2_ + 0), (double)f).tex((double)f3, (double)f2).endVertex();
        worldrenderer.pos((double)(p_152436_1_ - 16 - p_152436_4_), (double)(p_152436_2_ + 0), (double)f).tex((double)f1, (double)f2).endVertex();
        tessellator.draw();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private int func_152440_b()
    {
        return 0;
    }

    private int func_152438_c()
    {
        return 32;
    }

    public void func_152439_a()
    {
    }
}
