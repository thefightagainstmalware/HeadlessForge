package net.minecraft.client.renderer;

/**
 *
 */
public class OpenGlHelper extends Object {

    /**
     *
     */
    public static boolean nvidia;

    /**
     *
     */
    public static boolean ati;

    /**
     *
     */
    public static int GL_FRAMEBUFFER;

    /**
     *
     */
    public static int GL_RENDERBUFFER;

    /**
     *
     */
    public static int GL_COLOR_ATTACHMENT0;

    /**
     *
     */
    public static int GL_DEPTH_ATTACHMENT;

    /**
     *
     */
    public static int GL_FRAMEBUFFER_COMPLETE;

    /**
     *
     */
    public static int GL_FB_INCOMPLETE_ATTACHMENT;

    /**
     *
     */
    public static int GL_FB_INCOMPLETE_MISS_ATTACH;

    /**
     *
     */
    public static int GL_FB_INCOMPLETE_DRAW_BUFFER;

    /**
     *
     */
    public static int GL_FB_INCOMPLETE_READ_BUFFER;

    /**
     *
     */
    private static int framebufferType;

    /**
     *
     */
    public static boolean framebufferSupported;

    /**
     *
     */
    private static boolean shadersAvailable;

    /**
     *
     */
    private static boolean arbShaders;

    /**
     *
     */
    public static int GL_LINK_STATUS;

    /**
     *
     */
    public static int GL_COMPILE_STATUS;

    /**
     *
     */
    public static int GL_VERTEX_SHADER;

    /**
     *
     */
    public static int GL_FRAGMENT_SHADER;

    /**
     *
     */
    private static boolean arbMultitexture;

    /**
     * An OpenGL constant corresponding to GL_TEXTURE0, used when setting data pertaining to auxiliary OpenGL texture
     * units.
     */
    public static int defaultTexUnit;

    /**
     * An OpenGL constant corresponding to GL_TEXTURE1, used when setting data pertaining to auxiliary OpenGL texture
     * units.
     */
    public static int lightmapTexUnit;

    /**
     *
     */
    public static int GL_TEXTURE2;

    /**
     *
     */
    private static boolean arbTextureEnvCombine;

    /**
     *
     */
    public static int GL_COMBINE;

    /**
     *
     */
    public static int GL_INTERPOLATE;

    /**
     *
     */
    public static int GL_PRIMARY_COLOR;

    /**
     *
     */
    public static int GL_CONSTANT;

    /**
     *
     */
    public static int GL_PREVIOUS;

    /**
     *
     */
    public static int GL_COMBINE_RGB;

    /**
     *
     */
    public static int GL_SOURCE0_RGB;

    /**
     *
     */
    public static int GL_SOURCE1_RGB;

    /**
     *
     */
    public static int GL_SOURCE2_RGB;

    /**
     *
     */
    public static int GL_OPERAND0_RGB;

    /**
     *
     */
    public static int GL_OPERAND1_RGB;

    /**
     *
     */
    public static int GL_OPERAND2_RGB;

    /**
     *
     */
    public static int GL_COMBINE_ALPHA;

    /**
     *
     */
    public static int GL_SOURCE0_ALPHA;

    /**
     *
     */
    public static int GL_SOURCE1_ALPHA;

    /**
     *
     */
    public static int GL_SOURCE2_ALPHA;

    /**
     *
     */
    public static int GL_OPERAND0_ALPHA;

    /**
     *
     */
    public static int GL_OPERAND1_ALPHA;

    /**
     *
     */
    public static int GL_OPERAND2_ALPHA;

    /**
     *
     */
    private static boolean openGL14;

    /**
     *
     */
    public static boolean extBlendFuncSeparate;

    /**
     *
     */
    public static boolean openGL21;

    /**
     *
     */
    public static boolean shadersSupported;

    /**
     *
     */
    private static java.lang.String logText;

    /**
     *
     */
    private static java.lang.String cpu;

    /**
     *
     */
    public static boolean vboSupported;

    /**
     *
     */
    public static boolean vboSupportedAti;

    /**
     *
     */
    private static boolean arbVbo;

    /**
     *
     */
    public static int GL_ARRAY_BUFFER;

    /**
     *
     */
    public static int GL_STATIC_DRAW;

    /**
     *
     */
    public static float lastBrightnessX;

    /**
     *
     */
    public static float lastBrightnessY;

    /**
     *
     */
    public OpenGlHelper() {
        
    }

    /**
     * Initializes the texture constants to be used when rendering lightmap values
     */
    public static void initializeTextures() {
        return;
    }

    /**
     *
     */
    public static boolean areShadersSupported() {
        return true;
    }

    /**
     *
     */
    public static String getLogText() {
        return null;
    }

    /**
     *
     */
    public static int glGetProgrami(int program,
                                    int pname) {
        return 0;
    }

    /**
     *
     */
    public static void glAttachShader(int program,
                                      int shaderIn) {
        return;
    }

    /**
     *
     */
    public static void glDeleteShader(int p_153180_0_) {
        return;
    }

    /**
     * creates a shader with the given mode and returns the GL id. params: mode
     */
    public static int glCreateShader(int type) {
        return 0;
    }

    /**
     *
     */
    public static void glShaderSource(int shaderIn,
                                      java.nio.ByteBuffer string) {
        return;
    }

    /**
     *
     */
    public static void glCompileShader(int shaderIn) {
        return;
    }

    /**
     *
     */
    public static int glGetShaderi(int shaderIn,
                                   int pname) {
        return 0;
    }

    /**
     *
     */
    public static String glGetShaderInfoLog(int shaderIn,
                                                      int maxLength) {
        return null;
    }

    /**
     *
     */
    public static String glGetProgramInfoLog(int program,
                                                       int maxLength) {
        return null;
    }

    /**
     *
     */
    public static void glUseProgram(int program) {
        return;
    }

    /**
     *
     */
    public static int glCreateProgram() {
        return 0;
    }

    /**
     *
     */
    public static void glDeleteProgram(int program) {
        return;
    }

    /**
     *
     */
    public static void glLinkProgram(int program) {
        return;
    }

    /**
     *
     */
    public static int glGetUniformLocation(int programObj,
                                           CharSequence name) {
        return 0;
    }

    /**
     *
     */
    public static void glUniform1(int location,
                                  java.nio.IntBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform1i(int location,
                                   int v0) {
        return;
    }

    /**
     *
     */
    public static void glUniform1(int location,
                                  java.nio.FloatBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform2(int location,
                                  java.nio.IntBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform2(int location,
                                  java.nio.FloatBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform3(int location,
                                  java.nio.IntBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform3(int location,
                                  java.nio.FloatBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform4(int location,
                                  java.nio.IntBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniform4(int location,
                                  java.nio.FloatBuffer values) {
        return;
    }

    /**
     *
     */
    public static void glUniformMatrix2(int location,
                                        boolean transpose,
                                        java.nio.FloatBuffer matrices) {
        return;
    }

    /**
     *
     */
    public static void glUniformMatrix3(int location,
                                        boolean transpose,
                                        java.nio.FloatBuffer matrices) {
        return;
    }

    /**
     *
     */
    public static void glUniformMatrix4(int location,
                                        boolean transpose,
                                        java.nio.FloatBuffer matrices) {
        return;
    }

    /**
     *
     */
    public static int glGetAttribLocation(int p_153164_0_,
                                          CharSequence p_153164_1_) {
        return 0;
    }

    /**
     *
     */
    public static int glGenBuffers() {
        return 0;
    }

    /**
     *
     */
    public static void glBindBuffer(int target,
                                    int buffer) {
        return;
    }

    /**
     *
     */
    public static void glBufferData(int target,
                                    java.nio.ByteBuffer data,
                                    int usage) {
        return;
    }

    /**
     *
     */
    public static void glDeleteBuffers(int buffer) {
        return;
    }

    /**
     *
     */
    public static boolean useVbo() {
        return true;
    }

    /**
     *
     */
    public static void glBindFramebuffer(int target,
                                         int framebufferIn) {
        return;
    }

    /**
     *
     */
    public static void glBindRenderbuffer(int target,
                                          int renderbuffer) {
        return;
    }

    /**
     *
     */
    public static void glDeleteRenderbuffers(int renderbuffer) {
        return;
    }

    /**
     *
     */
    public static void glDeleteFramebuffers(int framebufferIn) {
        return;
    }

    /**
     * Calls the appropriate glGenFramebuffers method and returns the newly created fbo, or returns -1 if not supported.
     */
    public static int glGenFramebuffers() {
        return 0;
    }

    /**
     *
     */
    public static int glGenRenderbuffers() {
        return 0;
    }

    /**
     *
     */
    public static void glRenderbufferStorage(int target,
                                             int internalFormat,
                                             int width,
                                             int height) {
        return;
    }

    /**
     *
     */
    public static void glFramebufferRenderbuffer(int target,
                                                 int attachment,
                                                 int renderBufferTarget,
                                                 int renderBuffer) {
        return;
    }

    /**
     *
     */
    public static int glCheckFramebufferStatus(int target) {
        return 0;
    }

    /**
     *
     */
    public static void glFramebufferTexture2D(int target,
                                              int attachment,
                                              int textarget,
                                              int texture,
                                              int level) {
        return;
    }

    /**
     * Sets the current lightmap texture to the specified OpenGL constant
     */
    public static void setActiveTexture(int texture) {
        return;
    }

    /**
     * Sets the current lightmap texture to the specified OpenGL constant
     */
    public static void setClientActiveTexture(int texture) {
        return;
    }

    /**
     * Sets the current coordinates of the given lightmap texture
     */
    public static void setLightmapTextureCoords(int target,
                                                float p_77475_1_,
                                                float p_77475_2_) {
        return;
    }

    /**
     *
     */
    public static void glBlendFunc(int sFactorRGB,
                                   int dFactorRGB,
                                   int sfactorAlpha,
                                   int dfactorAlpha) {
        return;
    }

    /**
     *
     */
    public static boolean isFramebufferEnabled() {
        return true;
    }

    /**
     *
     */
    public static String getCpu() {
        return null;
    }

}