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
public class S02PacketChat extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private IChatComponent chatComponent;

    /**
     *
     */
    private byte type;

    /**
     *
     */
    public S02PacketChat() {
        
    }

    /**
     *
     */
    public S02PacketChat(IChatComponent component) {
        
    }

    /**
     *
     */
    public S02PacketChat(IChatComponent message,
                         byte typeIn) {
        
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
    public IChatComponent getChatComponent() {
        return null;
    }

    /**
     *
     */
    public boolean isChat() {
        return true;
    }

    /**
     * Returns the id of the area to display the text, 2 for above the action bar, anything else currently for the chat
     * window
     */
    public byte getType() {
        return 0;
    }

}