package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;

/**
 *
 */
public class GuiOverlayDebug extends Gui {

    /**
     *
     */
    private final Minecraft mc;

    /**
     *
     */
    private final FontRenderer fontRenderer;

    /**
     *
     */
    public GuiOverlayDebug(Minecraft mc) {
        this.mc = mc;
        this.fontRenderer = mc.fontRendererObj;
    }

    /**
     *
     */
    public void renderDebugInfo(ScaledResolution scaledResolutionIn) {
        return;
    }

    /**
     *
     */
    private boolean isReducedDebug() {
        return true;
    }

    /**
     *
     */
    protected void renderDebugInfoLeft() {
        return;
    }

    /**
     *
     */
    protected void renderDebugInfoRight(ScaledResolution p_175239_1_) {
        return;
    }

    /**
     *
     */
    protected java.util.List<String> call() {
        return null;
    }

    /**
     *
     */
    protected java.util.List<String> getDebugInfoRight() {
        return null;
    }

    /**
     *
     */
    private void renderLagometer() {
        return;
    }

    /**
     *
     */
    private int func_181552_c(int p_181552_1_,
                              int p_181552_2_,
                              int p_181552_3_,
                              int p_181552_4_) {
        return 0;
    }

    /**
     *
     */
    private int func_181553_a(int p_181553_1_,
                              int p_181553_2_,
                              float p_181553_3_) {
        return 0;
    }

    /**
     *
     */
    private static long bytesToMb(long bytes) {
        return 0;
    }

}