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
public class S32PacketConfirmTransaction extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int windowId;

    /**
     *
     */
    private short actionNumber;

    /**
     *
     */
    private boolean field_148893_c;

    /**
     *
     */
    public S32PacketConfirmTransaction() {
        
    }

    /**
     *
     */
    public S32PacketConfirmTransaction(int windowIdIn,
                                       short actionNumberIn,
                                       boolean p_i45182_3_) {
        
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
    public int getWindowId() {
        return 0;
    }

    /**
     *
     */
    public short getActionNumber() {
        return 0;
    }

    /**
     *
     */
    public boolean func_148888_e() {
        return true;
    }

}