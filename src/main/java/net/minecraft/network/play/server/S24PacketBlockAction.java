package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;

/**
 *
 */
public class S24PacketBlockAction extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private BlockPos blockPosition;

    /**
     *
     */
    private int instrument;

    /**
     *
     */
    private int pitch;

    /**
     *
     */
    private Block block;

    /**
     *
     */
    public S24PacketBlockAction() {
        
    }

    /**
     *
     */
    public S24PacketBlockAction(BlockPos blockPositionIn,
                                Block blockIn,
                                int instrumentIn,
                                int pitchIn) {
        
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
    public BlockPos getBlockPosition() {
        return null;
    }

    /**
     * instrument data for noteblocks
     */
    public int getData1() {
        return 0;
    }

    /**
     * pitch data for noteblocks
     */
    public int getData2() {
        return 0;
    }

    /**
     *
     */
    public Block getBlockType() {
        return null;
    }

}