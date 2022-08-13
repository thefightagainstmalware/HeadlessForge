package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class S0FPacketSpawnMob extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private int type;

    /**
     *
     */
    private int x;

    /**
     *
     */
    private int y;

    /**
     *
     */
    private int z;

    /**
     *
     */
    private int velocityX;

    /**
     *
     */
    private int velocityY;

    /**
     *
     */
    private int velocityZ;

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
    private byte headPitch;

    /**
     *
     */
    private DataWatcher field_149043_l;

    /**
     *
     */
    private java.util.List<DataWatcher.WatchableObject> watcher;

    /**
     *
     */
    public S0FPacketSpawnMob() {
        
    }

    /**
     *
     */
    public S0FPacketSpawnMob(EntityLivingBase entityIn) {
        
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
    public java.util.List<DataWatcher.WatchableObject> func_149027_c() {
        return null;
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
    public int getEntityType() {
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
    public int getVelocityX() {
        return 0;
    }

    /**
     *
     */
    public int getVelocityY() {
        return 0;
    }

    /**
     *
     */
    public int getVelocityZ() {
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
    public byte getHeadPitch() {
        return 0;
    }

}