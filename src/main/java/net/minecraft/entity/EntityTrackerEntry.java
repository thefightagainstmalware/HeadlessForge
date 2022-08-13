package net.minecraft.entity;

import net.minecraft.network.Packet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class EntityTrackerEntry extends Object {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     * The entity that this EntityTrackerEntry tracks.
     */
    public Entity trackedEntity;

    /**
     *
     */
    public int trackingDistanceThreshold;

    /**
     * check for sync when ticks % updateFrequency==0
     */
    public int updateFrequency;

    /**
     * The encoded entity X position.
     */
    public int encodedPosX;

    /**
     * The encoded entity Y position.
     */
    public int encodedPosY;

    /**
     * The encoded entity Z position.
     */
    public int encodedPosZ;

    /**
     * The encoded entity yaw rotation.
     */
    public int encodedRotationYaw;

    /**
     * The encoded entity pitch rotation.
     */
    public int encodedRotationPitch;

    /**
     *
     */
    public int lastHeadMotion;

    /**
     *
     */
    public double lastTrackedEntityMotionX;

    /**
     *
     */
    public double lastTrackedEntityMotionY;

    /**
     *
     */
    public double motionZ;

    /**
     *
     */
    public int updateCounter;

    /**
     *
     */
    private double lastTrackedEntityPosX;

    /**
     *
     */
    private double lastTrackedEntityPosY;

    /**
     *
     */
    private double lastTrackedEntityPosZ;

    /**
     *
     */
    private boolean firstUpdateDone;

    /**
     *
     */
    private boolean sendVelocityUpdates;

    /**
     * every 400 ticks a  full teleport packet is sent, rather than just a "move me +x" command, so that position
     * remains fully synced.
     */
    private int ticksSinceLastForcedTeleport;

    /**
     *
     */
    private Entity field_85178_v;

    /**
     *
     */
    private boolean ridingEntity;

    /**
     *
     */
    private boolean onGround;

    /**
     *
     */
    public boolean playerEntitiesUpdated;

    /**
     *
     */
    public java.util.Set<EntityPlayerMP> trackingPlayers;

    /**
     *
     */
    public EntityTrackerEntry(Entity trackedEntityIn,
                              int trackingDistanceThresholdIn,
                              int updateFrequencyIn,
                              boolean sendVelocityUpdatesIn) {
        
    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    public void updatePlayerList(java.util.List<EntityPlayer> p_73122_1_) {
        return;
    }

    /**
     * Sends the entity metadata (DataWatcher) and attributes to all players tracking this entity, including the entity
     * itself if a player.
     */
    private void sendMetadataToAllAssociatedPlayers() {
        return;
    }

    /**
     * Send the given packet to all players tracking this entity.
     */
    public void sendPacketToTrackedPlayers(Packet packetIn) {
        return;
    }

    /**
     *
     */
    public void func_151261_b(Packet packetIn) {
        return;
    }

    /**
     *
     */
    public void sendDestroyEntityPacketToTrackedPlayers() {
        return;
    }

    /**
     *
     */
    public void removeFromTrackedPlayers(EntityPlayerMP playerMP) {
        return;
    }

    /**
     *
     */
    public void updatePlayerEntity(EntityPlayerMP playerMP) {
        return;
    }

    /**
     *
     */
    public boolean func_180233_c(EntityPlayerMP playerMP) {
        return true;
    }

    /**
     *
     */
    private boolean isPlayerWatchingThisChunk(EntityPlayerMP playerMP) {
        return true;
    }

    /**
     *
     */
    public void updatePlayerEntities(java.util.List<EntityPlayer> p_73125_1_) {
        return;
    }

    /**
     *
     */
    private Packet func_151260_c() {
        return null;
    }

    /**
     * Remove a tracked player from our list and tell the tracked player to destroy us from their world.
     */
    public void removeTrackedPlayerSymmetric(EntityPlayerMP playerMP) {
        return;
    }

}