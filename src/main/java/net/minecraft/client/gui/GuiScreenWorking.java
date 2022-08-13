package net.minecraft.client.gui;

import net.minecraft.util.IProgressUpdate;

/**
 *
 */
public class GuiScreenWorking extends GuiScreen implements IProgressUpdate {

    /**
     *
     */
    private java.lang.String field_146591_a;

    /**
     *
     */
    private java.lang.String field_146589_f;

    /**
     *
     */
    private int progress;

    /**
     *
     */
    private boolean doneWorking;

    /**
     *
     */
    public GuiScreenWorking() {
        
    }

    /**
     * Shows the 'Saving level' string.
     */
    public void displaySavingString(String message) {
        return;
    }

    /**
     * this string, followed by "working..." and then the "% complete" are the 3 lines shown. This resets progress to 0,
     * and the WorkingString to "working...".
     */
    public void resetProgressAndMessage(String message) {
        return;
    }

    /**
     * Displays a string on the loading screen supposed to indicate what is being done currently.
     */
    public void displayLoadingString(String message) {
        return;
    }

    /**
     * Updates the progress bar on the loading screen to the specified amount. Args: loadProgress
     */
    public void setLoadingProgress(int progress) {
        return;
    }

    /**
     *
     */
    public void setDoneWorking() {
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