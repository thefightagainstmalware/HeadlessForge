package net.minecraft.network.login.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.network.login.INetHandlerLoginClient;
import java.io.IOException;

/**
 *
 */
public class S03PacketEnableCompression extends Object implements Packet<INetHandlerLoginClient> {

    /**
     *
     */
    private int compressionTreshold;

    /**
     *
     */
    public S03PacketEnableCompression() {
        
    }

    /**
     *
     */
    public S03PacketEnableCompression(int compressionTresholdIn) {
        
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
    public int getCompressionTreshold() {
        return 0;
    }

}