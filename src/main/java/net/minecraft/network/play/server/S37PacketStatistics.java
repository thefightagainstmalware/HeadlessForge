package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.stats.StatList;
import net.minecraftforge.fml.relauncher.Side;
import java.util.Map.Entry;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.stats.StatBase;

/**
 *
 */
public class S37PacketStatistics extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private java.util.Map<StatBase,java.lang.Integer> field_148976_a;

    /**
     *
     */
    public S37PacketStatistics() {
        
    }

    /**
     *
     */
    public S37PacketStatistics(java.util.Map<StatBase,Integer> p_i45173_1_) {
        
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler) {
        return;
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
    public java.util.Map<StatBase,Integer> func_148974_c() {
        return null;
    }

}