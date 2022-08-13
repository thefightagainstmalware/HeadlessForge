package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.world.WorldServer;
import java.io.IOException;
import java.util.UUID;

/**
 *
 */
public class C18PacketSpectate extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private java.util.UUID id;

    /**
     *
     */
    public C18PacketSpectate() {
        
    }

    /**
     *
     */
    public C18PacketSpectate(java.util.UUID id) {
        
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
    public void processPacket(INetHandlerPlayServer handler) {
        return;
    }

    /**
     *
     */
    public Entity getEntity(WorldServer worldIn) {
        return null;
    }

}