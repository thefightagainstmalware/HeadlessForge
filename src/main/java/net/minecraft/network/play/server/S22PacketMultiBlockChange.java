package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.ChunkCoordIntPair;

/**
 *
 */
public class S22PacketMultiBlockChange extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private ChunkCoordIntPair chunkPosCoord;

    /**
     *
     */
    private S22PacketMultiBlockChange.BlockUpdateData[] changedBlocks;

    /**
     *
     */
    public S22PacketMultiBlockChange() {
        
    }

    /**
     *
     */
    public S22PacketMultiBlockChange(int p_i45181_1_,
                                     short[] crammedPositionsIn,
                                     Chunk chunkIn) {
        
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
    public S22PacketMultiBlockChange.BlockUpdateData[] getChangedBlocks() {
        return null;
    }

    public class BlockUpdateData {
    }
}