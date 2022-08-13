package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class ItemSaddle extends Item {

    /**
     *
     */
    public ItemSaddle() {
        
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

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    @Override
    public boolean hitEntity(ItemStack stack,
                             EntityLivingBase target,
                             EntityLivingBase attacker) {
        return true;
    }

}