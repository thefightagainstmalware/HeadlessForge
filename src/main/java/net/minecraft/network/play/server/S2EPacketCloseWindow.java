package net.minecraft.network.play.server;

import net.minecraft.network.play.INetHandlerPlayClient;
import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

/**
 *
 */
public class S2EPacketCloseWindow extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int windowId;

    /**
     *
     */
    public S2EPacketCloseWindow() {
        
    }

    /**
     *
     */
    public S2EPacketCloseWindow(int windowIdIn) {
        
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

}