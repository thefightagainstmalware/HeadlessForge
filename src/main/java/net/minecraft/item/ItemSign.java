package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class ItemSign extends Item {

    /**
     *
     */
    public ItemSign() {
        
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