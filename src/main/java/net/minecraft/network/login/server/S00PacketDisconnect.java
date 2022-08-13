package net.minecraft.network.login.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.network.login.INetHandlerLoginClient;
import java.io.IOException;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class S00PacketDisconnect extends Object implements Packet<INetHandlerLoginClient> {

    /**
     *
     */
    private IChatComponent reason;

    /**
     *
     */
    public S00PacketDisconnect() {
        
    }

    /**
     *
     */
    public S00PacketDisconnect(IChatComponent reasonIn) {
        
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
    public void processPacket(INetHandlerLoginClient handler) {
        return;
    }

    /**
     *
     */
    public IChatComponent func_149603_c() {
        return null;
    }

}