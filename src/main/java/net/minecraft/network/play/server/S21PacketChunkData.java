package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.chunk.Chunk;
import com.google.common.collect.Lists;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import java.io.IOException;

/**
 *
 */
public class S21PacketChunkData extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int chunkX;

    /**
     *
     */
    private int chunkZ;

    /**
     *
     */
    private S21PacketChunkData.Extracted extractedData;

    /**
     *
     */
    private boolean field_149279_g;

    /**
     *
     */
    public S21PacketChunkData() {
        
    }

    /**
     *
     */
    public S21PacketChunkData(Chunk chunkIn,
                              boolean p_i45196_2_,
                              int p_i45196_3_) {
        
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
    public byte[] func_149272_d() {
        return null;
    }

    /**
     *
     */
    protected static int func_180737_a(int p_180737_0_,
                                       boolean p_180737_1_,
                                       boolean p_180737_2_) {
        return 0;
    }

    /**
     *
     */
    public static S21PacketChunkData.Extracted func_179756_a(Chunk p_179756_0_,
                                                             boolean p_179756_1_,
                                                             boolean p_179756_2_,
                                                             int p_179756_3_) {
        return null;
    }

    /**
     *
     */
    private static int func_179757_a(byte[] p_179757_0_,
                                     byte[] p_179757_1_,
                                     int p_179757_2_) {
        return 0;
    }

    /**
     *
     */
    public int getChunkX() {
        return 0;
    }

    /**
     *
     */
    public int getChunkZ() {
        return 0;
    }

    /**
     *
     */
    public int getExtractedSize() {
        return 0;
    }

    /**
     *
     */
    public boolean func_149274_i() {
        return true;
    }

    public class Extracted {
    }
}