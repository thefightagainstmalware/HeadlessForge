package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class ItemDoor extends Item {

    /**
     *
     */
    private Block block;

    /**
     *
     */
    public ItemDoor(Block block) {
        
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    @Override
    public boolean onItemUse(ItemStack stack,
                             EntityPlayer playerIn,
                             World worldIn,
                             BlockPos pos,
                             EnumFacing side,
                             float hitX,
                             float hitY,
                             float hitZ) {
        return true;
    }

    /**
     *
     */
    public static void placeDoor(World worldIn,
                                 BlockPos pos,
                                 EnumFacing facing,
                                 Block door) {
        return;
    }

}