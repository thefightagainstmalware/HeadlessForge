package net.minecraft.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class EntityRenderer extends Object implements IResourceManagerReloadListener {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private static final ResourceLocation locationRainPng = new ResourceLocation("textures/environment/rain.png");
    /**
     *
     */
    private static final ResourceLocation locationSnowPng = new ResourceLocation("textures/environment/snow.png");
    /**
     *
     */
    public static boolean anaglyphEnable;

    /**
     * Anaglyph field (0=R, 1=GB)
     */
    public static int anaglyphField;

    /**
     * A reference to the Minecraft object.
     */
    private Minecraft mc;

    /**
     *
     */
    private final IResourceManager resourceManager;

    /**
     *
     */
    private java.util.Random random;

    /**
     *
     */
    private float farPlaneDistance;

    /**
     *
     */
    public final ItemRenderer itemRenderer;

    /**
     *
     */
    private final MapItemRenderer theMapItemRenderer;

    /**
     * Entity renderer update count
     */
    private int rendererUpdateCount;

    /**
     * Pointed entity
     */
    private Entity pointedEntity;

    /**
     *
     */
    private MouseFilter mouseFilterXAxis;

    /**
     *
     */
    private MouseFilter mouseFilterYAxis;

    /**
     *
     */
    private float thirdPersonDistance;

    /**
     * Third person distance temp
     */
    private float thirdPersonDistanceTemp;

    /**
     * Smooth cam yaw
     */
    private float smoothCamYaw;

    /**
     * Smooth cam pitch
     */
    private float smoothCamPitch;

    /**
     * Smooth cam filter X
     */
    private float smoothCamFilterX;

    /**
     * Smooth cam filter Y
     */
    private float smoothCamFilterY;

    /**
     * Smooth cam partial ticks
     */
    private float smoothCamPartialTicks;

    /**
     * FOV modifier hand
     */
    private float fovModifierHand;

    /**
     * FOV modifier hand prev
     */
    private float fovModifierHandPrev;

    /**
     *
     */
    private float bossColorModifier;

    /**
     *
     */
    private float bossColorModifierPrev;

    /**
     * Cloud fog mode
     */
    private boolean cloudFog;

    /**
     *
     */
    private boolean renderHand;

    /**
     *
     */
    private boolean drawBlockOutline;

    /**
     * Previous frame time in milliseconds
     */
    private long prevFrameTime;

    /**
     * End time of last render (ns)
     */
    private long renderEndNanoTime;

    /**
     * The texture id of the blocklight/skylight texture used for lighting effects
     */
    private final DynamicTexture lightmapTexture;

    /**
     * Colors computed in updateLightmap() and loaded into the lightmap emptyTexture
     */
    private final int[] lightmapColors;

    /**
     *
     */
    private final ResourceLocation locationLightMap;

    /**
     * Is set, updateCameraAndRender() calls updateLightmap(); set by updateTorchFlicker()
     */
    private boolean lightmapUpdateNeeded;

    /**
     * Torch flicker X
     */
    private float torchFlickerX;

    /**
     *
     */
    private float torchFlickerDX;

    /**
     * Rain sound counter
     */
    private int rainSoundCounter;

    /**
     *
     */
    private float[] rainXCoords;

    /**
     *
     */
    private float[] rainYCoords;

    /**
     * Fog color buffer
     */
    private java.nio.FloatBuffer fogColorBuffer;

    /**
     *
     */
    private float fogColorRed;

    /**
     *
     */
    private float fogColorGreen;

    /**
     *
     */
    private float fogColorBlue;

    /**
     * Fog color 2
     */
    private float fogColor2;

    /**
     * Fog color 1
     */
    private float fogColor1;

    /**
     *
     */
    private int debugViewDirection;

    /**
     *
     */
    private boolean debugView;

    /**
     *
     */
    private double cameraZoom;

    /**
     *
     */
    private double cameraYaw;

    /**
     *
     */
    private double cameraPitch;

    /**
     *
     */
    private ShaderGroup theShaderGroup;

    /**
     *
     */
    private static final ResourceLocation[] shaderResourceLocations = new ResourceLocation[] {new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json")};
    /**
     *
     */
    public static final int shaderCount = shaderResourceLocations.length;
    /**
     *
     */
    private int shaderIndex;

    /**
     *
     */
    private boolean useShader;

    /**
     *
     */
    private int frameCount;

    /**
     *
     */
    public EntityRenderer(Minecraft mcIn, IResourceManager resourceManagerIn)
    {
        this.shaderIndex = shaderCount;
        this.useShader = false;
        this.frameCount = 0;
        this.mc = mcIn;
        this.resourceManager = resourceManagerIn;
        this.itemRenderer = null;
        this.theMapItemRenderer = new MapItemRenderer(mcIn.func_110434_K());
        this.lightmapTexture = new DynamicTexture(16, 16);
        this.locationLightMap = mcIn.func_110434_K().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;

        for (int i = 0; i < 32; ++i)
        {
            for (int j = 0; j < 32; ++j)
            {
                float f = (float)(j - 16);
                float f1 = (float)(i - 16);
                float f2 = MathHelper.sqrt_float(f * f + f1 * f1);
                this.rainXCoords[i << 5 | j] = -f1 / f2;
                this.rainYCoords[i << 5 | j] = f / f2;
            }
        }
    }


    /**
     *
     */
    public boolean isShaderActive() {
        return true;
    }

    /**
     *
     */
    public void stopUseShader() {
        return;
    }

    /**
     *
     */
    public void switchUseShader() {
        return;
    }

    /**
     * What shader to use when spectating this entity
     */
    public void loadEntityShader(Entity entityIn) {
        return;
    }

    /**
     *
     */
    public void activateNextShader() {
        return;
    }

    /**
     *
     */
    public void loadShader(ResourceLocation resourceLocationIn) {
        return;
    }

    /**
     *
     */
    public void func_110549_a(IResourceManager resourceManager) {
        return;
    }

    /**
     * Updates the entity renderer
     */
    public void updateRenderer() {
        return;
    }

    /**
     *
     */
    public ShaderGroup getShaderGroup() {
        return null;
    }

    /**
     *
     */
    public void updateShaderGroupSize(int width,
                                      int height) {
        return;
    }

    /**
     * Finds what block or object the mouse is over at the specified partial tick time. Args: partialTickTime
     */
    public void getMouseOver(float partialTicks) {
        return;
    }

    /**
     * Update FOV modifier hand
     */
    private void updateFovModifierHand() {
        return;
    }

    /**
     * Changes the field of view of the player depending on if they are underwater or not
     */
    private float getFOVModifier(float partialTicks,
                                 boolean p_78481_2_) {
        return 0;
    }

    /**
     *
     */
    private void hurtCameraEffect(float partialTicks) {
        return;
    }

    /**
     * Setups all the GL settings for view bobbing. Args: partialTickTime
     */
    private void setupViewBobbing(float partialTicks) {
        return;
    }

    /**
     * sets up player's eye (or camera in third person mode)
     */
    private void orientCamera(float partialTicks) {
        return;
    }

    /**
     * sets up projection, view effects, camera position/rotation
     */
    private void setupCameraTransform(float partialTicks,
                                      int pass) {
        return;
    }

    /**
     * Render player hand
     */
    private void renderHand(float partialTicks,
                            int xOffset) {
        return;
    }

    /**
     *
     */
    public void disableLightmap() {
        return;
    }

    /**
     *
     */
    public void enableLightmap() {
        return;
    }

    /**
     * Recompute a random value that is applied to block color in updateLightmap()
     */
    private void updateTorchFlicker() {
        return;
    }

    /**
     *
     */
    private void updateLightmap(float partialTicks) {
        return;
    }

    /**
     *
     */
    private float getNightVisionBrightness(EntityLivingBase entitylivingbaseIn,
                                           float partialTicks) {
        return 0;
    }

    /**
     *
     */
    public void updateCameraAndRender(float p_181560_1_,
                                      long p_181560_2_) {
        return;
    }

    /**
     *
     */
    public void renderStreamIndicator(float partialTicks) {
        return;
    }

    /**
     *
     */
    private boolean isDrawBlockOutline() {
        return true;
    }

    /**
     *
     */
    private void renderWorldDirections(float partialTicks) {
        return;
    }

    /**
     *
     */
    public void renderWorld(float partialTicks,
                            long finishTimeNano) {
        return;
    }

    /**
     *
     */
    private void renderWorldPass(int pass,
                                 float partialTicks,
                                 long finishTimeNano) {
        return;
    }

    /**
     *
     */
    private void renderCloudsCheck(RenderGlobal renderGlobalIn,
                                   float partialTicks,
                                   int pass) {
        return;
    }

    /**
     *
     */
    private void addRainParticles() {
        return;
    }

    /**
     * Render rain and snow
     */
    protected void renderRainSnow(float partialTicks) {
        return;
    }

    /**
     * Setup orthogonal projection for rendering GUI screen overlays
     */
    public void setupOverlayRendering() {
        return;
    }

    /**
     * calculates fog and calls glClearColor
     */
    private void updateFogColor(float partialTicks) {
        return;
    }

    /**
     * Sets up the fog to be rendered. If the arg passed in is -1 the fog starts at 0 and goes to 80% of far plane
     * distance and is used for sky rendering.
     */
    private void setupFog(int p_78468_1_,
                          float partialTicks) {
        return;
    }

    /**
     * Update and return fogColorBuffer with the RGBA values passed as arguments
     */
    private java.nio.FloatBuffer setFogColorBuffer(float red,
                                                   float green,
                                                   float blue,
                                                   float alpha) {
        return null;
    }

    /**
     *
     */
    public MapItemRenderer getMapItemRenderer() {
        return null;
    }

}