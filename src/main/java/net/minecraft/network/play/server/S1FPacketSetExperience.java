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
public class S1FPacketSetExperience extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private float field_149401_a;

    /**
     *
     */
    private int totalExperience;

    /**
     *
     */
    private int level;

    /**
     *
     */
    public S1FPacketSetExperience() {
        
    }

    /**
     *
     */
    public S1FPacketSetExperience(float p_i45222_1_,
                                  int totalExperienceIn,
                                  int levelIn) {
        
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
    public float func_149397_c() {
        return 0;
    }

    /**
     *
     */
    public int getTotalExperience() {
        return 0;
    }

    /**
     *
     */
    public int getLevel() {
        return 0;
    }

}