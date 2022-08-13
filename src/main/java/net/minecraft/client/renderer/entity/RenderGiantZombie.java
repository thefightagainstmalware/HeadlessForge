package net.minecraft.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.monster.EntityGiantZombie;

/**
 *
 */
public class RenderGiantZombie extends RenderLiving<EntityGiantZombie> {

    /**
     *
     */
    private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");

    /**
     * Scale of the model to use
     */
    private float scale;

    /**
     *
     */
    public RenderGiantZombie(RenderManager renderManagerIn,
                             ModelBase modelBaseIn,
                             float shadowSizeIn,
                             float scaleIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
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
    protected void preRenderCallback(EntityGiantZombie entitylivingbaseIn,
                                     float partialTickTime) {
        return;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGiantZombie entity) {
        return null;
    }

}