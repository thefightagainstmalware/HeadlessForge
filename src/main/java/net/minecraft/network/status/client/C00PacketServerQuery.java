package net.minecraft.network.status.client;

import net.minecraft.network.status.INetHandlerStatusServer;
import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

/**
 *
 */
public class C00PacketServerQuery extends Object implements Packet<INetHandlerStatusServer> {

    /**
     *
     */
    public C00PacketServerQuery() {
        
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
    public void processPacket(INetHandlerStatusServer handler) {
        return;
    }

}