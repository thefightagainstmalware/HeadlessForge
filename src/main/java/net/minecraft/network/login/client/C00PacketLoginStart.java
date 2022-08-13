package net.minecraft.network.login.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginServer;
import java.io.IOException;
import java.util.UUID;

/**
 *
 */
public class C00PacketLoginStart extends Object implements Packet<INetHandlerLoginServer> {

    /**
     *
     */
    private GameProfile profile;

    /**
     *
     */
    public C00PacketLoginStart() {
        
    }

    /**
     *
     */
    public C00PacketLoginStart(GameProfile profileIn) {
        
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
    public void processPacket(INetHandlerLoginServer handler) {
        return;
    }

    /**
     *
     */
    public GameProfile getProfile() {
        return null;
    }

}