package net.minecraft.client.particle;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;

/**
 *
 */
public class EntityDropParticleFX extends EntityFX {

    /**
     * the material type for dropped items/blocks
     */
    private Material materialType;

    /**
     * The height of the current bob
     */
    private int bobTimer;

    /**
     *
     */
    protected EntityDropParticleFX(World worldIn,
                                   double xCoordIn,
                                   double yCoordIn,
                                   double zCoordIn,
                                   Material p_i1203_8_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
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