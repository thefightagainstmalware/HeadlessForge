package net.minecraft.client.gui;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.Minecraft;

/**
 *
 */
public abstract class GuiListExtended extends GuiSlot {

    /**
     *
     */
    public GuiListExtended(Minecraft mcIn,
                           int widthIn,
                           int heightIn,
                           int topIn,
                           int bottomIn,
                           int slotHeightIn) {
        super(mcIn, widthIn, heightIn, topIn, bottomIn, slotHeightIn);
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
    @Override
    protected void func_178040_a(int p_178040_1_,
                                 int p_178040_2_,
                                 int p_178040_3_) {
        return;
    }

    /**
     *
     */
    public boolean mouseClicked(int mouseX,
                                int mouseY,
                                int mouseEvent) {
        return true;
    }

    /**
     *
     */
    public boolean mouseReleased(int p_148181_1_,
                                 int p_148181_2_,
                                 int p_148181_3_) {
        return true;
    }

    /**
     * Gets the IGuiListEntry object for the given index
     */
    public abstract GuiListExtended.IGuiListEntry getListEntry(int index);

    public interface IGuiListEntry {
    }
}