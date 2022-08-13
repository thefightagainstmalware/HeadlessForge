package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class ItemHoe extends Item {

    /**
     *
     */
    protected Item.ToolMaterial theToolMaterial;

    /**
     *
     */
    public ItemHoe(Item.ToolMaterial material) {
        
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
    protected boolean useHoe(ItemStack stack,
                             EntityPlayer player,
                             World worldIn,
                             BlockPos target,
                             IBlockState newState) {
        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @Override
    public boolean isFull3D() {
        return true;
    }

    /**
     * Returns the name of the material this tool is made from as it is declared in EnumToolMaterial (meaning diamond
     * would return "EMERALD")
     */
    public String getMaterialName() {
        return null;
    }

}