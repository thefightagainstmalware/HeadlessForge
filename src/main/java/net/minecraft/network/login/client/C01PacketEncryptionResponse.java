package net.minecraft.network.login.client;

import net.minecraft.util.CryptManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.INetHandlerLoginServer;

/**
 *
 */
public class C01PacketEncryptionResponse extends Object implements Packet<INetHandlerLoginServer> {

    /**
     *
     */
    private byte[] secretKeyEncrypted;

    /**
     *
     */
    private byte[] verifyTokenEncrypted;

    /**
     *
     */
    public C01PacketEncryptionResponse() {
        
    }

    /**
     *
     */
    public C01PacketEncryptionResponse(javax.crypto.SecretKey secretKey,
                                       java.security.PublicKey publicKey,
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
    public void processPacket(INetHandlerLoginServer handler) {
        return;
    }

    /**
     *
     */
    public javax.crypto.SecretKey getSecretKey(java.security.PrivateKey key) {
        return null;
    }

    /**
     *
     */
    public byte[] getVerifyToken(java.security.PrivateKey key) {
        return null;
    }

}