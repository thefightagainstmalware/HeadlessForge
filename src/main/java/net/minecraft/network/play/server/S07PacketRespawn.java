package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.WorldType;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.EnumDifficulty;
import java.io.IOException;

/**
 *
 */
public class S07PacketRespawn extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int dimensionID;

    /**
     *
     */
    private EnumDifficulty difficulty;

    /**
     *
     */
    private WorldSettings.GameType gameType;

    /**
     *
     */
    private WorldType worldType;

    /**
     *
     */
    public S07PacketRespawn() {
        
    }

    /**
     *
     */
    public S07PacketRespawn(int dimensionIDIn,
                            EnumDifficulty difficultyIn,
                            WorldType worldTypeIn,
                            WorldSettings.GameType gameTypeIn) {
        
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
    public int getDimensionID() {
        return 0;
    }

    /**
     *
     */
    public EnumDifficulty getDifficulty() {
        return null;
    }

    /**
     *
     */
    public WorldSettings.GameType getGameType() {
        return null;
    }

    /**
     *
     */
    public WorldType getWorldType() {
        return null;
    }

}