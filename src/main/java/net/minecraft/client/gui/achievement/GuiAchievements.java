package net.minecraft.client.gui.achievement;

import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class GuiAchievements extends GuiScreen implements IProgressMeter
{
    private static final int field_146572_y = AchievementList.minDisplayColumn * 24 - 112;
    private static final int field_146571_z = AchievementList.minDisplayRow * 24 - 112;
    private static final int field_146559_A = AchievementList.maxDisplayColumn * 24 - 77;
    private static final int field_146560_B = AchievementList.maxDisplayRow * 24 - 77;
    private static final ResourceLocation ACHIEVEMENT_BACKGROUND = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    protected GuiScreen parentScreen;
    protected int field_146555_f = 256;
    protected int field_146557_g = 202;
    protected int field_146563_h;
    protected int field_146564_i;
    protected float field_146570_r = 1.0F;
    protected double field_146569_s;
    protected double field_146568_t;
    protected double field_146567_u;
    protected double field_146566_v;
    protected double field_146565_w;
    protected double field_146573_x;
    private int field_146554_D;
    private StatFileWriter statFileWriter;
    private boolean loadingAchievements = true;

    public GuiAchievements(GuiScreen parentScreenIn, StatFileWriter statFileWriterIn)
    {
        this.parentScreen = parentScreenIn;
        this.statFileWriter = statFileWriterIn;
        int i = 141;
        int j = 141;
        this.field_146569_s = this.field_146567_u = this.field_146565_w = (double)(AchievementList.openInventory.displayColumn * 24 - i / 2 - 12);
        this.field_146568_t = this.field_146566_v = this.field_146573_x = (double)(AchievementList.openInventory.displayRow * 24 - j / 2);
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        this.buttonList.clear();
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 24, this.height / 2 + 74, 80, 20, I18n.format("gui.done", new Object[0])));
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException {}

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is the equivalent of
     * KeyListener.keyTyped(KeyEvent e). Args : character (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException {}

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        if (this.loadingAchievements)
        {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats", new Object[0]), this.width / 2, this.height / 2, 16777215);
            this.drawCenteredString(this.fontRendererObj, lanSearchStates[(int)(Minecraft.getSystemTime() / 150L % (long)lanSearchStates.length)], this.width / 2, this.height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
        }
        else
        {
            if (Mouse.isButtonDown(0))
            {
                int i = (this.width - this.field_146555_f) / 2;
                int j = (this.height - this.field_146557_g) / 2;
                int k = i + 8;
                int l = j + 17;

                if ((this.field_146554_D == 0 || this.field_146554_D == 1) && mouseX >= k && mouseX < k + 224 && mouseY >= l && mouseY < l + 155)
                {
                    if (this.field_146554_D == 0)
                    {
                        this.field_146554_D = 1;
                    }
                    else
                    {
                        this.field_146567_u -= (double)((float)(mouseX - this.field_146563_h) * this.field_146570_r);
                        this.field_146566_v -= (double)((float)(mouseY - this.field_146564_i) * this.field_146570_r);
                        this.field_146565_w = this.field_146569_s = this.field_146567_u;
                        this.field_146573_x = this.field_146568_t = this.field_146566_v;
                    }

                    this.field_146563_h = mouseX;
                    this.field_146564_i = mouseY;
                }
            }
            else
            {
                this.field_146554_D = 0;
            }

            int i1 = Mouse.getDWheel();
            float f3 = this.field_146570_r;

            if (i1 < 0)
            {
                this.field_146570_r += 0.25F;
            }
            else if (i1 > 0)
            {
                this.field_146570_r -= 0.25F;
            }

            this.field_146570_r = MathHelper.func_76131_a(this.field_146570_r, 1.0F, 2.0F);

            if (this.field_146570_r != f3)
            {
                float f5 = f3 - this.field_146570_r;
                float f4 = f3 * (float)this.field_146555_f;
                float f = f3 * (float)this.field_146557_g;
                float f1 = this.field_146570_r * (float)this.field_146555_f;
                float f2 = this.field_146570_r * (float)this.field_146557_g;
                this.field_146567_u -= (double)((f1 - f4) * 0.5F);
                this.field_146566_v -= (double)((f2 - f) * 0.5F);
                this.field_146565_w = this.field_146569_s = this.field_146567_u;
                this.field_146573_x = this.field_146568_t = this.field_146566_v;
            }

            if (this.field_146565_w < (double)field_146572_y)
            {
                this.field_146565_w = (double)field_146572_y;
            }

            if (this.field_146573_x < (double)field_146571_z)
            {
                this.field_146573_x = (double)field_146571_z;
            }

            if (this.field_146565_w >= (double)field_146559_A)
            {
                this.field_146565_w = (double)(field_146559_A - 1);
            }

            if (this.field_146573_x >= (double)field_146560_B)
            {
                this.field_146573_x = (double)(field_146560_B - 1);
            }

            this.drawDefaultBackground();
            this.drawAchievementScreen(mouseX, mouseY, partialTicks);
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.drawTitle();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }
    }

    public void doneLoading()
    {
        if (this.loadingAchievements)
        {
            this.loadingAchievements = false;
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (!this.loadingAchievements)
        {
            this.field_146569_s = this.field_146567_u;
            this.field_146568_t = this.field_146566_v;
            double d0 = this.field_146565_w - this.field_146567_u;
            double d1 = this.field_146573_x - this.field_146566_v;

            if (d0 * d0 + d1 * d1 < 4.0D)
            {
                this.field_146567_u += d0;
                this.field_146566_v += d1;
            }
            else
            {
                this.field_146567_u += d0 * 0.85D;
                this.field_146566_v += d1 * 0.85D;
            }
        }
    }

    protected void drawTitle()
    {
        int i = (this.width - this.field_146555_f) / 2;
        int j = (this.height - this.field_146557_g) / 2;
        this.fontRendererObj.drawString(I18n.format("gui.achievements", new Object[0]), i + 15, j + 5, 4210752);
    }

    protected void drawAchievementScreen(int p_146552_1_, int p_146552_2_, float p_146552_3_) {}

    private TextureAtlasSprite func_175371_a(Block p_175371_1_)
    {
        return null;
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return !this.loadingAchievements;
    }
}
