package net.minecraft.client.gui;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.client.resources.I18n;
import java.io.IOException;

/**
 *
 */
public class GuiDownloadTerrain extends GuiScreen {

    /**
     *
     */
    private NetHandlerPlayClient netHandlerPlayClient;

    /**
     *
     */
    private int progress;

    /**
     *
     */
    public GuiDownloadTerrain(NetHandlerPlayClient netHandler) {
        
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
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    @Override
    public void initGui() {
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

}