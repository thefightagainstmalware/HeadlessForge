package net.minecraft.client;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;

import java.io.File;

public class Minecraft {
    public FontRenderer fontRendererObj;
    private static Minecraft mc = null;
    private final Session session = new Session();
    public GameSettings field_71474_y;
    public File field_71412_D = new File("./.minecraft");
    private IResourceManager resourceManager;
    private TextureManager textureManager;
    private LanguageManager languageManager = new LanguageManager(new IMetadataSerializer(), "en_us");

    private Minecraft() {
        this.fontRendererObj = new FontRenderer(null, new ResourceLocation(""), null, false);
        this.field_71474_y = new GameSettings(this, null);
        this.textureManager = new TextureManager((this.resourceManager = new SimpleReloadableResourceManager(null)));
        this.field_71412_D.mkdir();
    }

    public static Minecraft func_71410_x() {
        if (mc == null) {
            mc = new Minecraft();
        }
        return mc;
    }

    public IResourceManager func_110442_L() {
        return this.resourceManager;
    }

    public Session func_110432_I() {
        return session;
    }

    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    public TextureManager func_110434_K() {
        return textureManager;
    }

    public boolean isDemo() {
        return false;
    }

    public void displayGuiScreen(GuiScreen guiScreenIn) {
    }

    public LanguageManager func_135016_M() {
        return languageManager;
    }
}