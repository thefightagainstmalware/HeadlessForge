package net.minecraft.network.handshake.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.handshake.INetHandlerHandshakeServer;
import java.io.IOException;

/**
 *
 */
public class C00Handshake extends Object implements Packet<INetHandlerHandshakeServer> {

    /**
     *
     */
    private int protocolVersion;

    /**
     *
     */
    private java.lang.String ip;

    /**
     *
     */
    private int port;

    /**
     *
     */
    private EnumConnectionState requestedState;

    /**
     *
     */
    private boolean hasFMLMarker;

    /**
     *
     */
    public C00Handshake() {
        
    }

    /**
     *
     */
    public C00Handshake(int version,
                        String ip,
                        int port,
                        EnumConnectionState requestedState) {
        
    }

    /**
     *
     */
    public C00Handshake(int protocol,
                        String address,
                        int port,
                        EnumConnectionState state,
                        boolean addFMLMarker) {
        
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
    public void processPacket(INetHandlerHandshakeServer handler) {
        return;
    }

    /**
     *
     */
    public EnumConnectionState getRequestedState() {
        return null;
    }

    /**
     *
     */
    public int getProtocolVersion() {
        return 0;
    }

    /**
     *
     */
    public boolean hasFMLMarker() {
        return true;
    }

}