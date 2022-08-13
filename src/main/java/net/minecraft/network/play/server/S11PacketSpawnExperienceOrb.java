package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.item.EntityXPOrb;

/**
 *
 */
public class S11PacketSpawnExperienceOrb extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityID;

    /**
     *
     */
    private int posX;

    /**
     *
     */
    private int posY;

    /**
     *
     */
    private int posZ;

    /**
     *
     */
    private int xpValue;

    /**
     *
     */
    public S11PacketSpawnExperienceOrb() {
        
    }

    /**
     *
     */
    public S11PacketSpawnExperienceOrb(EntityXPOrb xpOrb) {
        
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
    public int getEntityID() {
        return 0;
    }

    /**
     *
     */
    public int getX() {
        return 0;
    }

    /**
     *
     */
    public int getY() {
        return 0;
    }

    /**
     *
     */
    public int getZ() {
        return 0;
    }

    /**
     *
     */
    public int getXPValue() {
        return 0;
    }

}