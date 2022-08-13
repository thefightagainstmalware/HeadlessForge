package net.minecraft.client.particle;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntityHeartFX extends EntityFX {

    /**
     *
     */
    float particleScaleOverTime;

    /**
     *
     */
    protected EntityHeartFX(World worldIn,
                            double p_i1211_2_,
                            double p_i1211_4_,
                            double p_i1211_6_,
                            double p_i1211_8_,
                            double p_i1211_10_,
                            double p_i1211_12_) {
        super(worldIn, p_i1211_2_, p_i1211_4_, p_i1211_6_, p_i1211_8_, p_i1211_10_, p_i1211_12_);
    }

    /**
     *
     */
    protected EntityHeartFX(World worldIn,
                            double xCoordIn,
                            double yCoordIn,
                            double zCoordIn,
                            double p_i46354_8_,
                            double p_i46354_10_,
                            double p_i46354_12_,
                            float scale) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46354_8_, p_i46354_10_, p_i46354_12_);
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