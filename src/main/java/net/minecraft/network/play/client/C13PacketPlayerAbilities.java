package net.minecraft.network.play.client;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;
import java.io.IOException;
import net.minecraft.entity.player.PlayerCapabilities;

/**
 *
 */
public class C13PacketPlayerAbilities extends Object implements Packet<INetHandlerPlayServer> {

    /**
     *
     */
    private boolean invulnerable;

    /**
     *
     */
    private boolean flying;

    /**
     *
     */
    private boolean allowFlying;

    /**
     *
     */
    private boolean creativeMode;

    /**
     *
     */
    private float flySpeed;

    /**
     *
     */
    private float walkSpeed;

    /**
     *
     */
    public C13PacketPlayerAbilities() {
        
    }

    /**
     *
     */
    public C13PacketPlayerAbilities(PlayerCapabilities capabilities) {
        
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
    public boolean isInvulnerable() {
        return true;
    }

    /**
     *
     */
    public void setInvulnerable(boolean isInvulnerable) {
        return;
    }

    /**
     *
     */
    public boolean isFlying() {
        return true;
    }

    /**
     *
     */
    public void setFlying(boolean isFlying) {
        return;
    }

    /**
     *
     */
    public boolean isAllowFlying() {
        return true;
    }

    /**
     *
     */
    public void setAllowFlying(boolean isAllowFlying) {
        return;
    }

    /**
     *
     */
    public boolean isCreativeMode() {
        return true;
    }

    /**
     *
     */
    public void setCreativeMode(boolean isCreativeMode) {
        return;
    }

    /**
     *
     */
    public void setFlySpeed(float flySpeedIn) {
        return;
    }

    /**
     *
     */
    public void setWalkSpeed(float walkSpeedIn) {
        return;
    }

}