package net.minecraft.server.management;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.network.play.server.S39PacketPlayerAbilities;
import net.minecraft.network.play.server.S3EPacketTeams;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraft.network.play.server.S41PacketServerDifficulty;
import net.minecraft.network.play.server.S44PacketWorldBorder;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatList;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.demo.DemoWorldManager;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ServerConfigurationManager
{
    public static final File FILE_PLAYERBANS = new File("banned-players.json");
    public static final File FILE_IPBANS = new File("banned-ips.json");
    public static final File FILE_OPS = new File("ops.json");
    public static final File FILE_WHITELIST = new File("whitelist.json");
    private static final Logger logger = LogManager.getLogger();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");

    /** Reference to the MinecraftServer object. */
    private final MinecraftServer mcServer;
    private final List<EntityPlayerMP> playerEntityList = Lists.<EntityPlayerMP>newArrayList();
    private final Map<UUID, EntityPlayerMP> uuidToPlayerMap = Maps.<UUID, EntityPlayerMP>newHashMap();
    private final UserListBans bannedPlayers;
    private final BanList bannedIPs;

    /** A set containing the OPs. */
    private final UserListOps ops;

    /** The Set of all whitelisted players. */
    private final UserListWhitelist whiteListedPlayers;
    private final Map<UUID, StatisticsFile> playerStatFiles;

    /** Reference to the PlayerNBTManager object. */
    private IPlayerFileData playerNBTManagerObj;

    /**
     * Server setting to only allow OPs and whitelisted players to join the server.
     */
    private boolean whiteListEnforced;

    /** The maximum number of players that can be connected at a time. */
    protected int maxPlayers;
    private int viewDistance;
    private WorldSettings.GameType gameType;

    /** True if all players are allowed to use commands (cheats). */
    private boolean commandsAllowedForAll;

    /**
     * index into playerEntities of player to ping, updated every tick; currently hardcoded to max at 200 players
     */
    private int playerPingIndex;

    public ServerConfigurationManager(MinecraftServer server)
    {
        this.bannedPlayers = new UserListBans(FILE_PLAYERBANS);
        this.bannedIPs = new BanList(FILE_IPBANS);
        this.ops = new UserListOps(FILE_OPS);
        this.whiteListedPlayers = new UserListWhitelist(FILE_WHITELIST);
        this.playerStatFiles = Maps.<UUID, StatisticsFile>newHashMap();
        this.mcServer = server;
        this.bannedPlayers.setLanServer(false);
        this.bannedIPs.setLanServer(false);
        this.maxPlayers = 8;
    }

    public void initializeConnectionToPlayer(NetworkManager netManager, EntityPlayerMP playerIn)
    {
        GameProfile gameprofile = playerIn.getGameProfile();
        PlayerProfileCache playerprofilecache = this.mcServer.func_152358_ax();
        GameProfile gameprofile1 = playerprofilecache.getProfileByUUID(gameprofile.getId());
        String s = gameprofile1 == null ? gameprofile.getName() : gameprofile1.getName();
        playerprofilecache.addEntry(gameprofile);
        NBTTagCompound nbttagcompound = this.readPlayerDataFromFile(playerIn);
        playerIn.setWorld(this.mcServer.func_71218_a(playerIn.dimension));
        playerIn.field_71134_c.setWorld((WorldServer)playerIn.field_70170_p);
        String s1 = "local";

        if (netManager.getRemoteAddress() != null)
        {
            s1 = netManager.getRemoteAddress().toString();
        }

        logger.info(playerIn.func_70005_c_() + "[" + s1 + "] logged in with entity id " + playerIn.getEntityId() + " at (" + playerIn.field_70165_t + ", " + playerIn.field_70163_u + ", " + playerIn.field_70161_v + ")");
        WorldServer worldserver = this.mcServer.func_71218_a(playerIn.dimension);
        WorldInfo worldinfo = worldserver.func_72912_H();
        BlockPos blockpos = worldserver.getSpawnPoint();
        this.setPlayerGameTypeBasedOnOther(playerIn, (EntityPlayerMP)null, worldserver);
        NetHandlerPlayServer nethandlerplayserver = new NetHandlerPlayServer(this.mcServer, netManager, playerIn);
        nethandlerplayserver.func_147359_a(new S01PacketJoinGame(playerIn.getEntityId(), playerIn.field_71134_c.getGameType(), worldinfo.isHardcoreModeEnabled(), worldserver.provider.getDimensionId(), worldserver.getDifficulty(), this.getMaxPlayers(), worldinfo.getTerrainType(), worldserver.func_82736_K().func_82766_b("reducedDebugInfo")));
        nethandlerplayserver.func_147359_a(new S3FPacketCustomPayload("MC|Brand", (new PacketBuffer(Unpooled.buffer())).writeString(this.getServerInstance().getServerModName())));
        nethandlerplayserver.func_147359_a(new S41PacketServerDifficulty(worldinfo.getDifficulty(), worldinfo.isDifficultyLocked()));
        nethandlerplayserver.func_147359_a(new S05PacketSpawnPosition(blockpos));
        nethandlerplayserver.func_147359_a(new S39PacketPlayerAbilities(playerIn.field_71075_bZ));
        nethandlerplayserver.func_147359_a(new S09PacketHeldItemChange(playerIn.field_71071_by.currentItem));
        playerIn.func_147099_x().func_150877_d();
        playerIn.func_147099_x().sendAchievements(playerIn);
        this.sendScoreboard((ServerScoreboard)worldserver.func_96441_U(), playerIn);
        this.mcServer.refreshStatusNextTick();
        ChatComponentTranslation chatcomponenttranslation;

        if (!playerIn.func_70005_c_().equalsIgnoreCase(s))
        {
            chatcomponenttranslation = new ChatComponentTranslation("multiplayer.player.joined.renamed", new Object[] {playerIn.func_145748_c_(), s});
        }
        else
        {
            chatcomponenttranslation = new ChatComponentTranslation("multiplayer.player.joined", new Object[] {playerIn.func_145748_c_()});
        }

        chatcomponenttranslation.func_150256_b().func_150238_a(EnumChatFormatting.YELLOW);
        this.func_148539_a(chatcomponenttranslation);
        this.playerLoggedIn(playerIn);
        nethandlerplayserver.func_147364_a(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, playerIn.field_70177_z, playerIn.field_70125_A);
        this.updateTimeAndWeatherForPlayer(playerIn, worldserver);

        if (this.mcServer.getResourcePackUrl().length() > 0)
        {
            playerIn.loadResourcePack(this.mcServer.getResourcePackUrl(), this.mcServer.getResourcePackHash());
        }

        for (PotionEffect potioneffect : playerIn.func_70651_bq())
        {
            nethandlerplayserver.func_147359_a(new S1DPacketEntityEffect(playerIn.getEntityId(), potioneffect));
        }

        playerIn.addSelfToInternalCraftingInventory();

        if (nbttagcompound != null && nbttagcompound.func_150297_b("Riding", 10))
        {
            Entity entity = EntityList.func_75615_a(nbttagcompound.func_74775_l("Riding"), worldserver);

            if (entity != null)
            {
                entity.forceSpawn = true;
                worldserver.func_72838_d(entity);
                playerIn.func_70078_a(entity);
                entity.forceSpawn = false;
            }
        }
    }

    protected void sendScoreboard(ServerScoreboard scoreboardIn, EntityPlayerMP playerIn)
    {
        Set<ScoreObjective> set = Sets.<ScoreObjective>newHashSet();

        for (ScorePlayerTeam scoreplayerteam : scoreboardIn.getTeams())
        {
            playerIn.field_71135_a.func_147359_a(new S3EPacketTeams(scoreplayerteam, 0));
        }

        for (int i = 0; i < 19; ++i)
        {
            ScoreObjective scoreobjective = scoreboardIn.getObjectiveInDisplaySlot(i);

            if (scoreobjective != null && !set.contains(scoreobjective))
            {
                for (Packet packet : scoreboardIn.func_96550_d(scoreobjective))
                {
                    playerIn.field_71135_a.func_147359_a(packet);
                }

                set.add(scoreobjective);
            }
        }
    }

    /**
     * Sets the NBT manager to the one for the WorldServer given.
     */
    public void setPlayerManager(WorldServer[] worldServers)
    {
        this.playerNBTManagerObj = worldServers[0].getSaveHandler().getPlayerNBTManager();
        worldServers[0].func_175723_af().addListener(new IBorderListener()
        {
            public void onSizeChanged(WorldBorder border, double newSize)
            {
                ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(border, S44PacketWorldBorder.Action.SET_SIZE));
            }
            public void onTransitionStarted(WorldBorder border, double oldSize, double newSize, long time)
            {
                ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(border, S44PacketWorldBorder.Action.LERP_SIZE));
            }
            public void onCenterChanged(WorldBorder border, double x, double z)
            {
                ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(border, S44PacketWorldBorder.Action.SET_CENTER));
            }
            public void onWarningTimeChanged(WorldBorder border, int newTime)
            {
                ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(border, S44PacketWorldBorder.Action.SET_WARNING_TIME));
            }
            public void onWarningDistanceChanged(WorldBorder border, int newDistance)
            {
                ServerConfigurationManager.this.func_148540_a(new S44PacketWorldBorder(border, S44PacketWorldBorder.Action.SET_WARNING_BLOCKS));
            }
            public void onDamageAmountChanged(WorldBorder border, double newAmount)
            {
            }
            public void onDamageBufferChanged(WorldBorder border, double newSize)
            {
            }
        });
    }

    public void preparePlayer(EntityPlayerMP playerIn, WorldServer worldIn)
    {
        WorldServer worldserver = playerIn.getServerForPlayer();

        if (worldIn != null)
        {
            worldIn.getPlayerManager().removePlayer(playerIn);
        }

        worldserver.getPlayerManager().addPlayer(playerIn);
        worldserver.theChunkProviderServer.loadChunk((int)playerIn.field_70165_t >> 4, (int)playerIn.field_70161_v >> 4);
    }

    public int getEntityViewDistance()
    {
        return PlayerManager.getFurthestViewableBlock(this.getViewDistance());
    }

    /**
     * called during player login. reads the player information from disk.
     */
    public NBTTagCompound readPlayerDataFromFile(EntityPlayerMP playerIn)
    {
        NBTTagCompound nbttagcompound = this.mcServer.field_71305_c[0].func_72912_H().getPlayerNBTTagCompound();
        NBTTagCompound nbttagcompound1;

        if (playerIn.func_70005_c_().equals(this.mcServer.getServerOwner()) && nbttagcompound != null)
        {
            playerIn.func_70020_e(nbttagcompound);
            nbttagcompound1 = nbttagcompound;
            logger.debug("loading single player");
        }
        else
        {
            nbttagcompound1 = this.playerNBTManagerObj.readPlayerData(playerIn);
        }

        return nbttagcompound1;
    }

    /**
     * also stores the NBTTags if this is an intergratedPlayerList
     */
    protected void writePlayerData(EntityPlayerMP playerIn)
    {
        this.playerNBTManagerObj.writePlayerData(playerIn);
        StatisticsFile statisticsfile = (StatisticsFile)this.playerStatFiles.get(playerIn.func_110124_au());

        if (statisticsfile != null)
        {
            statisticsfile.saveStatFile();
        }
    }

    /**
     * Called when a player successfully logs in. Reads player data from disk and inserts the player into the world.
     */
    public void playerLoggedIn(EntityPlayerMP playerIn)
    {
        this.playerEntityList.add(playerIn);
        this.uuidToPlayerMap.put(playerIn.func_110124_au(), playerIn);
        this.func_148540_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] {playerIn}));
        WorldServer worldserver = this.mcServer.func_71218_a(playerIn.dimension);
        worldserver.func_72838_d(playerIn);
        this.preparePlayer(playerIn, (WorldServer)null);

        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntityList.get(i);
            playerIn.field_71135_a.func_147359_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.ADD_PLAYER, new EntityPlayerMP[] {entityplayermp}));
        }
    }

    /**
     * using player's dimension, update their movement when in a vehicle (e.g. cart, boat)
     */
    public void serverUpdateMountedMovingPlayer(EntityPlayerMP playerIn)
    {
        playerIn.getServerForPlayer().getPlayerManager().updateMountedMovingPlayer(playerIn);
    }

    /**
     * Called when a player disconnects from the game. Writes player data to disk and removes them from the world.
     */
    public void playerLoggedOut(EntityPlayerMP playerIn)
    {
        playerIn.func_71029_a(StatList.leaveGameStat);
        this.writePlayerData(playerIn);
        WorldServer worldserver = playerIn.getServerForPlayer();

        if (playerIn.ridingEntity != null)
        {
            worldserver.removePlayerEntityDangerously(playerIn.ridingEntity);
            logger.debug("removing player mount");
        }

        worldserver.removeEntity(playerIn);
        worldserver.getPlayerManager().removePlayer(playerIn);
        this.playerEntityList.remove(playerIn);
        UUID uuid = playerIn.func_110124_au();
        EntityPlayerMP entityplayermp = (EntityPlayerMP)this.uuidToPlayerMap.get(uuid);

        if (entityplayermp == playerIn)
        {
            this.uuidToPlayerMap.remove(uuid);
            this.playerStatFiles.remove(uuid);
        }

        this.func_148540_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.REMOVE_PLAYER, new EntityPlayerMP[] {playerIn}));
    }

    /**
     * checks ban-lists, then white-lists, then space for the server. Returns null on success, or an error message
     */
    public String allowUserToConnect(SocketAddress address, GameProfile profile)
    {
        if (this.bannedPlayers.isBanned(profile))
        {
            UserListBansEntry userlistbansentry = (UserListBansEntry)this.bannedPlayers.getEntry(profile);
            String s1 = "You are banned from this server!\nReason: " + userlistbansentry.getBanReason();

            if (userlistbansentry.getBanEndDate() != null)
            {
                s1 = s1 + "\nYour ban will be removed on " + dateFormat.format(userlistbansentry.getBanEndDate());
            }

            return s1;
        }
        else if (!this.canJoin(profile))
        {
            return "You are not white-listed on this server!";
        }
        else if (this.bannedIPs.isBanned(address))
        {
            IPBanEntry ipbanentry = this.bannedIPs.getBanEntry(address);
            String s = "Your IP address is banned from this server!\nReason: " + ipbanentry.getBanReason();

            if (ipbanentry.getBanEndDate() != null)
            {
                s = s + "\nYour ban will be removed on " + dateFormat.format(ipbanentry.getBanEndDate());
            }

            return s;
        }
        else
        {
            return this.playerEntityList.size() >= this.maxPlayers && !this.func_183023_f(profile) ? "The server is full!" : null;
        }
    }

    /**
     * also checks for multiple logins across servers
     */
    public EntityPlayerMP createPlayerForUser(GameProfile profile)
    {
        UUID uuid = EntityPlayer.getUUID(profile);
        List<EntityPlayerMP> list = Lists.<EntityPlayerMP>newArrayList();

        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntityList.get(i);

            if (entityplayermp.func_110124_au().equals(uuid))
            {
                list.add(entityplayermp);
            }
        }

        EntityPlayerMP entityplayermp2 = (EntityPlayerMP)this.uuidToPlayerMap.get(profile.getId());

        if (entityplayermp2 != null && !list.contains(entityplayermp2))
        {
            list.add(entityplayermp2);
        }

        for (EntityPlayerMP entityplayermp1 : list)
        {
            entityplayermp1.field_71135_a.func_147360_c("You logged in from another location");
        }

        ItemInWorldManager iteminworldmanager;

        if (this.mcServer.isDemo())
        {
            iteminworldmanager = new DemoWorldManager(this.mcServer.func_71218_a(0));
        }
        else
        {
            iteminworldmanager = new ItemInWorldManager(this.mcServer.func_71218_a(0));
        }

        return new EntityPlayerMP(this.mcServer, this.mcServer.func_71218_a(0), profile, iteminworldmanager);
    }

    /**
     * Called on respawn
     */
    public EntityPlayerMP recreatePlayerEntity(EntityPlayerMP playerIn, int dimension, boolean conqueredEnd)
    {
        playerIn.getServerForPlayer().getEntityTracker().removePlayerFromTrackers(playerIn);
        playerIn.getServerForPlayer().getEntityTracker().untrackEntity(playerIn);
        playerIn.getServerForPlayer().getPlayerManager().removePlayer(playerIn);
        this.playerEntityList.remove(playerIn);
        this.mcServer.func_71218_a(playerIn.dimension).removePlayerEntityDangerously(playerIn);
        BlockPos blockpos = playerIn.getBedLocation();
        boolean flag = playerIn.isSpawnForced();
        playerIn.dimension = dimension;
        ItemInWorldManager iteminworldmanager;

        if (this.mcServer.isDemo())
        {
            iteminworldmanager = new DemoWorldManager(this.mcServer.func_71218_a(playerIn.dimension));
        }
        else
        {
            iteminworldmanager = new ItemInWorldManager(this.mcServer.func_71218_a(playerIn.dimension));
        }

        EntityPlayerMP entityplayermp = new EntityPlayerMP(this.mcServer, this.mcServer.func_71218_a(playerIn.dimension), playerIn.getGameProfile(), iteminworldmanager);
        entityplayermp.field_71135_a = playerIn.field_71135_a;
        entityplayermp.clonePlayer(playerIn, conqueredEnd);
        entityplayermp.setEntityId(playerIn.getEntityId());
        entityplayermp.func_174817_o(playerIn);
        WorldServer worldserver = this.mcServer.func_71218_a(playerIn.dimension);
        this.setPlayerGameTypeBasedOnOther(entityplayermp, playerIn, worldserver);

        if (blockpos != null)
        {
            BlockPos blockpos1 = EntityPlayer.getBedSpawnLocation(this.mcServer.func_71218_a(playerIn.dimension), blockpos, flag);

            if (blockpos1 != null)
            {
                entityplayermp.func_70012_b((double)((float)blockpos1.func_177958_n() + 0.5F), (double)((float)blockpos1.func_177956_o() + 0.1F), (double)((float)blockpos1.func_177952_p() + 0.5F), 0.0F, 0.0F);
                entityplayermp.func_180473_a(blockpos, flag);
            }
            else
            {
                entityplayermp.field_71135_a.func_147359_a(new S2BPacketChangeGameState(0, 0.0F));
            }
        }

        worldserver.theChunkProviderServer.loadChunk((int)entityplayermp.field_70165_t >> 4, (int)entityplayermp.field_70161_v >> 4);

        while (!worldserver.getCollidingBoundingBoxes(entityplayermp, entityplayermp.getEntityBoundingBox()).isEmpty() && entityplayermp.field_70163_u < 256.0D)
        {
            entityplayermp.setPosition(entityplayermp.field_70165_t, entityplayermp.field_70163_u + 1.0D, entityplayermp.field_70161_v);
        }

        entityplayermp.field_71135_a.func_147359_a(new S07PacketRespawn(entityplayermp.dimension, entityplayermp.field_70170_p.getDifficulty(), entityplayermp.field_70170_p.func_72912_H().getTerrainType(), entityplayermp.field_71134_c.getGameType()));
        BlockPos blockpos2 = worldserver.getSpawnPoint();
        entityplayermp.field_71135_a.func_147364_a(entityplayermp.field_70165_t, entityplayermp.field_70163_u, entityplayermp.field_70161_v, entityplayermp.field_70177_z, entityplayermp.field_70125_A);
        entityplayermp.field_71135_a.func_147359_a(new S05PacketSpawnPosition(blockpos2));
        entityplayermp.field_71135_a.func_147359_a(new S1FPacketSetExperience(entityplayermp.experience, entityplayermp.field_71067_cb, entityplayermp.field_71068_ca));
        this.updateTimeAndWeatherForPlayer(entityplayermp, worldserver);
        worldserver.getPlayerManager().addPlayer(entityplayermp);
        worldserver.func_72838_d(entityplayermp);
        this.playerEntityList.add(entityplayermp);
        this.uuidToPlayerMap.put(entityplayermp.func_110124_au(), entityplayermp);
        entityplayermp.addSelfToInternalCraftingInventory();
        entityplayermp.setHealth(entityplayermp.getHealth());
        return entityplayermp;
    }

    /**
     * moves provided player from overworld to nether or vice versa
     */
    public void transferPlayerToDimension(EntityPlayerMP playerIn, int dimension)
    {
        int i = playerIn.dimension;
        WorldServer worldserver = this.mcServer.func_71218_a(playerIn.dimension);
        playerIn.dimension = dimension;
        WorldServer worldserver1 = this.mcServer.func_71218_a(playerIn.dimension);
        playerIn.field_71135_a.func_147359_a(new S07PacketRespawn(playerIn.dimension, playerIn.field_70170_p.getDifficulty(), playerIn.field_70170_p.func_72912_H().getTerrainType(), playerIn.field_71134_c.getGameType()));
        worldserver.removePlayerEntityDangerously(playerIn);
        playerIn.isDead = false;
        this.transferEntityToWorld(playerIn, i, worldserver, worldserver1);
        this.preparePlayer(playerIn, worldserver);
        playerIn.field_71135_a.func_147364_a(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, playerIn.field_70177_z, playerIn.field_70125_A);
        playerIn.field_71134_c.setWorld(worldserver1);
        this.updateTimeAndWeatherForPlayer(playerIn, worldserver1);
        this.syncPlayerInventory(playerIn);

        for (PotionEffect potioneffect : playerIn.func_70651_bq())
        {
            playerIn.field_71135_a.func_147359_a(new S1DPacketEntityEffect(playerIn.getEntityId(), potioneffect));
        }
    }

    /**
     * Transfers an entity from a world to another world.
     */
    public void transferEntityToWorld(Entity entityIn, int p_82448_2_, WorldServer p_82448_3_, WorldServer p_82448_4_)
    {
        double d0 = entityIn.field_70165_t;
        double d1 = entityIn.field_70161_v;
        double d2 = 8.0D;
        float f = entityIn.field_70177_z;
        p_82448_3_.theProfiler.startSection("moving");

        if (entityIn.dimension == -1)
        {
            d0 = MathHelper.clamp_double(d0 / d2, p_82448_4_.func_175723_af().minX() + 16.0D, p_82448_4_.func_175723_af().maxX() - 16.0D);
            d1 = MathHelper.clamp_double(d1 / d2, p_82448_4_.func_175723_af().minZ() + 16.0D, p_82448_4_.func_175723_af().maxZ() - 16.0D);
            entityIn.func_70012_b(d0, entityIn.field_70163_u, d1, entityIn.field_70177_z, entityIn.field_70125_A);

            if (entityIn.isEntityAlive())
            {
                p_82448_3_.updateEntityWithOptionalForce(entityIn, false);
            }
        }
        else if (entityIn.dimension == 0)
        {
            d0 = MathHelper.clamp_double(d0 * d2, p_82448_4_.func_175723_af().minX() + 16.0D, p_82448_4_.func_175723_af().maxX() - 16.0D);
            d1 = MathHelper.clamp_double(d1 * d2, p_82448_4_.func_175723_af().minZ() + 16.0D, p_82448_4_.func_175723_af().maxZ() - 16.0D);
            entityIn.func_70012_b(d0, entityIn.field_70163_u, d1, entityIn.field_70177_z, entityIn.field_70125_A);

            if (entityIn.isEntityAlive())
            {
                p_82448_3_.updateEntityWithOptionalForce(entityIn, false);
            }
        }
        else
        {
            BlockPos blockpos;

            if (p_82448_2_ == 1)
            {
                blockpos = p_82448_4_.getSpawnPoint();
            }
            else
            {
                blockpos = p_82448_4_.getSpawnCoordinate();
            }

            d0 = (double)blockpos.func_177958_n();
            entityIn.field_70163_u = (double)blockpos.func_177956_o();
            d1 = (double)blockpos.func_177952_p();
            entityIn.func_70012_b(d0, entityIn.field_70163_u, d1, 90.0F, 0.0F);

            if (entityIn.isEntityAlive())
            {
                p_82448_3_.updateEntityWithOptionalForce(entityIn, false);
            }
        }

        p_82448_3_.theProfiler.endSection();

        if (p_82448_2_ != 1)
        {
            p_82448_3_.theProfiler.startSection("placing");
            d0 = (double)MathHelper.clamp_int((int)d0, -29999872, 29999872);
            d1 = (double)MathHelper.clamp_int((int)d1, -29999872, 29999872);

            if (entityIn.isEntityAlive())
            {
                entityIn.func_70012_b(d0, entityIn.field_70163_u, d1, entityIn.field_70177_z, entityIn.field_70125_A);
                p_82448_4_.getDefaultTeleporter().placeInPortal(entityIn, f);
                p_82448_4_.func_72838_d(entityIn);
                p_82448_4_.updateEntityWithOptionalForce(entityIn, false);
            }

            p_82448_3_.theProfiler.endSection();
        }

        entityIn.setWorld(p_82448_4_);
    }

    /**
     * self explanitory
     */
    public void onTick()
    {
        if (++this.playerPingIndex > 600)
        {
            this.func_148540_a(new S38PacketPlayerListItem(S38PacketPlayerListItem.Action.UPDATE_LATENCY, this.playerEntityList));
            this.playerPingIndex = 0;
        }
    }

    public void func_148540_a(Packet packetIn)
    {
        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            ((EntityPlayerMP)this.playerEntityList.get(i)).field_71135_a.func_147359_a(packetIn);
        }
    }

    public void sendPacketToAllPlayersInDimension(Packet packetIn, int dimension)
    {
        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntityList.get(i);

            if (entityplayermp.dimension == dimension)
            {
                entityplayermp.field_71135_a.func_147359_a(packetIn);
            }
        }
    }

    public void sendMessageToAllTeamMembers(EntityPlayer player, IChatComponent message)
    {
        Team team = player.func_96124_cp();

        if (team != null)
        {
            for (String s : team.getMembershipCollection())
            {
                EntityPlayerMP entityplayermp = this.func_152612_a(s);

                if (entityplayermp != null && entityplayermp != player)
                {
                    entityplayermp.func_145747_a(message);
                }
            }
        }
    }

    public void sendMessageToTeamOrEvryPlayer(EntityPlayer player, IChatComponent message)
    {
        Team team = player.func_96124_cp();

        if (team == null)
        {
            this.func_148539_a(message);
        }
        else
        {
            for (int i = 0; i < this.playerEntityList.size(); ++i)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntityList.get(i);

                if (entityplayermp.func_96124_cp() != team)
                {
                    entityplayermp.func_145747_a(message);
                }
            }
        }
    }

    public String func_181058_b(boolean p_181058_1_)
    {
        String s = "";
        List<EntityPlayerMP> list = Lists.newArrayList(this.playerEntityList);

        for (int i = 0; i < ((List)list).size(); ++i)
        {
            if (i > 0)
            {
                s = s + ", ";
            }

            s = s + ((EntityPlayerMP)list.get(i)).func_70005_c_();

            if (p_181058_1_)
            {
                s = s + " (" + ((EntityPlayerMP)list.get(i)).func_110124_au().toString() + ")";
            }
        }

        return s;
    }

    /**
     * Returns an array of the usernames of all the connected players.
     */
    public String[] getAllUsernames()
    {
        String[] astring = new String[this.playerEntityList.size()];

        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            astring[i] = ((EntityPlayerMP)this.playerEntityList.get(i)).func_70005_c_();
        }

        return astring;
    }

    public GameProfile[] getAllProfiles()
    {
        GameProfile[] agameprofile = new GameProfile[this.playerEntityList.size()];

        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            agameprofile[i] = ((EntityPlayerMP)this.playerEntityList.get(i)).getGameProfile();
        }

        return agameprofile;
    }

    public UserListBans func_152608_h()
    {
        return this.bannedPlayers;
    }

    public BanList func_72363_f()
    {
        return this.bannedIPs;
    }

    public void func_152605_a(GameProfile profile)
    {
        this.ops.func_152687_a(new UserListOpsEntry(profile, this.mcServer.getOpPermissionLevel(), this.ops.func_183026_b(profile)));
    }

    public void func_152610_b(GameProfile profile)
    {
        this.ops.func_152684_c(profile);
    }

    public boolean canJoin(GameProfile profile)
    {
        return !this.whiteListEnforced || this.ops.hasEntry(profile) || this.whiteListedPlayers.hasEntry(profile);
    }

    public boolean func_152596_g(GameProfile profile)
    {
        return this.ops.hasEntry(profile) || this.mcServer.func_71264_H() && this.mcServer.field_71305_c[0].func_72912_H().areCommandsAllowed() && this.mcServer.getServerOwner().equalsIgnoreCase(profile.getName()) || this.commandsAllowedForAll;
    }

    public EntityPlayerMP func_152612_a(String username)
    {
        for (EntityPlayerMP entityplayermp : this.playerEntityList)
        {
            if (entityplayermp.func_70005_c_().equalsIgnoreCase(username))
            {
                return entityplayermp;
            }
        }

        return null;
    }

    /**
     * params: x,y,z,r,dimension. The packet is sent to all players within r radius of x,y,z (r^2>x^2+y^2+z^2)
     */
    public void sendToAllNear(double x, double y, double z, double radius, int dimension, Packet packetIn)
    {
        this.sendToAllNearExcept((EntityPlayer)null, x, y, z, radius, dimension, packetIn);
    }

    /**
     * params: srcPlayer,x,y,z,r,dimension. The packet is not sent to the srcPlayer, but all other players within the
     * search radius
     */
    public void sendToAllNearExcept(EntityPlayer p_148543_1_, double x, double y, double z, double radius, int dimension, Packet p_148543_11_)
    {
        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.playerEntityList.get(i);

            if (entityplayermp != p_148543_1_ && entityplayermp.dimension == dimension)
            {
                double d0 = x - entityplayermp.field_70165_t;
                double d1 = y - entityplayermp.field_70163_u;
                double d2 = z - entityplayermp.field_70161_v;

                if (d0 * d0 + d1 * d1 + d2 * d2 < radius * radius)
                {
                    entityplayermp.field_71135_a.func_147359_a(p_148543_11_);
                }
            }
        }
    }

    /**
     * Saves all of the players' current states.
     */
    public void saveAllPlayerData()
    {
        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            this.writePlayerData((EntityPlayerMP)this.playerEntityList.get(i));
        }
    }

    public void func_152601_d(GameProfile profile)
    {
        this.whiteListedPlayers.func_152687_a(new UserListWhitelistEntry(profile));
    }

    public void func_152597_c(GameProfile profile)
    {
        this.whiteListedPlayers.func_152684_c(profile);
    }

    public UserListWhitelist func_152599_k()
    {
        return this.whiteListedPlayers;
    }

    public String[] func_152598_l()
    {
        return this.whiteListedPlayers.func_152685_a();
    }

    public UserListOps func_152603_m()
    {
        return this.ops;
    }

    public String[] func_152606_n()
    {
        return this.ops.func_152685_a();
    }

    /**
     * Either does nothing, or calls readWhiteList.
     */
    public void func_72362_j()
    {
    }

    /**
     * Updates the time and weather for the given player to those of the given world
     */
    public void updateTimeAndWeatherForPlayer(EntityPlayerMP playerIn, WorldServer worldIn)
    {
        WorldBorder worldborder = this.mcServer.field_71305_c[0].func_175723_af();
        playerIn.field_71135_a.func_147359_a(new S44PacketWorldBorder(worldborder, S44PacketWorldBorder.Action.INITIALIZE));
        playerIn.field_71135_a.func_147359_a(new S03PacketTimeUpdate(worldIn.func_82737_E(), worldIn.func_72820_D(), worldIn.func_82736_K().func_82766_b("doDaylightCycle")));

        if (worldIn.isRaining())
        {
            playerIn.field_71135_a.func_147359_a(new S2BPacketChangeGameState(1, 0.0F));
            playerIn.field_71135_a.func_147359_a(new S2BPacketChangeGameState(7, worldIn.getRainStrength(1.0F)));
            playerIn.field_71135_a.func_147359_a(new S2BPacketChangeGameState(8, worldIn.getThunderStrength(1.0F)));
        }
    }

    /**
     * sends the players inventory to himself
     */
    public void syncPlayerInventory(EntityPlayerMP playerIn)
    {
        playerIn.sendContainerToPlayer(playerIn.field_71069_bz);
        playerIn.setPlayerHealthUpdated();
        playerIn.field_71135_a.func_147359_a(new S09PacketHeldItemChange(playerIn.field_71071_by.currentItem));
    }

    /**
     * Returns the number of players currently on the server.
     */
    public int getCurrentPlayerCount()
    {
        return this.playerEntityList.size();
    }

    /**
     * Returns the maximum number of players allowed on the server.
     */
    public int getMaxPlayers()
    {
        return this.maxPlayers;
    }

    /**
     * Returns an array of usernames for which player.dat exists for.
     */
    public String[] func_72373_m()
    {
        return this.mcServer.field_71305_c[0].getSaveHandler().getPlayerNBTManager().getAvailablePlayerDat();
    }

    public void func_72371_a(boolean whitelistEnabled)
    {
        this.whiteListEnforced = whitelistEnabled;
    }

    public List<EntityPlayerMP> func_72382_j(String address)
    {
        List<EntityPlayerMP> list = Lists.newArrayList();

        for (EntityPlayerMP entityplayermp : this.playerEntityList)
        {
            if (entityplayermp.func_71114_r().equals(address))
            {
                list.add(entityplayermp);
            }
        }

        return list;
    }

    /**
     * Gets the View Distance.
     */
    public int getViewDistance()
    {
        return this.viewDistance;
    }

    public MinecraftServer getServerInstance()
    {
        return this.mcServer;
    }

    /**
     * On integrated servers, returns the host's player data to be written to level.dat.
     */
    public NBTTagCompound getHostPlayerData()
    {
        return null;
    }

    public void setGameType(WorldSettings.GameType p_152604_1_)
    {
        this.gameType = p_152604_1_;
    }

    private void setPlayerGameTypeBasedOnOther(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World worldIn)
    {
        if (p_72381_2_ != null)
        {
            p_72381_1_.field_71134_c.setGameType(p_72381_2_.field_71134_c.getGameType());
        }
        else if (this.gameType != null)
        {
            p_72381_1_.field_71134_c.setGameType(this.gameType);
        }

        p_72381_1_.field_71134_c.initializeGameType(worldIn.func_72912_H().getGameType());
    }

    /**
     * Sets whether all players are allowed to use commands (cheats) on the server.
     */
    public void setCommandsAllowedForAll(boolean p_72387_1_)
    {
        this.commandsAllowedForAll = p_72387_1_;
    }

    /**
     * Kicks everyone with "Server closed" as reason.
     */
    public void removeAllPlayers()
    {
        for (int i = 0; i < this.playerEntityList.size(); ++i)
        {
            ((EntityPlayerMP)this.playerEntityList.get(i)).field_71135_a.func_147360_c("Server closed");
        }
    }

    public void sendChatMsgImpl(IChatComponent component, boolean isChat)
    {
        this.mcServer.func_145747_a(component);
        byte b0 = (byte)(isChat ? 1 : 0);
        this.func_148540_a(new S02PacketChat(component, b0));
    }

    /**
     * Sends the given string to every player as chat message.
     */
    public void func_148539_a(IChatComponent component)
    {
        this.sendChatMsgImpl(component, true);
    }

    public StatisticsFile getPlayerStatsFile(EntityPlayer playerIn)
    {
        UUID uuid = playerIn.func_110124_au();
        StatisticsFile statisticsfile = uuid == null ? null : (StatisticsFile)this.playerStatFiles.get(uuid);

        if (statisticsfile == null)
        {
            File file1 = new File(this.mcServer.func_71218_a(0).getSaveHandler().getWorldDirectory(), "stats");
            File file2 = new File(file1, uuid.toString() + ".json");

            if (!file2.exists())
            {
                File file3 = new File(file1, playerIn.func_70005_c_() + ".json");

                if (file3.exists() && file3.isFile())
                {
                    file3.renameTo(file2);
                }
            }

            statisticsfile = new StatisticsFile(this.mcServer, file2);
            statisticsfile.readStatFile();
            this.playerStatFiles.put(uuid, statisticsfile);
        }

        return statisticsfile;
    }

    public void setViewDistance(int distance)
    {
        this.viewDistance = distance;

        if (this.mcServer.field_71305_c != null)
        {
            for (WorldServer worldserver : this.mcServer.field_71305_c)
            {
                if (worldserver != null)
                {
                    worldserver.getPlayerManager().setPlayerViewRadius(distance);
                }
            }
        }
    }

    public List<EntityPlayerMP> func_181057_v()
    {
        return this.playerEntityList;
    }

    /**
     * Get's the EntityPlayerMP object representing the player with the UUID.
     */
    public EntityPlayerMP func_177451_a(UUID playerUUID)
    {
        return this.uuidToPlayerMap.get(playerUUID);
    }

    public boolean func_183023_f(GameProfile p_183023_1_)
    {
        return false;
    }
}
