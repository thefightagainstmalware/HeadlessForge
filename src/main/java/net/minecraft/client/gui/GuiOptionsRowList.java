package net.minecraft.client.gui;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.google.common.collect.Lists;
import net.minecraft.client.settings.GameSettings;

/**
 *
 */
public class GuiOptionsRowList extends GuiListExtended {

    /**
     *
     */
    private final java.util.List<GuiOptionsRowList.Row> field_148184_k = Lists.<GuiOptionsRowList.Row>newArrayList();

    /**
     *
     */
    public GuiOptionsRowList(Minecraft mcIn,
                             int p_i45015_2_,
                             int p_i45015_3_,
                             int p_i45015_4_,
                             int p_i45015_5_,
                             int p_i45015_6_,
                             GameSettings.Options... p_i45015_7_) {
        super(mcIn, p_i45015_2_, p_i45015_3_, p_i45015_4_, p_i45015_5_, p_i45015_6_);
    }

    /**
     *
     */
    private GuiButton func_148182_a(Minecraft mcIn,
                                    int p_148182_2_,
                                    int p_148182_3_,
                                    GameSettings.Options p_148182_4_) {
        return null;
    }

    /**
     * Gets the IGuiListEntry object for the given index
     */
    public GuiOptionsRowList.Row getListEntry(int index) {
        return null;
    }

    /**
     *
     */
    protected int getSize() {
        return 0;
    }

    /**
     * Gets the width of the list
     */
    @Override
    public int getListWidth() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected int getScrollBarX() {
        return 0;
    }

    public class Row implements IGuiListEntry {
    }
}