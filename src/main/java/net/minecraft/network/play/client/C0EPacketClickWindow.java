package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.IOException;

/**
 *
 */
public class C0EPacketClickWindow extends Object implements Packet<INetHandlerPlayServer> {

    /**
     * The id of the window which was clicked. 0 for player inventory.
     */
    private int windowId;

    /**
     * Id of the clicked slot
     */
    private int slotId;

    /**
     * Button used
     */
    private int usedButton;

    /**
     * A unique number for the action, used for transaction handling
     */
    private short actionNumber;

    /**
     * The item stack present in the slot
     */
    private ItemStack clickedItem;

    /**
     * Inventory operation mode
     */
    private int mode;

    /**
     *
     */
    public C0EPacketClickWindow() {
        
    }

    /**
     *
     */
    public C0EPacketClickWindow(int windowId,
                                int slotId,
                                int usedButton,
                                int mode,
                                ItemStack clickedItem,
                                short actionNumber) {
        
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayServer handler) {
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
    public int getSlotId() {
        return 0;
    }

    /**
     *
     */
    public int getUsedButton() {
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
    public ItemStack getClickedItem() {
        return null;
    }

    /**
     *
     */
    public int getMode() {
        return 0;
    }

}