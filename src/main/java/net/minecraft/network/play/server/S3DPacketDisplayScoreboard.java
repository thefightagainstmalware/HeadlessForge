package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.scoreboard.ScoreObjective;
import java.io.IOException;

/**
 *
 */
public class S3DPacketDisplayScoreboard extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int position;

    /**
     *
     */
    private java.lang.String scoreName;

    /**
     *
     */
    public S3DPacketDisplayScoreboard() {
        
    }

    /**
     *
     */
    public S3DPacketDisplayScoreboard(int positionIn,
                                      ScoreObjective scoreIn) {
        
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
    public int func_149371_c() {
        return 0;
    }

    /**
     *
     */
    public String func_149370_d() {
        return null;
    }

}