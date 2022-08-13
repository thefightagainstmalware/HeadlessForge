package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

/**
 *
 */
public class C16PacketClientStatus extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private C16PacketClientStatus.EnumState status;

    /**
     *
     */
    public C16PacketClientStatus() {
        
    }

    /**
     *
     */
    public C16PacketClientStatus(C16PacketClientStatus.EnumState statusIn) {
        
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
    public void processPacket(INetHandlerPlayServer handler) {
        return;
    }

    /**
     *
     */
    public C16PacketClientStatus.EnumState getStatus() {
        return null;
    }

    public enum EnumState {}
}