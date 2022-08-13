package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.DataWatcher;
import java.io.IOException;

/**
 *
 */
public class S1CPacketEntityMetadata extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private java.util.List<DataWatcher.WatchableObject> field_149378_b;

    /**
     *
     */
    public S1CPacketEntityMetadata() {
        
    }

    /**
     *
     */
    public S1CPacketEntityMetadata(int entityIdIn,
                                   DataWatcher p_i45217_2_,
                                   boolean p_i45217_3_) {
        
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
    public java.util.List<DataWatcher.WatchableObject> func_149376_c() {
        return null;
    }

    /**
     *
     */
    public int getEntityId() {
        return 0;
    }

}