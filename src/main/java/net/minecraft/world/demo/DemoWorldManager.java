package net.minecraft.world.demo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class DemoWorldManager extends ItemInWorldManager {

    /**
     *
     */
    private boolean field_73105_c;

    /**
     *
     */
    private boolean demoTimeExpired;

    /**
     *
     */
    private int field_73104_e;

    /**
     *
     */
    private int field_73102_f;

    /**
     *
     */
    public DemoWorldManager(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    public void updateBlockRemoving() {
        return;
    }

    /**
     * Sends a message to the player reminding them that this is the demo version
     */
    private void sendDemoReminder() {
        return;
    }

    /**
     * If not creative, it calls sendBlockBreakProgress until the block is broken first. tryHarvestBlock can also be the
     * result of this call.
     */
    @Override
    public void onBlockClicked(BlockPos pos,
                               EnumFacing side) {
        return;
    }

    /**
     *
     */
    @Override
    public void blockRemoving(BlockPos pos) {
        return;
    }

    /**
     * Attempts to harvest a block
     */
    @Override
    public boolean tryHarvestBlock(BlockPos pos) {
        return true;
    }

    /**
     * Attempts to right-click use an item by the given EntityPlayer in the given World
     */
    @Override
    public boolean tryUseItem(EntityPlayer player,
                              World worldIn,
                              ItemStack stack) {
        return true;
    }

    /**
     * Activate the clicked on block, otherwise use the held item.
     */
    @Override
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

}