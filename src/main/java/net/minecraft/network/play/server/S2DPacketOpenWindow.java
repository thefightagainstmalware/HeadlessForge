package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class S2DPacketOpenWindow extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int windowId;

    /**
     *
     */
    private java.lang.String inventoryType;

    /**
     *
     */
    private IChatComponent windowTitle;

    /**
     *
     */
    private int slotCount;

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    public S2DPacketOpenWindow() {
        
    }

    /**
     *
     */
    public S2DPacketOpenWindow(int incomingWindowId,
                               String incomingWindowTitle,
                               IChatComponent windowTitleIn) {
        
    }

    /**
     *
     */
    public S2DPacketOpenWindow(int windowIdIn,
                               String guiId,
                               IChatComponent windowTitleIn,
                               int slotCountIn) {
        
    }

    /**
     *
     */
    public S2DPacketOpenWindow(int windowIdIn,
                               String guiId,
                               IChatComponent windowTitleIn,
                               int slotCountIn,
                               int incomingEntityId) {
        
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
    public String getGuiId() {
        return null;
    }

    /**
     *
     */
    public IChatComponent getWindowTitle() {
        return null;
    }

    /**
     *
     */
    public int getSlotCount() {
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
    public boolean hasSlots() {
        return true;
    }

}