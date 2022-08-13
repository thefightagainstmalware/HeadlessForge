package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;

/**
 *
 */
public class S27PacketExplosion extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private double posX;

    /**
     *
     */
    private double posY;

    /**
     *
     */
    private double posZ;

    /**
     *
     */
    private float strength;

    /**
     *
     */
    private java.util.List<BlockPos> affectedBlockPositions;

    /**
     *
     */
    private float field_149152_f;

    /**
     *
     */
    private float field_149153_g;

    /**
     *
     */
    private float field_149159_h;

    /**
     *
     */
    public S27PacketExplosion() {
        
    }

    /**
     *
     */
    public S27PacketExplosion(double p_i45193_1_,
                              double y,
                              double z,
                              float strengthIn,
                              java.util.List<BlockPos> affectedBlocksIn,
                              Vec3 p_i45193_9_) {
        
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
    public float func_149149_c() {
        return 0;
    }

    /**
     *
     */
    public float func_149144_d() {
        return 0;
    }

    /**
     *
     */
    public float func_149147_e() {
        return 0;
    }

    /**
     *
     */
    public double getX() {
        return 0;
    }

    /**
     *
     */
    public double getY() {
        return 0;
    }

    /**
     *
     */
    public double getZ() {
        return 0;
    }

    /**
     *
     */
    public float getStrength() {
        return 0;
    }

    /**
     *
     */
    public java.util.List<BlockPos> getAffectedBlockPositions() {
        return null;
    }

}