package net.minecraft.tileentity;

import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.network.Packet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.command.CommandResultStats;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class TileEntitySign extends TileEntity {

    /**
     *
     */
    public final IChatComponent[] signText = new IChatComponent[0];

    /**
     * The index of the line currently being edited. Only used on client side, but defined on both. Note this is only
     * really used when the &gt; &lt; are going to be visible.
     */
    public int lineBeingEdited;

    /**
     *
     */
    private boolean isEditable;

    /**
     *
     */
    private EntityPlayer player;

    /**
     *
     */
    private final CommandResultStats stats = new CommandResultStats();

    /**
     *
     */
    public TileEntitySign() {
        
    }

    /**
     *
     */
    @Override
    public void func_145841_b(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    @Override
    public void func_145839_a(NBTTagCompound compound) {
        return;
    }

    /**
     * Allows for a specialized description packet to be created. This is often used to sync tile entity data from the
     * server to the client easily. For example this is used by signs to synchronise the text to be displayed.
     */
    @Override
    public Packet getDescriptionPacket() {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean func_183000_F() {
        return true;
    }

    /**
     *
     */
    public boolean getIsEditable() {
        return true;
    }

    /**
     * Sets the sign's isEditable flag to the specified parameter.
     */
    public void setEditable(boolean isEditableIn) {
        return;
    }

    /**
     *
     */
    public void setPlayer(EntityPlayer playerIn) {
        return;
    }

    /**
     *
     */
    public EntityPlayer getPlayer() {
        return null;
    }

    /**
     *
     */
    public boolean executeCommand(EntityPlayer playerIn) {
        return true;
    }

    /**
     *
     */
    public CommandResultStats func_174880_d() {
        return null;
    }

}