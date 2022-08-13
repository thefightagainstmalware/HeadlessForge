package net.minecraft.client.particle;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntitySmokeFX extends EntityFX {

    /**
     *
     */
    float smokeParticleScale;

    /**
     *
     */
    private EntitySmokeFX(World worldIn,
                          double xCoordIn,
                          double yCoordIn,
                          double zCoordIn,
                          double p_i46347_8_,
                          double p_i46347_10_,
                          double p_i46347_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46347_8_, p_i46347_10_, p_i46347_12_);
    }

    /**
     *
     */
    protected EntitySmokeFX(World worldIn,
                            double xCoordIn,
                            double yCoordIn,
                            double zCoordIn,
                            double p_i46348_8_,
                            double p_i46348_10_,
                            double p_i46348_12_,
                            float p_i46348_14_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46348_8_, p_i46348_10_, p_i46348_12_);
    }

    /**
     * Renders the particle
     */
    @Override
    public void renderParticle(WorldRenderer worldRendererIn,
                               Entity entityIn,
                               float partialTicks,
                               float p_180434_4_,
                               float p_180434_5_,
                               float p_180434_6_,
                               float p_180434_7_,
                               float p_180434_8_) {
        return;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

}