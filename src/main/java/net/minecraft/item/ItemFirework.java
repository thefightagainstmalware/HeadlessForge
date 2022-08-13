package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;

/**
 *
 */
public class ItemFirework extends Item {

    /**
     *
     */
    public ItemFirework() {
        
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
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    public void addInformation(ItemStack stack,
                               EntityPlayer playerIn,
                               java.util.List<String> tooltip,
                               boolean advanced) {
        return;
    }

}