package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class S28PacketEffect extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int soundType;

    /**
     *
     */
    private BlockPos soundPos;

    /**
     * can be a block/item id or other depending on the soundtype
     */
    private int soundData;

    /**
     * If true the sound is played across the server
     */
    private boolean serverWide;

    /**
     *
     */
    public S28PacketEffect() {
        
    }

    /**
     *
     */
    public S28PacketEffect(int soundTypeIn,
                           BlockPos soundPosIn,
                           int soundDataIn,
                           boolean serverWideIn) {
        
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
    public boolean isSoundServerwide() {
        return true;
    }

    /**
     *
     */
    public int getSoundType() {
        return 0;
    }

    /**
     *
     */
    public int getSoundData() {
        return 0;
    }

    /**
     *
     */
    public BlockPos getSoundPos() {
        return null;
    }

}