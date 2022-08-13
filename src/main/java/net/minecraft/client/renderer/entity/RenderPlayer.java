package net.minecraft.client.renderer.entity;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelPlayer;

/**
 *
 */
public class RenderPlayer extends RendererLivingEntity<AbstractClientPlayer> {

    /**
     * this field is used to indicate the 3-pixel wide arms
     */
    private boolean smallArms;

    /**
     *
     */
    public RenderPlayer(RenderManager renderManager) {
        super(renderManager, new ModelPlayer(0.0F, false), 0.5F);
    }

    /**
     *
     */
    public RenderPlayer(RenderManager renderManager,
                        boolean useSmallArms) {
        super(renderManager, new ModelPlayer(0.0F, useSmallArms), 0.5F);
        this.smallArms = useSmallArms;
    }

    /**
     *
     */
    @Override
    public ModelPlayer getMainModel() {
        return null;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<t entity="" extends="">) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe</t>
     */
    @Override
    public void doRender(AbstractClientPlayer entity,
                         double x,
                         double y,
                         double z,
                         float entityYaw,
                         float partialTicks) {
        return;
    }

    /**
     *
     */
    private void setModelVisibilities(AbstractClientPlayer clientPlayer) {
        return;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(AbstractClientPlayer entity) {
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
    protected void preRenderCallback(AbstractClientPlayer entitylivingbaseIn,
                                     float partialTickTime) {
        return;
    }

    /**
     *
     */
    @Override
    protected void renderOffsetLivingLabel(AbstractClientPlayer entityIn,
                                           double x,
                                           double y,
                                           double z,
                                           String str,
                                           float p_177069_9_,
                                           double p_177069_10_) {
        return;
    }

    /**
     *
     */
    public void renderRightArm(AbstractClientPlayer clientPlayer) {
        return;
    }

    /**
     *
     */
    public void renderLeftArm(AbstractClientPlayer clientPlayer) {
        return;
    }

    /**
     * Sets a simple glTranslate on a LivingEntity.
     */
    @Override
    protected void renderLivingAt(AbstractClientPlayer entityLivingBaseIn,
                                  double x,
                                  double y,
                                  double z) {
        return;
    }

    /**
     *
     */
    @Override
    protected void rotateCorpse(AbstractClientPlayer bat,
                                float p_77043_2_,
                                float p_77043_3_,
                                float partialTicks) {
        return;
    }

}