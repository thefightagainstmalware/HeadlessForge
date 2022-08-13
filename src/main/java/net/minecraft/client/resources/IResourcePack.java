package net.minecraft.client.resources;

import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.data.IMetadataSerializer;

/**
 *
 */
public interface IResourcePack {

    /**
     * 
     * @throws java.io.IOException
     */
    java.io.InputStream getInputStream(ResourceLocation location)
                                throws java.io.IOException;

    /**
     *
     */
    boolean resourceExists(ResourceLocation location);

    /**
     *
     */
    java.util.Set<String> getResourceDomains();

    /**
     * 
     * @throws java.io.IOException
     */
    <T extends IMetadataSection> T getPackMetadata(IMetadataSerializer p_135058_1_,
                                                   String p_135058_2_)
                                            throws java.io.IOException;

    /**
     * 
     * @throws java.io.IOException
     */
    java.awt.image.BufferedImage getPackImage()
                                       throws java.io.IOException;

    /**
     *
     */
    String getPackName();

}