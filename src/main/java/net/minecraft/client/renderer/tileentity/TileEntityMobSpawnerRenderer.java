package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer<TileEntityMobSpawner> {

    /**
     *
     */
    public TileEntityMobSpawnerRenderer() {
        
    }

    /**
     *
     */
    public void renderTileEntityAt(TileEntityMobSpawner te,
                                   double x,
                                   double y,
                                   double z,
                                   float partialTicks,
                                   int destroyStage) {
        return;
    }

    /**
     * Render the mob inside the mob spawner.
     */
    public static void renderMob(MobSpawnerBaseLogic mobSpawnerLogic,
                                 double posX,
                                 double posY,
                                 double posZ,
                                 float partialTicks) {
        return;
    }

}