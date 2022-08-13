package net.minecraft.client.gui.spectator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import java.util.List;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public interface ISpectatorMenuView {

    /**
     *
     */
    java.util.List<ISpectatorMenuObject> func_178669_a();

    /**
     *
     */
    IChatComponent func_178670_b();

}