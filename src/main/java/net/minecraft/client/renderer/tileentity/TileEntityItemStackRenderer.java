package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class TileEntityItemStackRenderer extends Object {

    /**
     *
     */
    public static TileEntityItemStackRenderer instance;

    /**
     *
     */
    private TileEntityChest field_147717_b;

    /**
     *
     */
    private TileEntityChest field_147718_c;

    /**
     *
     */
    private TileEntityEnderChest enderChest;

    /**
     *
     */
    private TileEntityBanner banner;

    /**
     *
     */
    private TileEntitySkull skull;

    /**
     *
     */
    public TileEntityItemStackRenderer() {
        
    }

    /**
     *
     */
    public void renderByItem(ItemStack itemStackIn) {
        return;
    }

}