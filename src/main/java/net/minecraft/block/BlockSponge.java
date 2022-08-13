package net.minecraft.block;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Tuple;
import net.minecraft.world.World;

public class BlockSponge extends Block
{
    public static final PropertyBool WET = PropertyBool.create("wet");

    protected BlockSponge()
    {
        super(Material.sponge);
        this.setDefaultState(this.blockState.getBaseState().withProperty(WET, Boolean.valueOf(false)));
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    public String func_149732_F()
    {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + ".dry.name");
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((Boolean)state.getValue(WET)).booleanValue() ? 1 : 0;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.tryAbsorb(worldIn, pos, state);
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.tryAbsorb(worldIn, pos, state);
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
    }

    protected void tryAbsorb(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!((Boolean)state.getValue(WET)).booleanValue() && this.absorb(worldIn, pos))
        {
            worldIn.func_180501_a(pos, state.withProperty(WET, Boolean.valueOf(true)), 2);
            worldIn.playAuxSFX(2001, pos, Block.func_149682_b(Blocks.field_150355_j));
        }
    }

    private boolean absorb(World worldIn, BlockPos pos)
    {
        Queue<Tuple<BlockPos, Integer>> queue = Lists.<Tuple<BlockPos, Integer>>newLinkedList();
        ArrayList<BlockPos> arraylist = Lists.<BlockPos>newArrayList();
        queue.add(new Tuple(pos, Integer.valueOf(0)));
        int i = 0;

        while (!((Queue)queue).isEmpty())
        {
            Tuple<BlockPos, Integer> tuple = (Tuple)queue.poll();
            BlockPos blockpos = (BlockPos)tuple.getFirst();
            int j = ((Integer)tuple.getSecond()).intValue();

            for (EnumFacing enumfacing : EnumFacing.values())
            {
                BlockPos blockpos1 = blockpos.offset(enumfacing);

                if (worldIn.func_180495_p(blockpos1).func_177230_c().func_149688_o() == Material.water)
                {
                    worldIn.func_180501_a(blockpos1, Blocks.field_150350_a.func_176223_P(), 2);
                    arraylist.add(blockpos1);
                    ++i;

                    if (j < 6)
                    {
                        queue.add(new Tuple(blockpos1, Integer.valueOf(j + 1)));
                    }
                }
            }

            if (i > 64)
            {
                break;
            }
        }

        for (BlockPos blockpos2 : arraylist)
        {
            worldIn.notifyNeighborsOfStateChange(blockpos2, Blocks.field_150350_a);
        }

        return i > 0;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        list.add(new ItemStack(itemIn, 1, 0));
        list.add(new ItemStack(itemIn, 1, 1));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(WET, Boolean.valueOf((meta & 1) == 1));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((Boolean)state.getValue(WET)).booleanValue() ? 1 : 0;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {WET});
    }

    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Boolean)state.getValue(WET)).booleanValue())
        {
            EnumFacing enumfacing = EnumFacing.random(rand);

            if (enumfacing != EnumFacing.UP && !World.doesBlockHaveSolidTopSurface(worldIn, pos.offset(enumfacing)))
            {
                double d0 = (double)pos.func_177958_n();
                double d1 = (double)pos.func_177956_o();
                double d2 = (double)pos.func_177952_p();

                if (enumfacing == EnumFacing.DOWN)
                {
                    d1 = d1 - 0.05D;
                    d0 += rand.nextDouble();
                    d2 += rand.nextDouble();
                }
                else
                {
                    d1 = d1 + rand.nextDouble() * 0.8D;

                    if (enumfacing.getAxis() == EnumFacing.Axis.X)
                    {
                        d2 += rand.nextDouble();

                        if (enumfacing == EnumFacing.EAST)
                        {
                            ++d0;
                        }
                        else
                        {
                            d0 += 0.05D;
                        }
                    }
                    else
                    {
                        d0 += rand.nextDouble();

                        if (enumfacing == EnumFacing.SOUTH)
                        {
                            ++d2;
                        }
                        else
                        {
                            d2 += 0.05D;
                        }
                    }
                }

                worldIn.spawnParticle(EnumParticleTypes.DRIP_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }
}
