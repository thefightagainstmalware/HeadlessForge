package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

/**
 *
 */
public class GuiKeyBindingList extends GuiListExtended {

    /**
     *
     */
    private final GuiControls field_148191_k;

    /**
     *
     */
    private final Minecraft mc;

    /**
     *
     */
    private final GuiListExtended.IGuiListEntry[] listEntries = null;

    /**
     *
     */
    private int maxListLabelWidth;

    /**
     *
     */
    public GuiKeyBindingList(GuiControls controls,
                             Minecraft mcIn) {
        super(mcIn, controls.width, controls.height, 32, controls.height - 32, 20);
        this.mc = mcIn;
        this.field_148191_k = controls;

    }

    /**
     *
     */
    protected int getSize() {
        return 0;
    }

    /**
     * Gets the IGuiListEntry object for the given index
     */
    public GuiListExtended.IGuiListEntry getListEntry(int index) {
        return null;
    }

    /**
     *
     */
    @Override
    protected int getScrollBarX() {
        return 0;
    }

    /**
     * Gets the width of the list
     */
    @Override
    public int getListWidth() {
        return 0;
    }

}