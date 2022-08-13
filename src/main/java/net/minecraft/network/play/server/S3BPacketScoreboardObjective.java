package net.minecraft.network.play.server;

import net.minecraft.scoreboard.IScoreObjectiveCriteria;
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
public class S3BPacketScoreboardObjective extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private java.lang.String objectiveName;

    /**
     *
     */
    private java.lang.String objectiveValue;

    /**
     *
     */
    private IScoreObjectiveCriteria.EnumRenderType type;

    /**
     *
     */
    private int field_149342_c;

    /**
     *
     */
    public S3BPacketScoreboardObjective() {
        
    }

    /**
     *
     */
    public S3BPacketScoreboardObjective(ScoreObjective p_i45224_1_,
                                        int p_i45224_2_) {
        
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
    public String func_149339_c() {
        return null;
    }

    /**
     *
     */
    public String func_149337_d() {
        return null;
    }

    /**
     *
     */
    public int func_149338_e() {
        return 0;
    }

    /**
     *
     */
    public IScoreObjectiveCriteria.EnumRenderType func_179817_d() {
        return null;
    }

}