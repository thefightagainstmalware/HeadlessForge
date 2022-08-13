package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.EnumDifficulty;
import java.io.IOException;

/**
 *
 */
public class S41PacketServerDifficulty extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private EnumDifficulty difficulty;

    /**
     *
     */
    private boolean difficultyLocked;

    /**
     *
     */
    public S41PacketServerDifficulty() {
        
    }

    /**
     *
     */
    public S41PacketServerDifficulty(EnumDifficulty difficultyIn,
                                     boolean lockedIn) {
        
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
    public boolean isDifficultyLocked() {
        return true;
    }

    /**
     *
     */
    public EnumDifficulty getDifficulty() {
        return null;
    }

}