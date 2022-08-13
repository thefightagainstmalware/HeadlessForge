package net.minecraft.client.settings;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 */
public class GameSettings {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private static final Gson gson = new Gson();

    /**
     *
     */
    private static final ParameterizedType typeListString = new ParameterizedType()
    {
        private static final String __OBFID = "CL_00000651";
        public Type[] getActualTypeArguments()
        {
            return new Type[] {String.class};
        }
        public Type getRawType()
        {
            return List.class;
        }
        public Type getOwnerType()
        {
            return null;
        }
    };
    /**
     * GUI scale values
     */
    private static final java.lang.String[] GUISCALES = new java.lang.String[] {"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};

    /**
     *
     */
    private static final java.lang.String[] PARTICLES = new java.lang.String[] {"options.particles.all", "options.particles.decreased", "options.particles.minimal"};

    /**
     *
     */
    private static final java.lang.String[] AMBIENT_OCCLUSIONS = new java.lang.String[] {"options.ao.off", "options.ao.min", "options.ao.max"};

    /**
     *
     */
    private static final java.lang.String[] STREAM_COMPRESSIONS = new java.lang.String[] {"options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high"};

    /**
     *
     */
    private static final java.lang.String[] STREAM_CHAT_MODES = new java.lang.String[] {"options.stream.chat.enabled.stream", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never"};

    /**
     *
     */
    private static final java.lang.String[] STREAM_CHAT_FILTER_MODES = new java.lang.String[] {"options.stream.chat.filters.legacy", "options.stream.chat.filters.op", "options.stream.chat.filters.whitelist", "options.stream.chat.filters.blacklist"};

    /**
     *
     */
    private static final java.lang.String[] STREAM_MIC_MODES = new java.lang.String[] {"options.stream.mic.enabled.stream", "options.stream.mic.enabled.always", "options.stream.mic.enabled.never"};

    /**
     *
     */
    private static final java.lang.String[] CLOUDS_TYPES = new java.lang.String[] {"options.3dClouds.all", "options.3dClouds.far", "options.3dClouds.off"};

    /**
     *
     */
    public float mouseSensitivity;

    /**
     *
     */
    public boolean invertMouse;

    /**
     *
     */
    public int renderDistanceChunks;

    /**
     *
     */
    public boolean viewBobbing;

    /**
     *
     */
    public boolean anaglyph;

    /**
     *
     */
    public boolean fboEnable;

    /**
     *
     */
    public int limitFramerate;

    /**
     * Clouds flag
     */
    public int clouds;

    /**
     *
     */
    public boolean fancyGraphics;

    /**
     * Smooth Lighting
     */
    public int ambientOcclusion;

    /**
     *
     */
    public java.util.List<java.lang.String> resourcePacks;

    /**
     *
     */
    public java.util.List<java.lang.String> incompatibleResourcePacks;

    /**
     *
     */
    public EntityPlayer.EnumChatVisibility chatVisibility;

    /**
     *
     */
    public boolean chatColours;

    /**
     *
     */
    public boolean chatLinks;

    /**
     *
     */
    public boolean chatLinksPrompt;

    /**
     *
     */
    public float chatOpacity;

    /**
     *
     */
    public boolean snooperEnabled;

    /**
     *
     */
    public boolean fullScreen;

    /**
     *
     */
    public boolean enableVsync;

    /**
     *
     */
    public boolean useVbo;

    /**
     *
     */
    public boolean allowBlockAlternatives;

    /**
     *
     */
    public boolean reducedDebugInfo;

    /**
     *
     */
    public boolean hideServerAddress;

    /**
     * Whether to show advanced information on item tooltips, toggled by F3+H
     */
    public boolean advancedItemTooltips;

    /**
     * Whether to pause when the game loses focus, toggled by F3+P
     */
    public boolean pauseOnLostFocus;

    /**
     *
     */
    private final java.util.Set<EnumPlayerModelParts> setModelParts = Sets.newHashSet(EnumPlayerModelParts.values());

    /**
     *
     */
    public boolean touchscreen;

    /**
     *
     */
    public int overrideWidth;

    /**
     *
     */
    public int overrideHeight;

    /**
     *
     */
    public boolean heldItemTooltips;

    /**
     *
     */
    public float chatScale;

    /**
     *
     */
    public float chatWidth;

    /**
     *
     */
    public float chatHeightUnfocused;

    /**
     *
     */
    public float chatHeightFocused;

    /**
     *
     */
    public boolean showInventoryAchievementHint;

    /**
     *
     */
    public int mipmapLevels;

    /**
     *
     */
    private java.util.Map<SoundCategory,java.lang.Float> mapSoundLevels;

    /**
     *
     */
    public float streamBytesPerPixel;

    /**
     *
     */
    public float streamMicVolume;

    /**
     *
     */
    public float streamGameVolume;

    /**
     *
     */
    public float streamKbps;

    /**
     *
     */
    public float streamFps;

    /**
     *
     */
    public int streamCompression;

    /**
     *
     */
    public boolean streamSendMetadata;

    /**
     *
     */
    public java.lang.String streamPreferredServer;

    /**
     *
     */
    public int streamChatEnabled;

    /**
     *
     */
    public int streamChatUserFilter;

    /**
     *
     */
    public int streamMicToggleBehavior;

    /**
     *
     */
    public boolean useNativeTransport;

    /**
     *
     */
    public boolean entityShadows;

    /**
     *
     */
    public boolean field_183509_X;

    /**
     *
     */
    public KeyBinding keyBindForward;

    /**
     *
     */
    public KeyBinding keyBindLeft;

    /**
     *
     */
    public KeyBinding keyBindBack;

    /**
     *
     */
    public KeyBinding keyBindRight;

    /**
     *
     */
    public KeyBinding keyBindJump;

    /**
     *
     */
    public KeyBinding keyBindSneak;

    /**
     *
     */
    public KeyBinding keyBindSprint;

    /**
     *
     */
    public KeyBinding keyBindInventory;

    /**
     *
     */
    public KeyBinding keyBindUseItem;

    /**
     *
     */
    public KeyBinding keyBindDrop;

    /**
     *
     */
    public KeyBinding keyBindAttack;

    /**
     *
     */
    public KeyBinding keyBindPickBlock;

    /**
     *
     */
    public KeyBinding keyBindChat;

    /**
     *
     */
    public KeyBinding keyBindPlayerList;

    /**
     *
     */
    public KeyBinding keyBindCommand;

    /**
     *
     */
    public KeyBinding keyBindScreenshot;

    /**
     *
     */
    public KeyBinding keyBindTogglePerspective;

    /**
     *
     */
    public KeyBinding keyBindSmoothCamera;

    /**
     *
     */
    public KeyBinding keyBindFullscreen;

    /**
     *
     */
    public KeyBinding keyBindSpectatorOutlines;

    /**
     *
     */
    public KeyBinding keyBindStreamStartStop;

    /**
     *
     */
    public KeyBinding keyBindStreamPauseUnpause;

    /**
     *
     */
    public KeyBinding keyBindStreamCommercials;

    /**
     *
     */
    public KeyBinding keyBindStreamToggleMic;

    /**
     *
     */
    public KeyBinding[] keyBindsHotbar;

    /**
     *
     */
    public KeyBinding[] field_74324_K;

    /**
     *
     */
    protected Minecraft mc;

    /**
     *
     */
    private java.io.File optionsFile;

    /**
     *
     */
    public EnumDifficulty difficulty;

    /**
     *
     */
    public boolean hideGUI;

    /**
     *
     */
    public int thirdPersonView;

    /**
     * true if debug info should be displayed instead of version
     */
    public boolean showDebugInfo;

    /**
     *
     */
    public boolean showDebugProfilerChart;

    /**
     *
     */
    public boolean showLagometer;

    /**
     * The lastServer string.
     */
    public java.lang.String lastServer;

    /**
     * Smooth Camera Toggle
     */
    public boolean smoothCamera;

    /**
     *
     */
    public boolean debugCamEnable;

    /**
     *
     */
    public float fovSetting;

    /**
     *
     */
    public float gammaSetting;

    /**
     *
     */
    public float saturation;

    /**
     * GUI scale
     */
    public int guiScale;

    /**
     * Determines amount of particles. 0 = All, 1 = Decreased, 2 = Minimal
     */
    public int particleSetting;

    /**
     * Game settings language
     */
    public java.lang.String language;

    /**
     *
     */
    public boolean forceUnicodeFont;

    /**
     *
     */
    public GameSettings(Minecraft mcIn,
                        java.io.File p_i46326_2_) {

    }

    /**
     *
     */
    public GameSettings() {

    }

    /**
     * Represents a key or mouse button as a string. Args: key
     */
    public static String getKeyDisplayString(int p_74298_0_) {
        return null;
    }

    /**
     * Returns whether the specified key binding is currently being pressed.
     */
    public static boolean isKeyDown(KeyBinding p_100015_0_) {
        return true;
    }

    /**
     * Sets a key binding and then saves all settings.
     */
    public void setOptionKeyBinding(KeyBinding p_151440_1_,
                                    int p_151440_2_) {
        return;
    }

    /**
     * If the specified option is controlled by a slider (float value), this will set the float value.
     */
    public void setOptionFloatValue(GameSettings.Options p_74304_1_,
                                    float p_74304_2_) {
        return;
    }

    /**
     * For non-float options. Toggles the option on/off, or cycles through the list i.e. render distances.
     */
    public void setOptionValue(GameSettings.Options p_74306_1_,
                               int p_74306_2_) {
        return;
    }

    /**
     *
     */
    public float getOptionFloatValue(GameSettings.Options p_74296_1_) {
        return 0;
    }

    /**
     *
     */
    public boolean getOptionOrdinalValue(GameSettings.Options p_74308_1_) {
        return true;
    }

    /**
     * Returns the translation of the given index in the given String array. If the index is smaller than 0 or greater
     * than/equal to the length of the String array, it is changed to 0.
     */
    private static String getTranslation(String[] p_74299_0_,
                                                   int p_74299_1_) {
        return null;
    }

    /**
     * Gets a key binding.
     */
    public String getKeyBinding(GameSettings.Options p_74297_1_) {
        return null;
    }

    /**
     * Loads the options from the options file. It appears that this has replaced the previous 'loadOptions'
     */
    public void loadOptions() {
        return;
    }

    /**
     * Parses a string into a float.
     */
    private float parseFloat(String p_74305_1_) {
        return 0;
    }

    /**
     * Saves the options to the options file.
     */
    public void saveOptions() {
        return;
    }

    /**
     *
     */
    public float getSoundLevel(SoundCategory p_151438_1_) {
        return 0;
    }

    /**
     *
     */
    public void setSoundLevel(SoundCategory p_151439_1_,
                              float p_151439_2_) {
        return;
    }

    /**
     * Send a client info packet with settings information to the server
     */
    public void sendSettingsToServer() {
        return;
    }

    /**
     *
     */
    public java.util.Set<EnumPlayerModelParts> getModelParts() {
        return null;
    }

    /**
     *
     */
    public void setModelPartEnabled(EnumPlayerModelParts p_178878_1_,
                                    boolean p_178878_2_) {
        return;
    }

    /**
     *
     */
    public void switchModelPartEnabled(EnumPlayerModelParts p_178877_1_) {
        return;
    }

    /**
     *
     */
    public int func_181147_e() {
        return 0;
    }

    /**
     *
     */
    public boolean func_181148_f() {
        return true;
    }

    public static enum Options {
        INVERT_MOUSE("INVERT_MOUSE", 0, "options.invertMouse", false, true),
        SENSITIVITY("SENSITIVITY", 1, "options.sensitivity", true, false),
        FOV("FOV", 2, "options.fov", true, false, 30.0F, 110.0F, 1.0F),
        GAMMA("GAMMA", 3, "options.gamma", true, false),
        SATURATION("SATURATION", 4, "options.saturation", true, false),
        RENDER_DISTANCE("RENDER_DISTANCE", 5, "options.renderDistance", true, false, 2.0F, 16.0F, 1.0F),
        VIEW_BOBBING("VIEW_BOBBING", 6, "options.viewBobbing", false, true),
        ANAGLYPH("ANAGLYPH", 7, "options.anaglyph", false, true),
        FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "options.framerateLimit", true, false, 0.0F, 260.0F, 5.0F),
        FBO_ENABLE("FBO_ENABLE", 9, "options.fboEnable", false, true),
        RENDER_CLOUDS("RENDER_CLOUDS", 10, "options.renderClouds", false, false),
        GRAPHICS("GRAPHICS", 11, "options.graphics", false, false),
        AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 12, "options.ao", false, false),
        GUI_SCALE("GUI_SCALE", 13, "options.guiScale", false, false),
        PARTICLES("PARTICLES", 14, "options.particles", false, false),
        CHAT_VISIBILITY("CHAT_VISIBILITY", 15, "options.chat.visibility", false, false),
        CHAT_COLOR("CHAT_COLOR", 16, "options.chat.color", false, true),
        CHAT_LINKS("CHAT_LINKS", 17, "options.chat.links", false, true),
        CHAT_OPACITY("CHAT_OPACITY", 18, "options.chat.opacity", true, false),
        CHAT_LINKS_PROMPT("CHAT_LINKS_PROMPT", 19, "options.chat.links.prompt", false, true),
        SNOOPER_ENABLED("SNOOPER_ENABLED", 20, "options.snooper", false, true),
        USE_FULLSCREEN("USE_FULLSCREEN", 21, "options.fullscreen", false, true),
        ENABLE_VSYNC("ENABLE_VSYNC", 22, "options.vsync", false, true),
        USE_VBO("USE_VBO", 23, "options.vbo", false, true),
        TOUCHSCREEN("TOUCHSCREEN", 24, "options.touchscreen", false, true),
        CHAT_SCALE("CHAT_SCALE", 25, "options.chat.scale", true, false),
        CHAT_WIDTH("CHAT_WIDTH", 26, "options.chat.width", true, false),
        CHAT_HEIGHT_FOCUSED("CHAT_HEIGHT_FOCUSED", 27, "options.chat.height.focused", true, false),
        CHAT_HEIGHT_UNFOCUSED("CHAT_HEIGHT_UNFOCUSED", 28, "options.chat.height.unfocused", true, false),
        MIPMAP_LEVELS("MIPMAP_LEVELS", 29, "options.mipmapLevels", true, false, 0.0F, 4.0F, 1.0F),
        FORCE_UNICODE_FONT("FORCE_UNICODE_FONT", 30, "options.forceUnicodeFont", false, true),
        STREAM_BYTES_PER_PIXEL("STREAM_BYTES_PER_PIXEL", 31, "options.stream.bytesPerPixel", true, false),
        STREAM_VOLUME_MIC("STREAM_VOLUME_MIC", 32, "options.stream.micVolumne", true, false),
        STREAM_VOLUME_SYSTEM("STREAM_VOLUME_SYSTEM", 33, "options.stream.systemVolume", true, false),
        STREAM_KBPS("STREAM_KBPS", 34, "options.stream.kbps", true, false),
        STREAM_FPS("STREAM_FPS", 35, "options.stream.fps", true, false),
        STREAM_COMPRESSION("STREAM_COMPRESSION", 36, "options.stream.compression", false, false),
        STREAM_SEND_METADATA("STREAM_SEND_METADATA", 37, "options.stream.sendMetadata", false, true),
        STREAM_CHAT_ENABLED("STREAM_CHAT_ENABLED", 38, "options.stream.chat.enabled", false, false),
        STREAM_CHAT_USER_FILTER("STREAM_CHAT_USER_FILTER", 39, "options.stream.chat.userFilter", false, false),
        STREAM_MIC_TOGGLE_BEHAVIOR("STREAM_MIC_TOGGLE_BEHAVIOR", 40, "options.stream.micToggleBehavior", false, false),
        BLOCK_ALTERNATIVES("BLOCK_ALTERNATIVES", 41, "options.blockAlternatives", false, true),
        REDUCED_DEBUG_INFO("REDUCED_DEBUG_INFO", 42, "options.reducedDebugInfo", false, true),
        ENTITY_SHADOWS("ENTITY_SHADOWS", 43, "options.entityShadows", false, true),
        FOG_FANCY("FOG", 999, "Fog", false, false),
        FOG_START("", 999, "Fog Start", false, false),
        MIPMAP_TYPE("", 999, "Mipmap Type", true, false, 0.0F, 3.0F, 1.0F),
        SMOOTH_FPS("", 999, "Smooth FPS", false, false),
        CLOUDS("", 999, "Clouds", false, false),
        CLOUD_HEIGHT("", 999, "Cloud Height", true, false),
        TREES("", 999, "Trees", false, false),
        RAIN("", 999, "Rain & Snow", false, false),
        ANIMATED_WATER("", 999, "Water Animated", false, false),
        ANIMATED_LAVA("", 999, "Lava Animated", false, false),
        ANIMATED_FIRE("", 999, "Fire Animated", false, false),
        ANIMATED_PORTAL("", 999, "Portal Animated", false, false),
        AO_LEVEL("", 999, "Smooth Lighting Level", true, false),
        LAGOMETER("", 999, "Lagometer", false, false),
        SHOW_FPS("", 999, "Show FPS", false, false),
        AUTOSAVE_TICKS("", 999, "Autosave", false, false),
        BETTER_GRASS("", 999, "Better Grass", false, false),
        ANIMATED_REDSTONE("", 999, "Redstone Animated", false, false),
        ANIMATED_EXPLOSION("", 999, "Explosion Animated", false, false),
        ANIMATED_FLAME("", 999, "Flame Animated", false, false),
        ANIMATED_SMOKE("", 999, "Smoke Animated", false, false),
        WEATHER("", 999, "Weather", false, false),
        SKY("", 999, "Sky", false, false),
        STARS("", 999, "Stars", false, false),
        SUN_MOON("", 999, "Sun & Moon", false, false),
        VIGNETTE("", 999, "Vignette", false, false),
        CHUNK_UPDATES("", 999, "Chunk Updates", false, false),
        CHUNK_UPDATES_DYNAMIC("", 999, "Dynamic Updates", false, false),
        TIME("", 999, "Time", false, false),
        CLEAR_WATER("", 999, "Clear Water", false, false),
        SMOOTH_WORLD("", 999, "Smooth World", false, false),
        VOID_PARTICLES("", 999, "Void Particles", false, false),
        WATER_PARTICLES("", 999, "Water Particles", false, false),
        RAIN_SPLASH("", 999, "Rain Splash", false, false),
        PORTAL_PARTICLES("", 999, "Portal Particles", false, false),
        POTION_PARTICLES("", 999, "Potion Particles", false, false),
        FIREWORK_PARTICLES("", 999, "Firework Particles", false, false),
        PROFILER("", 999, "Debug Profiler", false, false),
        DRIPPING_WATER_LAVA("", 999, "Dripping Water/Lava", false, false),
        BETTER_SNOW("", 999, "Better Snow", false, false),
        FULLSCREEN_MODE("", 999, "Fullscreen Mode", false, false),
        ANIMATED_TERRAIN("", 999, "Terrain Animated", false, false),
        SWAMP_COLORS("", 999, "Swamp Colors", false, false),
        RANDOM_MOBS("", 999, "Random Mobs", false, false),
        SMOOTH_BIOMES("", 999, "Smooth Biomes", false, false),
        CUSTOM_FONTS("", 999, "Custom Fonts", false, false),
        CUSTOM_COLORS("", 999, "Custom Colors", false, false),
        SHOW_CAPES("", 999, "Show Capes", false, false),
        CONNECTED_TEXTURES("", 999, "Connected Textures", false, false),
        AA_LEVEL("", 999, "Antialiasing", true, false, 0.0F, 16.0F, 1.0F),
        AF_LEVEL("", 999, "Anisotropic Filtering", true, false, 1.0F, 16.0F, 1.0F),
        ANIMATED_TEXTURES("", 999, "Textures Animated", false, false),
        NATURAL_TEXTURES("", 999, "Natural Textures", false, false),
        CHUNK_LOADING("", 999, "Chunk Loading", false, false),
        HELD_ITEM_TOOLTIPS("", 999, "Held Item Tooltips", false, false),
        DROPPED_ITEMS("", 999, "Dropped Items", false, false),
        LAZY_CHUNK_LOADING("", 999, "Lazy Chunk Loading", false, false),
        CUSTOM_SKY("", 999, "Custom Sky", false, false),
        FAST_MATH("", 999, "Fast Math", false, false),
        FAST_RENDER("", 999, "Fast Render", false, false),
        TRANSLUCENT_BLOCKS("", 999, "Translucent Blocks", false, false);

        private final boolean enumFloat;
        private final boolean enumBoolean;
        private final String enumString;
        private final float valueStep;
        private float valueMin;
        private float valueMax;
        private static final GameSettings.Options[] $VALUES = new GameSettings.Options[]{INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, SATURATION, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, FRAMERATE_LIMIT, FBO_ENABLE, RENDER_CLOUDS, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, PARTICLES, CHAT_VISIBILITY, CHAT_COLOR, CHAT_LINKS, CHAT_OPACITY, CHAT_LINKS_PROMPT, SNOOPER_ENABLED, USE_FULLSCREEN, ENABLE_VSYNC, USE_VBO, TOUCHSCREEN, CHAT_SCALE, CHAT_WIDTH, CHAT_HEIGHT_FOCUSED, CHAT_HEIGHT_UNFOCUSED, MIPMAP_LEVELS, FORCE_UNICODE_FONT, STREAM_BYTES_PER_PIXEL, STREAM_VOLUME_MIC, STREAM_VOLUME_SYSTEM, STREAM_KBPS, STREAM_FPS, STREAM_COMPRESSION, STREAM_SEND_METADATA, STREAM_CHAT_ENABLED, STREAM_CHAT_USER_FILTER, STREAM_MIC_TOGGLE_BEHAVIOR, BLOCK_ALTERNATIVES, REDUCED_DEBUG_INFO, ENTITY_SHADOWS};
        private static final String __OBFID = "CL_00000653";

        public static GameSettings.Options getEnumOptions(int p_74379_0_)
        {
            for (GameSettings.Options gamesettings$options : values())
            {
                if (gamesettings$options.returnEnumOrdinal() == p_74379_0_)
                {
                    return gamesettings$options;
                }
            }

            return null;
        }

        private Options(String p_i0_3_, int p_i0_4_, String p_i0_5_, boolean p_i0_6_, boolean p_i0_7_)
        {
            this(p_i0_3_, p_i0_4_, p_i0_5_, p_i0_6_, p_i0_7_, 0.0F, 1.0F, 0.0F);
        }

        private Options(String p_i1_3_, int p_i1_4_, String p_i1_5_, boolean p_i1_6_, boolean p_i1_7_, float p_i1_8_, float p_i1_9_, float p_i1_10_)
        {
            this.enumString = p_i1_5_;
            this.enumFloat = p_i1_6_;
            this.enumBoolean = p_i1_7_;
            this.valueMin = p_i1_8_;
            this.valueMax = p_i1_9_;
            this.valueStep = p_i1_10_;
        }

        public boolean getEnumFloat()
        {
            return this.enumFloat;
        }

        public boolean getEnumBoolean()
        {
            return this.enumBoolean;
        }

        public int returnEnumOrdinal()
        {
            return this.ordinal();
        }

        public String getEnumString()
        {
            return this.enumString;
        }

        public float getValueMax()
        {
            return this.valueMax;
        }

        public void setValueMax(float p_148263_1_)
        {
            this.valueMax = p_148263_1_;
        }

        public float normalizeValue(float p_148266_1_)
        {
            return MathHelper.func_76131_a((this.snapToStepClamp(p_148266_1_) - this.valueMin) / (this.valueMax - this.valueMin), 0.0F, 1.0F);
        }

        public float denormalizeValue(float p_148262_1_)
        {
            return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.func_76131_a(p_148262_1_, 0.0F, 1.0F));
        }

        public float snapToStepClamp(float p_148268_1_)
        {
            p_148268_1_ = this.snapToStep(p_148268_1_);
            return MathHelper.func_76131_a(p_148268_1_, this.valueMin, this.valueMax);
        }

        protected float snapToStep(float p_148264_1_)
        {
            if (this.valueStep > 0.0F)
            {
                p_148264_1_ = this.valueStep * (float)Math.round(p_148264_1_ / this.valueStep);
            }

            return p_148264_1_;
        }
    }
}