package net.minecraft.client.gui;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.realms.RealmsButton;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class GuiButtonRealmsProxy extends GuiButton {

    /**
     *
     */
    private RealmsButton realmsButton;

    /**
     *
     */
    public GuiButtonRealmsProxy(RealmsButton realmsButtonIn,
                                int buttonId,
                                int x,
                                int y,
                                String text) {
        super(buttonId, x, y, text);
    }

    /**
     *
     */
    public GuiButtonRealmsProxy(RealmsButton realmsButtonIn,
                                int buttonId,
                                int x,
                                int y,
                                String text,
                                int widthIn,
                                int heightIn) {
        super(buttonId, x, y, widthIn, heightIn, text);
    }

    /**
     *
     */
    public int getId() {
        return 0;
    }

    /**
     *
     */
    public boolean getEnabled() {
        return true;
    }

    /**
     *
     */
    public void setEnabled(boolean isEnabled) {
        return;
    }

    /**
     *
     */
    public void setText(String text) {
        return;
    }

    /**
     *
     */
    @Override
    public int getButtonWidth() {
        return 0;
    }

    /**
     *
     */
    public int getPositionY() {
        return 0;
    }

    /**
     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
     * e).
     */
    @Override
    public boolean mousePressed(Minecraft mc,
                                int mouseX,
                                int mouseY) {
        return true;
    }

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    @Override
    public void mouseReleased(int mouseX,
                              int mouseY) {
        return;
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    @Override
    public void mouseDragged(Minecraft mc,
                             int mouseX,
                             int mouseY) {
        return;
    }

    /**
     *
     */
    public RealmsButton getRealmsButton() {
        return null;
    }

    /**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
    @Override
    public int getHoverState(boolean mouseOver) {
        return 0;
    }

    /**
     *
     */
    public int func_154312_c(boolean p_154312_1_) {
        return 0;
    }

    /**
     *
     */
    public int getHeight() {
        return 0;
    }

}