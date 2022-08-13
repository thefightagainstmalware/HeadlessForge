package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class S30PacketWindowItems extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int windowId;

    /**
     *
     */
    private ItemStack[] itemStacks;

    /**
     *
     */
    public S30PacketWindowItems() {
        
    }

    /**
     *
     */
    public S30PacketWindowItems(int windowIdIn,
                                java.util.List<ItemStack> p_i45186_2_) {
        
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
    public int func_148911_c() {
        return 0;
    }

    /**
     *
     */
    public ItemStack[] getItemStacks() {
        return null;
    }

}