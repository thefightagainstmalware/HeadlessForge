package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.Entity;

/**
 *
 */
public class S0EPacketSpawnObject extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

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
    private int speedX;

    /**
     *
     */
    private int speedY;

    /**
     *
     */
    private int speedZ;

    /**
     *
     */
    private int pitch;

    /**
     *
     */
    private int yaw;

    /**
     *
     */
    private int type;

    /**
     *
     */
    private int field_149020_k;

    /**
     *
     */
    public S0EPacketSpawnObject() {
        
    }

    /**
     *
     */
    public S0EPacketSpawnObject(Entity entityIn,
                                int typeIn) {
        
    }

    /**
     *
     */
    public S0EPacketSpawnObject(Entity entityIn,
                                int typeIn,
                                int p_i45166_3_) {
        
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
    public void setX(int newX) {
        return;
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
    public void setY(int newY) {
        return;
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
    public void setZ(int newZ) {
        return;
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
    public void setSpeedX(int newSpeedX) {
        return;
    }

    /**
     *
     */
    public int getSpeedX() {
        return 0;
    }

    /**
     *
     */
    public void setSpeedY(int newSpeedY) {
        return;
    }

    /**
     *
     */
    public int getSpeedY() {
        return 0;
    }

    /**
     *
     */
    public void setSpeedZ(int newSpeedZ) {
        return;
    }

    /**
     *
     */
    public int getSpeedZ() {
        return 0;
    }

    /**
     *
     */
    public int getPitch() {
        return 0;
    }

    /**
     *
     */
    public int getYaw() {
        return 0;
    }

    /**
     *
     */
    public int getType() {
        return 0;
    }

    /**
     *
     */
    public int func_149009_m() {
        return 0;
    }

    /**
     *
     */
    public void func_149002_g(int p_149002_1_) {
        return;
    }

}