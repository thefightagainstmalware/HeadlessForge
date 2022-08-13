package net.minecraft.client.resources;

import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.util.ResourceLocation;

/**
 *
 */
public interface IResource {

    /**
     *
     */
    ResourceLocation getResourceLocation();

    /**
     *
     */
    java.io.InputStream func_110527_b();

    /**
     *
     */
    boolean hasMetadata();

    /**
     *
     */
    <T extends IMetadataSection> T getMetadata(String p_110526_1_);

    /**
     *
     */
    String func_177240_d();

}