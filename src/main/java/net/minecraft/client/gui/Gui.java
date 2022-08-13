package net.minecraft.client.gui;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

/**
 *
 */
public class Gui extends Object {

    /**
     *
     */
    public static final ResourceLocation optionsBackground = new ResourceLocation("textures/gui/options_background.png");

    /**
     *
     */
    public static final ResourceLocation statIcons = new ResourceLocation("textures/gui/container/stats_icons.png");

    /**
     *
     */
    public static final ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");

    /**
     *
     */
    protected float zLevel;

    /**
     *
     */
    public Gui() {
        
    }

    /**
     * Draw a 1 pixel wide horizontal line. Args: x1, x2, y, color
     */
    protected void drawHorizontalLine(int startX,
                                      int endX,
                                      int y,
                                      int color) {
        return;
    }

    /**
     * Draw a 1 pixel wide vertical line. Args : x, y1, y2, color
     */
    protected void drawVerticalLine(int x,
                                    int startY,
                                    int endY,
                                    int color) {
        return;
    }

    /**
     * Draws a solid color rectangle with the specified coordinates and color (ARGB format). Args: x1, y1, x2, y2, color
     */
    public static void drawRect(int left,
                                int top,
                                int right,
                                int bottom,
                                int color) {
        return;
    }

    /**
     * Draws a rectangle with a vertical gradient between the specified colors (ARGB format). Args : x1, y1, x2, y2,
     * topColor, bottomColor
     */
    protected void drawGradientRect(int left,
                                    int top,
                                    int right,
                                    int bottom,
                                    int startColor,
                                    int endColor) {
        return;
    }

    /**
     * Renders the specified text to the screen, center-aligned. Args : renderer, string, x, y, color
     */
    public void drawCenteredString(FontRenderer fontRendererIn,
                                   String text,
                                   int x,
                                   int y,
                                   int color) {
        return;
    }

    /**
     * Renders the specified text to the screen. Args : renderer, string, x, y, color
     */
    public void drawString(FontRenderer fontRendererIn,
                           String text,
                           int x,
                           int y,
                           int color) {
        return;
    }

    /**
     * Draws a textured rectangle at the stored z-value. Args: x, y, u, v, width, height
     */
    public void drawTexturedModalRect(int x,
                                      int y,
                                      int textureX,
                                      int textureY,
                                      int width,
                                      int height) {
        return;
    }

    /**
     * Draws a textured rectangle using the texture currently bound to the TextureManager
     */
    public void drawTexturedModalRect(float xCoord,
                                      float yCoord,
                                      int minU,
                                      int minV,
                                      int maxU,
                                      int maxV) {
        return;
    }

    /**
     * Draws a texture rectangle using the texture currently bound to the TextureManager
     */
    public void drawTexturedModalRect(int xCoord,
                                      int yCoord,
                                      TextureAtlasSprite textureSprite,
                                      int widthIn,
                                      int heightIn) {
        return;
    }

    /**
     * Draws a textured rectangle at z = 0. Args: x, y, u, v, width, height, textureWidth, textureHeight
     */
    public static void drawModalRectWithCustomSizedTexture(int x,
                                                           int y,
                                                           float u,
                                                           float v,
                                                           int width,
                                                           int height,
                                                           float textureWidth,
                                                           float textureHeight) {
        return;
    }

    /**
     * Draws a scaled, textured, tiled modal rect at z = 0. This method isn't used anywhere in vanilla code.
     */
    public static void drawScaledCustomSizeModalRect(int x,
                                                     int y,
                                                     float u,
                                                     float v,
                                                     int uWidth,
                                                     int vHeight,
                                                     int width,
                                                     int height,
                                                     float tileWidth,
                                                     float tileHeight) {
        return;
    }

}