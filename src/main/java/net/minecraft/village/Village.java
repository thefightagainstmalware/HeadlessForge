package net.minecraft.village;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.util.Vec3;

/**
 *
 */
public class Village extends Object {

    /**
     *
     */
    private World worldObj;

    /**
     *
     */
    private final java.util.List<VillageDoorInfo> villageDoorInfoList = Lists.newArrayList();

    /**
     * This is the sum of all door coordinates and used to calculate the actual village center by dividing by the number
     * of doors.
     */
    private BlockPos centerHelper;

    /**
     * This is the actual village center.
     */
    private BlockPos center;

    /**
     *
     */
    private int villageRadius;

    /**
     *
     */
    private int lastAddDoorTimestamp;

    /**
     *
     */
    private int tickCounter;

    /**
     *
     */
    private int numVillagers;

    /**
     * Timestamp of tick count when villager last bred
     */
    private int noBreedTicks;

    /**
     *
     */
    private java.util.TreeMap<java.lang.String,java.lang.Integer> playerReputation;

    /**
     *
     */
    private java.util.List<Village.VillageAggressor> villageAgressors;

    /**
     *
     */
    private int numIronGolems;

    /**
     *
     */
    public Village() {
        
    }

    /**
     *
     */
    public Village(World worldIn) {
    }

    /**
     *
     */
    public void setWorld(World worldIn) {
        return;
    }

    /**
     * Called periodically by VillageCollection
     */
    public void tick(int p_75560_1_) {
        return;
    }

    /**
     *
     */
    private Vec3 func_179862_a(BlockPos p_179862_1_,
                               int p_179862_2_,
                               int p_179862_3_,
                               int p_179862_4_) {
        return null;
    }

    /**
     *
     */
    private boolean func_179861_a(BlockPos p_179861_1_,
                                  BlockPos p_179861_2_) {
        return true;
    }

    /**
     *
     */
    private void updateNumIronGolems() {
        return;
    }

    /**
     *
     */
    private void updateNumVillagers() {
        return;
    }

    /**
     *
     */
    public BlockPos getCenter() {
        return null;
    }

    /**
     *
     */
    public int getVillageRadius() {
        return 0;
    }

    /**
     * Actually get num village door info entries, but that boils down to number of doors. Called by
     * EntityAIVillagerMate and VillageSiege
     */
    public int getNumVillageDoors() {
        return 0;
    }

    /**
     *
     */
    public int getTicksSinceLastDoorAdding() {
        return 0;
    }

    /**
     *
     */
    public int getNumVillagers() {
        return 0;
    }

    /**
     *
     */
    public boolean func_179866_a(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    public java.util.List<VillageDoorInfo> getVillageDoorInfoList() {
        return null;
    }

    /**
     *
     */
    public VillageDoorInfo getNearestDoor(BlockPos pos) {
        return null;
    }

    /**
     * Returns <a href="../../../net/minecraft/village/VillageDoorInfo.html" title="class in net.minecraft.village"><code>VillageDoorInfo</code></a> from given block position
     */
    public VillageDoorInfo getDoorInfo(BlockPos pos) {
        return null;
    }

    /**
     * if door not existed in this village, null will be returned
     */
    public VillageDoorInfo getExistedDoor(BlockPos doorBlock) {
        return null;
    }

    /**
     *
     */
    public void addVillageDoorInfo(VillageDoorInfo doorInfo) {
        return;
    }

    /**
     * Returns true, if there is not a single village door left. Called by VillageCollection
     */
    public boolean isAnnihilated() {
        return true;
    }

    /**
     *
     */
    public void addOrRenewAgressor(EntityLivingBase entitylivingbaseIn) {
        return;
    }

    /**
     *
     */
    public EntityLivingBase findNearestVillageAggressor(EntityLivingBase entitylivingbaseIn) {
        return null;
    }

    /**
     *
     */
    public EntityPlayer getNearestTargetPlayer(EntityLivingBase villageDefender) {
        return null;
    }

    /**
     *
     */
    private void removeDeadAndOldAgressors() {
        return;
    }

    /**
     *
     */
    private void removeDeadAndOutOfRangeDoors() {
        return;
    }

    /**
     *
     */
    private boolean isWoodDoor(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    private void updateVillageRadiusAndCenter() {
        return;
    }

    /**
     * Return the village reputation for a player
     */
    public int getReputationForPlayer(String p_82684_1_) {
        return 0;
    }

    /**
     * Set the village reputation for a player.
     */
    public int setReputationForPlayer(String p_82688_1_,
                                      int p_82688_2_) {
        return 0;
    }

    /**
     * Return whether this player has a too low reputation with this village.
     */
    public boolean isPlayerReputationTooLow(String p_82687_1_) {
        return true;
    }

    /**
     * Read this village's data from NBT.
     */
    public void readVillageDataFromNBT(NBTTagCompound p_82690_1_) {
        return;
    }

    /**
     * Write this village's data to NBT.
     */
    public void writeVillageDataToNBT(NBTTagCompound p_82689_1_) {
        return;
    }

    /**
     * Prevent villager breeding for a fixed interval of time
     */
    public void endMatingSeason() {
        return;
    }

    /**
     * Return whether villagers mating refractory period has passed
     */
    public boolean isMatingSeason() {
        return true;
    }

    /**
     *
     */
    public void setDefaultPlayerReputation(int p_82683_1_) {
        return;
    }

    public class VillageAggressor {
    }
}