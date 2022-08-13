package net.minecraft.client.gui;

import net.minecraft.util.EnumChatFormatting;

/**
 *
 */
public class GuiGameOver extends GuiScreen implements GuiYesNoCallback {

    /**
     * The integer value containing the number of ticks that have passed since the player's death
     */
    private int enableButtonsTimer;

    /**
     *
     */
    private boolean field_146346_f;

    /**
     *
     */
    public GuiGameOver() {
        
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
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     * @throws java.io.IOException
     */
    @Override
    protected void keyTyped(char typedChar,
                            int keyCode)
                     throws java.io.IOException {
        return;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     * @throws java.io.IOException
     */
    @Override
    protected void actionPerformed(GuiButton button)
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
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    @Override
    public void drawScreen(int mouseX,
                           int mouseY,
                           float partialTicks) {
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
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        return;
    }

}