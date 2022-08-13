package net.minecraft.client.gui;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.world.EnumDifficulty;

/**
 *
 */
public class GuiOptions extends GuiScreen implements GuiYesNoCallback {

    /**
     *
     */
    private static final GameSettings.Options[] field_146440_f = new GameSettings.Options[] {GameSettings.Options.FOV};
    /**
     *
     */
    private final GuiScreen field_146441_g;

    /**
     * Reference to the GameSettings object.
     */
    private final GameSettings game_settings_1;

    /**
     *
     */
    private GuiButton field_175357_i;

    /**
     *
     */
    private GuiLockIconButton field_175356_r;

    /**
     *
     */
    protected java.lang.String field_146442_a;

    /**
     *
     */
    public GuiOptions(GuiScreen p_i1046_1_,
                      GameSettings p_i1046_2_) {
        this.field_146441_g = p_i1046_1_;
        this.game_settings_1 = p_i1046_2_;
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
    public String func_175355_a(EnumDifficulty p_175355_1_) {
        return null;
    }

    /**
     *
     */
    @Override
    public void confirmClicked(boolean result,
                               int id) {
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

}