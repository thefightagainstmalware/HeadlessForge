package net.minecraft.network.status.server;

import net.minecraft.network.status.INetHandlerStatusClient;
import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

/**
 *
 */
public class S01PacketPong extends Object implements Packet<INetHandlerStatusClient> {

    /**
     *
     */
    private long clientTime;

    /**
     *
     */
    public S01PacketPong() {
        
    }

    /**
     *
     */
    public S01PacketPong(long time) {
        
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
    public void processPacket(INetHandlerStatusClient handler) {
        return;
    }

}