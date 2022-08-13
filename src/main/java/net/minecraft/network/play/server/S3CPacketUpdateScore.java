package net.minecraft.network.play.server;

import net.minecraft.scoreboard.Score;
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
public class S3CPacketUpdateScore extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private java.lang.String name;

    /**
     *
     */
    private java.lang.String objective;

    /**
     *
     */
    private int value;

    /**
     *
     */
    private S3CPacketUpdateScore.Action action;

    /**
     *
     */
    public S3CPacketUpdateScore() {
        
    }

    /**
     *
     */
    public S3CPacketUpdateScore(Score scoreIn) {
        
    }

    /**
     *
     */
    public S3CPacketUpdateScore(String nameIn) {
        
    }

    /**
     *
     */
    public S3CPacketUpdateScore(String nameIn,
                                ScoreObjective objectiveIn) {
        
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
    public String getPlayerName() {
        return null;
    }

    /**
     *
     */
    public String getObjectiveName() {
        return null;
    }

    /**
     *
     */
    public int getScoreValue() {
        return 0;
    }

    /**
     *
     */
    public S3CPacketUpdateScore.Action getScoreAction() {
        return null;
    }

    public class Action {
    }
}