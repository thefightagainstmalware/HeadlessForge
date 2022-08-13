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
public class S06PacketUpdateHealth extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private float health;

    /**
     *
     */
    private int foodLevel;

    /**
     *
     */
    private float saturationLevel;

    /**
     *
     */
    public S06PacketUpdateHealth() {
        
    }

    /**
     *
     */
    public S06PacketUpdateHealth(float healthIn,
                                 int foodLevelIn,
                                 float saturationIn) {
        
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
    public float getHealth() {
        return 0;
    }

    /**
     *
     */
    public int getFoodLevel() {
        return 0;
    }

    /**
     *
     */
    public float getSaturationLevel() {
        return 0;
    }

}