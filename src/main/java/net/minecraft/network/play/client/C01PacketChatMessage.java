package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

/**
 *
 */
public class C01PacketChatMessage extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private java.lang.String message;

    /**
     *
     */
    public C01PacketChatMessage() {
        
    }

    /**
     *
     */
    public C01PacketChatMessage(String messageIn) {
        
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
    public String getMessage() {
        return null;
    }

}