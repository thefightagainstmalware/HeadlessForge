package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BlockRedstoneOre extends Block
{
    private final boolean isOn;

    public BlockRedstoneOre(boolean isOn)
    {
        super(Material.rock);

        if (isOn)
        {
            this.setTickRandomly(true);
        }

        this.isOn = isOn;
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World worldIn)
    {
        return 30;
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        this.activate(worldIn, pos);
        super.onBlockClicked(worldIn, pos, playerIn);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block)
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
    {
        this.activate(worldIn, pos);
        super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        this.activate(worldIn, pos);
        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

    private void activate(World worldIn, BlockPos pos)
    {
        this.spawnParticles(worldIn, pos);

        if (this == Blocks.field_150450_ax)
        {
            worldIn.setBlockState(pos, Blocks.field_150439_ay.func_176223_P());
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this == Blocks.field_150439_ay)
        {
            worldIn.setBlockState(pos, Blocks.field_150450_ax.func_176223_P());
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.redstone;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(2);
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);

        if (this.getItemDropped(state, worldIn.rand, fortune) != Item.func_150898_a(this))
        {
            int i = 1 + worldIn.rand.nextInt(5);
            this.dropXpOnBlockBreak(worldIn, pos, i);
        }
    }

    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isOn)
        {
            this.spawnParticles(worldIn, pos);
        }
    }

    private void spawnParticles(World worldIn, BlockPos pos)
    {
        Random random = worldIn.rand;
        double d0 = 0.0625D;

        for (int i = 0; i < 6; ++i)
        {
            double d1 = (double)((float)pos.func_177958_n() + random.nextFloat());
            double d2 = (double)((float)pos.func_177956_o() + random.nextFloat());
            double d3 = (double)((float)pos.func_177952_p() + random.nextFloat());

            if (i == 0 && !worldIn.func_180495_p(pos.up()).func_177230_c().isOpaqueCube())
            {
                d2 = (double)pos.func_177956_o() + d0 + 1.0D;
            }

            if (i == 1 && !worldIn.func_180495_p(pos.func_177977_b()).func_177230_c().isOpaqueCube())
            {
                d2 = (double)pos.func_177956_o() - d0;
            }

            if (i == 2 && !worldIn.func_180495_p(pos.south()).func_177230_c().isOpaqueCube())
            {
                d3 = (double)pos.func_177952_p() + d0 + 1.0D;
            }

            if (i == 3 && !worldIn.func_180495_p(pos.north()).func_177230_c().isOpaqueCube())
            {
                d3 = (double)pos.func_177952_p() - d0;
            }

            if (i == 4 && !worldIn.func_180495_p(pos.east()).func_177230_c().isOpaqueCube())
            {
                d1 = (double)pos.func_177958_n() + d0 + 1.0D;
            }

            if (i == 5 && !worldIn.func_180495_p(pos.west()).func_177230_c().isOpaqueCube())
            {
                d1 = (double)pos.func_177958_n() - d0;
            }

            if (d1 < (double)pos.func_177958_n() || d1 > (double)(pos.func_177958_n() + 1) || d2 < 0.0D || d2 > (double)(pos.func_177956_o() + 1) || d3 < (double)pos.func_177952_p() || d3 > (double)(pos.func_177952_p() + 1))
            {
                worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d1, d2, d3, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Blocks.field_150450_ax);
    }
}
