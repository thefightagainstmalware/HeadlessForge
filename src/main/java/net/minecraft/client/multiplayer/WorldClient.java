package net.minecraft.client.multiplayer;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.concurrent.Callable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.*;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.SaveDataMemoryStorage;
import net.minecraft.world.storage.SaveHandlerMP;
import net.minecraft.world.storage.WorldInfo;

public class WorldClient extends World
{
    /** The packets that need to be sent to the server. */
    private NetHandlerPlayClient sendQueue;

    /** The ChunkProviderClient instance */
    private ChunkProviderClient clientChunkProvider;

    /** Contains all entities for this client, both spawned and non-spawned. */
    private final Set entityList = Sets.newHashSet();

    /**
     * Contains all entities for this client that were not spawned due to a non-present chunk. The game will attempt to
     * spawn up to 10 pending entities with each subsequent tick until the spawn queue is empty.
     */
    private final Set entitySpawnQueue = Sets.newHashSet();
    private final Minecraft mc = Minecraft.func_71410_x();
    private final Set previousActiveChunkSet = Sets.newHashSet();
    private static final String __OBFID = "CL_00000882";

    public WorldClient(NetHandlerPlayClient p_i45063_1_, WorldSettings p_i45063_2_, int p_i45063_3_, EnumDifficulty p_i45063_4_, Profiler p_i45063_5_)
    {
        super(new SaveHandlerMP(), new WorldInfo(p_i45063_2_, "MpServer"), WorldProvider.getProviderForDimension(p_i45063_3_), p_i45063_5_, true);
        this.sendQueue = p_i45063_1_;
        this.func_72912_H().setDifficulty(p_i45063_4_);
        this.provider.registerWorld(this);
        this.func_175652_B(new BlockPos(8, 64, 8));
        this.chunkProvider = this.createChunkProvider();
        this.mapStorage = new SaveDataMemoryStorage();
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
    }

    /**
     * Runs a single tick for the world
     */
    public void tick()
    {
        super.tick();
        this.setTotalWorldTime(this.func_82737_E() + 1L);

        if (this.func_82736_K().func_82766_b("doDaylightCycle"))
        {
            this.func_72877_b(this.func_72820_D() + 1L);
        }

        this.theProfiler.startSection("reEntryProcessing");

        for (int i = 0; i < 10 && !this.entitySpawnQueue.isEmpty(); ++i)
        {
            Entity entity = (Entity)this.entitySpawnQueue.iterator().next();
            this.entitySpawnQueue.remove(entity);

            if (!this.loadedEntityList.contains(entity))
            {
                this.func_72838_d(entity);
            }
        }

        this.theProfiler.endStartSection("chunkCache");
        this.clientChunkProvider.unloadQueuedChunks();
        this.theProfiler.endStartSection("blocks");
        this.updateBlocks();
        this.theProfiler.endSection();
    }

    /**
     * Invalidates an AABB region of blocks from the receive queue, in the event that the block has been modified
     * client-side in the intervening 80 receive ticks.
     */
    public void invalidateBlockReceiveRegion(int p_73031_1_, int p_73031_2_, int p_73031_3_, int p_73031_4_, int p_73031_5_, int p_73031_6_)
    {
    }

    /**
     * Creates the chunk provider for this world. Called in the constructor. Retrieves provider from worldProvider?
     */
    protected IChunkProvider createChunkProvider()
    {
        this.clientChunkProvider = new ChunkProviderClient(this);
        return this.clientChunkProvider;
    }

    protected void updateBlocks()
    {
        super.updateBlocks();
        this.previousActiveChunkSet.retainAll(this.activeChunkSet);

        if (this.previousActiveChunkSet.size() == this.activeChunkSet.size())
        {
            this.previousActiveChunkSet.clear();
        }

        int i = 0;

        for (ChunkCoordIntPair chunkcoordintpair : this.activeChunkSet)
        {
            if (!this.previousActiveChunkSet.contains(chunkcoordintpair))
            {
                int j = chunkcoordintpair.chunkXPos * 16;
                int k = chunkcoordintpair.chunkZPos * 16;
                this.theProfiler.startSection("getChunk");
                Chunk chunk = this.getChunkFromChunkCoords(chunkcoordintpair.chunkXPos, chunkcoordintpair.chunkZPos);
                this.playMoodSoundAndCheckLight(j, k, chunk);
                this.theProfiler.endSection();
                this.previousActiveChunkSet.add(chunkcoordintpair);
                ++i;

                if (i >= 10)
                {
                    return;
                }
            }
        }
    }

    public void doPreChunk(int p_73025_1_, int p_73025_2_, boolean p_73025_3_)
    {
        if (p_73025_3_)
        {
            this.clientChunkProvider.loadChunk(p_73025_1_, p_73025_2_);
        }
        else
        {
            this.clientChunkProvider.unloadChunk(p_73025_1_, p_73025_2_);
        }

        if (!p_73025_3_)
        {
            this.markBlockRangeForRenderUpdate(p_73025_1_ * 16, 0, p_73025_2_ * 16, p_73025_1_ * 16 + 15, 256, p_73025_2_ * 16 + 15);
        }
    }

    /**
     * Called when an entity is spawned in the world. This includes players.
     */
    public boolean func_72838_d(Entity entityIn)
    {
        boolean flag = super.func_72838_d(entityIn);
        this.entityList.add(entityIn);

        if (!flag)
        {
            this.entitySpawnQueue.add(entityIn);
        }
        else if (entityIn instanceof EntityMinecart)
        {
        }

        return flag;
    }

    /**
     * Schedule the entity for removal during the next tick. Marks the entity dead in anticipation.
     */
    public void removeEntity(Entity entityIn)
    {
        super.removeEntity(entityIn);
        this.entityList.remove(entityIn);
    }

    protected void onEntityAdded(Entity entityIn)
    {
        super.onEntityAdded(entityIn);

        if (this.entitySpawnQueue.contains(entityIn))
        {
            this.entitySpawnQueue.remove(entityIn);
        }
    }

    protected void onEntityRemoved(Entity entityIn)
    {
        super.onEntityRemoved(entityIn);
        boolean flag = false;

        if (this.entityList.contains(entityIn))
        {
            if (entityIn.isEntityAlive())
            {
                this.entitySpawnQueue.add(entityIn);
                flag = true;
            }
            else
            {
                this.entityList.remove(entityIn);
            }
        }
    }

    /**
     * Add an ID to Entity mapping to entityHashSet
     */
    public void addEntityToWorld(int p_73027_1_, Entity p_73027_2_)
    {
        Entity entity = this.getEntityByID(p_73027_1_);

        if (entity != null)
        {
            this.removeEntity(entity);
        }

        this.entityList.add(p_73027_2_);
        p_73027_2_.setEntityId(p_73027_1_);

        if (!this.func_72838_d(p_73027_2_))
        {
            this.entitySpawnQueue.add(p_73027_2_);
        }

        this.entitiesById.addKey(p_73027_1_, p_73027_2_);
    }

    /**
     * Returns the Entity with the given ID, or null if it doesn't exist in this World.
     */
    public Entity getEntityByID(int id)
    {
        return super.getEntityByID(id);
    }

    public Entity removeEntityFromWorld(int p_73028_1_)
    {
        Entity entity = (Entity)this.entitiesById.removeObject(p_73028_1_);

        if (entity != null)
        {
            this.entityList.remove(entity);
            this.removeEntity(entity);
        }

        return entity;
    }

    public boolean invalidateRegionAndSetBlock(BlockPos p_180503_1_, IBlockState p_180503_2_)
    {
        int i = p_180503_1_.func_177958_n();
        int j = p_180503_1_.func_177956_o();
        int k = p_180503_1_.func_177952_p();
        this.invalidateBlockReceiveRegion(i, j, k, i, j, k);
        return super.func_180501_a(p_180503_1_, p_180503_2_, 3);
    }

    /**
     * If on MP, sends a quitting packet.
     */
    public void sendQuittingDisconnectingPacket()
    {
        this.sendQueue.getNetworkManager().closeChannel(new ChatComponentText("Quitting"));
    }

    /**
     * Updates all weather states.
     */
    protected void updateWeather()
    {
    }

    protected int getRenderDistanceChunks()
    {
        return 16;
    }

    public void doVoidFogParticles(int p_73029_1_, int p_73029_2_, int p_73029_3_)
    {

    }

    /**
     * also releases skins.
     */
    public void removeAllEntities()
    {
        this.loadedEntityList.removeAll(this.unloadedEntityList);

        for (int i = 0; i < this.unloadedEntityList.size(); ++i)
        {
            Entity entity = (Entity)this.unloadedEntityList.get(i);
            int j = entity.chunkCoordX;
            int k = entity.chunkCoordZ;

            if (entity.addedToChunk && this.isChunkLoaded(j, k, true))
            {
                this.getChunkFromChunkCoords(j, k).removeEntity(entity);
            }
        }

        for (int l = 0; l < this.unloadedEntityList.size(); ++l)
        {
            this.onEntityRemoved((Entity)this.unloadedEntityList.get(l));
        }

        this.unloadedEntityList.clear();

        for (int i1 = 0; i1 < this.loadedEntityList.size(); ++i1)
        {
            Entity entity1 = (Entity)this.loadedEntityList.get(i1);

            if (entity1.ridingEntity != null)
            {
                if (!entity1.ridingEntity.isDead && entity1.ridingEntity.riddenByEntity == entity1)
                {
                    continue;
                }

                entity1.ridingEntity.riddenByEntity = null;
                entity1.ridingEntity = null;
            }

            if (entity1.isDead)
            {
                int j1 = entity1.chunkCoordX;
                int k1 = entity1.chunkCoordZ;

                if (entity1.addedToChunk && this.isChunkLoaded(j1, k1, true))
                {
                    this.getChunkFromChunkCoords(j1, k1).removeEntity(entity1);
                }

                this.loadedEntityList.remove(i1--);
                this.onEntityRemoved(entity1);
            }
        }
    }

    /**
     * Adds some basic stats of the world to the given crash report.
     */
    public CrashReportCategory addWorldInfoToCrashReport(CrashReport report)
    {
        CrashReportCategory crashreportcategory = super.addWorldInfoToCrashReport(report);
        crashreportcategory.addCrashSectionCallable("Forced entities", new Callable()
        {
            private static final String __OBFID = "CL_00000883";
            public String call()
            {
                return WorldClient.this.entityList.size() + " total; " + WorldClient.this.entityList.toString();
            }
        });
        crashreportcategory.addCrashSectionCallable("Retry entities", new Callable()
        {
            private static final String __OBFID = "CL_00000884";
            public String call()
            {
                return WorldClient.this.entitySpawnQueue.size() + " total; " + WorldClient.this.entitySpawnQueue.toString();
            }
        });
        return crashreportcategory;
    }

    /**
     * Plays a sound at the specified position.
     */
    public void playSoundAtPos(BlockPos p_175731_1_, String p_175731_2_, float p_175731_3_, float p_175731_4_, boolean p_175731_5_)
    {
        this.playSound((double)p_175731_1_.func_177958_n() + 0.5D, (double)p_175731_1_.func_177956_o() + 0.5D, (double)p_175731_1_.func_177952_p() + 0.5D, p_175731_2_, p_175731_3_, p_175731_4_, p_175731_5_);
    }

    /**
     * par8 is loudness, all pars passed to minecraftInstance.sndManager.playSound
     */
    public void playSound(double x, double y, double z, String soundName, float volume, float pitch, boolean distanceDelay)
    {
    }

    public void makeFireworks(double x, double y, double z, double motionX, double motionY, double motionZ, NBTTagCompound compund)
    {
    }

    public void setWorldScoreboard(Scoreboard p_96443_1_)
    {
        this.worldScoreboard = p_96443_1_;
    }

    /**
     * Sets the world time.
     */
    public void func_72877_b(long time)
    {
        if (time < 0L)
        {
            time = -time;
            this.func_82736_K().func_82764_b("doDaylightCycle", "false");
        }
        else
        {
            this.func_82736_K().func_82764_b("doDaylightCycle", "true");
        }

        super.func_72877_b(time);
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
}
