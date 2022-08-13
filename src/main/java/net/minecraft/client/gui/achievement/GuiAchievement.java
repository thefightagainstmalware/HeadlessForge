package net.minecraft.client.gui.achievement;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;

public class GuiAchievement extends Gui
{
    private static final ResourceLocation achievementBg = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    private Minecraft mc;
    private int width;
    private int height;
    private String achievementTitle;
    private String achievementDescription;
    private Achievement theAchievement;
    private long notificationTime;
    private RenderItem renderItem;
    private boolean permanentNotification;

    public GuiAchievement(Minecraft mc)
    {
        this.mc = mc;
        this.renderItem = null;
    }

    public void displayAchievement(Achievement ach)
    {
        this.achievementTitle = I18n.format("achievement.get", new Object[0]);
        this.achievementDescription = ach.getStatName().func_150260_c();
        this.notificationTime = Minecraft.getSystemTime();
        this.theAchievement = ach;
        this.permanentNotification = false;
    }

    public void displayUnformattedAchievement(Achievement achievementIn)
    {
        this.achievementTitle = achievementIn.getStatName().func_150260_c();
        this.achievementDescription = achievementIn.getDescription();
        this.notificationTime = Minecraft.getSystemTime() + 2500L;
        this.theAchievement = achievementIn;
        this.permanentNotification = true;
    }

    private void updateAchievementWindowScale(){}

    public void updateAchievementWindow(){}

    public void clearAchievements()
    {
        this.theAchievement = null;
        this.notificationTime = 0L;
    }
}
