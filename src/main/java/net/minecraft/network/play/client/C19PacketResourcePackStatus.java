package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C19PacketResourcePackStatus extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private java.lang.String hash;

    /**
     *
     */
    private C19PacketResourcePackStatus.Action status;

    /**
     *
     */
    public C19PacketResourcePackStatus() {
        
    }

    /**
     *
     */
    public C19PacketResourcePackStatus(String hashIn,
                                       C19PacketResourcePackStatus.Action statusIn) {
        
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

    public class Action {
    }
}