package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C17PacketCustomPayload extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private java.lang.String channel;

    /**
     *
     */
    private PacketBuffer data;

    /**
     *
     */
    public C17PacketCustomPayload() {
        
    }

    /**
     *
     */
    public C17PacketCustomPayload(String channelIn,
                                  PacketBuffer dataIn) {
        
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
    public String getChannelName() {
        return null;
    }

    /**
     *
     */
    public PacketBuffer getBufferData() {
        return null;
    }

}