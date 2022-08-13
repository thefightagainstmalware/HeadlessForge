package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class S04PacketEntityEquipment extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityID;

    /**
     *
     */
    private int equipmentSlot;

    /**
     *
     */
    private ItemStack itemStack;

    /**
     *
     */
    public S04PacketEntityEquipment() {
        
    }

    /**
     *
     */
    public S04PacketEntityEquipment(int entityIDIn,
                                    int p_i45221_2_,
                                    ItemStack itemStackIn) {
        
    }

    /**
     * Reads the raw packet data from the data stream.
     * @throws java.io.IOException
     */
    public void readPacketData(PacketBuffer buf)
                        throws java.io.IOException {
        return;
    }

    /**
     * Writes the raw packet data to the data stream.
     * @throws java.io.IOException
     */
    public void writePacketData(PacketBuffer buf)
                         throws java.io.IOException {
        return;
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler) {
        return;
    }

    /**
     *
     */
    public ItemStack getItemStack() {
        return null;
    }

    /**
     *
     */
    public int getEntityID() {
        return 0;
    }

    /**
     *
     */
    public int getEquipmentSlot() {
        return 0;
    }

}