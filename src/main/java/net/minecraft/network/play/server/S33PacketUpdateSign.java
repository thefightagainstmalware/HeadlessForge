package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class S33PacketUpdateSign extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private World world;

    /**
     *
     */
    private BlockPos blockPos;

    /**
     *
     */
    private IChatComponent[] lines;

    /**
     *
     */
    public S33PacketUpdateSign() {
        
    }

    /**
     *
     */
    public S33PacketUpdateSign(World worldIn,
                               BlockPos blockPosIn,
                               IChatComponent[] linesIn) {
        
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
    public BlockPos getPos() {
        return null;
    }

    /**
     *
     */
    public IChatComponent[] getLines() {
        return null;
    }

}