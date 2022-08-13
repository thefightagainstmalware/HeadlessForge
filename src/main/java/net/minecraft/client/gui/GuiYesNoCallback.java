package net.minecraft.client.gui;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public interface GuiYesNoCallback {

    /**
     *
     */
    void confirmClicked(boolean result,
                        int id);

}