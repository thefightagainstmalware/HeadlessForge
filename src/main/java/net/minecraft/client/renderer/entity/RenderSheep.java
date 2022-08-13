package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;

/**
 *
 */
public class RenderSheep extends RenderLiving<EntitySheep> {

    /**
     *
     */
    private static final ResourceLocation shearedSheepTextures = new ResourceLocation("textures/entity/sheep/sheep_fur.png");

    /**
     *
     */
    public RenderSheep(RenderManager renderManagerIn,
                       ModelBase modelBaseIn,
                       float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntitySheep entity) {
        return null;
    }

}