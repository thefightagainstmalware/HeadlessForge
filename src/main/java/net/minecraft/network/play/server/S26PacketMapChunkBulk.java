package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.chunk.Chunk;
import java.io.IOException;

/**
 *
 */
public class S26PacketMapChunkBulk extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int[] xPositions;

    /**
     *
     */
    private int[] zPositions;

    /**
     *
     */
    private S21PacketChunkData.Extracted[] chunksData;

    /**
     *
     */
    private boolean isOverworld;

    /**
     *
     */
    public S26PacketMapChunkBulk() {
        
    }

    /**
     *
     */
    public S26PacketMapChunkBulk(java.util.List<Chunk> chunks) {
        
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
    public int getChunkX(int p_149255_1_) {
        return 0;
    }

    /**
     *
     */
    public int getChunkZ(int p_149253_1_) {
        return 0;
    }

    /**
     *
     */
    public int getChunkCount() {
        return 0;
    }

    /**
     *
     */
    public byte[] getChunkBytes(int p_149256_1_) {
        return null;
    }

    /**
     *
     */
    public int getChunkSize(int p_179754_1_) {
        return 0;
    }

}