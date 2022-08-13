package net.minecraft.network.play.server;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.IChatComponent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.world.WorldSettings;

import java.io.IOException;
import java.util.List;

public class S38PacketPlayerListItem implements Packet<INetHandlerPlayClient>
{
    private S38PacketPlayerListItem.Action action;
    private final List<S38PacketPlayerListItem.AddPlayerData> players = Lists.<S38PacketPlayerListItem.AddPlayerData>newArrayList();

    public S38PacketPlayerListItem()
    {
    }

    public S38PacketPlayerListItem(S38PacketPlayerListItem.Action actionIn, EntityPlayerMP... players)
    {
        this.action = actionIn;

        for (EntityPlayerMP entityplayermp : players)
        {
            this.players.add(new S38PacketPlayerListItem.AddPlayerData(entityplayermp.getGameProfile(), entityplayermp.ping, entityplayermp.field_71134_c.getGameType(), entityplayermp.getTabListDisplayName()));
        }
    }

    public S38PacketPlayerListItem(S38PacketPlayerListItem.Action actionIn, Iterable<EntityPlayerMP> players)
    {
        this.action = actionIn;

        for (EntityPlayerMP entityplayermp : players)
        {
            this.players.add(new S38PacketPlayerListItem.AddPlayerData(entityplayermp.getGameProfile(), entityplayermp.ping, entityplayermp.field_71134_c.getGameType(), entityplayermp.getTabListDisplayName()));
        }
    }

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {

    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer buf) throws IOException
    {

    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler)
    {
        handler.handlePlayerListItem(this);
    }

    public List<S38PacketPlayerListItem.AddPlayerData> func_179767_a()
    {
        return this.players;
    }

    public S38PacketPlayerListItem.Action func_179768_b()
    {
        return this.action;
    }



    public enum Action
    {
        ADD_PLAYER,
        UPDATE_GAME_MODE,
        UPDATE_LATENCY,
        UPDATE_DISPLAY_NAME,
        REMOVE_PLAYER;
    }

    public class AddPlayerData
    {
        private final int ping;
        private final WorldSettings.GameType gamemode;
        private final GameProfile profile;
        private final IChatComponent displayName;

        public AddPlayerData(GameProfile profile, int pingIn, WorldSettings.GameType gamemodeIn, IChatComponent displayNameIn)
        {
            this.profile = profile;
            this.ping = pingIn;
            this.gamemode = gamemodeIn;
            this.displayName = displayNameIn;
        }

        public GameProfile getProfile()
        {
            return this.profile;
        }

        public int getPing()
        {
            return this.ping;
        }

        public WorldSettings.GameType getGameMode()
        {
            return this.gamemode;
        }

        public IChatComponent getDisplayName()
        {
            return this.displayName;
        }

    }
}
