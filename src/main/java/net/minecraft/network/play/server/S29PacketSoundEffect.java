package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.INetHandlerPlayClient;

/**
 *
 */
public class S29PacketSoundEffect extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private java.lang.String soundName;

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
    private float soundVolume;

    /**
     *
     */
    private int soundPitch;

    /**
     *
     */
    public S29PacketSoundEffect() {
        
    }

    /**
     *
     */
    public S29PacketSoundEffect(String soundNameIn,
                                double soundX,
                                double soundY,
                                double soundZ,
                                float volume,
                                float pitch) {
        
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
    public String getSoundName() {
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
    public float getVolume() {
        return 0;
    }

    /**
     *
     */
    public float getPitch() {
        return 0;
    }

}