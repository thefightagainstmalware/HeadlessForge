package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.Rotations;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class ItemArmorStand extends Item {

    /**
     *
     */
    public ItemArmorStand() {
        
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
    private void applyRandomRotations(EntityArmorStand armorStand,
                                      java.util.Random rand) {
        return;
    }

}