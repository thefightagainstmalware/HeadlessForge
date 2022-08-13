package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class S05PacketSpawnPosition extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private BlockPos spawnBlockPos;

    /**
     *
     */
    public S05PacketSpawnPosition() {
        
    }

    /**
     *
     */
    public S05PacketSpawnPosition(BlockPos spawnBlockPosIn) {
        
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
    public BlockPos getSpawnPos() {
        return null;
    }

}