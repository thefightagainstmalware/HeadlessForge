package net.minecraft.client.particle;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntityCrit2FX extends EntityFX {

    /**
     *
     */
    float field_174839_a;

    /**
     *
     */
    protected EntityCrit2FX(World worldIn,
                            double xCoordIn,
                            double yCoordIn,
                            double zCoordIn,
                            double p_i46284_8_,
                            double p_i46284_10_,
                            double p_i46284_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46284_8_, p_i46284_10_, p_i46284_12_);
    }

    /**
     *
     */
    protected EntityCrit2FX(World worldIn,
                            double xCoordIn,
                            double yCoordIn,
                            double zCoordIn,
                            double p_i46285_8_,
                            double p_i46285_10_,
                            double p_i46285_12_,
                            float p_i46285_14_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46285_8_, p_i46285_10_, p_i46285_12_);
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