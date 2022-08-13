package net.minecraft.network.play.server;

import net.minecraft.potion.PotionEffect;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class S1EPacketRemoveEntityEffect extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private int effectId;

    /**
     *
     */
    public S1EPacketRemoveEntityEffect() {
        
    }

    /**
     *
     */
    public S1EPacketRemoveEntityEffect(int entityIdIn,
                                       PotionEffect effect) {
        
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
    public int getEntityId() {
        return 0;
    }

    /**
     *
     */
    public int getEffectId() {
        return 0;
    }

}