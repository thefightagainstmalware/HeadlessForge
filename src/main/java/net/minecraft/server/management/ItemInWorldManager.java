package net.minecraft.server.management;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldServer;

/**
 *
 */
public class ItemInWorldManager extends Object {

    /**
     * Forge reach distance
     */
    private double blockReachDistance;

    /**
     * The world object that this object is connected to.
     */
    public World theWorld;

    /**
     * The EntityPlayerMP object that this object is connected to.
     */
    public EntityPlayerMP thisPlayerMP;

    /**
     *
     */
    private WorldSettings.GameType gameType;

    /**
     * True if the player is destroying a block
     */
    private boolean isDestroyingBlock;

    /**
     *
     */
    private int initialDamage;

    /**
     *
     */
    private BlockPos field_180240_f;

    /**
     *
     */
    private int curblockDamage;

    /**
     * Set to true when the "finished destroying block" packet is received but the block wasn't fully damaged yet. The
     * block will not be destroyed while this is false.
     */
    private boolean receivedFinishDiggingPacket;

    /**
     *
     */
    private BlockPos field_180241_i;

    /**
     *
     */
    private int initialBlockDamage;

    /**
     *
     */
    private int durabilityRemainingOnBlock;

    /**
     *
     */
    public ItemInWorldManager(World worldIn) {
        
    }

    /**
     *
     */
    public void setGameType(WorldSettings.GameType type) {
        return;
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
    public boolean survivalOrAdventure() {
        return true;
    }

    /**
     * Get if we are in creative game mode.
     */
    public boolean func_73083_d() {
        return true;
    }

    /**
     * if the gameType is currently NOT_SET then change it to par1
     */
    public void initializeGameType(WorldSettings.GameType type) {
        return;
    }

    /**
     *
     */
    public void updateBlockRemoving() {
        return;
    }

    /**
     * If not creative, it calls sendBlockBreakProgress until the block is broken first. tryHarvestBlock can also be the
     * result of this call.
     */
    public void onBlockClicked(BlockPos pos,
                               EnumFacing side) {
        return;
    }

    /**
     *
     */
    public void blockRemoving(BlockPos pos) {
        return;
    }

    /**
     * Stops the block breaking process
     */
    public void cancelDestroyingBlock() {
        return;
    }

    /**
     * Removes a block and triggers the appropriate events
     */
    private boolean removeBlock(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    private boolean removeBlock(BlockPos pos,
                                boolean canHarvest) {
        return true;
    }

    /**
     * Attempts to harvest a block
     */
    public boolean tryHarvestBlock(BlockPos pos) {
        return true;
    }

    /**
     * Attempts to right-click use an item by the given EntityPlayer in the given World
     */
    public boolean tryUseItem(EntityPlayer player,
                              World worldIn,
                              ItemStack stack) {
        return true;
    }

    /**
     * Activate the clicked on block, otherwise use the held item.
     */
    public boolean activateBlockOrUseItem(EntityPlayer player,
                                          World worldIn,
                                          ItemStack stack,
                                          BlockPos pos,
                                          EnumFacing side,
                                          float offsetX,
                                          float offsetY,
                                          float offsetZ) {
        return true;
    }

    /**
     * Sets the world instance.
     */
    public void setWorld(WorldServer serverWorld) {
        return;
    }

    /**
     *
     */
    public double getBlockReachDistance() {
        return 0;
    }

    /**
     *
     */
    public void setBlockReachDistance(double distance) {
        return;
    }

}