package net.minecraft.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ItemSimpleFoiled extends Item {

    /**
     *
     */
    public ItemSimpleFoiled() {
        
    }

    /**
     *
     */
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

}