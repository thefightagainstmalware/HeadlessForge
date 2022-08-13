package net.minecraft.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.client.model.ModelMagmaCube;

/**
 *
 */
public class RenderMagmaCube extends RenderLiving<EntityMagmaCube> {

    /**
     *
     */
    private static final ResourceLocation magmaCubeTextures = null;

    /**
     *
     */
    public RenderMagmaCube(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelMagmaCube(), 0.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMagmaCube entity) {
        return null;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    @Override
    protected void preRenderCallback(EntityMagmaCube entitylivingbaseIn,
                                     float partialTickTime) {
        return;
    }

}