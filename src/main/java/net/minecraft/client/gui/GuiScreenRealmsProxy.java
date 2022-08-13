package net.minecraft.client.gui;

import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.google.common.collect.Lists;
import java.util.Collections;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsButton;
import java.io.IOException;

/**
 *
 */
public class GuiScreenRealmsProxy extends GuiScreen {

    /**
     *
     */
    private RealmsScreen field_154330_a;

    /**
     *
     */
    public GuiScreenRealmsProxy(RealmsScreen p_i1087_1_) {
        
    }

    /**
     *
     */
    public RealmsScreen func_154321_a() {
        return null;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
    public void initGui() {
        return;
    }

    /**
     *
     */
    public void func_154325_a(String p_154325_1_,
                              int p_154325_2_,
                              int p_154325_3_,
                              int p_154325_4_) {
        return;
    }

    /**
     *
     */
    public void func_154322_b(String p_154322_1_,
                              int p_154322_2_,
                              int p_154322_3_,
                              int p_154322_4_,
                              boolean p_154322_5_) {
        return;
    }

    /**
     * Draws a textured rectangle at the stored z-value. Args: x, y, u, v, width, height
     */
    @Override
    public void drawTexturedModalRect(int x,
                                      int y,
                                      int textureX,
                                      int textureY,
                                      int width,
                                      int height) {
        return;
    }

    /**
     * Draws a rectangle with a vertical gradient between the specified colors (ARGB format). Args : x1, y1, x2, y2,
     * topColor, bottomColor
     */
    @Override
    public void drawGradientRect(int left,
                                 int top,
                                 int right,
                                 int bottom,
                                 int startColor,
                                 int endColor) {
        return;
    }

    /**
     * Draws either a gradient over the background screen (when it exists) or a flat gradient over background.png
     */
    @Override
    public void drawDefaultBackground() {
        return;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    /**
     *
     */
    @Override
    public void drawWorldBackground(int tint) {
        return;
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    @Override
    public void drawScreen(int mouseX,
                           int mouseY,
                           float partialTicks) {
        return;
    }

    /**
     *
     */
    @Override
    public void renderToolTip(ItemStack stack,
                              int x,
                              int y) {
        return;
    }

    /**
     * Draws the text when mouse is over creative inventory tab. Params: current creative tab to be checked, current
     * mouse x position, current mouse y position.
     */
    @Override
    public void drawCreativeTabHoveringText(String tabName,
                                            int mouseX,
                                            int mouseY) {
        return;
    }

    /**
     * Draws a List of strings as a tooltip. Every entry is drawn on a seperate line.
     */
    @Override
    public void drawHoveringText(java.util.List<String> textLines,
                                 int x,
                                 int y) {
        return;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        return;
    }

    /**
     *
     */
    public int func_154329_h() {
        return 0;
    }

    /**
     *
     */
    public int func_154326_c(String p_154326_1_) {
        return 0;
    }

    /**
     *
     */
    public void func_154319_c(String p_154319_1_,
                              int p_154319_2_,
                              int p_154319_3_,
                              int p_154319_4_) {
        return;
    }

    /**
     *
     */
    public java.util.List<String> func_154323_a(String p_154323_1_,
                                                          int p_154323_2_) {
        return null;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     * @throws java.io.IOException
     */
    @Override
    public final void actionPerformed(GuiButton button)
                               throws java.io.IOException {
        return;
    }

    /**
     *
     */
    public void func_154324_i() {
        return;
    }

    /**
     *
     */
    public void func_154327_a(RealmsButton p_154327_1_) {
        return;
    }

    /**
     *
     */
    public java.util.List<RealmsButton> func_154320_j() {
        return null;
    }

    /**
     *
     */
    public void func_154328_b(RealmsButton p_154328_1_) {
        return;
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     * @throws java.io.IOException
     */
    @Override
    public void mouseClicked(int mouseX,
                             int mouseY,
                             int mouseButton)
                      throws java.io.IOException {
        return;
    }

    /**
     * Handles mouse input.
     * @throws java.io.IOException
     */
    @Override
    public void handleMouseInput()
                          throws java.io.IOException {
        return;
    }

    /**
     * Handles keyboard input.
     * @throws java.io.IOException
     */
    @Override
    public void handleKeyboardInput()
                             throws java.io.IOException {
        return;
    }

    /**
     * Called when a mouse button is released.  Args : mouseX, mouseY, releaseButton
     */
    @Override
    public void mouseReleased(int mouseX,
                              int mouseY,
                              int state) {
        return;
    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. Parameters are : mouseX, mouseY,
     * lastButtonClicked &amp; timeSinceMouseClick.
     */
    @Override
    public void mouseClickMove(int mouseX,
                               int mouseY,
                               int clickedMouseButton,
                               long timeSinceLastClick) {
        return;
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     * @throws java.io.IOException
     */
    @Override
    public void keyTyped(char typedChar,
                         int keyCode)
                  throws java.io.IOException {
        return;
    }

    /**
     *
     */
    @Override
    public void confirmClicked(boolean result,
                               int id) {
        return;
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
    public void onGuiClosed() {
        return;
    }

}