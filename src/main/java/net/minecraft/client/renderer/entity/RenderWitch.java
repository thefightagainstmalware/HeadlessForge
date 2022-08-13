package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelWitch;

/**
 *
 */
public class RenderWitch extends RenderLiving<EntityWitch> {

    /**
     *
     */
    private static final ResourceLocation witchTextures = new ResourceLocation("textures/entity/witch.png");

    /**
     *
     */
    public RenderWitch(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelWitch(1.0F), 0.5F);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<t entity="" extends="">) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe</t>
     */
    @Override
    public void doRender(EntityWitch entity,
                         double x,
                         double y,
                         double z,
                         float entityYaw,
                         float partialTicks) {
        return;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityWitch entity) {
        return null;
    }

    /**
     *
     */
    @Override
    public void transformHeldFull3DItemLayer() {
        return;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    @Override
    protected void preRenderCallback(EntityWitch entitylivingbaseIn,
                                     float partialTickTime) {
        return;
    }

}