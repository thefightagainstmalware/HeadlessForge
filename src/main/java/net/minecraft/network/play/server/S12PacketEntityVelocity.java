package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class S12PacketEntityVelocity extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityID;

    /**
     *
     */
    private int motionX;

    /**
     *
     */
    private int motionY;

    /**
     *
     */
    private int motionZ;

    /**
     *
     */
    public S12PacketEntityVelocity() {
        
    }

    /**
     *
     */
    public S12PacketEntityVelocity(Entity entityIn) {
        
    }

    /**
     *
     */
    public S12PacketEntityVelocity(int entityIDIn,
                                   double motionXIn,
                                   double motionYIn,
                                   double motionZIn) {
        
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
    public int getMotionX() {
        return 0;
    }

    /**
     *
     */
    public int getMotionY() {
        return 0;
    }

    /**
     *
     */
    public int getMotionZ() {
        return 0;
    }

}