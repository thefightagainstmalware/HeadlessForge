package net.minecraft.world;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEventData;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.INpc;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import net.minecraft.network.play.server.S24PacketBlockAction;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.village.VillageCollection;
import net.minecraft.village.VillageSiege;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldServer extends World implements IThreadListener {
    private static final Logger logger = LogManager.getLogger();
    private final MinecraftServer mcServer;
    private final EntityTracker theEntityTracker;
    private final PlayerManager thePlayerManager;
    private final Set<NextTickListEntry> pendingTickListEntriesHashSet = Sets.<NextTickListEntry>newHashSet();
    private final TreeSet<NextTickListEntry> pendingTickListEntriesTreeSet = new TreeSet();
    private final Map<UUID, Entity> entitiesByUuid = Maps.<UUID, Entity>newHashMap();
    public ChunkProviderServer theChunkProviderServer;

    /**
     * Whether level saving is disabled or not
     */
    public boolean disableLevelSaving;

    /**
     * is false if there are no players
     */
    private boolean allPlayersSleeping;
    private int updateEntityTick;

    /**
     * the teleporter to use when the entity is being transferred into the dimension
     */
    private final Teleporter worldTeleporter;
    private final SpawnerAnimals mobSpawner = new SpawnerAnimals();
    protected final VillageSiege villageSiege = new VillageSiege(this);
    private WorldServer.ServerBlockEventList[] field_147490_S = new WorldServer.ServerBlockEventList[]{new WorldServer.ServerBlockEventList(), new WorldServer.ServerBlockEventList()};
    private int blockEventCacheIndex;
    private static final List<WeightedRandomChestContent> bonusChestContent = Lists.newArrayList(new WeightedRandomChestContent[]{new WeightedRandomChestContent(Items.stick, 0, 1, 3, 10), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150344_f), 0, 1, 3, 10), new WeightedRandomChestContent(Item.func_150898_a(Blocks.log), 0, 1, 3, 10), new WeightedRandomChestContent(Items.stone_axe, 0, 1, 1, 3), new WeightedRandomChestContent(Items.wooden_axe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.stone_pickaxe, 0, 1, 1, 3), new WeightedRandomChestContent(Items.wooden_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.apple, 0, 2, 3, 5), new WeightedRandomChestContent(Items.bread, 0, 2, 3, 3), new WeightedRandomChestContent(Item.func_150898_a(Blocks.log2), 0, 1, 3, 10)});
    private List<NextTickListEntry> pendingTickListEntriesThisTick = Lists.<NextTickListEntry>newArrayList();

    public WorldServer(MinecraftServer server, ISaveHandler saveHandlerIn, WorldInfo info, int dimensionId, Profiler profilerIn) {
        super(saveHandlerIn, info, WorldProvider.getProviderForDimension(dimensionId), profilerIn, false);
        this.mcServer = server;
        this.theEntityTracker = new EntityTracker(this);
        this.thePlayerManager = new PlayerManager(this);
        this.provider.registerWorld(this);
        this.chunkProvider = this.createChunkProvider();
        this.worldTeleporter = new Teleporter(this);
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        this.func_175723_af().setSize(server.getMaxWorldSize());
    }

    public World init() {
        this.mapStorage = new MapStorage(this.saveHandler);
        String s = VillageCollection.fileNameForProvider(this.provider);
        VillageCollection villagecollection = (VillageCollection) this.mapStorage.loadData(VillageCollection.class, s);

        if (villagecollection == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(s, this.villageCollectionObj);
        } else {
            this.villageCollectionObj = villagecollection;
            this.villageCollectionObj.setWorldsForAll(this);
        }

        this.worldScoreboard = new ServerScoreboard(this.mcServer);
        ScoreboardSaveData scoreboardsavedata = (ScoreboardSaveData) this.mapStorage.loadData(ScoreboardSaveData.class, "scoreboard");

        if (scoreboardsavedata == null) {
            scoreboardsavedata = new ScoreboardSaveData();
            this.mapStorage.setData("scoreboard", scoreboardsavedata);
        }

        scoreboardsavedata.setScoreboard(this.worldScoreboard);
        ((ServerScoreboard) this.worldScoreboard).func_96547_a(scoreboardsavedata);
        this.func_175723_af().func_177739_c(this.worldInfo.getBorderCenterX(), this.worldInfo.getBorderCenterZ());
        this.func_175723_af().func_177744_c(this.worldInfo.getBorderDamagePerBlock());
        this.func_175723_af().func_177724_b(this.worldInfo.getBorderSafeZone());
        this.func_175723_af().func_177747_c(this.worldInfo.getBorderWarningDistance());
        this.func_175723_af().func_177723_b(this.worldInfo.getBorderWarningTime());

        if (this.worldInfo.getBorderLerpTime() > 0L) {
            this.func_175723_af().func_177738_a(this.worldInfo.getBorderSize(), this.worldInfo.getBorderLerpTarget(), this.worldInfo.getBorderLerpTime());
        } else {
            this.func_175723_af().func_177750_a(this.worldInfo.getBorderSize());
        }

        return this;
    }

    /**
     * Runs a single tick for the world
     */
    public void tick() {
        super.tick();

        if (this.func_72912_H().isHardcoreModeEnabled() && this.getDifficulty() != EnumDifficulty.HARD) {
            this.func_72912_H().setDifficulty(EnumDifficulty.HARD);
        }

        this.provider.getWorldChunkManager().cleanupCache();

        if (this.areAllPlayersAsleep()) {
            if (this.func_82736_K().func_82766_b("doDaylightCycle")) {
                long i = this.worldInfo.getWorldTime() + 24000L;
                this.worldInfo.func_72877_b(i - i % 24000L);
            }

            this.wakeAllPlayers();
        }

        this.theProfiler.startSection("mobSpawner");

        if (this.func_82736_K().func_82766_b("doMobSpawning") && this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.mobSpawner.findChunksForSpawning(this, this.spawnHostileMobs, this.spawnPeacefulMobs, this.worldInfo.func_82573_f() % 400L == 0L);
        }

        this.theProfiler.endStartSection("chunkSource");
        this.chunkProvider.unloadQueuedChunks();
        int j = this.calculateSkylightSubtracted(1.0F);

        if (j != this.getSkylightSubtracted()) {
            this.setSkylightSubtracted(j);
        }

        this.worldInfo.setWorldTotalTime(this.worldInfo.func_82573_f() + 1L);

        if (this.func_82736_K().func_82766_b("doDaylightCycle")) {
            this.worldInfo.func_72877_b(this.worldInfo.getWorldTime() + 1L);
        }

        this.theProfiler.endStartSection("tickPending");
        this.tickUpdates(false);
        this.theProfiler.endStartSection("tickBlocks");
        this.updateBlocks();
        this.theProfiler.endStartSection("chunkMap");
        this.thePlayerManager.updatePlayerInstances();
        this.theProfiler.endStartSection("village");
        this.villageCollectionObj.tick();
        this.villageSiege.tick();
        this.theProfiler.endStartSection("portalForcer");
        this.worldTeleporter.removeStalePortalLocations(this.func_82737_E());
        this.theProfiler.endSection();
        this.sendQueuedBlockEvents();
    }

    public BiomeGenBase.SpawnListEntry getSpawnListEntryForTypeAt(EnumCreatureType creatureType, BlockPos pos) {
        List<BiomeGenBase.SpawnListEntry> list = this.getChunkProvider().getPossibleCreatures(creatureType, pos);
        return list != null && !list.isEmpty() ? (BiomeGenBase.SpawnListEntry) WeightedRandom.getRandomItem(this.rand, list) : null;
    }

    public boolean canCreatureTypeSpawnHere(EnumCreatureType creatureType, BiomeGenBase.SpawnListEntry spawnListEntry, BlockPos pos) {
        List<BiomeGenBase.SpawnListEntry> list = this.getChunkProvider().getPossibleCreatures(creatureType, pos);
        return list != null && !list.isEmpty() ? list.contains(spawnListEntry) : false;
    }

    /**
     * Updates the flag that indicates whether or not all players in the world are sleeping.
     */
    public void updateAllPlayersSleepingFlag() {
        this.allPlayersSleeping = false;

        if (!this.playerEntities.isEmpty()) {
            int i = 0;
            int j = 0;

            for (EntityPlayer entityplayer : this.playerEntities) {
                if (entityplayer.isSpectator()) {
                    ++i;
                } else if (entityplayer.isPlayerSleeping()) {
                    ++j;
                }
            }

            this.allPlayersSleeping = j > 0 && j >= this.playerEntities.size() - i;
        }
    }

    protected void wakeAllPlayers() {
        this.allPlayersSleeping = false;

        for (EntityPlayer entityplayer : this.playerEntities) {
            if (entityplayer.isPlayerSleeping()) {
                entityplayer.wakeUpPlayer(false, false, true);
            }
        }

        this.resetRainAndThunder();
    }

    private void resetRainAndThunder() {
        this.worldInfo.func_76080_g(0);
        this.worldInfo.func_76084_b(false);
        this.worldInfo.func_76090_f(0);
        this.worldInfo.func_76069_a(false);
    }

    public boolean areAllPlayersAsleep() {
        if (this.allPlayersSleeping && !this.isRemote) {
            for (EntityPlayer entityplayer : this.playerEntities) {
                if (entityplayer.isSpectator() || !entityplayer.isPlayerFullyAsleep()) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets a new spawn location by finding an uncovered block at a random (x,z) location in the chunk.
     */
    public void setInitialSpawnLocation() {
        if (this.worldInfo.getSpawnY() <= 0) {
            this.worldInfo.setSpawnY(this.func_181545_F() + 1);
        }

        int i = this.worldInfo.getSpawnX();
        int j = this.worldInfo.getSpawnZ();
        int k = 0;

        while (this.getGroundAboveSeaLevel(new BlockPos(i, 0, j)).func_149688_o() == Material.field_151579_a) {
            i += this.rand.nextInt(8) - this.rand.nextInt(8);
            j += this.rand.nextInt(8) - this.rand.nextInt(8);
            ++k;

            if (k == 10000) {
                break;
            }
        }

        this.worldInfo.setSpawnX(i);
        this.worldInfo.setSpawnZ(j);
    }

    protected void updateBlocks() {
        super.updateBlocks();

        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            for (ChunkCoordIntPair chunkcoordintpair1 : this.activeChunkSet) {
                this.getChunkFromChunkCoords(chunkcoordintpair1.chunkXPos, chunkcoordintpair1.chunkZPos).func_150804_b(false);
            }
        } else {
            int i = 0;
            int j = 0;

            for (ChunkCoordIntPair chunkcoordintpair : this.activeChunkSet) {
                int k = chunkcoordintpair.chunkXPos * 16;
                int l = chunkcoordintpair.chunkZPos * 16;
                this.theProfiler.startSection("getChunk");
                Chunk chunk = this.getChunkFromChunkCoords(chunkcoordintpair.chunkXPos, chunkcoordintpair.chunkZPos);
                this.playMoodSoundAndCheckLight(k, l, chunk);
                this.theProfiler.endStartSection("tickChunk");
                chunk.func_150804_b(false);
                this.theProfiler.endStartSection("thunder");

                if (this.rand.nextInt(100000) == 0 && this.isRaining() && this.isThundering()) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    int i1 = this.updateLCG >> 2;
                    BlockPos blockpos = this.adjustPosToNearbyEntity(new BlockPos(k + (i1 & 15), 0, l + (i1 >> 8 & 15)));

                    if (this.canLightningStrike(blockpos)) {
                        this.func_72942_c(new EntityLightningBolt(this, (double) blockpos.func_177958_n(), (double) blockpos.func_177956_o(), (double) blockpos.func_177952_p()));
                    }
                }

                this.theProfiler.endStartSection("iceandsnow");

                if (this.rand.nextInt(16) == 0) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    int k2 = this.updateLCG >> 2;
                    BlockPos blockpos2 = this.getPrecipitationHeight(new BlockPos(k + (k2 & 15), 0, l + (k2 >> 8 & 15)));
                    BlockPos blockpos1 = blockpos2.func_177977_b();

                    if (this.canBlockFreezeNoWater(blockpos1)) {
                        this.setBlockState(blockpos1, Blocks.ice.func_176223_P());
                    }

                    if (this.isRaining() && this.canSnowAt(blockpos2, true)) {
                        this.setBlockState(blockpos2, Blocks.snow_layer.func_176223_P());
                    }

                    if (this.isRaining() && this.getBiomeGenForCoords(blockpos1).canSpawnLightningBolt()) {
                        this.func_180495_p(blockpos1).func_177230_c().fillWithRain(this, blockpos1);
                    }
                }

                this.theProfiler.endStartSection("tickBlocks");
                int l2 = this.func_82736_K().func_180263_c("randomTickSpeed");

                if (l2 > 0) {
                    for (ExtendedBlockStorage extendedblockstorage : chunk.getBlockStorageArray()) {
                        if (extendedblockstorage != null && extendedblockstorage.getNeedsRandomTick()) {
                            for (int j1 = 0; j1 < l2; ++j1) {
                                this.updateLCG = this.updateLCG * 3 + 1013904223;
                                int k1 = this.updateLCG >> 2;
                                int l1 = k1 & 15;
                                int i2 = k1 >> 8 & 15;
                                int j2 = k1 >> 16 & 15;
                                ++j;
                                IBlockState iblockstate = extendedblockstorage.get(l1, j2, i2);
                                Block block = iblockstate.func_177230_c();

                                if (block.getTickRandomly()) {
                                    ++i;
                                    block.randomTick(this, new BlockPos(l1 + k, j2 + extendedblockstorage.getYLocation(), i2 + l), iblockstate, this.rand);
                                }
                            }
                        }
                    }
                }

                this.theProfiler.endSection();
            }
        }
    }

    protected BlockPos adjustPosToNearbyEntity(BlockPos pos) {
        BlockPos blockpos = this.getPrecipitationHeight(pos);
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(blockpos, new BlockPos(blockpos.func_177958_n(), this.getHeight(), blockpos.func_177952_p()))).expand(3.0D, 3.0D, 3.0D);
        List<EntityLivingBase> list = this.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb, new Predicate<EntityLivingBase>() {
            public boolean apply(EntityLivingBase p_apply_1_) {
                return p_apply_1_ != null && p_apply_1_.isEntityAlive() && WorldServer.this.canSeeSky(p_apply_1_.func_180425_c());
            }
        });
        return !list.isEmpty() ? ((EntityLivingBase) list.get(this.rand.nextInt(list.size()))).func_180425_c() : blockpos;
    }

    public boolean isBlockTickPending(BlockPos pos, Block blockType) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(pos, blockType);
        return this.pendingTickListEntriesThisTick.contains(nextticklistentry);
    }

    public void scheduleUpdate(BlockPos pos, Block blockIn, int delay) {
        this.updateBlockTick(pos, blockIn, delay, 0);
    }

    public void updateBlockTick(BlockPos pos, Block blockIn, int delay, int priority) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(pos, blockIn);
        int i = 0;

        if (this.scheduledUpdatesAreImmediate && blockIn.func_149688_o() != Material.field_151579_a) {
            if (blockIn.requiresUpdates()) {
                i = 8;

                if (this.isAreaLoaded(nextticklistentry.field_180282_a.add(-i, -i, -i), nextticklistentry.field_180282_a.add(i, i, i))) {
                    IBlockState iblockstate = this.func_180495_p(nextticklistentry.field_180282_a);

                    if (iblockstate.func_177230_c().func_149688_o() != Material.field_151579_a && iblockstate.func_177230_c() == nextticklistentry.func_151351_a()) {
                        iblockstate.func_177230_c().updateTick(this, nextticklistentry.field_180282_a, iblockstate, this.rand);
                    }
                }

                return;
            }

            delay = 1;
        }

        if (this.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i))) {
            if (blockIn.func_149688_o() != Material.field_151579_a) {
                nextticklistentry.setScheduledTime((long) delay + this.worldInfo.func_82573_f());
                nextticklistentry.setPriority(priority);
            }

            if (!this.pendingTickListEntriesHashSet.contains(nextticklistentry)) {
                this.pendingTickListEntriesHashSet.add(nextticklistentry);
                this.pendingTickListEntriesTreeSet.add(nextticklistentry);
            }
        }
    }

    public void func_180497_b(BlockPos pos, Block blockIn, int delay, int priority) {
        NextTickListEntry nextticklistentry = new NextTickListEntry(pos, blockIn);
        nextticklistentry.setPriority(priority);

        if (blockIn.func_149688_o() != Material.field_151579_a) {
            nextticklistentry.setScheduledTime((long) delay + this.worldInfo.func_82573_f());
        }

        if (!this.pendingTickListEntriesHashSet.contains(nextticklistentry)) {
            this.pendingTickListEntriesHashSet.add(nextticklistentry);
            this.pendingTickListEntriesTreeSet.add(nextticklistentry);
        }
    }

    /**
     * Updates (and cleans up) entities and tile entities
     */
    public void updateEntities() {
        if (this.playerEntities.isEmpty()) {
            if (this.updateEntityTick++ >= 1200) {
                return;
            }
        } else {
            this.resetUpdateEntityTick();
        }

        super.updateEntities();
    }

    /**
     * Resets the updateEntityTick field to 0
     */
    public void resetUpdateEntityTick() {
        this.updateEntityTick = 0;
    }

    /**
     * Runs through the list of updates to run and ticks them
     */
    public boolean tickUpdates(boolean p_72955_1_) {
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        } else {
            int i = this.pendingTickListEntriesTreeSet.size();

            if (i != this.pendingTickListEntriesHashSet.size()) {
                throw new IllegalStateException("TickNextTick list out of synch");
            } else {
                if (i > 1000) {
                    i = 1000;
                }

                this.theProfiler.startSection("cleaning");

                for (int j = 0; j < i; ++j) {
                    NextTickListEntry nextticklistentry = (NextTickListEntry) this.pendingTickListEntriesTreeSet.first();

                    if (!p_72955_1_ && nextticklistentry.field_77180_e > this.worldInfo.func_82573_f()) {
                        break;
                    }

                    this.pendingTickListEntriesTreeSet.remove(nextticklistentry);
                    this.pendingTickListEntriesHashSet.remove(nextticklistentry);
                    this.pendingTickListEntriesThisTick.add(nextticklistentry);
                }

                this.theProfiler.endSection();
                this.theProfiler.startSection("ticking");
                Iterator<NextTickListEntry> iterator = this.pendingTickListEntriesThisTick.iterator();

                while (iterator.hasNext()) {
                    NextTickListEntry nextticklistentry1 = (NextTickListEntry) iterator.next();
                    iterator.remove();
                    int k = 0;

                    if (this.isAreaLoaded(nextticklistentry1.field_180282_a.add(-k, -k, -k), nextticklistentry1.field_180282_a.add(k, k, k))) {
                        IBlockState iblockstate = this.func_180495_p(nextticklistentry1.field_180282_a);

                        if (iblockstate.func_177230_c().func_149688_o() != Material.field_151579_a && Block.isEqualTo(iblockstate.func_177230_c(), nextticklistentry1.func_151351_a())) {
                            try {
                                iblockstate.func_177230_c().updateTick(this, nextticklistentry1.field_180282_a, iblockstate, this.rand);
                            } catch (Throwable throwable) {
                                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Exception while ticking a block");
                                CrashReportCategory crashreportcategory = crashreport.makeCategory("Block being ticked");
                                CrashReportCategory.addBlockInfo(crashreportcategory, nextticklistentry1.field_180282_a, iblockstate);
                                throw new ReportedException(crashreport);
                            }
                        }
                    } else {
                        this.scheduleUpdate(nextticklistentry1.field_180282_a, nextticklistentry1.func_151351_a(), 0);
                    }
                }

                this.theProfiler.endSection();
                this.pendingTickListEntriesThisTick.clear();
                return !this.pendingTickListEntriesTreeSet.isEmpty();
            }
        }
    }

    public List<NextTickListEntry> getPendingBlockUpdates(Chunk chunkIn, boolean p_72920_2_) {
        ChunkCoordIntPair chunkcoordintpair = chunkIn.getChunkCoordIntPair();
        int i = (chunkcoordintpair.chunkXPos << 4) - 2;
        int j = i + 16 + 2;
        int k = (chunkcoordintpair.chunkZPos << 4) - 2;
        int l = k + 16 + 2;
        return this.func_175712_a(new StructureBoundingBox(i, 0, k, j, 256, l), p_72920_2_);
    }

    public List<NextTickListEntry> func_175712_a(StructureBoundingBox structureBB, boolean p_175712_2_) {
        List<NextTickListEntry> list = null;

        for (int i = 0; i < 2; ++i) {
            Iterator<NextTickListEntry> iterator;

            if (i == 0) {
                iterator = this.pendingTickListEntriesTreeSet.iterator();
            } else {
                iterator = this.pendingTickListEntriesThisTick.iterator();
            }

            while (iterator.hasNext()) {
                NextTickListEntry nextticklistentry = (NextTickListEntry) iterator.next();
                BlockPos blockpos = nextticklistentry.field_180282_a;

                if (blockpos.func_177958_n() >= structureBB.field_78897_a && blockpos.func_177958_n() < structureBB.field_78893_d && blockpos.func_177952_p() >= structureBB.field_78896_c && blockpos.func_177952_p() < structureBB.field_78892_f) {
                    if (p_175712_2_) {
                        this.pendingTickListEntriesHashSet.remove(nextticklistentry);
                        iterator.remove();
                    }

                    if (list == null) {
                        list = Lists.<NextTickListEntry>newArrayList();
                    }

                    list.add(nextticklistentry);
                }
            }
        }

        return list;
    }

    /**
     * Will update the entity in the world if the chunk the entity is in is currently loaded or its forced to update.
     * Args: entity, forceUpdate
     */
    public void updateEntityWithOptionalForce(Entity entityIn, boolean forceUpdate) {
        if (!this.canSpawnAnimals() && (entityIn instanceof EntityAnimal || entityIn instanceof EntityWaterMob)) {
            entityIn.setDead();
        }

        if (!this.canSpawnNPCs() && entityIn instanceof INpc) {
            entityIn.setDead();
        }

        super.updateEntityWithOptionalForce(entityIn, forceUpdate);
    }

    private boolean canSpawnNPCs() {
        return this.mcServer.getCanSpawnNPCs();
    }

    private boolean canSpawnAnimals() {
        return this.mcServer.getCanSpawnAnimals();
    }

    /**
     * Creates the chunk provider for this world. Called in the constructor. Retrieves provider from worldProvider?
     */
    protected IChunkProvider createChunkProvider() {
        IChunkLoader ichunkloader = this.saveHandler.getChunkLoader(this.provider);
        this.theChunkProviderServer = new ChunkProviderServer(this, ichunkloader, this.provider.createChunkGenerator());
        return this.theChunkProviderServer;
    }

    public List<TileEntity> getTileEntitiesIn(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        List<TileEntity> list = Lists.<TileEntity>newArrayList();

        for (int i = 0; i < this.loadedTileEntityList.size(); ++i) {
            TileEntity tileentity = (TileEntity) this.loadedTileEntityList.get(i);
            BlockPos blockpos = tileentity.getPos();

            if (blockpos.func_177958_n() >= minX && blockpos.func_177956_o() >= minY && blockpos.func_177952_p() >= minZ && blockpos.func_177958_n() < maxX && blockpos.func_177956_o() < maxY && blockpos.func_177952_p() < maxZ) {
                list.add(tileentity);
            }
        }

        return list;
    }

    public boolean isBlockModifiable(EntityPlayer player, BlockPos pos) {
        return !this.mcServer.isBlockProtected(this, pos, player) && this.func_175723_af().contains(pos);
    }

    public void initialize(WorldSettings settings) {
        if (!this.worldInfo.isInitialized()) {
            try {
                this.createSpawnPosition(settings);

                if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
                    this.setDebugWorldSettings();
                }

                super.initialize(settings);
            } catch (Throwable throwable) {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Exception initializing level");

                try {
                    this.addWorldInfoToCrashReport(crashreport);
                } catch (Throwable var5) {
                    ;
                }

                throw new ReportedException(crashreport);
            }

            this.worldInfo.setServerInitialized(true);
        }
    }

    private void setDebugWorldSettings() {
        this.worldInfo.setMapFeaturesEnabled(false);
        this.worldInfo.setAllowCommands(true);
        this.worldInfo.func_76084_b(false);
        this.worldInfo.func_76069_a(false);
        this.worldInfo.func_176142_i(1000000000);
        this.worldInfo.func_72877_b(6000L);
        this.worldInfo.setGameType(WorldSettings.GameType.SPECTATOR);
        this.worldInfo.setHardcore(false);
        this.worldInfo.setDifficulty(EnumDifficulty.PEACEFUL);
        this.worldInfo.setDifficultyLocked(true);
        this.func_82736_K().func_82764_b("doDaylightCycle", "false");
    }

    /**
     * creates a spawn position at random within 256 blocks of 0,0
     */
    private void createSpawnPosition(WorldSettings p_73052_1_) {
        if (!this.provider.canRespawnHere()) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.up(this.provider.getAverageGroundLevel()));
        } else if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.up());
        } else {
            this.findingSpawnPoint = true;
            WorldChunkManager worldchunkmanager = this.provider.getWorldChunkManager();
            List<BiomeGenBase> list = worldchunkmanager.getBiomesToSpawnIn();
            Random random = new Random(this.func_72905_C());
            BlockPos blockpos = worldchunkmanager.findBiomePosition(0, 0, 256, list, random);
            int i = 0;
            int j = this.provider.getAverageGroundLevel();
            int k = 0;

            if (blockpos != null) {
                i = blockpos.func_177958_n();
                k = blockpos.func_177952_p();
            } else {
                logger.warn("Unable to find spawn biome");
            }

            int l = 0;

            while (!this.provider.canCoordinateBeSpawn(i, k)) {
                i += random.nextInt(64) - random.nextInt(64);
                k += random.nextInt(64) - random.nextInt(64);
                ++l;

                if (l == 1000) {
                    break;
                }
            }

            this.worldInfo.setSpawn(new BlockPos(i, j, k));
            this.findingSpawnPoint = false;

            if (p_73052_1_.isBonusChestEnabled()) {
                this.createBonusChest();
            }
        }
    }

    /**
     * Creates the bonus chest in the world.
     */
    protected void createBonusChest() {
        WorldGeneratorBonusChest worldgeneratorbonuschest = new WorldGeneratorBonusChest(bonusChestContent, 10);

        for (int i = 0; i < 10; ++i) {
            int j = this.worldInfo.getSpawnX() + this.rand.nextInt(6) - this.rand.nextInt(6);
            int k = this.worldInfo.getSpawnZ() + this.rand.nextInt(6) - this.rand.nextInt(6);
            BlockPos blockpos = this.getTopSolidOrLiquidBlock(new BlockPos(j, 0, k)).up();

            if (worldgeneratorbonuschest.generate(this, this.rand, blockpos)) {
                break;
            }
        }
    }

    /**
     * Returns null for anything other than the End
     */
    public BlockPos getSpawnCoordinate() {
        return this.provider.getSpawnCoordinate();
    }

    /**
     * Saves all chunks to disk while updating progress bar.
     */
    public void saveAllChunks(boolean p_73044_1_, IProgressUpdate progressCallback) throws MinecraftException {
        if (this.chunkProvider.canSave()) {
            if (progressCallback != null) {
                progressCallback.displaySavingString("Saving level");
            }

            this.saveLevel();

            if (progressCallback != null) {
                progressCallback.displayLoadingString("Saving chunks");
            }

            this.chunkProvider.saveChunks(p_73044_1_, progressCallback);

            for (Chunk chunk : Lists.newArrayList(this.theChunkProviderServer.func_152380_a())) {
                if (chunk != null && !this.thePlayerManager.hasPlayerInstance(chunk.xPosition, chunk.zPosition)) {
                    this.theChunkProviderServer.dropChunk(chunk.xPosition, chunk.zPosition);
                }
            }
        }
    }

    /**
     * saves chunk data - currently only called during execution of the Save All command
     */
    public void saveChunkData() {
        if (this.chunkProvider.canSave()) {
            this.chunkProvider.saveExtraData();
        }
    }

    /**
     * Saves the chunks to disk.
     */
    protected void saveLevel() throws MinecraftException {
        this.checkSessionLock();
        this.worldInfo.setBorderSize(this.func_175723_af().func_177741_h());
        this.worldInfo.getBorderCenterX(this.func_175723_af().getCenterX());
        this.worldInfo.getBorderCenterZ(this.func_175723_af().getCenterZ());
        this.worldInfo.setBorderSafeZone(this.func_175723_af().func_177742_m());
        this.worldInfo.setBorderDamagePerBlock(this.func_175723_af().func_177727_n());
        this.worldInfo.setBorderWarningDistance(this.func_175723_af().func_177748_q());
        this.worldInfo.setBorderWarningTime(this.func_175723_af().func_177740_p());
        this.worldInfo.setBorderLerpTarget(this.func_175723_af().func_177751_j());
        this.worldInfo.setBorderLerpTime(this.func_175723_af().func_177732_i());
        this.saveHandler.saveWorldInfoWithPlayer(this.worldInfo, this.mcServer.func_71203_ab().getHostPlayerData());
        this.mapStorage.saveAllData();
    }

    protected void onEntityAdded(Entity entityIn) {
        super.onEntityAdded(entityIn);
        this.entitiesById.addKey(entityIn.getEntityId(), entityIn);
        this.entitiesByUuid.put(entityIn.func_110124_au(), entityIn);
        Entity[] aentity = entityIn.getParts();

        if (aentity != null) {
            for (int i = 0; i < aentity.length; ++i) {
                this.entitiesById.addKey(aentity[i].getEntityId(), aentity[i]);
            }
        }
    }

    protected void onEntityRemoved(Entity entityIn) {
        super.onEntityRemoved(entityIn);
        this.entitiesById.removeObject(entityIn.getEntityId());
        this.entitiesByUuid.remove(entityIn.func_110124_au());
        Entity[] aentity = entityIn.getParts();

        if (aentity != null) {
            for (int i = 0; i < aentity.length; ++i) {
                this.entitiesById.removeObject(aentity[i].getEntityId());
            }
        }
    }

    /**
     * adds a lightning bolt to the list of lightning bolts in this world.
     */
    public boolean func_72942_c(Entity entityIn) {
        if (super.func_72942_c(entityIn)) {
            this.mcServer.func_71203_ab().sendToAllNear(entityIn.field_70165_t, entityIn.field_70163_u, entityIn.field_70161_v, 512.0D, this.provider.getDimensionId(), new S2CPacketSpawnGlobalEntity(entityIn));
            return true;
        } else {
            return false;
        }
    }

    /**
     * sends a Packet 38 (Entity Status) to all tracked players of that entity
     */
    public void setEntityState(Entity entityIn, byte state) {
        this.getEntityTracker().func_151248_b(entityIn, new S19PacketEntityStatus(entityIn, state));
    }

    /**
     * returns a new explosion. Does initiation (at time of writing Explosion is not finished)
     */
    public Explosion newExplosion(Entity entityIn, double x, double y, double z, float strength, boolean isFlaming, boolean isSmoking) {
        Explosion explosion = new Explosion(this, entityIn, x, y, z, strength, isFlaming, isSmoking);
        explosion.doExplosionA();
        explosion.doExplosionB(false);

        if (!isSmoking) {
            explosion.func_180342_d();
        }

        for (EntityPlayer entityplayer : this.playerEntities) {
            if (entityplayer.getDistanceSq(x, y, z) < 4096.0D) {
                ((EntityPlayerMP) entityplayer).field_71135_a.func_147359_a(new S27PacketExplosion(x, y, z, strength, explosion.getAffectedBlockPositions(), (Vec3) explosion.getPlayerKnockbackMap().get(entityplayer)));
            }
        }

        return explosion;
    }

    public void addBlockEvent(BlockPos pos, Block blockIn, int eventID, int eventParam) {
        BlockEventData blockeventdata = new BlockEventData(pos, blockIn, eventID, eventParam);

        for (BlockEventData blockeventdata1 : this.field_147490_S[this.blockEventCacheIndex]) {
            if (blockeventdata1.equals(blockeventdata)) {
                return;
            }
        }

        this.field_147490_S[this.blockEventCacheIndex].add(blockeventdata);
    }

    private void sendQueuedBlockEvents() {
        while (!this.field_147490_S[this.blockEventCacheIndex].isEmpty()) {
            int i = this.blockEventCacheIndex;
            this.blockEventCacheIndex ^= 1;

            for (BlockEventData blockeventdata : this.field_147490_S[i]) {
                if (this.fireBlockEvent(blockeventdata)) {
                    this.mcServer.func_71203_ab().sendToAllNear((double) blockeventdata.getPosition().func_177958_n(), (double) blockeventdata.getPosition().func_177956_o(), (double) blockeventdata.getPosition().func_177952_p(), 64.0D, this.provider.getDimensionId(), new S24PacketBlockAction(blockeventdata.getPosition(), blockeventdata.getBlock(), blockeventdata.getEventID(), blockeventdata.getEventParameter()));
                }
            }

            this.field_147490_S[i].clear();
        }
    }

    private boolean fireBlockEvent(BlockEventData event) {
        IBlockState iblockstate = this.func_180495_p(event.getPosition());
        return iblockstate.func_177230_c() == event.getBlock() ? iblockstate.func_177230_c().onBlockEventReceived(this, event.getPosition(), iblockstate, event.getEventID(), event.getEventParameter()) : false;
    }

    /**
     * Syncs all changes to disk and wait for completion.
     */
    public void flush() {
        this.saveHandler.flush();
    }

    /**
     * Updates all weather states.
     */
    protected void updateWeather() {
        boolean flag = this.isRaining();
        super.updateWeather();

        if (this.prevRainingStrength != this.rainingStrength) {
            this.mcServer.func_71203_ab().sendPacketToAllPlayersInDimension(new S2BPacketChangeGameState(7, this.rainingStrength), this.provider.getDimensionId());
        }

        if (this.prevThunderingStrength != this.thunderingStrength) {
            this.mcServer.func_71203_ab().sendPacketToAllPlayersInDimension(new S2BPacketChangeGameState(8, this.thunderingStrength), this.provider.getDimensionId());
        }

        if (flag != this.isRaining()) {
            if (flag) {
                this.mcServer.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(2, 0.0F));
            } else {
                this.mcServer.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(1, 0.0F));
            }

            this.mcServer.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(7, this.rainingStrength));
            this.mcServer.func_71203_ab().func_148540_a(new S2BPacketChangeGameState(8, this.thunderingStrength));
        }
    }

    protected int getRenderDistanceChunks() {
        return this.mcServer.func_71203_ab().getViewDistance();
    }

    public MinecraftServer getMinecraftServer() {
        return this.mcServer;
    }

    /**
     * Gets the EntityTracker
     */
    public EntityTracker getEntityTracker() {
        return this.theEntityTracker;
    }

    public PlayerManager getPlayerManager() {
        return this.thePlayerManager;
    }

    public Teleporter getDefaultTeleporter() {
        return this.worldTeleporter;
    }

    /**
     * Spawns the desired particle and sends the necessary packets to the relevant connected players.
     */
    public void func_180505_a(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, int numberOfParticles, double p_175739_9_, double p_175739_11_, double p_175739_13_, double p_175739_15_, int... p_175739_17_) {
        this.func_180505_a(particleType, false, xCoord, yCoord, zCoord, numberOfParticles, p_175739_9_, p_175739_11_, p_175739_13_, p_175739_15_, p_175739_17_);
    }

    /**
     * Spawns the desired particle and sends the necessary packets to the relevant connected players.
     */
    public void func_180505_a(EnumParticleTypes particleType, boolean longDistance, double xCoord, double yCoord, double zCoord, int numberOfParticles, double xOffset, double yOffset, double zOffset, double particleSpeed, int... p_180505_18_) {
        Packet packet = new S2APacketParticles(particleType, longDistance, (float) xCoord, (float) yCoord, (float) zCoord, (float) xOffset, (float) yOffset, (float) zOffset, (float) particleSpeed, numberOfParticles, p_180505_18_);

        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayerMP entityplayermp = (EntityPlayerMP) this.playerEntities.get(i);
            BlockPos blockpos = entityplayermp.func_180425_c();
            double d0 = blockpos.distanceSq(xCoord, yCoord, zCoord);

            if (d0 <= 256.0D || longDistance && d0 <= 65536.0D) {
                entityplayermp.field_71135_a.func_147359_a(packet);
            }
        }
    }

    public Entity getEntityFromUuid(UUID uuid) {
        return (Entity) this.entitiesByUuid.get(uuid);
    }

    public ListenableFuture<Object> addScheduledTask(Runnable runnableToSchedule) throws Exception {
        return this.mcServer.addScheduledTask(runnableToSchedule);
    }

    public boolean isCallingFromMinecraftThread() {
        return this.mcServer.isCallingFromMinecraftThread();
    }

    /**
     * FORGE: isSideSolid, pulled up from <a href="../../../net/minecraft/world/World.html" title="class in net.minecraft.world"><code>World</code></a>
     *
     * @param pos      Position
     * @param side     Side
     * @param _default default return value
     * @return if the block is solid on the side
     */
    @Override
    public boolean isSideSolid(BlockPos pos, EnumFacing side, boolean _default) {
        return false;
    }

    static class ServerBlockEventList extends ArrayList<BlockEventData> {
        private ServerBlockEventList() {
        }
    }
}
