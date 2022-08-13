package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.BlockPos;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class S35PacketUpdateTileEntity extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private BlockPos blockPos;

    /**
     * Used only for vanilla tile entities
     */
    private int metadata;

    /**
     *
     */
    private NBTTagCompound nbt;

    /**
     *
     */
    public S35PacketUpdateTileEntity() {
        
    }

    /**
     *
     */
    public S35PacketUpdateTileEntity(BlockPos blockPosIn,
                                     int metadataIn,
                                     NBTTagCompound nbtIn) {
        
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
    public BlockPos getPos() {
        return null;
    }

    /**
     *
     */
    public int getTileEntityType() {
        return 0;
    }

    /**
     *
     */
    public NBTTagCompound getNbtCompound() {
        return null;
    }

}