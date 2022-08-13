package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 *
 */
public class GuiContainerCreative extends InventoryEffectRenderer {

    /**
     * The location of the creative inventory tabs texture
     */
    private static final ResourceLocation creativeInventoryTabs = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");

    /**
     *
     */
    private static InventoryBasic field_147060_v;

    /**
     * Currently selected creative inventory tab index.
     */
    private static int selectedTabIndex;

    /**
     * Amount scrolled in Creative mode inventory (0 = top, 1 = bottom)
     */
    private float currentScroll;

    /**
     * True if the scrollbar is being dragged
     */
    private boolean isScrolling;

    /**
     * True if the left mouse button was held down last time drawScreen was called.
     */
    private boolean wasClicking;

    /**
     *
     */
    private GuiTextField searchField;

    /**
     *
     */
    private java.util.List<Slot> field_147063_B;

    /**
     *
     */
    private Slot field_147064_C;

    /**
     *
     */
    private boolean field_147057_D;

    /**
     *
     */
    private CreativeCrafting field_147059_E;

    /**
     *
     */
    private static int tabPage;

    /**
     *
     */
    private int maxPages;

    /**
     *
     */
    public GuiContainerCreative(EntityPlayer p_i1088_1_) {
        super(p_i1088_1_.field_71069_bz);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        return;
    }

    /**
     * Called when the mouse is clicked over a slot or outside the gui.
     */
    @Override
    protected void handleMouseClick(Slot slotIn,
                                    int slotId,
                                    int clickedButton,
                                    int clickType) {
        return;
    }

    /**
     *
     */
    @Override
    protected void updateActivePotionEffects() {
        return;
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
     *
     */
    private void updateCreativeSearch() {
        return;
    }

    /**
     *
     */
    private void updateFilteredItems(GuiContainerCreative.ContainerCreative guicontainercreative$containercreative) {
        return;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX,
                                                   int mouseY) {
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
     * Called when a mouse button is released.  Args : mouseX, mouseY, releaseButton
     */
    @Override
    protected void mouseReleased(int mouseX,
                                 int mouseY,
                                 int state) {
        return;
    }

    /**
     * returns (if you are not on the inventoryTab) and (the flag isn't set) and (you have more than 1 page of items)
     */
    private boolean needsScrollBars() {
        return true;
    }

    /**
     *
     */
    private void setCurrentCreativeTab(CreativeTabs p_147050_1_) {
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
    protected void renderToolTip(ItemStack stack,
                                 int x,
                                 int y) {
        return;
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks,
                                                   int mouseX,
                                                   int mouseY) {
        return;
    }

    /**
     *
     */
    protected boolean func_147049_a(CreativeTabs p_147049_1_,
                                    int p_147049_2_,
                                    int p_147049_3_) {
        return true;
    }

    /**
     * Renders the creative inventory hovering text if mouse is over it. Returns true if did render or false otherwise.
     * Params: current creative tab to be checked, current mouse x position, current mouse y position.
     */
    protected boolean renderCreativeInventoryHoveringText(CreativeTabs p_147052_1_,
                                                          int p_147052_2_,
                                                          int p_147052_3_) {
        return true;
    }

    /**
     *
     */
    protected void func_147051_a(CreativeTabs p_147051_1_) {
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
    public int getSelectedTabIndex() {
        return 0;
    }

    public class ContainerCreative {
    }
}