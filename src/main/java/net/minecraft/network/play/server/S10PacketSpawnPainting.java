package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.item.EntityPainting;

/**
 *
 */
public class S10PacketSpawnPainting extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityID;

    /**
     *
     */
    private BlockPos position;

    /**
     *
     */
    private EnumFacing facing;

    /**
     *
     */
    private java.lang.String title;

    /**
     *
     */
    public S10PacketSpawnPainting() {
        
    }

    /**
     *
     */
    public S10PacketSpawnPainting(EntityPainting painting) {
        
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
    public int getEntityID() {
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
    public EnumFacing getFacing() {
        return null;
    }

    /**
     *
     */
    public String getTitle() {
        return null;
    }

}