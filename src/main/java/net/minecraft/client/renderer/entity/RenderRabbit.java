package net.minecraft.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.client.model.ModelBase;

/**
 *
 */
public class RenderRabbit extends RenderLiving<EntityRabbit> {

    /**
     *
     */
    private static final ResourceLocation BROWN = new ResourceLocation("textures/entity/rabbit/brown.png");

    /**
     *
     */
    private static final ResourceLocation WHITE = new ResourceLocation("textures/entity/rabbit/white.png");

    /**
     *
     */
    private static final ResourceLocation BLACK = new ResourceLocation("textures/entity/rabbit/black.png");

    /**
     *
     */
    private static final ResourceLocation GOLD = new ResourceLocation("textures/entity/rabbit/brown_gold.png");

    /**
     *
     */
    private static final ResourceLocation SALT = new ResourceLocation("textures/entity/rabbit/rabbit_salt.png");

    /**
     *
     */
    private static final ResourceLocation WHITE_SPLOTCHED = new ResourceLocation("textures/entity/rabbit/rabbit_w.png");

    /**
     *
     */
    private static final ResourceLocation TOAST = new ResourceLocation("textures/entity/rabbit/rabbit_toast.png");

    /**
     *
     */
    private static final ResourceLocation CAERBANNOG = new ResourceLocation("textures/entity/rabbit/caerbannog.png");

    /**
     *
     */
    public RenderRabbit(RenderManager renderManagerIn,
                        ModelBase modelBaseIn,
                        float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityRabbit entity) {
        return null;
    }

}