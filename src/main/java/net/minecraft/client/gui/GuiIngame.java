package net.minecraft.client.gui;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public class GuiIngame extends Gui
{
    private static final ResourceLocation vignetteTexPath = new ResourceLocation("textures/misc/vignette.png");
    private static final ResourceLocation widgetsTexPath = new ResourceLocation("textures/gui/widgets.png");
    private static final ResourceLocation pumpkinBlurTexPath = new ResourceLocation("textures/misc/pumpkinblur.png");
    private final Random rand = new Random();
    private final Minecraft mc;
    private final RenderItem itemRenderer;

    /** ChatGUI instance that retains all previous chat data */
    private final GuiNewChat persistantChatGUI;
    private final GuiStreamIndicator streamIndicator;
    private int updateCounter;

    /** The string specifying which record music is playing */
    private String recordPlaying = "";

    /** How many ticks the record playing message will be displayed */
    private int recordPlayingUpFor;
    private boolean recordIsPlaying;

    /** Previous frame vignette brightness (slowly changes by 1% each frame) */
    public float prevVignetteBrightness = 1.0F;

    /** Remaining ticks the item highlight should be visible */
    private int remainingHighlightTicks;

    /** The ItemStack that is currently being highlighted */
    private ItemStack highlightingItemStack;
    private final GuiOverlayDebug overlayDebug;

    /** The spectator GUI for this in-game GUI instance */
    private final GuiSpectator spectatorGui;
    private final GuiPlayerTabOverlay overlayPlayerList;
    private int field_175195_w;
    private String field_175201_x = "";
    private String field_175200_y = "";
    private int field_175199_z;
    private int field_175192_A;
    private int field_175193_B;
    private int playerHealth = 0;
    private int lastPlayerHealth = 0;

    /** The last recorded system time */
    private long lastSystemTime = 0L;

    /** Used with updateCounter to make the heart bar flash */
    private long healthUpdateCounter = 0L;
    private static final String __OBFID = "CL_00000661";

    public GuiIngame(Minecraft mcIn)
    {
        this.mc = mcIn;
        this.itemRenderer = null;
        this.overlayDebug = new GuiOverlayDebug(mcIn);
        this.spectatorGui = new GuiSpectator(mcIn);
        this.persistantChatGUI = new GuiNewChat(mcIn);
        this.streamIndicator = new GuiStreamIndicator(mcIn);
        this.overlayPlayerList = new GuiPlayerTabOverlay(mcIn, this);
        this.func_175177_a();
    }

    public void func_175177_a()
    {
        this.field_175199_z = 10;
        this.field_175192_A = 70;
        this.field_175193_B = 20;
    }

    public void renderGameOverlay(float partialTicks)
    {
        
    }

    protected void renderTooltip(ScaledResolution sr, float partialTicks)
    {
        
    }

    public void renderHorseJumpBar(ScaledResolution p_175186_1_, int p_175186_2_)
    {
    }

    public void renderExpBar(ScaledResolution p_175176_1_, int p_175176_2_)
    {
        
    }

    public void renderDemo(ScaledResolution p_175185_1_)
    {
    }

    protected boolean showCrosshair()
    {
        return true;
    }

    public void renderStreamIndicator(ScaledResolution p_180478_1_)
    {
        this.streamIndicator.render(p_180478_1_.getScaledWidth() - 10, 10);
    }

    private void renderScoreboard(ScoreObjective p_180475_1_, ScaledResolution p_180475_2_)
    {
        Scoreboard scoreboard = p_180475_1_.getScoreboard();
        Collection collection = scoreboard.getSortedScores(p_180475_1_);
        ArrayList arraylist = Lists.newArrayList(Iterables.filter(collection, new Predicate()
        {
            private static final String __OBFID = "CL_00001958";
            public boolean apply(Score p_apply_1_)
            {
                return p_apply_1_.getPlayerName() != null && !p_apply_1_.getPlayerName().startsWith("#");
            }
            public boolean apply(Object p_apply_1_)
            {
                return this.apply((Score)p_apply_1_);
            }
        }));
        ArrayList arraylist1;

        if (arraylist.size() > 15)
        {
            arraylist1 = Lists.newArrayList(Iterables.skip(arraylist, collection.size() - 15));
        }
        else
        {
            arraylist1 = arraylist;
        }

        int i = this.getFontRenderer().getStringWidth(p_180475_1_.getDisplayName());

        for (Object score0 : arraylist1)
        {
            Score score = (Score) score0;
            ScorePlayerTeam scoreplayerteam = scoreboard.getPlayersTeam(score.getPlayerName());
            String s = ScorePlayerTeam.formatPlayerName(scoreplayerteam, score.getPlayerName()) + ": " + EnumChatFormatting.RED + score.getScorePoints();
            i = Math.max(i, this.getFontRenderer().getStringWidth(s));
        }

        int j1 = arraylist1.size() * this.getFontRenderer().FONT_HEIGHT;
        int k1 = p_180475_2_.getScaledHeight() / 2 + j1 / 3;
        byte b0 = 3;
        int j = p_180475_2_.getScaledWidth() - i - b0;
        int k = 0;

        for (Object score10 : arraylist1)
        {
            Score score1 = (Score) score10;
            ++k;
            ScorePlayerTeam scoreplayerteam1 = scoreboard.getPlayersTeam(score1.getPlayerName());
            String s1 = ScorePlayerTeam.formatPlayerName(scoreplayerteam1, score1.getPlayerName());
            String s2 = EnumChatFormatting.RED + "" + score1.getScorePoints();
            int l = k1 - k * this.getFontRenderer().FONT_HEIGHT;
            int i1 = p_180475_2_.getScaledWidth() - b0 + 2;
            drawRect(j - 2, l, i1, l + this.getFontRenderer().FONT_HEIGHT, 1342177280);
            this.getFontRenderer().drawString(s1, j, l, 553648127);
            this.getFontRenderer().drawString(s2, i1 - this.getFontRenderer().getStringWidth(s2), l, 553648127);

            if (k == arraylist1.size())
            {
                String s3 = p_180475_1_.getDisplayName();
                drawRect(j - 2, l - this.getFontRenderer().FONT_HEIGHT - 1, i1, l - 1, 1610612736);
                drawRect(j - 2, l - 1, i1, l, 1342177280);
                this.getFontRenderer().drawString(s3, j + i / 2 - this.getFontRenderer().getStringWidth(s3) / 2, l - this.getFontRenderer().FONT_HEIGHT, 553648127);
            }
        }
    }

    private void renderPlayerStats(ScaledResolution p_180477_1_)
    {
        
    }

    /**
     * Renders dragon's (boss) health on the HUD
     */
    private void renderBossHealth()
    {
        if (BossStatus.bossName != null && BossStatus.statusBarTime > 0)
        {
            --BossStatus.statusBarTime;
            FontRenderer fontrenderer = this.mc.fontRendererObj;
            ScaledResolution scaledresolution = new ScaledResolution(this.mc);
            int i = scaledresolution.getScaledWidth();
            short short1 = 182;
            int j = i / 2 - short1 / 2;
            int k = (int)(BossStatus.healthScale * (float)(short1 + 1));
            byte b0 = 12;
            this.drawTexturedModalRect(j, b0, 0, 74, short1, 5);
            this.drawTexturedModalRect(j, b0, 0, 74, short1, 5);

            if (k > 0)
            {
                this.drawTexturedModalRect(j, b0, 0, 79, k, 5);
            }

            String s = BossStatus.bossName;
            this.getFontRenderer().drawStringWithShadow(s, (float)(i / 2 - this.getFontRenderer().getStringWidth(s) / 2), (float)(b0 - 10), 16777215);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.func_110434_K().func_110577_a(icons);
        }
    }

    private void renderPumpkinOverlay(ScaledResolution p_180476_1_)
    {
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableAlpha();
        this.mc.func_110434_K().func_110577_a(pumpkinBlurTexPath);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(0.0D, (double)p_180476_1_.getScaledHeight(), -90.0D).tex(0.0D, 1.0D).endVertex();
        worldrenderer.pos((double)p_180476_1_.getScaledWidth(), (double)p_180476_1_.getScaledHeight(), -90.0D).tex(1.0D, 1.0D).endVertex();
        worldrenderer.pos((double)p_180476_1_.getScaledWidth(), 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
        worldrenderer.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Renders a Vignette arount the entire screen that changes with light level.
     */
    private void renderVignette(float p_180480_1_, ScaledResolution p_180480_2_) {}

    private void func_180474_b(float p_180474_1_, ScaledResolution p_180474_2_)
    {
        if (p_180474_1_ < 1.0F)
        {
            p_180474_1_ = p_180474_1_ * p_180474_1_;
            p_180474_1_ = p_180474_1_ * p_180474_1_;
            p_180474_1_ = p_180474_1_ * 0.8F + 0.2F;
        }

        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0F, 1.0F, 1.0F, p_180474_1_);
        this.mc.func_110434_K().func_110577_a(TextureMap.locationBlocksTexture);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        tessellator.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void renderHotbarItem(int index, int xPos, int yPos, float partialTicks, EntityPlayer p_175184_5_)
    {
        ItemStack itemstack = p_175184_5_.field_71071_by.mainInventory[index];

        if (itemstack != null)
        {
            float f = (float)itemstack.animationsToGo - partialTicks;

            if (f > 0.0F)
            {
                GlStateManager.pushMatrix();
                float f1 = 1.0F + f / 5.0F;
                GlStateManager.translate((float)(xPos + 8), (float)(yPos + 12), 0.0F);
                GlStateManager.scale(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
                GlStateManager.translate((float)(-(xPos + 8)), (float)(-(yPos + 12)), 0.0F);
            }

            this.itemRenderer.renderItemAndEffectIntoGUI(itemstack, xPos, yPos);

            if (f > 0.0F)
            {
                GlStateManager.popMatrix();
            }

            this.itemRenderer.renderItemOverlays(this.mc.fontRendererObj, itemstack, xPos, yPos);
        }
    }

    /**
     * The update tick for the ingame UI
     */
    public void updateTick()
    {
        if (this.recordPlayingUpFor > 0)
        {
            --this.recordPlayingUpFor;
        }

        if (this.field_175195_w > 0)
        {
            --this.field_175195_w;

            if (this.field_175195_w <= 0)
            {
                this.field_175201_x = "";
                this.field_175200_y = "";
            }
        }

        ++this.updateCounter;
        this.streamIndicator.func_152439_a();
    }

    public void setRecordPlayingMessage(String p_73833_1_)
    {
        this.setRecordPlaying(I18n.format("record.nowPlaying", new Object[] {p_73833_1_}), true);
    }

    public void setRecordPlaying(String p_110326_1_, boolean p_110326_2_)
    {
        this.recordPlaying = p_110326_1_;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = p_110326_2_;
    }

    public void displayTitle(String p_175178_1_, String p_175178_2_, int p_175178_3_, int p_175178_4_, int p_175178_5_)
    {
        if (p_175178_1_ == null && p_175178_2_ == null && p_175178_3_ < 0 && p_175178_4_ < 0 && p_175178_5_ < 0)
        {
            this.field_175201_x = "";
            this.field_175200_y = "";
            this.field_175195_w = 0;
        }
        else if (p_175178_1_ != null)
        {
            this.field_175201_x = p_175178_1_;
            this.field_175195_w = this.field_175199_z + this.field_175192_A + this.field_175193_B;
        }
        else if (p_175178_2_ != null)
        {
            this.field_175200_y = p_175178_2_;
        }
        else
        {
            if (p_175178_3_ >= 0)
            {
                this.field_175199_z = p_175178_3_;
            }

            if (p_175178_4_ >= 0)
            {
                this.field_175192_A = p_175178_4_;
            }

            if (p_175178_5_ >= 0)
            {
                this.field_175193_B = p_175178_5_;
            }

            if (this.field_175195_w > 0)
            {
                this.field_175195_w = this.field_175199_z + this.field_175192_A + this.field_175193_B;
            }
        }
    }

    public void setRecordPlaying(IChatComponent p_175188_1_, boolean p_175188_2_)
    {
        this.setRecordPlaying(p_175188_1_.func_150260_c(), p_175188_2_);
    }

    /**
     * returns a pointer to the persistant Chat GUI, containing all previous chat messages and such
     */
    public GuiNewChat getChatGUI()
    {
        return this.persistantChatGUI;
    }

    public int getUpdateCounter()
    {
        return this.updateCounter;
    }

    public FontRenderer getFontRenderer()
    {
        return this.mc.fontRendererObj;
    }

    public GuiSpectator getSpectatorGui()
    {
        return this.spectatorGui;
    }

    public GuiPlayerTabOverlay getTabList()
    {
        return this.overlayPlayerList;
    }

    public void func_181029_i()
    {
        this.overlayPlayerList.func_181030_a();
    }
}
