package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 *
 */
public class Barrier extends EntityFX {

    /**
     *
     */
    protected Barrier(World worldIn,
                      double p_i46286_2_,
                      double p_i46286_4_,
                      double p_i46286_6_,
                      Item p_i46286_8_) {
        super(worldIn, p_i46286_2_, p_i46286_4_, p_i46286_6_, 0.0D, 0.0D, 0.0D);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.particleRed = 1.0F;
        this.particleGreen = 1.0F;
        this.particleBlue = 1.0F;
        this.particleScale = 1.0F;
        this.particleMaxAge = (int) (Math.random() * 10.0D) + 40;
        this.noClip = true;
    }
    public static class Factory extends Object implements IParticleFactory {

        /**
         *
         */
    public Factory() {

        }

        /**
         *
         */
        public EntityFX getEntityFX(int particleID,
        World worldIn,
        double xCoordIn,
        double yCoordIn,
        double zCoordIn,
        double xSpeedIn,
        double ySpeedIn,
        double zSpeedIn,
        int... p_178902_15_) {
            return null;
        }

    }
    /**
     *
     */
    @Override
    public int getFXLayer() {
        return 0;
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