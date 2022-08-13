package net.minecraft.world;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;

/**
 *
 */
public class WorldManager extends Object implements IWorldAccess {

    /**
     * Reference to the MinecraftServer object.
     */
    private MinecraftServer mcServer;

    /**
     * The WorldServer object.
     */
    private WorldServer theWorldServer;

    /**
     *
     */
    public WorldManager(MinecraftServer p_i1517_1_,
                        WorldServer p_i1517_2_) {
        
    }

    /**
     *
     */
    public void spawnParticle(int particleID,
                              boolean ignoreRange,
                              double xCoord,
                              double yCoord,
                              double zCoord,
                              double xOffset,
                              double yOffset,
                              double zOffset,
                              int... p_180442_15_) {
        return;
    }

    /**
     * Called on all IWorldAccesses when an entity is created or loaded. On client worlds, starts downloading any
     * necessary textures. On server worlds, adds the entity to the entity tracker.
     */
    public void onEntityAdded(Entity entityIn) {
        return;
    }

    /**
     * Called on all IWorldAccesses when an entity is unloaded or destroyed. On client worlds, releases any downloaded
     * textures. On server worlds, removes the entity from the entity tracker.
     */
    public void onEntityRemoved(Entity entityIn) {
        return;
    }

    /**
     * Plays the specified sound. Arg: soundName, x, y, z, volume, pitch
     */
    public void playSound(String soundName,
                          double x,
                          double y,
                          double z,
                          float volume,
                          float pitch) {
        return;
    }

    /**
     * Plays sound to all near players except the player reference given
     */
    public void playSoundToNearExcept(EntityPlayer except,
                                      String soundName,
                                      double x,
                                      double y,
                                      double z,
                                      float volume,
                                      float pitch) {
        return;
    }

    /**
     * On the client, re-renders all blocks in this range, inclusive. On the server, does nothing. Args: min x, min y,
     * min z, max x, max y, max z
     */
    public void markBlockRangeForRenderUpdate(int x1,
                                              int y1,
                                              int z1,
                                              int x2,
                                              int y2,
                                              int z2) {
        return;
    }

    /**
     *
     */
    public void markBlockForUpdate(BlockPos pos) {
        return;
    }

    /**
     *
     */
    public void notifyLightSet(BlockPos pos) {
        return;
    }

    /**
     *
     */
    public void playRecord(String recordName,
                           BlockPos blockPosIn) {
        return;
    }

    /**
     *
     */
    public void playAuxSFX(EntityPlayer player,
                           int sfxType,
                           BlockPos blockPosIn,
                           int p_180439_4_) {
        return;
    }

    /**
     *
     */
    public void broadcastSound(int p_180440_1_,
                               BlockPos p_180440_2_,
                               int p_180440_3_) {
        return;
    }

    /**
     *
     */
    public void sendBlockBreakProgress(int breakerId,
                                       BlockPos pos,
                                       int progress) {
        return;
    }

}