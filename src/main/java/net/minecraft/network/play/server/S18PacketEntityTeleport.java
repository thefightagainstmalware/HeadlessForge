package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.Entity;

/**
 *
 */
public class S18PacketEntityTeleport extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

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
    private byte yaw;

    /**
     *
     */
    private byte pitch;

    /**
     *
     */
    private boolean onGround;

    /**
     *
     */
    public S18PacketEntityTeleport() {
        
    }

    /**
     *
     */
    public S18PacketEntityTeleport(Entity entityIn) {
        
    }

    /**
     *
     */
    public S18PacketEntityTeleport(int entityIdIn,
                                   int posXIn,
                                   int posYIn,
                                   int posZIn,
                                   byte yawIn,
                                   byte pitchIn,
                                   boolean onGroundIn) {
        
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
    public int getEntityId() {
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
    public byte getYaw() {
        return 0;
    }

    /**
     *
     */
    public byte getPitch() {
        return 0;
    }

    /**
     *
     */
    public boolean getOnGround() {
        return true;
    }

}