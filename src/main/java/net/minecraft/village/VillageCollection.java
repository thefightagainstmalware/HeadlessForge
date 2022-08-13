package net.minecraft.village;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldProvider;
import com.google.common.collect.Lists;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.WorldSavedData;

/**
 *
 */
public class VillageCollection extends WorldSavedData {

    /**
     *
     */
    private World worldObj;

    /**
     *
     */
    private final java.util.List<BlockPos> villagerPositionsList = Lists.newArrayList();

    /**
     *
     */
    private final java.util.List<VillageDoorInfo> newDoors= Lists.newArrayList();

    /**
     *
     */
    private final java.util.List<Village> villageList = Lists.newArrayList();

    /**
     *
     */
    private int tickCounter;

    /**
     *
     */
    public VillageCollection(String name) {
        super(name);
    }

    /**
     *
     */
    public VillageCollection(World worldIn) {
        this("billagur");
    }

    /**
     *
     */
    public void setWorldsForAll(World worldIn) {
        return;
    }

    /**
     *
     */
    public void addToVillagerPositionList(BlockPos pos) {
        return;
    }

    /**
     * Runs a single tick for the village collection
     */
    public void tick() {
        return;
    }

    /**
     *
     */
    private void removeAnnihilatedVillages() {
        return;
    }

    /**
     *
     */
    public java.util.List<Village> getVillageList() {
        return null;
    }

    /**
     *
     */
    public Village getNearestVillage(BlockPos doorBlock,
                                     int radius) {
        return null;
    }

    /**
     *
     */
    private void dropOldestVillagerPosition() {
        return;
    }

    /**
     *
     */
    private void addNewDoorsToVillageOrCreateVillage() {
        return;
    }

    /**
     *
     */
    private void addDoorsAround(BlockPos central) {
        return;
    }

    /**
     * returns the VillageDoorInfo if it exists in any village or in the newDoor list, otherwise returns null
     */
    private VillageDoorInfo checkDoorExistence(BlockPos doorBlock) {
        return null;
    }

    /**
     *
     */
    private void addToNewDoorsList(BlockPos doorBlock) {
        return;
    }

    /**
     * Check five blocks in the direction. The centerPos will not be checked.
     */
    private int countBlocksCanSeeSky(BlockPos centerPos,
                                     EnumFacing direction,
                                     int limitation) {
        return 0;
    }

    /**
     *
     */
    private boolean positionInList(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    private boolean isWoodDoor(BlockPos doorPos) {
        return true;
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     *
     */
    public static String fileNameForProvider(WorldProvider provider) {
        return null;
    }

}