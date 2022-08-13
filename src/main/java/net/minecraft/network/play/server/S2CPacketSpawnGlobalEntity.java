package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.MathHelper;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.entity.Entity;

/**
 *
 */
public class S2CPacketSpawnGlobalEntity extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private int x;

    /**
     *
     */
    private int y;

    /**
     *
     */
    private int z;

    /**
     *
     */
    private int type;

    /**
     *
     */
    public S2CPacketSpawnGlobalEntity() {
        
    }

    /**
     *
     */
    public S2CPacketSpawnGlobalEntity(Entity entityIn) {
        
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
    public int func_149052_c() {
        return 0;
    }

    /**
     *
     */
    public int func_149051_d() {
        return 0;
    }

    /**
     *
     */
    public int func_149050_e() {
        return 0;
    }

    /**
     *
     */
    public int func_149049_f() {
        return 0;
    }

    /**
     *
     */
    public int func_149053_g() {
        return 0;
    }

}