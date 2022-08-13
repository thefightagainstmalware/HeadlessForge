package net.minecraft.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.EnumPlantType;

/**
 *
 */
public class ItemSeeds extends Item  {

    /**
     *
     */
    private Block crops;

    /**
     * BlockID of the block the seeds can be planted on.
     */
    private Block soilBlockID;

    /**
     *
     */
    public ItemSeeds(Block crops,
                     Block soil) {
        
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
    public EnumPlantType getPlantType(IBlockAccess world,
                                      BlockPos pos) {
        return null;
    }

    /**
     *
     */
    public IBlockState getPlant(IBlockAccess world,
                                BlockPos pos) {
        return null;
    }

}