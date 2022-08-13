package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C0FPacketConfirmTransaction extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private int windowId;

    /**
     *
     */
    private short uid;

    /**
     *
     */
    private boolean accepted;

    /**
     *
     */
    public C0FPacketConfirmTransaction() {
        
    }

    /**
     *
     */
    public C0FPacketConfirmTransaction(int windowId,
                                       short uid,
                                       boolean accepted) {
        
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
    public int getWindowId() {
        return 0;
    }

    /**
     *
     */
    public short getUid() {
        return 0;
    }

}