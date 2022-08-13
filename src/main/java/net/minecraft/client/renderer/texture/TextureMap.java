package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SideOnly(Side.CLIENT)
public class TextureMap extends AbstractTexture implements ITickableTextureObject
{
    private static final boolean ENABLE_SKIP = Boolean.parseBoolean(System.getProperty("fml.skipFirstTextureLoad", "true"));
    private static final Logger logger = LogManager.getLogger();
    public static final ResourceLocation LOCATION_MISSING_TEXTURE = new ResourceLocation("missingno");
    public static final ResourceLocation locationBlocksTexture = new ResourceLocation("textures/atlas/blocks.png");
    private final List<TextureAtlasSprite> listAnimatedSprites;
    private final Map<String, TextureAtlasSprite> mapRegisteredSprites;
    private final Map<String, TextureAtlasSprite> mapUploadedSprites;
    private final String basePath;
    private final IIconCreator iconCreator;
    private int mipmapLevels;
    private final TextureAtlasSprite missingImage;
    private boolean skipFirst = false;

    public TextureMap(String p_i46099_1_)
    {
        this(p_i46099_1_, (IIconCreator)null);
    }

    public TextureMap(String p_i46100_1_, IIconCreator iconCreatorIn)
    {
        this(p_i46100_1_, iconCreatorIn, false);
    }

    public TextureMap(String p_i46100_1_, boolean skipFirst)
    {
        this(p_i46100_1_, null, skipFirst);
    }

    public TextureMap(String p_i46100_1_, IIconCreator iconCreatorIn, boolean skipFirst)
    {
        this.listAnimatedSprites = Lists.<TextureAtlasSprite>newArrayList();
        this.mapRegisteredSprites = Maps.<String, TextureAtlasSprite>newHashMap();
        this.mapUploadedSprites = Maps.<String, TextureAtlasSprite>newHashMap();
        this.missingImage = new TextureAtlasSprite("missingno");
        this.basePath = p_i46100_1_;
        this.iconCreator = iconCreatorIn;
        this.skipFirst = skipFirst && ENABLE_SKIP;
    }

    private void initMissingImage()
    {
        int[] aint = TextureUtil.missingTextureData;
        this.missingImage.setIconWidth(16);
        this.missingImage.setIconHeight(16);
        int[][] aint1 = new int[this.mipmapLevels + 1][];
        aint1[0] = aint;
        this.missingImage.setFramesTextureData(Lists.newArrayList(new int[][][] {aint1}));
    }

    public void loadTexture(IResourceManager resourceManager) throws IOException
    {
        if (this.iconCreator != null)
        {
            this.loadSprites(resourceManager, this.iconCreator);
        }
    }

    public void loadSprites(IResourceManager resourceManager, IIconCreator p_174943_2_)
    {
        this.mapRegisteredSprites.clear();
        p_174943_2_.registerSprites(this);
        this.initMissingImage();
        this.deleteGlTexture();
        this.loadTextureAtlas(resourceManager);
    }

    public void loadTextureAtlas(IResourceManager resourceManager)
    {    }

    private ResourceLocation completeResourceLocation(ResourceLocation location, int p_147634_2_)
    {
        return p_147634_2_ == 0 ? new ResourceLocation(location.func_110624_b(), String.format("%s/%s%s", new Object[] {this.basePath, location.func_110623_a(), ".png"})): new ResourceLocation(location.func_110624_b(), String.format("%s/mipmaps/%s.%d%s", new Object[] {this.basePath, location.func_110623_a(), Integer.valueOf(p_147634_2_), ".png"}));
    }

    public TextureAtlasSprite getAtlasSprite(String iconName)
    {
        TextureAtlasSprite textureatlassprite = (TextureAtlasSprite)this.mapUploadedSprites.get(iconName);

        if (textureatlassprite == null)
        {
            textureatlassprite = this.missingImage;
        }

        return textureatlassprite;
    }

    public void updateAnimations()
    {
        TextureUtil.bindTexture(this.getGlTextureId());

        for (TextureAtlasSprite textureatlassprite : this.listAnimatedSprites)
        {
            textureatlassprite.updateAnimation();
        }
    }

    public TextureAtlasSprite registerSprite(ResourceLocation location)
    {
        if (location == null)
        {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        else
        {
            TextureAtlasSprite textureatlassprite = (TextureAtlasSprite)this.mapRegisteredSprites.get(location);

            if (textureatlassprite == null)
            {
                textureatlassprite = TextureAtlasSprite.makeAtlasSprite(location);
                this.mapRegisteredSprites.put(location.toString(), textureatlassprite);
            }

            return textureatlassprite;
        }
    }

    public void tick()
    {
        this.updateAnimations();
    }

    public void setMipmapLevels(int mipmapLevelsIn)
    {
        this.mipmapLevels = mipmapLevelsIn;
    }

    public TextureAtlasSprite getMissingSprite()
    {
        return this.missingImage;
    }

    //===================================================================================================
    //                                           Forge Start
    //===================================================================================================
    /**
     * Grabs the registered entry for the specified name, returning null if there was not a entry.
     * Opposed to registerIcon, this will not instantiate the entry, useful to test if a mapping exists.
     *
     * @param name The name of the entry to find
     * @return The registered entry, null if nothing was registered.
     */
    public TextureAtlasSprite getTextureExtry(String name)
    {
        return (TextureAtlasSprite)mapRegisteredSprites.get(name);
    }

    /**
     * Adds a texture registry entry to this map for the specified name if one does not already exist.
     * Returns false if the map already contains a entry for the specified name.
     *
     * @param name Entry name
     * @param entry Entry instance
     * @return True if the entry was added to the map, false otherwise.
     */
    public boolean setTextureEntry(String name, TextureAtlasSprite entry)
    {
        if (!mapRegisteredSprites.containsKey(name))
        {
            mapRegisteredSprites.put(name, entry);
            return true;
        }
        return false;
    }
}