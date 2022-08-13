package net.minecraft.client.particle;

import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntityCloudFX extends EntityFX {

    /**
     *
     */
    float field_70569_a;

    /**
     *
     */
    protected EntityCloudFX(World worldIn,
                            double xCoordIn,
                            double yCoordIn,
                            double zCoordIn,
                            double p_i1221_8_,
                            double p_i1221_10_,
                            double p_i1221_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i1221_8_, p_i1221_10_, p_i1221_12_);
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