package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.util.MathHelper;
import net.minecraft.client.renderer.vertex.VertexFormat;

/**
 *
 */
public class WorldRenderer extends Object {

    /**
     *
     */
    private java.nio.ByteBuffer byteBuffer;

    /**
     *
     */
    private java.nio.IntBuffer rawIntBuffer;

    /**
     *
     */
    private java.nio.ShortBuffer rawShortBuffer;

    /**
     *
     */
    private java.nio.FloatBuffer rawFloatBuffer;

    /**
     *
     */
    private int vertexCount;

    /**
     *
     */
    private VertexFormatElement vertexFormatElement;

    /**
     *
     */
    private int vertexFormatIndex;

    /**
     * None
     */
    private boolean noColor;

    /**
     *
     */
    private int drawMode;

    /**
     *
     */
    private double xOffset;

    /**
     *
     */
    private double yOffset;

    /**
     *
     */
    private double zOffset;

    /**
     *
     */
    private VertexFormat vertexFormat;

    /**
     *
     */
    private boolean isDrawing;

    /**
     *
     */
    public WorldRenderer(int bufferSizeIn) {
        
    }

    /**
     *
     */
    private void growBuffer(int p_181670_1_) {
        return;
    }

    /**
     *
     */
    public void sortVertexData(float p_181674_1_,
                               float p_181674_2_,
                               float p_181674_3_) {
        return;
    }

    /**
     *
     */
    public WorldRenderer.State getVertexState() {
        return null;
    }

    /**
     *
     */
    private int getBufferSize() {
        return 0;
    }

    /**
     *
     */
    private static float func_181665_a(java.nio.FloatBuffer p_181665_0_,
                                       float p_181665_1_,
                                       float p_181665_2_,
                                       float p_181665_3_,
                                       int p_181665_4_,
                                       int p_181665_5_) {
        return 0;
    }

    /**
     *
     */
    public void setVertexState(WorldRenderer.State state) {
        return;
    }

    /**
     *
     */
    public void reset() {
        return;
    }

    /**
     *
     */
    public void begin(int glMode,
                      VertexFormat format) {
        return;
    }

    /**
     *
     */
    public WorldRenderer tex(double u,
                             double v) {
        return null;
    }

    /**
     *
     */
    public WorldRenderer lightmap(int p_181671_1_,
                                  int p_181671_2_) {
        return null;
    }

    /**
     *
     */
    public void putBrightness4(int p_178962_1_,
                               int p_178962_2_,
                               int p_178962_3_,
                               int p_178962_4_) {
        return;
    }

    /**
     *
     */
    public void putPosition(double x,
                            double y,
                            double z) {
        return;
    }

    /**
     * Takes in the pass the call list is being requested for. Args: renderPass
     */
    public int getColorIndex(int p_78909_1_) {
        return 0;
    }

    /**
     *
     */
    public void putColorMultiplier(float red,
                                   float green,
                                   float blue,
                                   int p_178978_4_) {
        return;
    }

    /**
     *
     */
    private void putColor(int argb,
                          int p_178988_2_) {
        return;
    }

    /**
     *
     */
    public void putColorRGB_F(float red,
                              float green,
                              float blue,
                              int p_178994_4_) {
        return;
    }

    /**
     *
     */
    public void putColorRGBA(int index,
                             int red,
                             int p_178972_3_,
                             int p_178972_4_,
                             int p_178972_5_) {
        return;
    }

    /**
     * Disabels color processing.
     */
    public void noColor() {
        return;
    }

    /**
     *
     */
    public WorldRenderer color(float red,
                               float green,
                               float blue,
                               float alpha) {
        return null;
    }

    /**
     *
     */
    public WorldRenderer color(int red,
                               int green,
                               int blue,
                               int alpha) {
        return null;
    }

    /**
     *
     */
    public void addVertexData(int[] vertexData) {
        return;
    }

    /**
     *
     */
    public void endVertex() {
        return;
    }

    /**
     *
     */
    public WorldRenderer pos(double x,
                             double y,
                             double z) {
        return null;
    }

    /**
     *
     */
    public void putNormal(float x,
                          float y,
                          float z) {
        return;
    }

    /**
     *
     */
    private void nextVertexFormatIndex() {
        return;
    }

    /**
     *
     */
    public WorldRenderer normal(float p_181663_1_,
                                float p_181663_2_,
                                float p_181663_3_) {
        return null;
    }

    /**
     *
     */
    public void setTranslation(double x,
                               double y,
                               double z) {
        return;
    }

    /**
     *
     */
    public void finishDrawing() {
        return;
    }

    /**
     *
     */
    public java.nio.ByteBuffer getByteBuffer() {
        return null;
    }

    /**
     *
     */
    public VertexFormat getVertexFormat() {
        return null;
    }

    /**
     *
     */
    public int getVertexCount() {
        return 0;
    }

    /**
     *
     */
    public int getDrawMode() {
        return 0;
    }

    /**
     *
     */
    public void putColor4(int argb) {
        return;
    }

    /**
     *
     */
    public void putColorRGB_F4(float red,
                               float green,
                               float blue) {
        return;
    }

    /**
     *
     */
    public void checkAndGrow() {
        return;
    }

    /**
     *
     */
    public boolean isColorDisabled() {
        return true;
    }

    public class State {
    }
}