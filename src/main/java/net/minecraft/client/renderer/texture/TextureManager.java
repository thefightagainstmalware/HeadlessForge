package net.minecraft.client.renderer.texture;

import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;

/**
 *
 */
public class TextureManager extends Object implements ITickable, IResourceManagerReloadListener {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private final java.util.Map<ResourceLocation,ITextureObject> mapTextureObjects = new java.util.HashMap<ResourceLocation,ITextureObject>();

    /**
     *
     */
    private final java.util.List<ITickable> listTickables = new java.util.ArrayList<ITickable>();

    /**
     *
     */
    private final java.util.Map<java.lang.String,java.lang.Integer> mapTextureCounters = new java.util.HashMap<java.lang.String,java.lang.Integer>();

    /**
     *
     */
    private IResourceManager theResourceManager;

    /**
     *
     */
    public TextureManager(IResourceManager resourceManager) {
        
    }

    /**
     *
     */
    public void func_110577_a(ResourceLocation resource) {
        return;
    }

    /**
     *
     */
    public boolean loadTickableTexture(ResourceLocation textureLocation,
                                       ITickableTextureObject textureObj) {
        return true;
    }

    /**
     *
     */
    public boolean loadTexture(ResourceLocation textureLocation,
                               ITextureObject textureObj) {
        return true;
    }

    /**
     *
     */
    public ITextureObject getTexture(ResourceLocation textureLocation) {
        return null;
    }

    /**
     *
     */
    public ResourceLocation getDynamicTextureLocation(String name,
                                                      DynamicTexture texture) {
        return null;
    }

    /**
     *
     */
    public void tick() {
        return;
    }

    /**
     *
     */
    public void deleteTexture(ResourceLocation textureLocation) {
        return;
    }

    /**
     *
     */
    public void func_110549_a(IResourceManager resourceManager) {
        return;
    }

}