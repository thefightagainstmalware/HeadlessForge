package net.minecraft.client.resources;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import java.util.List;

/**
 *
 */
public interface IReloadableResourceManager extends IResourceManager {

    /**
     *
     */
    void reloadResources(java.util.List<IResourcePack> p_110541_1_);

    /**
     *
     */
    void func_110542_a(IResourceManagerReloadListener reloadListener);

}