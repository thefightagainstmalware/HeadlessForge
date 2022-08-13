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
public class S2FPacketSetSlot extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int windowId;

    /**
     *
     */
    private int slot;

    /**
     *
     */
    private ItemStack item;

    /**
     *
     */
    public S2FPacketSetSlot() {
        
    }

    /**
     *
     */
    public S2FPacketSetSlot(int windowIdIn,
                            int slotIn,
                            ItemStack itemIn) {
        
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler) {
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
    public int func_149175_c() {
        return 0;
    }

    /**
     *
     */
    public int func_149173_d() {
        return 0;
    }

    /**
     *
     */
    public ItemStack func_149174_e() {
        return null;
    }

}