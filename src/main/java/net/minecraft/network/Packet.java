package net.minecraft.network;

/**
 *
 */
public interface Packet<T extends INetHandler> {

    /**
     * Reads the raw packet data from the data stream.
     * @throws java.io.IOException
     */
    void readPacketData(PacketBuffer buf)
                 throws java.io.IOException;

    /**
     * Writes the raw packet data to the data stream.
     * @throws java.io.IOException
     */
    void writePacketData(PacketBuffer buf)
                  throws java.io.IOException;

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    void processPacket(T handler);

}