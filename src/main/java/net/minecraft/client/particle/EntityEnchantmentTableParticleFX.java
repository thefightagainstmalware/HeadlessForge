package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class EntityEnchantmentTableParticleFX extends EntityFX {

    /**
     *
     */
    private float field_70565_a;

    /**
     *
     */
    private double coordX;

    /**
     *
     */
    private double coordY;

    /**
     *
     */
    private double coordZ;

    /**
     *
     */
    protected EntityEnchantmentTableParticleFX(World worldIn,
                                               double xCoordIn,
                                               double yCoordIn,
                                               double zCoordIn,
                                               double xSpeedIn,
                                               double ySpeedIn,
                                               double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
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