package net.minecraft.item;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;

/**
 *
 */
public class ItemBucket extends Item {

    /**
     * field for checking if the bucket has been filled.
     */
    private Block isFull;

    /**
     *
     */
    public ItemBucket(Block containedBlock) {
        
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
     *
     */
    private ItemStack fillBucket(ItemStack emptyBuckets,
                                 EntityPlayer player,
                                 Item fullBucket) {
        return null;
    }

    /**
     *
     */
    public boolean tryPlaceContainedLiquid(World worldIn,
                                           BlockPos pos) {
        return true;
    }

}