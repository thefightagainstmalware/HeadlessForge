package net.minecraft.client.particle;

import net.minecraft.world.World;

/**
 *
 */
public class EntityBubbleFX extends EntityFX {

    /**
     *
     */
    protected EntityBubbleFX(World worldIn,
                             double xCoordIn,
                             double yCoordIn,
                             double zCoordIn,
                             double xSpeedIn,
                             double ySpeedIn,
                             double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

}