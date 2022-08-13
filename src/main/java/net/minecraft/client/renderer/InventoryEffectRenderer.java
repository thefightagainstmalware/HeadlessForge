package net.minecraft.client.renderer;

import net.minecraft.inventory.Container;
import net.minecraft.potion.PotionEffect;
import java.util.Collection;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;

/**
 *
 */
public abstract class InventoryEffectRenderer extends GuiContainer {

    /**
     * True if there is some potion effect to display
     */
    private boolean hasActivePotionEffects;

    /**
     *
     */
    public InventoryEffectRenderer(Container inventorySlotsIn) {
        super(inventorySlotsIn);
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
     *
     */
    protected void updateActivePotionEffects() {
        return;
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    @Override
    public void drawScreen(int mouseX,
                           int mouseY,
                           float partialTicks) {
        return;
    }

    /**
     * Display the potion effects list
     */
    private void drawActivePotionEffects() {
        return;
    }

}