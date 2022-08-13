package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class ItemFlintAndSteel extends Item {

    /**
     *
     */
    public ItemFlintAndSteel() {
        
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

}