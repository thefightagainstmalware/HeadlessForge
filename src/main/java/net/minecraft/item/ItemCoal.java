package net.minecraft.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import java.util.List;

/**
 *
 */
public class ItemCoal extends Item {

    /**
     *
     */
    public ItemCoal() {
        
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return null;
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(Item itemIn,
                            CreativeTabs tab,
                            java.util.List<ItemStack> subItems) {
        return;
    }

}