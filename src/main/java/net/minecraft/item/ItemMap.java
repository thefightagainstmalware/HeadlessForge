package net.minecraft.item;

import net.minecraft.network.Packet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.storage.MapData;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 *
 */
public class ItemMap extends ItemMapBase {

    /**
     *
     */
    protected ItemMap() {
        
    }

    /**
     *
     */
    public static MapData loadMapData(int mapId,
                                      World worldIn) {
        return null;
    }

    /**
     *
     */
    public MapData getMapData(ItemStack stack,
                              World worldIn) {
        return null;
    }

    /**
     *
     */
    public void updateMapData(World worldIn,
                              Entity viewer,
                              MapData data) {
        return;
    }

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    @Override
    public void onUpdate(ItemStack stack,
                         World worldIn,
                         Entity entityIn,
                         int itemSlot,
                         boolean isSelected) {
        return;
    }

    /**
     *
     */
    @Override
    public Packet createMapDataPacket(ItemStack stack,
                                      World worldIn,
                                      EntityPlayer player) {
        return null;
    }

    /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    @Override
    public void onCreated(ItemStack stack,
                          World worldIn,
                          EntityPlayer playerIn) {
        return;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    public void addInformation(ItemStack stack,
                               EntityPlayer playerIn,
                               java.util.List<String> tooltip,
                               boolean advanced) {
        return;
    }

}