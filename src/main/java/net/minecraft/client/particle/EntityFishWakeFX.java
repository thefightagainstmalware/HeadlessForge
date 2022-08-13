package net.minecraft.client.particle;

import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class EntityFishWakeFX extends EntityFX {

    /**
     *
     */
    protected EntityFishWakeFX(World worldIn,
                               double xCoordIn,
                               double yCoordIn,
                               double zCoordIn,
                               double p_i45073_8_,
                               double p_i45073_10_,
                               double p_i45073_12_) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i45073_8_, p_i45073_10_, p_i45073_12_);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

}