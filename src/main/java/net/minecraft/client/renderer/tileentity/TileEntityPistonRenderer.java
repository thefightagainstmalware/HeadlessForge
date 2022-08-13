package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.tileentity.TileEntityPiston;

/**
 *
 */
public class TileEntityPistonRenderer extends TileEntitySpecialRenderer<TileEntityPiston> {

    /**
     *
     */
    private BlockRendererDispatcher blockRenderer;

    /**
     *
     */
    public TileEntityPistonRenderer() {
        
    }

    /**
     *
     */
    public void renderTileEntityAt(TileEntityPiston te,
                                   double x,
                                   double y,
                                   double z,
                                   float partialTicks,
                                   int destroyStage) {
        return;
    }

}