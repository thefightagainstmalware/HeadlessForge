package net.minecraft.network.login.server;

import net.minecraft.util.CryptManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginClient;

/**
 *
 */
public class S01PacketEncryptionRequest extends Object implements Packet<INetHandlerLoginClient> {

    /**
     *
     */
    private java.lang.String hashedServerId;

    /**
     *
     */
    private java.security.PublicKey publicKey;

    /**
     *
     */
    private byte[] verifyToken;

    /**
     *
     */
    public S01PacketEncryptionRequest() {
        
    }

    /**
     *
     */
    public S01PacketEncryptionRequest(String serverId,
                                      java.security.PublicKey key,
                                      byte[] verifyToken) {
        
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
    public String getServerId() {
        return null;
    }

    /**
     *
     */
    public java.security.PublicKey getPublicKey() {
        return null;
    }

    /**
     *
     */
    public byte[] getVerifyToken() {
        return null;
    }

}