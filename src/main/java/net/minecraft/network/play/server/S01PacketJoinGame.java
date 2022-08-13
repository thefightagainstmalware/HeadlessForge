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
public class S01PacketJoinGame extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int entityId;

    /**
     *
     */
    private boolean hardcoreMode;

    /**
     *
     */
    private WorldSettings.GameType gameType;

    /**
     *
     */
    private int dimension;

    /**
     *
     */
    private EnumDifficulty difficulty;

    /**
     *
     */
    private int maxPlayers;

    /**
     *
     */
    private WorldType worldType;

    /**
     *
     */
    private boolean reducedDebugInfo;

    /**
     *
     */
    public S01PacketJoinGame() {
        
    }

    /**
     *
     */
    public S01PacketJoinGame(int entityIdIn,
                             WorldSettings.GameType gameTypeIn,
                             boolean hardcoreModeIn,
                             int dimensionIn,
                             EnumDifficulty difficultyIn,
                             int maxPlayersIn,
                             WorldType worldTypeIn,
                             boolean reducedDebugInfoIn) {
        
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
    public int getEntityId() {
        return 0;
    }

    /**
     *
     */
    public boolean isHardcoreMode() {
        return true;
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
    public int getDimension() {
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
    public int getMaxPlayers() {
        return 0;
    }

    /**
     *
     */
    public WorldType getWorldType() {
        return null;
    }

    /**
     *
     */
    public boolean isReducedDebugInfo() {
        return true;
    }

}