package net.minecraftforge.fml.client.registry;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

public class ClientRegistry {
    private static Map<Class<? extends Entity>, ResourceLocation> entityShaderMap = Maps.newHashMap();

    public ClientRegistry() {
    }

    public static <T extends TileEntity> void registerTileEntity(Class<T> tileEntityClass, String id, TileEntitySpecialRenderer<? super T> specialRenderer) {
//        GameRegistry.registerTileEntity(tileEntityClass, id);
        bindTileEntitySpecialRenderer(tileEntityClass, specialRenderer);
    }

    public static <T extends TileEntity> void bindTileEntitySpecialRenderer(Class<T> tileEntityClass, TileEntitySpecialRenderer<? super T> specialRenderer) {
        TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(tileEntityClass, specialRenderer);
        specialRenderer.setRendererDispatcher(TileEntityRendererDispatcher.instance);
    }

    public static void registerKeyBinding(KeyBinding key) {
        Minecraft.func_71410_x().field_71474_y.field_74324_K = (KeyBinding[])ArrayUtils.add(Minecraft.func_71410_x().field_71474_y.field_74324_K, key);
    }

    public static void registerEntityShader(Class<? extends Entity> entityClass, ResourceLocation shader) {
        entityShaderMap.put(entityClass, shader);
    }

    public static ResourceLocation getEntityShader(Class<? extends Entity> entityClass) {
        return (ResourceLocation)entityShaderMap.get(entityClass);
    }
}
