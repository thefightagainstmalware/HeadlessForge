package net.minecraft.client.renderer;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import java.awt.image.BufferedImage;

/**
 *
 */
public interface IImageBuffer {

    /**
     *
     */
    java.awt.image.BufferedImage parseUserSkin(java.awt.image.BufferedImage image);

    /**
     *
     */
    void skinAvailable();

}