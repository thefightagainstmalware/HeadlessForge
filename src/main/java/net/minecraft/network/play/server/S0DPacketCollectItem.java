package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class S0DPacketCollectItem extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int collectedItemEntityId;

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    public S0DPacketCollectItem() {
        
    }

    /**
     *
     */
    public S0DPacketCollectItem(int collectedItemEntityIdIn,
                                int entityIdIn) {
        
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
    public int getCollectedItemEntityID() {
        return 0;
    }

    /**
     *
     */
    public int getEntityID() {
        return 0;
    }

}