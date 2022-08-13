package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.CombatTracker;

/**
 *
 */
public class S42PacketCombatEvent extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    public S42PacketCombatEvent.Event eventType;

    /**
     *
     */
    public int field_179774_b;

    /**
     *
     */
    public int field_179775_c;

    /**
     *
     */
    public int field_179772_d;

    /**
     *
     */
    public java.lang.String deathMessage;

    /**
     *
     */
    public S42PacketCombatEvent() {
        
    }

    /**
     *
     */
    public S42PacketCombatEvent(CombatTracker combatTrackerIn,
                                S42PacketCombatEvent.Event combatEventType) {
        
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

    public class Event {
    }
}