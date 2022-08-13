package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntityPortalFX extends EntityFX {

    /**
     *
     */
    private float portalParticleScale;

    /**
     *
     */
    private double portalPosX;

    /**
     *
     */
    private double portalPosY;

    /**
     *
     */
    private double portalPosZ;

    /**
     *
     */
    protected EntityPortalFX(World worldIn,
                             double xCoordIn,
                             double yCoordIn,
                             double zCoordIn,
                             double xSpeedIn,
                             double ySpeedIn,
                             double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
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
     *
     */
    @Override
    public int getBrightnessForRender(float partialTicks) {
        return 0;
    }

    /**
     * Gets how bright this entity is.
     */
    @Override
    public float getBrightness(float partialTicks) {
        return 0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

}