package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class S40PacketDisconnect extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private IChatComponent reason;

    /**
     *
     */
    public S40PacketDisconnect() {
        
    }

    /**
     *
     */
    public S40PacketDisconnect(IChatComponent reasonIn) {
        
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
    public IChatComponent getReason() {
        return null;
    }

}