package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class S25PacketBlockBreakAnim extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int breakerId;

    /**
     *
     */
    private BlockPos position;

    /**
     *
     */
    private int progress;

    /**
     *
     */
    public S25PacketBlockBreakAnim() {
        
    }

    /**
     *
     */
    public S25PacketBlockBreakAnim(int breakerId,
                                   BlockPos pos,
                                   int progress) {
        
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
    public int getBreakerId() {
        return 0;
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
    public int getProgress() {
        return 0;
    }

}