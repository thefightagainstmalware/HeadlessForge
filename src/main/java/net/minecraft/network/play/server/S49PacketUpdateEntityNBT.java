package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import java.io.IOException;

/**
 *
 */
public class S49PacketUpdateEntityNBT extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private NBTTagCompound tagCompound;

    /**
     *
     */
    public S49PacketUpdateEntityNBT() {
        
    }

    /**
     *
     */
    public S49PacketUpdateEntityNBT(int entityIdIn,
                                    NBTTagCompound tagCompoundIn) {
        
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
    public NBTTagCompound getTagCompound() {
        return null;
    }

    /**
     *
     */
    public Entity getEntity(World worldIn) {
        return null;
    }

}