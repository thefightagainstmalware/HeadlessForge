package net.minecraft.client.audio;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistrySimple;

/**
 *
 */
public class SoundRegistry extends RegistrySimple<ResourceLocation,SoundEventAccessorComposite> {

    /**
     *
     */
    private java.util.Map<ResourceLocation,SoundEventAccessorComposite> soundRegistry;

    /**
     *
     */
    public SoundRegistry() {
        
    }

    /**
     *
     */
    @Override
    protected java.util.Map<ResourceLocation,SoundEventAccessorComposite> createUnderlyingMap() {
        return null;
    }

    /**
     *
     */
    public void registerSound(SoundEventAccessorComposite p_148762_1_) {
        return;
    }

    /**
     * Reset the underlying sound map (Called on resource manager reload)
     */
    public void clearMap() {
        return;
    }

}