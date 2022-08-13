package net.minecraft.client.gui;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class GuiListButton extends GuiButton {

    /**
     *
     */
    private boolean field_175216_o;

    /**
     * The localization string used by this control.
     */
    private java.lang.String localizationStr;

    /**
     * The GuiResponder Object reference.
     */
    private final GuiPageButtonList.GuiResponder guiResponder = null;
    /**
     *
     */
    public GuiListButton(GuiPageButtonList.GuiResponder responder,
                         int p_i45539_2_,
                         int p_i45539_3_,
                         int p_i45539_4_,
                         String p_i45539_5_,
                         boolean p_i45539_6_) {
        super(p_i45539_2_, p_i45539_3_, p_i45539_4_, p_i45539_5_);
    }

    /**
     * Builds the localized display string for this GuiListButton
     */
    private String buildDisplayString() {
        return null;
    }

    /**
     *
     */
    public void func_175212_b(boolean p_175212_1_) {
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

}