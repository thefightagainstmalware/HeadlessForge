package net.minecraft.client.renderer.texture;

/**
 *
 */
public abstract class AbstractTexture extends Object implements ITextureObject {

    /**
     *
     */
    protected int glTextureId;

    /**
     *
     */
    protected boolean blur;

    /**
     *
     */
    protected boolean mipmap;

    /**
     *
     */
    protected boolean blurLast;

    /**
     *
     */
    protected boolean mipmapLast;

    /**
     *
     */
    public AbstractTexture() {
        
    }

    /**
     *
     */
    public void setBlurMipmapDirect(boolean p_174937_1_,
                                    boolean p_174937_2_) {
        return;
    }

    /**
     *
     */
    public void setBlurMipmap(boolean p_174936_1_,
                              boolean p_174936_2_) {
        return;
    }

    /**
     *
     */
    public void restoreLastBlurMipmap() {
        return;
    }

    /**
     *
     */
    public int getGlTextureId() {
        return 0;
    }

    /**
     *
     */
    public void deleteGlTexture() {
        return;
    }

}