package net.minecraft.client.resources;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import gq.malwarefight.headlessforge.HeadlessForge;
import gq.malwarefight.headlessforge.ModResourceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleReloadableResourceManager implements IReloadableResourceManager
{
    private static final Logger logger = LogManager.getLogger();
    private static final Joiner joinerResourcePacks = Joiner.on(", ");
    private final Map<String, FallbackResourceManager> domainResourceManagers = Maps.<String, FallbackResourceManager>newHashMap();
    private final List<IResourceManagerReloadListener> reloadListeners = Lists.<IResourceManagerReloadListener>newArrayList();
    private final Set<String> setResourceDomains = Sets.<String>newLinkedHashSet();
    private final IMetadataSerializer rmMetadataSerializer;

    public SimpleReloadableResourceManager(IMetadataSerializer rmMetadataSerializerIn)
    {
        this.rmMetadataSerializer = rmMetadataSerializerIn;
    }

    public void reloadResourcePack(IResourcePack resourcePack) {
        for (String s : resourcePack.getResourceDomains())
        {
            this.setResourceDomains.add(s);
            FallbackResourceManager fallbackresourcemanager = (FallbackResourceManager)this.domainResourceManagers.get(s);

            if (fallbackresourcemanager == null)
            {
                fallbackresourcemanager = new FallbackResourceManager(this.rmMetadataSerializer);
                this.domainResourceManagers.put(s, fallbackresourcemanager);
            }

            fallbackresourcemanager.addResourcePack(resourcePack);
        }
    }

    public Set<String> getResourceDomains()
    {
        return this.setResourceDomains;
    }

    public IResource func_110536_a(ResourceLocation location) throws IOException
    {
        IResourceManager iresourcemanager = this.domainResourceManagers.get(location.func_110624_b());

        if (iresourcemanager != null)
        {
            return iresourcemanager.func_110536_a(location);
        }
        else
        {
            System.out.println("[WARN]: attempting to fix, this could end badly");
            return new ModResourceManager(HeadlessForge.instance.modid, HeadlessForge.instance.mod).func_110536_a(location);
        }
    }

    public List<IResource> getAllResources(ResourceLocation location) throws IOException
    {
        IResourceManager iresourcemanager = (IResourceManager)this.domainResourceManagers.get(location.func_110624_b());

        if (iresourcemanager != null)
        {
            return iresourcemanager.getAllResources(location);
        }
        else
        {
            throw new FileNotFoundException(location.toString());
        }
    }

    private void clearResources()
    {
        this.domainResourceManagers.clear();
        this.setResourceDomains.clear();
    }

    public void reloadResources(List<IResourcePack> p_110541_1_)
    {
        this.clearResources();
        logger.info("Reloading ResourceManager: " + joinerResourcePacks.join(Iterables.transform(p_110541_1_, new Function<IResourcePack, String>()
        {
            public String apply(IResourcePack p_apply_1_)
            {
                return p_apply_1_.getPackName();
            }
        })));

        for (IResourcePack iresourcepack : p_110541_1_)
        {
            this.reloadResourcePack(iresourcepack);
        }

        this.notifyReloadListeners();
    }

    public void func_110542_a(IResourceManagerReloadListener reloadListener)
    {
        this.reloadListeners.add(reloadListener);
        reloadListener.func_110549_a(this);
    }

    private void notifyReloadListeners()
    {
        for (IResourceManagerReloadListener iresourcemanagerreloadlistener : this.reloadListeners)
        {
            iresourcemanagerreloadlistener.func_110549_a(this);
        }
    }
}
