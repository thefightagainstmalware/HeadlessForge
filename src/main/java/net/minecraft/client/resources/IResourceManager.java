package net.minecraft.client.resources;

import net.minecraft.util.ResourceLocation;

/**
 *
 */
public interface IResourceManager {

    /**
     *
     */
    java.util.Set<String> getResourceDomains();

    /**
     * 
     * @throws java.io.IOException
     */
    IResource func_110536_a(ResourceLocation location)
                   throws java.io.IOException;

    /**
     * 
     * @throws java.io.IOException
     */
    java.util.List<IResource> getAllResources(ResourceLocation location)
                                       throws java.io.IOException;

}