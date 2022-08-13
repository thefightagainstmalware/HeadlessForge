package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.culling.ICamera;

/**
 *
 */
public class RenderManager extends Object {

    /**
     *
     */
    public java.util.Map<java.lang.Class<? extends Entity>,Render<? extends Entity>> entityRenderMap;

    /**
     *
     */
    private java.util.Map<java.lang.String,RenderPlayer> skinMap;

    /**
     *
     */
    private RenderPlayer playerRenderer;

    /**
     * Renders fonts
     */
    private FontRenderer textRenderer;

    /**
     *
     */
    private double renderPosX;

    /**
     *
     */
    private double renderPosY;

    /**
     *
     */
    private double renderPosZ;

    /**
     *
     */
    public TextureManager renderEngine;

    /**
     * Reference to the World object.
     */
    public World worldObj;

    /**
     * Rendermanager's variable for the player
     */
    public Entity livingPlayer;

    /**
     *
     */
    public Entity pointedEntity;

    /**
     *
     */
    public float playerViewY;

    /**
     *
     */
    public float playerViewX;

    /**
     * Reference to the GameSettings object.
     */
    public GameSettings options;

    /**
     *
     */
    public double viewerPosX;

    /**
     *
     */
    public double viewerPosY;

    /**
     *
     */
    public double viewerPosZ;

    /**
     *
     */
    private boolean renderOutlines;

    /**
     *
     */
    private boolean renderShadow;

    /**
     * whether bounding box should be rendered or not
     */
    private boolean debugBoundingBox;

    /**
     *
     */
    public RenderManager(TextureManager renderEngineIn,
                         RenderItem itemRendererIn) {
        
    }

    /**
     *
     */
    public java.util.Map<String,RenderPlayer> getSkinMap() {
        return null;
    }

    /**
     *
     */
    public void setRenderPosition(double renderPosXIn,
                                  double renderPosYIn,
                                  double renderPosZIn) {
        return;
    }

    /**
     *
     */
    public <T extends Entity> Render<T> getEntityClassRenderObject(Class<? extends Entity> p_78715_1_) {
        return null;
    }

    /**
     *
     */
    public <T extends Entity> Render<T> getEntityRenderObject(Entity entityIn) {
        return null;
    }

    /**
     *
     */
    public void cacheActiveRenderInfo(World worldIn,
                                      FontRenderer textRendererIn,
                                      Entity livingPlayerIn,
                                      Entity pointedEntityIn,
                                      GameSettings optionsIn,
                                      float partialTicks) {
        return;
    }

    /**
     *
     */
    public void setPlayerViewY(float playerViewYIn) {
        return;
    }

    /**
     *
     */
    public boolean isRenderShadow() {
        return true;
    }

    /**
     *
     */
    public void setRenderShadow(boolean renderShadowIn) {
        return;
    }

    /**
     *
     */
    public void setDebugBoundingBox(boolean debugBoundingBoxIn) {
        return;
    }

    /**
     *
     */
    public boolean isDebugBoundingBox() {
        return true;
    }

    /**
     *
     */
    public boolean renderEntitySimple(Entity entityIn,
                                      float partialTicks) {
        return true;
    }

    /**
     *
     */
    public boolean shouldRender(Entity entityIn,
                                ICamera camera,
                                double camX,
                                double camY,
                                double camZ) {
        return true;
    }

    /**
     *
     */
    public boolean renderEntityStatic(Entity entity,
                                      float partialTicks,
                                      boolean p_147936_3_) {
        return true;
    }

    /**
     *
     */
    public void renderWitherSkull(Entity entityIn,
                                  float partialTicks) {
        return;
    }

    /**
     *
     */
    public boolean renderEntityWithPosYaw(Entity entityIn,
                                          double x,
                                          double y,
                                          double z,
                                          float entityYaw,
                                          float partialTicks) {
        return true;
    }

    /**
     *
     */
    public boolean doRenderEntity(Entity entity,
                                  double x,
                                  double y,
                                  double z,
                                  float entityYaw,
                                  float partialTicks,
                                  boolean p_147939_10_) {
        return true;
    }

    /**
     * Renders the bounding box around an entity when F3+B is pressed
     */
    private void renderDebugBoundingBox(Entity entityIn,
                                        double p_85094_2_,
                                        double p_85094_4_,
                                        double p_85094_6_,
                                        float p_85094_8_,
                                        float p_85094_9_) {
        return;
    }

    /**
     * World sets this RenderManager's worldObj to the world provided
     */
    public void set(World worldIn) {
        return;
    }

    /**
     *
     */
    public double getDistanceToCamera(double p_78714_1_,
                                      double p_78714_3_,
                                      double p_78714_5_) {
        return 0;
    }

    /**
     * Returns the font renderer
     */
    public FontRenderer getFontRenderer() {
        return null;
    }

    /**
     *
     */
    public void setRenderOutlines(boolean renderOutlinesIn) {
        return;
    }

}