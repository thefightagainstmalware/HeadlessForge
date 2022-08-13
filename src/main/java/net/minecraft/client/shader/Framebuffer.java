package net.minecraft.client.shader;

/**
 *
 */
public class Framebuffer extends Object {

    /**
     *
     */
    public int framebufferTextureWidth;

    /**
     *
     */
    public int framebufferTextureHeight;

    /**
     *
     */
    public int framebufferWidth;

    /**
     *
     */
    public int framebufferHeight;

    /**
     *
     */
    public boolean useDepth;

    /**
     *
     */
    public int framebufferObject;

    /**
     *
     */
    public int framebufferTexture;

    /**
     *
     */
    public int depthBuffer;

    /**
     *
     */
    public float[] framebufferColor;

    /**
     *
     */
    public int framebufferFilter;

    /**
     *
     */
    private boolean stencilEnabled;

    /**
     *
     */
    public Framebuffer(int p_i45078_1_,
                       int p_i45078_2_,
                       boolean p_i45078_3_) {
        
    }

    /**
     *
     */
    public void createBindFramebuffer(int width,
                                      int height) {
        return;
    }

    /**
     *
     */
    public void deleteFramebuffer() {
        return;
    }

    /**
     *
     */
    public void createFramebuffer(int width,
                                  int height) {
        return;
    }

    /**
     *
     */
    public void setFramebufferFilter(int p_147607_1_) {
        return;
    }

    /**
     *
     */
    public void checkFramebufferComplete() {
        return;
    }

    /**
     *
     */
    public void bindFramebufferTexture() {
        return;
    }

    /**
     *
     */
    public void unbindFramebufferTexture() {
        return;
    }

    /**
     *
     */
    public void bindFramebuffer(boolean p_147610_1_) {
        return;
    }

    /**
     *
     */
    public void unbindFramebuffer() {
        return;
    }

    /**
     *
     */
    public void setFramebufferColor(float p_147604_1_,
                                    float p_147604_2_,
                                    float p_147604_3_,
                                    float p_147604_4_) {
        return;
    }

    /**
     *
     */
    public void framebufferRender(int p_147615_1_,
                                  int p_147615_2_) {
        return;
    }

    /**
     *
     */
    public void framebufferRenderExt(int p_178038_1_,
                                     int p_178038_2_,
                                     boolean p_178038_3_) {
        return;
    }

    /**
     *
     */
    public void framebufferClear() {
        return;
    }

    /**
     * Attempts to enabled 8 bits of stencil buffer on this FrameBuffer.
     * Modders must call this directly to set things up.
     * This is to prevent the default cause where graphics cards do not support stencil bits.
     * Modders should check the below 'isStencilEnabled' to check if another modder has already enabled them.
     * 
     * Note:
     *   As of now the only thing that is checked is if FBOs are supported entirely, in the future
     *   we may expand to check for errors.
     * @return True if the FBO was re-initialized with stencil bits.
     */
    public boolean enableStencil() {
        return true;
    }

    /**
     * Returns wither or not this FBO has been successfully initialized with stencil bits.
     * If not, and a modder wishes it to be, they must call enableStencil.
     */
    public boolean isStencilEnabled() {
        return true;
    }

}