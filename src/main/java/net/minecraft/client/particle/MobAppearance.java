package net.minecraft.client.particle;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class MobAppearance extends EntityFX {

    /**
     *
     */
    private EntityLivingBase entity;

    /**
     *
     */
    protected MobAppearance(World worldIn,
                            double xCoordIn,
                            double yCoordIn,
                            double zCoordIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn);
    }

    /**
     *
     */
    @Override
    public int getFXLayer() {
        return 0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
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

}