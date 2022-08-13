package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class S3FPacketCustomPayload extends Object implements Packet<INetHandlerPlayClient> {

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
    public S3FPacketCustomPayload() {
        
    }

    /**
     *
     */
    public S3FPacketCustomPayload(String channelName,
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
    public void processPacket(INetHandlerPlayClient handler) {
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