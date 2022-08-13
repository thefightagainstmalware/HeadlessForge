package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 *
 */
public class S0APacketUseBed extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int playerID;

    /**
     * Block location of the head part of the bed
     */
    private BlockPos bedPos;

    /**
     *
     */
    public S0APacketUseBed() {
        
    }

    /**
     *
     */
    public S0APacketUseBed(EntityPlayer player,
                           BlockPos bedPosIn) {
        
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
    public EntityPlayer getPlayer(World worldIn) {
        return null;
    }

    /**
     *
     */
    public BlockPos getBedPosition() {
        return null;
    }

}