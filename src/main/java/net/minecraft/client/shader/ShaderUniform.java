package net.minecraft.client.shader;

import org.apache.logging.log4j.Logger;
import org.lwjgl.util.vector.Matrix4f;

/**
 *
 */
public class ShaderUniform extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private int uniformLocation;

    /**
     *
     */
    private final int uniformCount ;

    /**
     *
     */
    private final int uniformType;

    /**
     *
     */
    private final java.nio.IntBuffer uniformIntBuffer = java.nio.IntBuffer.allocate(1);

    /**
     *
     */
    private final java.nio.FloatBuffer uniformFloatBuffer = java.nio.FloatBuffer.allocate(1);

    /**
     *
     */
    private final java.lang.String shaderName;

    /**
     *
     */
    private boolean dirty;

    /**
     *
     */
    private final ShaderManager shaderManager;

    /**
     *
     */
    public ShaderUniform(String name,
                         int type,
                         int count,
                         ShaderManager manager) {
        this.shaderManager = manager;
        this.shaderName = name;
        this.uniformType = type;
        this.uniformCount = count;
    }

    /**
     *
     */
    private void markDirty() {
        return;
    }

    /**
     *
     */
    public static int parseType(String p_148085_0_) {
        return 0;
    }

    /**
     *
     */
    public void setUniformLocation(int p_148084_1_) {
        return;
    }

    /**
     *
     */
    public String getShaderName() {
        return null;
    }

    /**
     *
     */
    public void set(float p_148090_1_) {
        return;
    }

    /**
     *
     */
    public void set(float p_148087_1_,
                    float p_148087_2_) {
        return;
    }

    /**
     *
     */
    public void set(float p_148095_1_,
                    float p_148095_2_,
                    float p_148095_3_) {
        return;
    }

    /**
     *
     */
    public void set(float p_148081_1_,
                    float p_148081_2_,
                    float p_148081_3_,
                    float p_148081_4_) {
        return;
    }

    /**
     *
     */
    public void func_148092_b(float p_148092_1_,
                              float p_148092_2_,
                              float p_148092_3_,
                              float p_148092_4_) {
        return;
    }

    /**
     *
     */
    public void set(int p_148083_1_,
                    int p_148083_2_,
                    int p_148083_3_,
                    int p_148083_4_) {
        return;
    }

    /**
     *
     */
    public void set(float[] p_148097_1_) {
        return;
    }

    /**
     *
     */
    public void set(float p_148094_1_,
                    float p_148094_2_,
                    float p_148094_3_,
                    float p_148094_4_,
                    float p_148094_5_,
                    float p_148094_6_,
                    float p_148094_7_,
                    float p_148094_8_,
                    float p_148094_9_,
                    float p_148094_10_,
                    float p_148094_11_,
                    float p_148094_12_,
                    float p_148094_13_,
                    float p_148094_14_,
                    float p_148094_15_,
                    float p_148094_16_) {
        return;
    }

    /**
     *
     */
    public void set(Matrix4f p_148088_1_) {
        return;
    }

    /**
     *
     */
    public void upload() {
        return;
    }

    /**
     *
     */
    private void uploadInt() {
        return;
    }

    /**
     *
     */
    private void uploadFloat() {
        return;
    }

    /**
     *
     */
    private void uploadFloatMatrix() {
        return;
    }

}