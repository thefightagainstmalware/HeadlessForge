package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.DataWatcher;

/**
 *
 */
public class S0CPacketSpawnPlayer extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private java.util.UUID playerId;

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
    private byte yaw;

    /**
     *
     */
    private byte pitch;

    /**
     *
     */
    private int currentItem;

    /**
     *
     */
    private DataWatcher watcher;

    /**
     *
     */
    private java.util.List<DataWatcher.WatchableObject> field_148958_j;

    /**
     *
     */
    public S0CPacketSpawnPlayer() {
        
    }

    /**
     *
     */
    public S0CPacketSpawnPlayer(EntityPlayer player) {
        
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
    public java.util.List<DataWatcher.WatchableObject> func_148944_c() {
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
    public java.util.UUID getPlayer() {
        return null;
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
    public int getCurrentItemID() {
        return 0;
    }

}