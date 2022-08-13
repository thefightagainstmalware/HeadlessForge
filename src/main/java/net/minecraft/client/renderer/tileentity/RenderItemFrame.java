package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.util.ResourceLocation;

public class RenderItemFrame extends Render<EntityItemFrame>
{
    private static final ResourceLocation mapBackgroundTextures = new ResourceLocation("textures/map/map_background.png");
    private final Minecraft mc = Minecraft.func_71410_x();
    private final ModelResourceLocation itemFrameModel = new ModelResourceLocation("item_frame", "normal");
    private final ModelResourceLocation mapModel = new ModelResourceLocation("item_frame", "map");
    private RenderItem itemRenderer;

    public RenderItemFrame(RenderManager renderManagerIn, RenderItem itemRendererIn)
    {
        super(renderManagerIn);
        this.itemRenderer = itemRendererIn;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(EntityItemFrame entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityItemFrame entity)
    {
        return null;
    }

    private void renderItem(EntityItemFrame itemFrame)
    {

    }

    protected void renderName(EntityItemFrame entity, double x, double y, double z)
    {

    }
}
