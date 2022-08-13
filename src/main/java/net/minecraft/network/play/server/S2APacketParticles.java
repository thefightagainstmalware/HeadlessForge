package net.minecraft.network.play.server;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

/**
 *
 */
public class S2APacketParticles extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private EnumParticleTypes particleType;

    /**
     *
     */
    private float xCoord;

    /**
     *
     */
    private float yCoord;

    /**
     *
     */
    private float zCoord;

    /**
     *
     */
    private float xOffset;

    /**
     *
     */
    private float yOffset;

    /**
     *
     */
    private float zOffset;

    /**
     *
     */
    private float particleSpeed;

    /**
     *
     */
    private int particleCount;

    /**
     *
     */
    private boolean longDistance;

    /**
     * These are the block/item ids and possibly metaData ids that are used to color or texture the particle.
     */
    private int[] particleArguments;

    /**
     *
     */
    public S2APacketParticles() {
        
    }

    /**
     *
     */
    public S2APacketParticles(EnumParticleTypes particleTypeIn,
                              boolean longDistanceIn,
                              float x,
                              float y,
                              float z,
                              float xOffsetIn,
                              float yOffset,
                              float zOffset,
                              float particleSpeedIn,
                              int particleCountIn,
                              int... particleArgumentsIn) {
        
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
     *
     */
    public EnumParticleTypes getParticleType() {
        return null;
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
    public boolean isLongDistance() {
        return true;
    }

    /**
     * Gets the x coordinate to spawn the particle.
     */
    public double getXCoordinate() {
        return 0;
    }

    /**
     * Gets the y coordinate to spawn the particle.
     */
    public double getYCoordinate() {
        return 0;
    }

    /**
     * Gets the z coordinate to spawn the particle.
     */
    public double getZCoordinate() {
        return 0;
    }

    /**
     * Gets the x coordinate offset for the particle. The particle may use the offset for particle spread.
     */
    public float getXOffset() {
        return 0;
    }

    /**
     * Gets the y coordinate offset for the particle. The particle may use the offset for particle spread.
     */
    public float getYOffset() {
        return 0;
    }

    /**
     * Gets the z coordinate offset for the particle. The particle may use the offset for particle spread.
     */
    public float getZOffset() {
        return 0;
    }

    /**
     * Gets the speed of the particle animation (used in client side rendering).
     */
    public float getParticleSpeed() {
        return 0;
    }

    /**
     * Gets the amount of particles to spawn
     */
    public int getParticleCount() {
        return 0;
    }

    /**
     * Gets the particle arguments. Some particles rely on block and/or item ids and sometimes metadata ids to color or
     * texture the particle.
     */
    public int[] getParticleArgs() {
        return null;
    }

}