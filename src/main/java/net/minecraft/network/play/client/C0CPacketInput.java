package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C0CPacketInput extends Object implements Packet<INetHandlerPlayServer> {

    /**
     * Positive for left strafe, negative for right
     */
    private float strafeSpeed;

    /**
     * Positive for forward, negative for backward
     */
    private float forwardSpeed;

    /**
     *
     */
    private boolean jumping;

    /**
     *
     */
    private boolean sneaking;

    /**
     *
     */
    public C0CPacketInput() {
        
    }

    /**
     *
     */
    public C0CPacketInput(float strafeSpeed,
                          float forwardSpeed,
                          boolean jumping,
                          boolean sneaking) {
        
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
    public void processPacket(INetHandlerPlayServer handler) {
        return;
    }

    /**
     *
     */
    public float getStrafeSpeed() {
        return 0;
    }

    /**
     *
     */
    public float getForwardSpeed() {
        return 0;
    }

    /**
     *
     */
    public boolean isJumping() {
        return true;
    }

    /**
     *
     */
    public boolean isSneaking() {
        return true;
    }

}