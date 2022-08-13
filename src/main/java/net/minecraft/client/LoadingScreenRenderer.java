package net.minecraft.client;

import net.minecraft.util.IProgressUpdate;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.MinecraftError;

/**
 *
 */
public class LoadingScreenRenderer extends Object implements IProgressUpdate {

    /**
     *
     */
    private java.lang.String message;

    /**
     * A reference to the Minecraft object.
     */
    private Minecraft mc;

    /**
     * The text currently displayed (i.e. the argument to the last call to printText or func_73722_d)
     */
    private java.lang.String currentlyDisplayedText;

    /**
     * The system's time represented in milliseconds.
     */
    private long systemTime;

    /**
     *
     */
    private boolean field_73724_e;

    /**
     *
     */
    private ScaledResolution scaledResolution;

    /**
     *
     */
    private Framebuffer framebuffer;

    /**
     *
     */
    public LoadingScreenRenderer(Minecraft mcIn) {
        
    }

    /**
     * this string, followed by "working..." and then the "% complete" are the 3 lines shown. This resets progress to 0,
     * and the WorkingString to "working...".
     */
    public void resetProgressAndMessage(String message) {
        return;
    }

    /**
     * Shows the 'Saving level' string.
     */
    public void displaySavingString(String message) {
        return;
    }

    /**
     *
     */
    private void displayString(String message) {
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

}