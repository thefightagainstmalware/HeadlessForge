package net.minecraft.client.gui;

import org.apache.logging.log4j.Logger;

/**
 *
 */
public class GuiChat extends GuiScreen {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private java.lang.String historyBuffer;

    /**
     * keeps position of which chat message you will select when you press up, (does not increase for duplicated
     * messages sent immediately after each other)
     */
    private int sentHistoryCursor;

    /**
     *
     */
    private boolean playerNamesFound;

    /**
     *
     */
    private boolean waitingOnAutocomplete;

    /**
     *
     */
    private int autocompleteIndex;

    /**
     *
     */
    private java.util.List<java.lang.String> foundPlayerNames;

    /**
     * Chat entry field
     */
    protected GuiTextField inputField;

    /**
     * is the text that appears when you press the chat key and the input box appears pre-filled
     */
    private java.lang.String defaultInputFieldText;

    /**
     *
     */
    public GuiChat() {
        
    }

    /**
     *
     */
    public GuiChat(String defaultText) {
        
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
     * Handles mouse input.
     * @throws java.io.IOException
     */
    @Override
    public void handleMouseInput()
                          throws java.io.IOException {
        return;
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     * @throws java.io.IOException
     */
    @Override
    protected void mouseClicked(int mouseX,
                                int mouseY,
                                int mouseButton)
                         throws java.io.IOException {
        return;
    }

    /**
     * Sets the text of the chat
     */
    @Override
    protected void setText(String newChatText,
                           boolean shouldOverwrite) {
        return;
    }

    /**
     *
     */
    public void autocompletePlayerNames() {
        return;
    }

    /**
     *
     */
    private void sendAutocompleteRequest(String p_146405_1_,
                                         String p_146405_2_) {
        return;
    }

    /**
     * input is relative and is applied directly to the sentHistoryCursor so -1 is the previous message, 1 is the next
     * message from the current cursor position
     */
    public void getSentHistory(int msgPos) {
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
    public void onAutocompleteResponse(String[] p_146406_1_) {
        return;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

}