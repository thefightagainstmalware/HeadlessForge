package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C10PacketCreativeInventoryAction extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private int slotId;

    /**
     *
     */
    private ItemStack stack;

    /**
     *
     */
    public C10PacketCreativeInventoryAction() {
        
    }

    /**
     *
     */
    public C10PacketCreativeInventoryAction(int slotIdIn,
                                            ItemStack stackIn) {
        
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayServer handler) {
        return;
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
     *
     */
    public int getSlotId() {
        return 0;
    }

    /**
     *
     */
    public ItemStack getStack() {
        return null;
    }

}