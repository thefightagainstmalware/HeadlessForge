package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import java.util.Collection;
import net.minecraft.network.PacketBuffer;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.google.common.collect.Lists;
import java.io.IOException;

/**
 *
 */
public class S3EPacketTeams extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private java.lang.String field_149320_a;

    /**
     *
     */
    private java.lang.String field_149318_b;

    /**
     *
     */
    private java.lang.String field_149319_c;

    /**
     *
     */
    private java.lang.String field_149316_d;

    /**
     *
     */
    private java.lang.String field_179816_e;

    /**
     *
     */
    private int field_179815_f;

    /**
     *
     */
    private java.util.Collection<java.lang.String> field_149317_e;

    /**
     *
     */
    private int field_149314_f;

    /**
     *
     */
    private int field_149315_g;

    /**
     *
     */
    public S3EPacketTeams() {
        
    }

    /**
     *
     */
    public S3EPacketTeams(ScorePlayerTeam p_i45225_1_,
                          int p_i45225_2_) {
        
    }

    /**
     *
     */
    public S3EPacketTeams(ScorePlayerTeam p_i45226_1_,
                          java.util.Collection<String> p_i45226_2_,
                          int p_i45226_3_) {
        
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
    public String func_149312_c() {
        return null;
    }

    /**
     *
     */
    public String func_149306_d() {
        return null;
    }

    /**
     *
     */
    public String func_149311_e() {
        return null;
    }

    /**
     *
     */
    public String func_149309_f() {
        return null;
    }

    /**
     *
     */
    public java.util.Collection<String> func_149310_g() {
        return null;
    }

    /**
     *
     */
    public int func_149307_h() {
        return 0;
    }

    /**
     *
     */
    public int func_149308_i() {
        return 0;
    }

    /**
     *
     */
    public int func_179813_h() {
        return 0;
    }

    /**
     *
     */
    public String func_179814_i() {
        return null;
    }

}