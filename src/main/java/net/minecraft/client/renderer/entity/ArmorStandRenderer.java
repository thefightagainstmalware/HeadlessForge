package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelArmorStand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityArmorStand;

/**
 *
 */
public class ArmorStandRenderer extends RendererLivingEntity<EntityArmorStand> {

    /**
     * A constant instance of the armor stand texture, wrapped inside a ResourceLocation wrapper.
     */
    public static final ResourceLocation TEXTURE_ARMOR_STAND = new ResourceLocation("textures/entity/armorstand/wood.png");

    /**
     *
     */
    public ArmorStandRenderer(RenderManager p_i46195_1_) {
        super(p_i46195_1_, new ModelArmorStand(), 0.5F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityArmorStand entity) {
        return null;
    }

    /**
     *
     */
    @Override
    public ModelArmorStand getMainModel() {
        return null;
    }

    /**
     *
     */
    @Override
    protected void rotateCorpse(EntityArmorStand bat,
                                float p_77043_2_,
                                float p_77043_3_,
                                float partialTicks) {
        return;
    }

    /**
     *
     */
    @Override
    protected boolean canRenderName(EntityArmorStand entity) {
        return true;
    }

}