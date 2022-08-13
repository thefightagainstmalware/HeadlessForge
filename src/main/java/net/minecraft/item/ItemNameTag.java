package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ItemNameTag extends Item {

    /**
     *
     */
    public ItemNameTag() {
        
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    @Override
    public boolean itemInteractionForEntity(ItemStack stack,
                                            EntityPlayer playerIn,
                                            EntityLivingBase target) {
        return true;
    }

}