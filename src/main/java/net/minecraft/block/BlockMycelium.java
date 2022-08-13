package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMycelium extends Block
{
    public static final PropertyBool SNOWY = PropertyBool.create("snowy");

    protected BlockMycelium()
    {
        super(Material.grass, MapColor.purpleColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.func_180495_p(pos.up()).func_177230_c();
        return state.withProperty(SNOWY, Boolean.valueOf(block == Blocks.snow || block == Blocks.snow_layer));
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.func_180495_p(pos.up()).func_177230_c().getLightOpacity() > 2)
            {
                worldIn.setBlockState(pos, Blocks.field_150346_d.func_176223_P().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
            }
            else
            {
                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                        IBlockState iblockstate = worldIn.func_180495_p(blockpos);
                        Block block = worldIn.func_180495_p(blockpos.up()).func_177230_c();

                        if (iblockstate.func_177230_c() == Blocks.field_150346_d && iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && block.getLightOpacity() <= 2)
                        {
                            worldIn.setBlockState(blockpos, this.func_176223_P());
                        }
                    }
                }
            }
        }
    }

    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        super.randomDisplayTick(worldIn, pos, state, rand);

        if (rand.nextInt(10) == 0)
        {
            worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, (double)((float)pos.func_177958_n() + rand.nextFloat()), (double)((float)pos.func_177956_o() + 1.1F), (double)((float)pos.func_177952_p() + rand.nextFloat()), 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Blocks.field_150346_d.getItemDropped(Blocks.field_150346_d.func_176223_P().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), rand, fortune);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return 0;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {SNOWY});
    }
}
