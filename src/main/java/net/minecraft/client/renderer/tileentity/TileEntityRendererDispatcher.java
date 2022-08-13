package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.tileentity.TileEntity;

/**
 *
 */
public class TileEntityRendererDispatcher extends Object {

    /**
     *
     */
    public java.util.Map<java.lang.Class<? extends TileEntity>,TileEntitySpecialRenderer<? extends TileEntity>> mapSpecialRenderers;

    /**
     *
     */
    public static TileEntityRendererDispatcher instance;

    /**
     *
     */
    private FontRenderer fontRenderer;

    /**
     * The player's current X position (same as playerX)
     */
    public static double staticPlayerX;

    /**
     * The player's current Y position (same as playerY)
     */
    public static double staticPlayerY;

    /**
     * The player's current Z position (same as playerZ)
     */
    public static double staticPlayerZ;

    /**
     *
     */
    public TextureManager renderEngine;

    /**
     *
     */
    public World worldObj;

    /**
     *
     */
    public Entity entity;

    /**
     *
     */
    public float entityYaw;

    /**
     *
     */
    public float entityPitch;

    /**
     *
     */
    public double entityX;

    /**
     *
     */
    public double entityY;

    /**
     *
     */
    public double entityZ;

    /**
     * Buffer used for batched TESRs
     */
    private Tessellator batchBuffer;

    /**
     *
     */
    private TileEntityRendererDispatcher() {
        
    }

    /**
     *
     */
    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRendererByClass(Class<? extends TileEntity> teClass) {
        return null;
    }

    /**
     *
     */
    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRenderer(TileEntity tileEntityIn) {
        return null;
    }

    /**
     *
     */
    public void cacheActiveRenderInfo(World worldIn,
                                      TextureManager textureManagerIn,
                                      FontRenderer fontrendererIn,
                                      Entity entityIn,
                                      float partialTicks) {
        return;
    }

    /**
     *
     */
    public void renderTileEntity(TileEntity tileentityIn,
                                 float partialTicks,
                                 int destroyStage) {
        return;
    }

    /**
     * Render this TileEntity at a given set of coordinates
     */
    public void renderTileEntityAt(TileEntity tileEntityIn,
                                   double x,
                                   double y,
                                   double z,
                                   float partialTicks) {
        return;
    }

    /**
     *
     */
    public void renderTileEntityAt(TileEntity tileEntityIn,
                                   double x,
                                   double y,
                                   double z,
                                   float partialTicks,
                                   int destroyStage) {
        return;
    }

    /**
     *
     */
    public void setWorld(World worldIn) {
        return;
    }

    /**
     *
     */
    public FontRenderer getFontRenderer() {
        return null;
    }

    /**
     * Prepare for a batched TESR rendering.
     * You probably shouldn't call this manually.
     */
    public void preDrawBatch() {
        return;
    }

    /**
     * Render all TESRs batched so far.
     * You probably shouldn't call this manually.
     */
    public void drawBatch(int pass) {
        return;
    }

}