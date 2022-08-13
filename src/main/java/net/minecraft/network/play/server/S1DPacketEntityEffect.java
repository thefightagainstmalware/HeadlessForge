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
public class S1DPacketEntityEffect extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private byte effectId;

    /**
     *
     */
    private byte amplifier;

    /**
     *
     */
    private int duration;

    /**
     *
     */
    private byte hideParticles;

    /**
     *
     */
    public S1DPacketEntityEffect() {
        
    }

    /**
     *
     */
    public S1DPacketEntityEffect(int entityIdIn,
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
     *
     */
    public boolean func_149429_c() {
        return true;
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
    public byte getEffectId() {
        return 0;
    }

    /**
     *
     */
    public byte getAmplifier() {
        return 0;
    }

    /**
     *
     */
    public int getDuration() {
        return 0;
    }

    /**
     *
     */
    public boolean func_179707_f() {
        return true;
    }

}