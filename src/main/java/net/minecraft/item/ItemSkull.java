package net.minecraft.item;

import com.mojang.authlib.GameProfile;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSkull extends Item
{
    private static final String[] skullTypes = new String[] {"skeleton", "wither", "zombie", "char", "creeper"};

    public ItemSkull()
    {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (side == EnumFacing.DOWN)
        {
            return false;
        }
        else
        {
            IBlockState iblockstate = worldIn.func_180495_p(pos);
            Block block = iblockstate.func_177230_c();
            boolean flag = block.isReplaceable(worldIn, pos);

            if (!flag)
            {
                if (!worldIn.func_180495_p(pos).func_177230_c().func_149688_o().isSolid())
                {
                    return false;
                }

                pos = pos.offset(side);
            }

            if (!playerIn.canPlayerEdit(pos, side, stack))
            {
                return false;
            }
            else if (!Blocks.skull.canPlaceBlockAt(worldIn, pos))
            {
                return false;
            }
            else
            {
                if (!worldIn.isRemote)
                {
                    worldIn.func_180501_a(pos, Blocks.skull.func_176223_P().withProperty(BlockSkull.FACING, side), 3);
                    int i = 0;

                    if (side == EnumFacing.UP)
                    {
                        i = MathHelper.func_76128_c((double)(playerIn.field_70177_z * 16.0F / 360.0F) + 0.5D) & 15;
                    }

                    TileEntity tileentity = worldIn.func_175625_s(pos);

                    if (tileentity instanceof TileEntitySkull)
                    {
                        TileEntitySkull tileentityskull = (TileEntitySkull)tileentity;

                        if (stack.getMetadata() == 3)
                        {
                            GameProfile gameprofile = null;

                            if (stack.func_77942_o())
                            {
                                NBTTagCompound nbttagcompound = stack.func_77978_p();

                                if (nbttagcompound.func_150297_b("SkullOwner", 10))
                                {
                                    gameprofile = NBTUtil.readGameProfileFromNBT(nbttagcompound.func_74775_l("SkullOwner"));
                                }
                                else if (nbttagcompound.func_150297_b("SkullOwner", 8) && nbttagcompound.getString("SkullOwner").length() > 0)
                                {
                                    gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
                                }
                            }

                            tileentityskull.setPlayerProfile(gameprofile);
                        }
                        else
                        {
                            tileentityskull.setType(stack.getMetadata());
                        }

                        tileentityskull.setSkullRotation(i);
                        Blocks.skull.checkWitherSpawn(worldIn, pos, tileentityskull);
                    }

                    --stack.field_77994_a;
                }

                return true;
            }
        }
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (int i = 0; i < skullTypes.length; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

    /**
     * Converts the given ItemStack damage value into a metadata value to be placed in the world when this Item is
     * placed as a Block (mostly used with ItemBlocks).
     */
    public int getMetadata(int damage)
    {
        return damage;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        int i = stack.getMetadata();

        if (i < 0 || i >= skullTypes.length)
        {
            i = 0;
        }

        return super.getUnlocalizedName() + "." + skullTypes[i];
    }

    public String getItemStackDisplayName(ItemStack stack)
    {
        if (stack.getMetadata() == 3 && stack.func_77942_o())
        {
            if (stack.func_77978_p().func_150297_b("SkullOwner", 8))
            {
                return StatCollector.translateToLocalFormatted("item.skull.player.name", new Object[] {stack.func_77978_p().getString("SkullOwner")});
            }

            if (stack.func_77978_p().func_150297_b("SkullOwner", 10))
            {
                NBTTagCompound nbttagcompound = stack.func_77978_p().func_74775_l("SkullOwner");

                if (nbttagcompound.func_150297_b("Name", 8))
                {
                    return StatCollector.translateToLocalFormatted("item.skull.player.name", new Object[] {nbttagcompound.getString("Name")});
                }
            }
        }

        return super.getItemStackDisplayName(stack);
    }

    /**
     * Called when an ItemStack with NBT data is read to potentially that ItemStack's NBT data
     */
    public boolean updateItemStackNBT(NBTTagCompound nbt)
    {
        super.updateItemStackNBT(nbt);

        if (nbt.func_150297_b("SkullOwner", 8) && nbt.getString("SkullOwner").length() > 0)
        {
            GameProfile gameprofile = new GameProfile((UUID)null, nbt.getString("SkullOwner"));
            gameprofile = TileEntitySkull.updateGameprofile(gameprofile);
            nbt.func_74782_a("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), gameprofile));
            return true;
        }
        else
        {
            return false;
        }
    }
}
