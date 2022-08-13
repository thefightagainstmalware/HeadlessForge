package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class S23PacketBlockChange extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private BlockPos blockPosition;

    /**
     *
     */
    public IBlockState blockState;

    /**
     *
     */
    public S23PacketBlockChange() {
        
    }

    /**
     *
     */
    public S23PacketBlockChange(World worldIn,
                                BlockPos blockPositionIn) {
        
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
    public IBlockState getBlockState() {
        return null;
    }

    /**
     *
     */
    public BlockPos getBlockPosition() {
        return null;
    }

}