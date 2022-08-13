package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;

/**
 *
 */
public class GuiSlider extends GuiButton {

    /**
     *
     */
    private float sliderPosition;

    /**
     *
     */
    public boolean isMouseDown;

    /**
     *
     */
    private java.lang.String name;

    /**
     *
     */
    private final float min;

    /**
     *
     */
    private final float max;

    /**
     *
     */
    private final GuiPageButtonList.GuiResponder responder;

    /**
     *
     */
    private GuiSlider.FormatHelper formatHelper;

    /**
     *
     */
    public GuiSlider(GuiPageButtonList.GuiResponder guiResponder,
                     int idIn,
                     int x,
                     int y,
                     String name,
                     float min,
                     float max,
                     float defaultValue,
                     GuiSlider.FormatHelper formatter) {
        super(idIn, x, y, 150, 20, name);
        this.name = name;
        this.min = min;
        this.max = max;
        this.sliderPosition = defaultValue;
        this.formatHelper = formatter;
        this.responder = guiResponder;
    }

    /**
     *
     */
    public float func_175220_c() {
        return 0;
    }

    /**
     *
     */
    public void func_175218_a(float p_175218_1_,
                              boolean p_175218_2_) {
        return;
    }

    /**
     *
     */
    public float func_175217_d() {
        return 0;
    }

    /**
     *
     */
    private String getDisplayString() {
        return null;
    }

    /**
     * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over this button and 2 if it IS hovering over
     * this button.
     */
    @Override
    protected int getHoverState(boolean mouseOver) {
        return 0;
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    @Override
    protected void mouseDragged(Minecraft mc,
                                int mouseX,
                                int mouseY) {
        return;
    }

    /**
     *
     */
    public void func_175219_a(float p_175219_1_) {
        return;
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

    public interface FormatHelper {
    }
}