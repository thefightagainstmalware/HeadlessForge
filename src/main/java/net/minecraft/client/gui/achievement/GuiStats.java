package net.minecraft.client.gui.achievement;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.item.Item;
import net.minecraft.stats.StatFileWriter;

/**
 *
 */
public class GuiStats extends GuiScreen implements IProgressMeter {

    /**
     *
     */
    protected GuiScreen parentScreen;

    /**
     *
     */
    protected java.lang.String screenTitle;

    /**
     *
     */
    private GuiStats.StatsGeneral generalStats;

    /**
     *
     */
    private GuiStats.StatsItem itemStats;

    /**
     *
     */
    private GuiStats.StatsBlock blockStats;

    /**
     *
     */
    private GuiStats.StatsMobsList mobStats;

    /**
     *
     */
    private StatFileWriter field_146546_t;

    /**
     *
     */
    private GuiSlot displaySlot;

    /**
     * When true, the game will be paused when the gui is shown
     */
    private boolean doesGuiPauseGame;

    /**
     *
     */
    public GuiStats(GuiScreen p_i1071_1_,
                    StatFileWriter p_i1071_2_) {
        
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
     * Handles mouse input.
     * @throws java.io.IOException
     */
    @Override
    public void handleMouseInput()
                          throws java.io.IOException {
        return;
    }

    /**
     *
     */
    public void func_175366_f() {
        return;
    }

    /**
     *
     */
    public void createButtons() {
        return;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     * @throws java.io.IOException
     */
    @Override
    protected void actionPerformed(GuiButton button)
                            throws java.io.IOException {
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
     *
     */
    public void doneLoading() {
        return;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    /**
     *
     */
    private void drawStatsScreen(int p_146521_1_,
                                 int p_146521_2_,
                                 Item p_146521_3_) {
        return;
    }

    /**
     * Draws a gray box that serves as a button background.
     */
    private void drawButtonBackground(int p_146531_1_,
                                      int p_146531_2_) {
        return;
    }

    /**
     * Draws a sprite from assets/textures/gui/container/stats_icons.png
     */
    private void drawSprite(int p_146527_1_,
                            int p_146527_2_,
                            int p_146527_3_,
                            int p_146527_4_) {
        return;
    }

    public class StatsGeneral {
    }

    public class StatsBlock {
    }

    public class StatsItem {
    }

    public class StatsMobsList {
    }
}