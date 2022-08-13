package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class ItemMonsterPlacer extends Item {

    /**
     *
     */
    public ItemMonsterPlacer() {
        
    }

    /**
     *
     */
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return null;
    }

    /**
     *
     */
    @Override
    public int getColorFromItemStack(ItemStack stack,
                                     int renderPass) {
        return 0;
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
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn,
                                      World worldIn,
                                      EntityPlayer playerIn) {
        return null;
    }

    /**
     * Spawns the creature specified by the egg's type in the location specified by the last three parameters.
     * Parameters: world, entityID, x, y, z.
     */
    @Deprecated
    public static Entity spawnCreature(World worldIn,
                                                    int entityID,
                                                    double x,
                                                    double y,
                                                    double z) {
        return null;
    }

    /**
     *
     */
    public static Entity spawnCreature(World worldIn,
                                       String name,
                                       double x,
                                       double y,
                                       double z) {
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

    /**
     *
     */
    public static String getEntityName(ItemStack stack) {
        return null;
    }

    /**
     *
     */
    private static EntityList.EntityEggInfo getEggInfo(ItemStack stack) {
        return null;
    }

}