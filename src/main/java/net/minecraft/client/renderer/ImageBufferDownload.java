package net.minecraft.client.renderer;

import java.awt.Graphics;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.awt.image.ImageObserver;
import java.awt.image.DataBufferInt;
import java.awt.image.BufferedImage;

/**
 *
 */
public class ImageBufferDownload extends Object implements IImageBuffer {

    /**
     *
     */
    private int[] imageData;

    /**
     *
     */
    private int imageWidth;

    /**
     *
     */
    private int imageHeight;

    /**
     *
     */
    public ImageBufferDownload() {
        
    }

    /**
     *
     */
    public java.awt.image.BufferedImage parseUserSkin(java.awt.image.BufferedImage image) {
        return null;
    }

    /**
     *
     */
    public void skinAvailable() {
        return;
    }

    /**
     * Makes the given area of the image transparent if it was previously completely opaque (used to remove the outer
     * layer of a skin around the head if it was saved all opaque; this would be redundant so it's assumed that the skin
     * maker is just using an image editor without an alpha channel)
     */
    private void setAreaTransparent(int p_78434_1_,
                                    int p_78434_2_,
                                    int p_78434_3_,
                                    int p_78434_4_) {
        return;
    }

    /**
     * Makes the given area of the image opaque
     */
    private void setAreaOpaque(int p_78433_1_,
                               int p_78433_2_,
                               int p_78433_3_,
                               int p_78433_4_) {
        return;
    }

    /**
     * Returns true if the given area of the image contains transparent pixels
     */
    private boolean hasTransparency(int p_78435_1_,
                                    int p_78435_2_,
                                    int p_78435_3_,
                                    int p_78435_4_) {
        return true;
    }

}