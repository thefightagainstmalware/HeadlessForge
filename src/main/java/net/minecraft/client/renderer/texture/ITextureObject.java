package net.minecraft.client.renderer.texture;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;

/**
 *
 */
public interface ITextureObject {

    /**
     *
     */
    void setBlurMipmap(boolean p_174936_1_,
                       boolean p_174936_2_);

    /**
     *
     */
    void restoreLastBlurMipmap();

    /**
     * 
     * @throws java.io.IOException
     */
    void loadTexture(IResourceManager resourceManager)
              throws java.io.IOException;

    /**
     *
     */
    int getGlTextureId();

}