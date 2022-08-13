package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.tileentity.TileEntitySign;

/**
 *
 */
public class GuiEditSign extends GuiScreen {

    /**
     * Reference to the sign object.
     */
    private TileEntitySign tileSign;

    /**
     * Counts the number of screen updates.
     */
    private int updateCounter;

    /**
     * The index of the line that is being edited.
     */
    private int editLine;

    /**
     * "Done" button for the GUI.
     */
    private GuiButton doneBtn;

    /**
     *
     */
    public GuiEditSign(TileEntitySign teSign) {
        
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
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    @Override
    public void onGuiClosed() {
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
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     * @throws java.io.IOException
     */
    @Override
    protected void actionPerformed(GuiButton button)
                            throws java.io.IOException {
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
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    @Override
    public void drawScreen(int mouseX,
                           int mouseY,
                           float partialTicks) {
        return;
    }

}