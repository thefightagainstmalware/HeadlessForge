package net.minecraft.client.gui;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.client.resources.I18n;
import java.io.IOException;

/**
 *
 */
public class GuiSleepMP extends GuiChat {

    /**
     *
     */
    public GuiSleepMP() {
        
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
    private void wakeFromSleep() {
        return;
    }

}