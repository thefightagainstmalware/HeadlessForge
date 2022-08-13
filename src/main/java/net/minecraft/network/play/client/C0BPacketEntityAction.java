package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C0BPacketEntityAction extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private int entityID;

    /**
     *
     */
    private C0BPacketEntityAction.Action action;

    /**
     *
     */
    private int auxData;

    /**
     *
     */
    public C0BPacketEntityAction() {
        
    }

    /**
     *
     */
    public C0BPacketEntityAction(Entity entity,
                                 C0BPacketEntityAction.Action action) {
        
    }

    /**
     *
     */
    public C0BPacketEntityAction(Entity entity,
                                 C0BPacketEntityAction.Action action,
                                 int auxData) {
        
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
    public C0BPacketEntityAction.Action getAction() {
        return null;
    }

    /**
     *
     */
    public int getAuxData() {
        return 0;
    }

    public class Action {
    }
}