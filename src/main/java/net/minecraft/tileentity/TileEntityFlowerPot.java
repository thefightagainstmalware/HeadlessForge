package net.minecraft.tileentity;

import net.minecraft.network.Packet;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item;

/**
 *
 */
public class TileEntityFlowerPot extends TileEntity {

    /**
     *
     */
    private Item flowerPotItem;

    /**
     *
     */
    private int flowerPotData;

    /**
     *
     */
    public TileEntityFlowerPot() {
        
    }

    /**
     *
     */
    public TileEntityFlowerPot(Item potItem,
                               int potData) {
        
    }

    /**
     *
     */
    @Override
    public void func_145841_b(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    @Override
    public void func_145839_a(NBTTagCompound compound) {
        return;
    }

    /**
     * Allows for a specialized description packet to be created. This is often used to sync tile entity data from the
     * server to the client easily. For example this is used by signs to synchronise the text to be displayed.
     */
    @Override
    public Packet getDescriptionPacket() {
        return null;
    }

    /**
     *
     */
    public void setFlowerPotData(Item potItem,
                                 int potData) {
        return;
    }

    /**
     *
     */
    public Item getFlowerPotItem() {
        return null;
    }

    /**
     *
     */
    public int getFlowerPotData() {
        return 0;
    }

}