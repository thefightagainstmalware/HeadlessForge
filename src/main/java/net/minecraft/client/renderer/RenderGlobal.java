package net.minecraft.client.renderer;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IWorldAccess;
import org.apache.logging.log4j.Logger;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

/**
 *
 */
public class RenderGlobal extends Object implements IWorldAccess, IResourceManagerReloadListener {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();
    private static final ResourceLocation field_110927_h = new ResourceLocation("textures/environment/moon_phases.png");
    private static final ResourceLocation field_110928_i = new ResourceLocation("textures/environment/sun.png");
    private static final ResourceLocation field_110925_j = new ResourceLocation("textures/environment/clouds.png");
    private static final ResourceLocation field_110926_k = new ResourceLocation("textures/environment/end_sky.png");
    private static final ResourceLocation field_175006_g = new ResourceLocation("textures/misc/forcefield.png");
    /**
     * A reference to the Minecraft object.
     */
    private final Minecraft mc = Minecraft.func_71410_x();

    /**
     * The RenderEngine instance used by RenderGlobal
     */
    private final TextureManager renderEngine = null;

    /**
     *
     */
    private final RenderManager renderManager = null;

    /**
     *
     */
    private WorldClient theWorld;

    /**
     *
     */
    private java.util.Set<RenderChunk> chunksToUpdate;

    /**
     *
     */
    private java.util.List<RenderGlobal.ContainerLocalRenderInformation> renderInfos;

    /**
     *
     */
    private final java.util.Set<TileEntity> setTileEntities = Sets.newHashSet();

    /**
     *
     */
    private ViewFrustum viewFrustum;

    /**
     * The star GL Call list
     */
    private int starGLCallList;

    /**
     * OpenGL sky list
     */
    private int glSkyList;

    /**
     * OpenGL sky list 2
     */
    private int glSkyList2;

    /**
     *
     */
    private VertexFormat vertexBufferFormat;

    /**
     *
     */
    private VertexBuffer starVBO;

    /**
     *
     */
    private VertexBuffer skyVBO;

    /**
     *
     */
    private VertexBuffer sky2VBO;

    /**
     * counts the cloud render updates. Used with mod to stagger some updates
     */
    private int cloudTickCounter;

    /**
     *
     */
    private final java.util.Map<java.lang.Integer,DestroyBlockProgress> damagedBlocks = Maps.newHashMap();

    /**
     *
     */
    private final java.util.Map<BlockPos,ISound> mapSoundPositions = Maps.newHashMap();

    /**
     *
     */
    private final TextureAtlasSprite[] destroyBlockIcons = new TextureAtlasSprite[10];

    /**
     *
     */
    private Framebuffer entityOutlineFramebuffer;

    /**
     * Stores the shader group for the entity_outline shader
     */
    private ShaderGroup entityOutlineShader;

    /**
     *
     */
    private double frustumUpdatePosX;

    /**
     *
     */
    private double frustumUpdatePosY;

    /**
     *
     */
    private double frustumUpdatePosZ;

    /**
     *
     */
    private int frustumUpdatePosChunkX;

    /**
     *
     */
    private int frustumUpdatePosChunkY;

    /**
     *
     */
    private int frustumUpdatePosChunkZ;

    /**
     *
     */
    private double lastViewEntityX;

    /**
     *
     */
    private double lastViewEntityY;

    /**
     *
     */
    private double lastViewEntityZ;

    /**
     *
     */
    private double lastViewEntityPitch;

    /**
     *
     */
    private double lastViewEntityYaw;

    /**
     *
     */
    private final ChunkRenderDispatcher renderDispatcher = new ChunkRenderDispatcher();

    /**
     *
     */
    private ChunkRenderContainer renderContainer;

    /**
     *
     */
    private int renderDistanceChunks;

    /**
     * Render entities startup counter (init value=2)
     */
    private int renderEntitiesStartupCounter;

    /**
     * Count entities total
     */
    private int countEntitiesTotal;

    /**
     * Count entities rendered
     */
    private int countEntitiesRendered;

    /**
     * Count entities hidden
     */
    private int countEntitiesHidden;

    /**
     *
     */
    private boolean debugFixTerrainFrustum;

    /**
     *
     */
    private ClippingHelper debugFixedClippingHelper;

    /**
     *
     */
    private final Vector4f[] debugTerrainMatrix = new Vector4f[8];

    /**
     *
     */
    private final Vector3d debugTerrainFrustumPosition = new Vector3d();

    /**
     *
     */
    private boolean vboEnabled;

    /**
     *
     */
    IRenderChunkFactory renderChunkFactory;

    /**
     *
     */
    private double prevRenderSortX;

    /**
     *
     */
    private double prevRenderSortY;

    /**
     *
     */
    private double prevRenderSortZ;

    /**
     *
     */
    private boolean displayListEntitiesDirty;

    /**
     *
     */
    public RenderGlobal(Minecraft mcIn) {

    }

    /**
     *
     */
    public void func_110549_a(IResourceManager resourceManager) {
        return;
    }

    /**
     *
     */
    private void updateDestroyBlockIcons() {
        return;
    }

    /**
     * Creates the entity outline shader to be stored in RenderGlobal.entityOutlineShader
     */
    public void makeEntityOutlineShader() {
        return;
    }

    /**
     *
     */
    public void renderEntityOutlineFramebuffer() {
        return;
    }

    /**
     *
     */
    protected boolean isRenderEntityOutlines() {
        return true;
    }

    /**
     *
     */
    private void generateSky2() {
        return;
    }

    /**
     *
     */
    private void generateSky() {
        return;
    }

    /**
     *
     */
    private void renderSky(WorldRenderer worldRendererIn,
                           float p_174968_2_,
                           boolean p_174968_3_) {
        return;
    }

    /**
     *
     */
    private void generateStars() {
        return;
    }

    /**
     *
     */
    private void renderStars(WorldRenderer worldRendererIn) {
        return;
    }

    /**
     * set null to clear
     */
    public void setWorldAndLoadRenderers(WorldClient worldClientIn) {
        return;
    }

    /**
     * Loads all the renderers and sets up the basic settings usage
     */
    public void loadRenderers() {
        return;
    }

    /**
     *
     */
    protected void stopChunkUpdates() {
        return;
    }

    /**
     *
     */
    public void createBindEntityOutlineFbs(int p_72720_1_,
                                           int p_72720_2_) {
        return;
    }

    /**
     *
     */
    public void renderEntities(Entity renderViewEntity,
                               ICamera camera,
                               float partialTicks) {
        return;
    }

    /**
     * Gets the render info for use on the Debug screen
     */
    public String getDebugInfoRenders() {
        return null;
    }

    /**
     * Gets the entities info for use on the Debug screen
     */
    public String getDebugInfoEntities() {
        return null;
    }

    /**
     *
     */
    public void setupTerrain(Entity viewEntity,
                             double partialTicks,
                             ICamera camera,
                             int frameCount,
                             boolean playerSpectator) {
        return;
    }

    /**
     *
     */
    private boolean isPositionInRenderChunk(BlockPos pos,
                                            RenderChunk renderChunkIn) {
        return true;
    }

    /**
     *
     */
    private java.util.Set<EnumFacing> getVisibleFacings(BlockPos pos) {
        return null;
    }

    /**
     * Returns RenderChunk offset from given RenderChunk in given direction, or null if it can't be seen by player at
     * given BlockPos.
     * @param playerPos Player position. If the offset RenderChunk can't be seen from this position (is too far) -
     *  returns null.
     * @param renderChunkBase The RenderChunk for which neighbor should be returned
     * @param facing Offset direction
     */
    private RenderChunk getRenderChunkOffset(BlockPos playerPos,
                                             RenderChunk renderChunkBase,
                                             EnumFacing facing) {
        return null;
    }

    /**
     *
     */
    private void fixTerrainFrustum(double x,
                                   double y,
                                   double z) {
        return;
    }

    /**
     *
     */
    protected Vector3f getViewVector(Entity entityIn,
                                     double partialTicks) {
        return null;
    }

    /**
     *
     */
    public int renderBlockLayer(EnumWorldBlockLayer blockLayerIn,
                                double partialTicks,
                                int pass,
                                Entity entityIn) {
        return 0;
    }

    /**
     *
     */
    private void renderBlockLayer(EnumWorldBlockLayer blockLayerIn) {
        return;
    }

    /**
     *
     */
    private void cleanupDamagedBlocks(java.util.Iterator<DestroyBlockProgress> iteratorIn) {
        return;
    }

    /**
     *
     */
    public void updateClouds() {
        return;
    }

    /**
     *
     */
    private void renderSkyEnd() {
        return;
    }

    /**
     *
     */
    public void renderSky(float partialTicks,
                          int pass) {
        return;
    }

    /**
     *
     */
    public void renderClouds(float partialTicks,
                             int pass) {
        return;
    }

    /**
     * Checks if the given position is to be rendered with cloud fog
     */
    public boolean hasCloudFog(double x,
                               double y,
                               double z,
                               float partialTicks) {
        return true;
    }

    /**
     *
     */
    private void renderCloudsFancy(float partialTicks,
                                   int pass) {
        return;
    }

    /**
     *
     */
    public void updateChunks(long finishTimeNano) {
        return;
    }

    /**
     *
     */
    public void renderWorldBorder(Entity p_180449_1_,
                                  float partialTicks) {
        return;
    }

    /**
     *
     */
    private void preRenderDamagedBlocks() {
        return;
    }

    /**
     *
     */
    private void postRenderDamagedBlocks() {
        return;
    }

    /**
     *
     */
    public void drawBlockDamageTexture(Tessellator tessellatorIn,
                                       WorldRenderer worldRendererIn,
                                       Entity entityIn,
                                       float partialTicks) {
        return;
    }

    /**
     * Draws the selection box for the player. Args: entityPlayer, rayTraceHit, i, itemStack, partialTickTime
     */
    public void drawSelectionBox(EntityPlayer player,
                                 MovingObjectPosition movingObjectPositionIn,
                                 int p_72731_3_,
                                 float partialTicks) {
        return;
    }

    /**
     *
     */
    public static void drawSelectionBoundingBox(AxisAlignedBB p_181561_0_) {
        return;
    }

    /**
     *
     */
    public static void drawOutlinedBoundingBox(AxisAlignedBB p_181563_0_,
                                               int p_181563_1_,
                                               int p_181563_2_,
                                               int p_181563_3_,
                                               int p_181563_4_) {
        return;
    }

    /**
     * Marks the blocks in the given range for update
     */
    private void markBlocksForUpdate(int x1,
                                     int y1,
                                     int z1,
                                     int x2,
                                     int y2,
                                     int z2) {
        return;
    }

    /**
     *
     */
    public void markBlockForUpdate(BlockPos pos) {
        return;
    }

    /**
     *
     */
    public void notifyLightSet(BlockPos pos) {
        return;
    }

    /**
     * On the client, re-renders all blocks in this range, inclusive. On the server, does nothing. Args: min x, min y,
     * min z, max x, max y, max z
     */
    public void markBlockRangeForRenderUpdate(int x1,
                                              int y1,
                                              int z1,
                                              int x2,
                                              int y2,
                                              int z2) {
        return;
    }

    /**
     *
     */
    public void playRecord(String recordName,
                           BlockPos blockPosIn) {
        return;
    }

    /**
     * Plays the specified sound. Arg: soundName, x, y, z, volume, pitch
     */
    public void playSound(String soundName,
                          double x,
                          double y,
                          double z,
                          float volume,
                          float pitch) {
        return;
    }

    /**
     * Plays sound to all near players except the player reference given
     */
    public void playSoundToNearExcept(EntityPlayer except,
                                      String soundName,
                                      double x,
                                      double y,
                                      double z,
                                      float volume,
                                      float pitch) {
        return;
    }

    /**
     *
     */
    public void spawnParticle(int particleID,
                              boolean ignoreRange,
                              double xCoord,
                              double yCoord,
                              double zCoord,
                              double xOffset,
                              double yOffset,
                              double zOffset,
                              int... p_180442_15_) {
        return;
    }

    /**
     *
     */
    private void spawnParticle(EnumParticleTypes particleIn,
                               double p_174972_2_,
                               double p_174972_4_,
                               double p_174972_6_,
                               double p_174972_8_,
                               double p_174972_10_,
                               double p_174972_12_,
                               int... p_174972_14_) {
        return;
    }

    /**
     *
     */
    private EntityFX spawnEntityFX(int p_174974_1_,
                                   boolean ignoreRange,
                                   double p_174974_3_,
                                   double p_174974_5_,
                                   double p_174974_7_,
                                   double p_174974_9_,
                                   double p_174974_11_,
                                   double p_174974_13_,
                                   int... p_174974_15_) {
        return null;
    }

    /**
     * Called on all IWorldAccesses when an entity is created or loaded. On client worlds, starts downloading any
     * necessary textures. On server worlds, adds the entity to the entity tracker.
     */
    public void onEntityAdded(Entity entityIn) {
        return;
    }

    /**
     * Called on all IWorldAccesses when an entity is unloaded or destroyed. On client worlds, releases any downloaded
     * textures. On server worlds, removes the entity from the entity tracker.
     */
    public void onEntityRemoved(Entity entityIn) {
        return;
    }

    /**
     * Deletes all display lists
     */
    public void deleteAllDisplayLists() {
        return;
    }

    /**
     *
     */
    public void broadcastSound(int p_180440_1_,
                               BlockPos p_180440_2_,
                               int p_180440_3_) {
        return;
    }

    /**
     *
     */
    public void playAuxSFX(EntityPlayer player,
                           int sfxType,
                           BlockPos blockPosIn,
                           int p_180439_4_) {
        return;
    }

    /**
     *
     */
    public void sendBlockBreakProgress(int breakerId,
                                       BlockPos pos,
                                       int progress) {
        return;
    }

    /**
     *
     */
    public void setDisplayListEntitiesDirty() {
        return;
    }

    /**
     *
     */
    public void updateTileEntities(java.util.Collection<TileEntity> p_181023_1_,
                                   java.util.Collection<TileEntity> p_181023_2_) {
        return;
    }

    public class ContainerLocalRenderInformation {
    }
}