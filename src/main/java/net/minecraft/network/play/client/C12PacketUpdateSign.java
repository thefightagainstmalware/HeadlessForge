package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class C12PacketUpdateSign extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private BlockPos pos;

    /**
     *
     */
    private IChatComponent[] lines;

    /**
     *
     */
    public C12PacketUpdateSign() {
        
    }

    /**
     *
     */
    public C12PacketUpdateSign(BlockPos pos,
                               IChatComponent[] lines) {
        
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
    public BlockPos getPosition() {
        return null;
    }

    /**
     *
     */
    public IChatComponent[] getLines() {
        return null;
    }

}