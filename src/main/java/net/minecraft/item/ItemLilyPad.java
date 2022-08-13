package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemLilyPad extends ItemColored
{
    public ItemLilyPad(Block block)
    {
        super(block, false);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

        if (movingobjectposition == null)
        {
            return itemStackIn;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = movingobjectposition.getBlockPos();

                if (!worldIn.isBlockModifiable(playerIn, blockpos))
                {
                    return itemStackIn;
                }

                if (!playerIn.canPlayerEdit(blockpos.offset(movingobjectposition.sideHit), movingobjectposition.sideHit, itemStackIn))
                {
                    return itemStackIn;
                }

                BlockPos blockpos1 = blockpos.up();
                IBlockState iblockstate = worldIn.func_180495_p(blockpos);

                if (iblockstate.func_177230_c().func_149688_o() == Material.water && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0 && worldIn.func_175623_d(blockpos1))
                {
                    worldIn.setBlockState(blockpos1, Blocks.waterlily.func_176223_P());

                    if (!playerIn.field_71075_bZ.field_75098_d)
                    {
                        --itemStackIn.field_77994_a;
                    }

                    playerIn.func_71029_a(StatList.objectUseStats[Item.getIdFromItem(this)]);
                }
            }

            return itemStackIn;
        }
    }

    public int getColorFromItemStack(ItemStack stack, int renderPass)
    {
        return Blocks.waterlily.getRenderColor(Blocks.waterlily.func_176203_a(stack.getMetadata()));
    }
}
