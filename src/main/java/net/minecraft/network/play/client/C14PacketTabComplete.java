package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;
import net.minecraft.network.play.INetHandlerPlayServer;

/**
 *
 */
public class C14PacketTabComplete extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private java.lang.String message;

    /**
     *
     */
    private BlockPos targetBlock;

    /**
     *
     */
    public C14PacketTabComplete() {
        
    }

    /**
     *
     */
    public C14PacketTabComplete(String msg) {
        
    }

    /**
     *
     */
    public C14PacketTabComplete(String msg,
                                BlockPos target) {
        
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

    /**
     *
     */
    public BlockPos getTargetBlock() {
        return null;
    }

}