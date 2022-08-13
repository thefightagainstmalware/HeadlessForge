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
public class S1BPacketEntityAttach extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int leash;

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private int vehicleEntityId;

    /**
     *
     */
    public S1BPacketEntityAttach() {
        
    }

    /**
     *
     */
    public S1BPacketEntityAttach(int leashIn,
                                 Entity entityIn,
                                 Entity vehicle) {
        
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
    public int getLeash() {
        return 0;
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
    public int getVehicleEntityId() {
        return 0;
    }

}