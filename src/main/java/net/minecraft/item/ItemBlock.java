package net.minecraft.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemBlock extends Item
{
    protected final Block block;

    public ItemBlock(Block block)
    {
        this.block = block;
    }

    /**
     * Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
     */
    public ItemBlock setUnlocalizedName(String unlocalizedName)
    {
        super.setUnlocalizedName(unlocalizedName);
        return this;
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.func_180495_p(pos);
        Block block = iblockstate.func_177230_c();

        if (!block.isReplaceable(worldIn, pos))
        {
            pos = pos.offset(side);
        }

        if (stack.field_77994_a == 0)
        {
            return false;
        }
        else if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else if (worldIn.canBlockBePlaced(this.block, pos, false, side, (Entity)null, stack))
        {
            int i = this.getMetadata(stack.getMetadata());
            IBlockState iblockstate1 = this.block.onBlockPlaced(worldIn, pos, side, hitX, hitY, hitZ, i, playerIn);

            if (worldIn.func_180501_a(pos, iblockstate1, 3))
            {
                iblockstate1 = worldIn.func_180495_p(pos);

                if (iblockstate1.func_177230_c() == this.block)
                {
                    setTileEntityNBT(worldIn, playerIn, pos, stack);
                    this.block.onBlockPlacedBy(worldIn, pos, iblockstate1, playerIn, stack);
                }

                worldIn.playSoundEffect((double)((float)pos.func_177958_n() + 0.5F), (double)((float)pos.func_177956_o() + 0.5F), (double)((float)pos.func_177952_p() + 0.5F), this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getFrequency() * 0.8F);
                --stack.field_77994_a;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean setTileEntityNBT(World worldIn, EntityPlayer pos, BlockPos stack, ItemStack p_179224_3_)
    {
        MinecraftServer minecraftserver = MinecraftServer.func_71276_C();

        if (minecraftserver == null)
        {
            return false;
        }
        else
        {
            if (p_179224_3_.func_77942_o() && p_179224_3_.func_77978_p().func_150297_b("BlockEntityTag", 10))
            {
                TileEntity tileentity = worldIn.func_175625_s(stack);

                if (tileentity != null)
                {
                    if (!worldIn.isRemote && tileentity.func_183000_F() && !minecraftserver.func_71203_ab().func_152596_g(pos.getGameProfile()))
                    {
                        return false;
                    }

                    NBTTagCompound nbttagcompound = new NBTTagCompound();
                    NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttagcompound.func_74737_b();
                    tileentity.func_145841_b(nbttagcompound);
                    NBTTagCompound nbttagcompound2 = (NBTTagCompound)p_179224_3_.func_77978_p().getTag("BlockEntityTag");
                    nbttagcompound.func_179237_a(nbttagcompound2);
                    nbttagcompound.func_74768_a("x", stack.func_177958_n());
                    nbttagcompound.func_74768_a("y", stack.func_177956_o());
                    nbttagcompound.func_74768_a("z", stack.func_177952_p());

                    if (!nbttagcompound.equals(nbttagcompound1))
                    {
                        tileentity.func_145839_a(nbttagcompound);
                        tileentity.func_70296_d();
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
    {
        Block block = worldIn.func_180495_p(pos).func_177230_c();

        if (block == Blocks.snow_layer)
        {
            side = EnumFacing.UP;
        }
        else if (!block.isReplaceable(worldIn, pos))
        {
            pos = pos.offset(side);
        }

        return worldIn.canBlockBePlaced(this.block, pos, false, side, (Entity)null, stack);
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.block.getUnlocalizedName();
    }

    /**
     * Returns the unlocalized name of this item.
     */
    public String getUnlocalizedName()
    {
        return this.block.getUnlocalizedName();
    }

    /**
     * gets the CreativeTab this item is displayed on
     */
    public CreativeTabs getCreativeTab()
    {
        return this.block.getCreativeTabToDisplayOn();
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        this.block.getSubBlocks(itemIn, tab, subItems);
    }

    public Block getBlock()
    {
        return this.block;
    }
}
