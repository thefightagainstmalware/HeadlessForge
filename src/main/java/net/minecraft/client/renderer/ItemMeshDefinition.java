package net.minecraft.client.renderer;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public interface ItemMeshDefinition {

    /**
     *
     */
    ModelResourceLocation getModelLocation(ItemStack stack);

}