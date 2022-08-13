package net.minecraft.client.renderer;

/**
 *
 */
public class GlStateManager extends Object {

    /**
     *
     */
    private static GlStateManager.AlphaState alphaState;

    /**
     *
     */
    private static GlStateManager.BooleanState lightingState;

    /**
     *
     */
    private static GlStateManager.BooleanState[] lightState;

    /**
     *
     */
    private static GlStateManager.ColorMaterialState colorMaterialState;

    /**
     *
     */
    private static GlStateManager.BlendState blendState;

    /**
     *
     */
    private static GlStateManager.DepthState depthState;

    /**
     *
     */
    private static GlStateManager.FogState fogState;

    /**
     *
     */
    private static GlStateManager.CullState cullState;

    /**
     *
     */
    private static GlStateManager.PolygonOffsetState polygonOffsetState;

    /**
     *
     */
    private static GlStateManager.ColorLogicState colorLogicState;

    /**
     *
     */
    private static GlStateManager.TexGenState texGenState;

    /**
     *
     */
    private static GlStateManager.ClearState clearState;

    /**
     *
     */
    private static GlStateManager.StencilState stencilState;

    /**
     *
     */
    private static GlStateManager.BooleanState normalizeState;

    /**
     *
     */
    private static int activeTextureUnit;

    /**
     *
     */
    private static GlStateManager.TextureState[] textureState;

    /**
     *
     */
    private static int activeShadeModel;

    /**
     *
     */
    private static GlStateManager.BooleanState rescaleNormalState;

    /**
     *
     */
    private static GlStateManager.ColorMask colorMaskState;

    /**
     *
     */
    private static GlStateManager.Color colorState;

    /**
     *
     */
    public GlStateManager() {
        
    }

    /**
     *
     */
    public static void pushAttrib() {
        return;
    }

    /**
     *
     */
    public static void popAttrib() {
        return;
    }

    /**
     *
     */
    public static void disableAlpha() {
        return;
    }

    /**
     *
     */
    public static void enableAlpha() {
        return;
    }

    /**
     *
     */
    public static void alphaFunc(int func,
                                 float ref) {
        return;
    }

    /**
     *
     */
    public static void enableLighting() {
        return;
    }

    /**
     *
     */
    public static void disableLighting() {
        return;
    }

    /**
     *
     */
    public static void enableLight(int light) {
        return;
    }

    /**
     *
     */
    public static void disableLight(int light) {
        return;
    }

    /**
     *
     */
    public static void enableColorMaterial() {
        return;
    }

    /**
     *
     */
    public static void disableColorMaterial() {
        return;
    }

    /**
     *
     */
    public static void colorMaterial(int face,
                                     int mode) {
        return;
    }

    /**
     *
     */
    public static void disableDepth() {
        return;
    }

    /**
     *
     */
    public static void enableDepth() {
        return;
    }

    /**
     *
     */
    public static void depthFunc(int depthFunc) {
        return;
    }

    /**
     *
     */
    public static void depthMask(boolean flagIn) {
        return;
    }

    /**
     *
     */
    public static void disableBlend() {
        return;
    }

    /**
     *
     */
    public static void enableBlend() {
        return;
    }

    /**
     *
     */
    public static void blendFunc(int srcFactor,
                                 int dstFactor) {
        return;
    }

    /**
     *
     */
    public static void tryBlendFuncSeparate(int srcFactor,
                                            int dstFactor,
                                            int srcFactorAlpha,
                                            int dstFactorAlpha) {
        return;
    }

    /**
     *
     */
    public static void enableFog() {
        return;
    }

    /**
     *
     */
    public static void disableFog() {
        return;
    }

    /**
     *
     */
    public static void setFog(int param) {
        return;
    }

    /**
     *
     */
    public static void setFogDensity(float param) {
        return;
    }

    /**
     *
     */
    public static void setFogStart(float param) {
        return;
    }

    /**
     *
     */
    public static void setFogEnd(float param) {
        return;
    }

    /**
     *
     */
    public static void enableCull() {
        return;
    }

    /**
     *
     */
    public static void disableCull() {
        return;
    }

    /**
     *
     */
    public static void cullFace(int mode) {
        return;
    }

    /**
     *
     */
    public static void enablePolygonOffset() {
        return;
    }

    /**
     *
     */
    public static void disablePolygonOffset() {
        return;
    }

    /**
     *
     */
    public static void doPolygonOffset(float factor,
                                       float units) {
        return;
    }

    /**
     *
     */
    public static void enableColorLogic() {
        return;
    }

    /**
     *
     */
    public static void disableColorLogic() {
        return;
    }

    /**
     *
     */
    public static void colorLogicOp(int opcode) {
        return;
    }

    /**
     *
     */
    public static void enableTexGenCoord(GlStateManager.TexGen p_179087_0_) {
        return;
    }

    /**
     *
     */
    public static void disableTexGenCoord(GlStateManager.TexGen p_179100_0_) {
        return;
    }

    /**
     *
     */
    public static void texGen(GlStateManager.TexGen texGen,
                              int param) {
        return;
    }

    /**
     *
     */
    public static void texGen(GlStateManager.TexGen p_179105_0_,
                              int pname,
                              java.nio.FloatBuffer params) {
        return;
    }

    /**
     *
     */
    private static GlStateManager.TexGenCoord texGenCoord(GlStateManager.TexGen p_179125_0_) {
        return null;
    }

    /**
     *
     */
    public static void setActiveTexture(int texture) {
        return;
    }

    /**
     *
     */
    public static void enableTexture2D() {
        return;
    }

    /**
     *
     */
    public static void disableTexture2D() {
        return;
    }

    /**
     *
     */
    public static int generateTexture() {
        return 0;
    }

    /**
     *
     */
    public static void deleteTexture(int texture) {
        return;
    }

    /**
     *
     */
    public static void bindTexture(int texture) {
        return;
    }

    /**
     *
     */
    public static void enableNormalize() {
        return;
    }

    /**
     *
     */
    public static void disableNormalize() {
        return;
    }

    /**
     *
     */
    public static void shadeModel(int mode) {
        return;
    }

    /**
     *
     */
    public static void enableRescaleNormal() {
        return;
    }

    /**
     *
     */
    public static void disableRescaleNormal() {
        return;
    }

    /**
     *
     */
    public static void viewport(int x,
                                int y,
                                int width,
                                int height) {
        return;
    }

    /**
     *
     */
    public static void colorMask(boolean red,
                                 boolean green,
                                 boolean blue,
                                 boolean alpha) {
        return;
    }

    /**
     *
     */
    public static void clearDepth(double depth) {
        return;
    }

    /**
     *
     */
    public static void clearColor(float red,
                                  float green,
                                  float blue,
                                  float alpha) {
        return;
    }

    /**
     *
     */
    public static void clear(int mask) {
        return;
    }

    /**
     *
     */
    public static void matrixMode(int mode) {
        return;
    }

    /**
     *
     */
    public static void loadIdentity() {
        return;
    }

    /**
     *
     */
    public static void pushMatrix() {
        return;
    }

    /**
     *
     */
    public static void popMatrix() {
        return;
    }

    /**
     *
     */
    public static void getFloat(int pname,
                                java.nio.FloatBuffer params) {
        return;
    }

    /**
     *
     */
    public static void ortho(double left,
                             double right,
                             double bottom,
                             double top,
                             double zNear,
                             double zFar) {
        return;
    }

    /**
     *
     */
    public static void rotate(float angle,
                              float x,
                              float y,
                              float z) {
        return;
    }

    /**
     *
     */
    public static void scale(float x,
                             float y,
                             float z) {
        return;
    }

    /**
     *
     */
    public static void scale(double x,
                             double y,
                             double z) {
        return;
    }

    /**
     *
     */
    public static void translate(float x,
                                 float y,
                                 float z) {
        return;
    }

    /**
     *
     */
    public static void translate(double x,
                                 double y,
                                 double z) {
        return;
    }

    /**
     *
     */
    public static void multMatrix(java.nio.FloatBuffer matrix) {
        return;
    }

    /**
     *
     */
    public static void color(float colorRed,
                             float colorGreen,
                             float colorBlue,
                             float colorAlpha) {
        return;
    }

    /**
     *
     */
    public static void color(float colorRed,
                             float colorGreen,
                             float colorBlue) {
        return;
    }

    /**
     *
     */
    public static void resetColor() {
        return;
    }

    /**
     *
     */
    public static void callList(int list) {
        return;
    }

    public class AlphaState {
    }

    public class BooleanState {
    }

    public class ColorMaterialState {
    }

    public class BlendState {
    }

    public class DepthState {
    }

    public class FogState {
    }

    public class CullState {
    }

    public class PolygonOffsetState {
    }

    public class ColorLogicState {
    }

    public class TexGenState {
    }

    public class ClearState {
    }

    public class StencilState {
    }

    public class TextureState {
    }

    public class ColorMask {
    }

    public class Color {
    }

    public class TexGen {
    }

    public class TexGenCoord {
    }
}