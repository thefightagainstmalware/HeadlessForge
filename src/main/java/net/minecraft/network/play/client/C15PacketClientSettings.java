package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C15PacketClientSettings extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private java.lang.String lang;

    /**
     *
     */
    private int view;

    /**
     *
     */
    private EntityPlayer.EnumChatVisibility chatVisibility;

    /**
     *
     */
    private boolean enableColors;

    /**
     *
     */
    private int modelPartFlags;

    /**
     *
     */
    public C15PacketClientSettings() {
        
    }

    /**
     *
     */
    public C15PacketClientSettings(String langIn,
                                   int viewIn,
                                   EntityPlayer.EnumChatVisibility chatVisibilityIn,
                                   boolean enableColorsIn,
                                   int modelPartFlagsIn) {
        
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
    public String getLang() {
        return null;
    }

    /**
     *
     */
    public EntityPlayer.EnumChatVisibility getChatVisibility() {
        return null;
    }

    /**
     *
     */
    public boolean isColorsEnabled() {
        return true;
    }

    /**
     *
     */
    public int getModelPartFlags() {
        return 0;
    }

}