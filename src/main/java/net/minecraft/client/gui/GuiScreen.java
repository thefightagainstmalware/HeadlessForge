package net.minecraft.client.gui;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.IChatComponent;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public abstract class GuiScreen extends Gui implements GuiYesNoCallback {

    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     *
     */
    private static final java.util.Set<java.lang.String> PROTOCOLS = Sets.newHashSet();

    /**
     *
     */
    private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n');

    /**
     * Reference to the Minecraft object.
     */
    public Minecraft mc;

    /**
     * Holds a instance of RenderItem, used to draw the achievement icons on screen (is based on ItemStack)
     */
    protected RenderItem itemRender;

    /**
     * The width of the screen object.
     */
    public int width;

    /**
     * The height of the screen object.
     */
    public int height;

    /**
     *
     */
    protected java.util.List<GuiButton> buttonList;

    /**
     *
     */
    protected java.util.List<GuiLabel> labelList;

    /**
     *
     */
    public boolean allowUserInput;

    /**
     * The FontRenderer used by GuiScreen
     */
    protected FontRenderer fontRendererObj;

    /**
     * The button that was just pressed.
     */
    private GuiButton selectedButton;

    /**
     *
     */
    private int eventButton;

    /**
     *
     */
    private long lastMouseEvent;

    /**
     * Incremented when the game is in touchscreen mode and the screen is tapped, decremented if the screen isn't
     * tapped. Does not appear to be used.
     */
    private int touchValue;

    /**
     *
     */
    private java.net.URI clickedLinkURI;

    /**
     *
     */
    public GuiScreen() {

    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX,
                           int mouseY,
                           float partialTicks) {
        return;
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     * @throws java.io.IOException
     */
    protected void keyTyped(char typedChar,
                            int keyCode)
                     throws java.io.IOException {
        return;
    }

    /**
     * Returns a string stored in the system clipboard.
     */
    public static String getClipboardString() {
        return null;
    }

    /**
     * Stores the given string in the system clipboard
     */
    public static void setClipboardString(String copyText) {
        return;
    }

    /**
     *
     */
    protected void renderToolTip(ItemStack stack,
                                 int x,
                                 int y) {
        return;
    }

    /**
     * Draws the text when mouse is over creative inventory tab. Params: current creative tab to be checked, current
     * mouse x position, current mouse y position.
     */
    protected void drawCreativeTabHoveringText(String tabName,
                                               int mouseX,
                                               int mouseY) {
        return;
    }

    /**
     * Draws a List of strings as a tooltip. Every entry is drawn on a seperate line.
     */
    protected void drawHoveringText(java.util.List<String> textLines,
                                    int x,
                                    int y) {
        return;
    }

    /**
     *
     */
    protected void drawHoveringText(java.util.List<String> textLines,
                                    int x,
                                    int y,
                                    FontRenderer font) {
        return;
    }

    /**
     * Draws the hover event specified by the given chat component
     */
    protected void handleComponentHover(IChatComponent p_175272_1_,
                                        int p_175272_2_,
                                        int p_175272_3_) {
        return;
    }

    /**
     * Sets the text of the chat
     */
    protected void setText(String newChatText,
                           boolean shouldOverwrite) {
        return;
    }

    /**
     * Executes the click event specified by the given chat component
     */
    protected boolean handleComponentClick(IChatComponent p_175276_1_) {
        return true;
    }

    /**
     *
     */
    public void sendChatMessage(String msg) {
        return;
    }

    /**
     *
     */
    public void sendChatMessage(String msg,
                                boolean addToChat) {
        return;
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     * @throws java.io.IOException
     */
    protected void mouseClicked(int mouseX,
                                int mouseY,
                                int mouseButton)
                         throws java.io.IOException {
        return;
    }

    /**
     * Called when a mouse button is released.  Args : mouseX, mouseY, releaseButton
     */
    protected void mouseReleased(int mouseX,
                                 int mouseY,
                                 int state) {
        return;
    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. Parameters are : mouseX, mouseY,
     * lastButtonClicked &amp; timeSinceMouseClick.
     */
    protected void mouseClickMove(int mouseX,
                                  int mouseY,
                                  int clickedMouseButton,
                                  long timeSinceLastClick) {
        return;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     * @throws java.io.IOException
     */
    protected void actionPerformed(GuiButton button)
                            throws java.io.IOException {
        return;
    }

    /**
     * Causes the screen to lay out its subcomponents again. This is the equivalent of the Java call
     * Container.validate()
     */
    public void setWorldAndResolution(Minecraft mc,
                                      int width,
                                      int height) {
        return;
    }

    /**
     *
     */
    public void func_183500_a(int p_183500_1_,
                              int p_183500_2_) {
        return;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui() {
        return;
    }

    /**
     * Delegates mouse and keyboard input.
     * @throws java.io.IOException
     */
    public void handleInput()
                     throws java.io.IOException {
        return;
    }

    /**
     * Handles mouse input.
     * @throws java.io.IOException
     */
    public void handleMouseInput()
                          throws java.io.IOException {
        return;
    }

    /**
     * Handles keyboard input.
     * @throws java.io.IOException
     */
    public void handleKeyboardInput()
                             throws java.io.IOException {
        return;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen() {
        return;
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed() {
        return;
    }

    /**
     * Draws either a gradient over the background screen (when it exists) or a flat gradient over background.png
     */
    public void drawDefaultBackground() {
        return;
    }

    /**
     *
     */
    public void drawWorldBackground(int tint) {
        return;
    }

    /**
     * Draws the background (i is always 0 as of 1.2.2)
     */
    public void drawBackground(int tint) {
        return;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame() {
        return true;
    }

    /**
     *
     */
    public void confirmClicked(boolean result,
                               int id) {
        return;
    }

    /**
     *
     */
    private void openWebLink(java.net.URI p_175282_1_) {
        return;
    }

    /**
     * Returns true if either windows ctrl key is down or if either mac meta key is down
     */
    public static boolean isCtrlKeyDown() {
        return true;
    }

    /**
     * Returns true if either shift key is down
     */
    public static boolean isShiftKeyDown() {
        return true;
    }

    /**
     * Returns true if either alt key is down
     */
    public static boolean isAltKeyDown() {
        return true;
    }

    /**
     *
     */
    public static boolean isKeyComboCtrlX(int p_175277_0_) {
        return true;
    }

    /**
     *
     */
    public static boolean isKeyComboCtrlV(int p_175279_0_) {
        return true;
    }

    /**
     *
     */
    public static boolean isKeyComboCtrlC(int p_175280_0_) {
        return true;
    }

    /**
     *
     */
    public static boolean isKeyComboCtrlA(int p_175278_0_) {
        return true;
    }

    /**
     * Called when the GUI is resized in order to update the world and the resolution
     */
    public void onResize(Minecraft mcIn,
                         int p_175273_2_,
                         int p_175273_3_) {
        return;
    }

}