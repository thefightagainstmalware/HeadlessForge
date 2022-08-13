package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.Tezzelator;

/**
 *
 */
public class GuiClickableScrolledSelectionListProxy extends GuiSlot {

    /**
     *
     */
    private final RealmsClickableScrolledSelectionList field_178046_u;

    /**
     *
     */
    public GuiClickableScrolledSelectionListProxy(RealmsClickableScrolledSelectionList selectionList,
                                                  int p_i45526_2_,
                                                  int p_i45526_3_,
                                                  int p_i45526_4_,
                                                  int p_i45526_5_,
                                                  int p_i45526_6_) {
        super(Minecraft.func_71410_x(), p_i45526_2_, p_i45526_3_, p_i45526_4_, p_i45526_5_, p_i45526_6_);
        this.field_178046_u = selectionList;
    }

    /**
     *
     */
    protected int getSize() {
        return 0;
    }

    /**
     * The element in the slot that was clicked, boolean for whether it was double clicked or not
     */
    protected void elementClicked(int slotIndex,
                                  boolean isDoubleClick,
                                  int mouseX,
                                  int mouseY) {
        return;
    }

    /**
     * Returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int slotIndex) {
        return true;
    }

    /**
     *
     */
    protected void drawBackground() {
        return;
    }

    /**
     *
     */
    protected void drawSlot(int entryID,
                            int p_180791_2_,
                            int p_180791_3_,
                            int p_180791_4_,
                            int mouseXIn,
                            int mouseYIn) {
        return;
    }

    /**
     *
     */
    public int func_178044_e() {
        return 0;
    }

    /**
     *
     */
    public int func_178042_f() {
        return 0;
    }

    /**
     *
     */
    public int func_178045_g() {
        return 0;
    }

    /**
     * Return the height of the content being scrolled
     */
    @Override
    protected int getContentHeight() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected int getScrollBarX() {
        return 0;
    }

    /**
     *
     */
    @Override
    public void handleMouseInput() {
        return;
    }

    /**
     *
     */
    public void func_178043_a(int p_178043_1_,
                              int p_178043_2_,
                              int p_178043_3_,
                              Tezzelator p_178043_4_) {
        return;
    }

    /**
     * Draws the selection box around the selected slot element.
     */
    @Override
    protected void drawSelectionBox(int p_148120_1_,
                                    int p_148120_2_,
                                    int mouseXIn,
                                    int mouseYIn) {
        return;
    }

}