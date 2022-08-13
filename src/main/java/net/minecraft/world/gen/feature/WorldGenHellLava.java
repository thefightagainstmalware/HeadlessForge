package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenHellLava extends WorldGenerator
{
    private final Block field_150553_a;
    private final boolean field_94524_b;

    public WorldGenHellLava(Block p_i45453_1_, boolean p_i45453_2_)
    {
        this.field_150553_a = p_i45453_1_;
        this.field_94524_b = p_i45453_2_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        if (worldIn.func_180495_p(position.up()).func_177230_c() != Blocks.netherrack)
        {
            return false;
        }
        else if (worldIn.func_180495_p(position).func_177230_c().func_149688_o() != Material.field_151579_a && worldIn.func_180495_p(position).func_177230_c() != Blocks.netherrack)
        {
            return false;
        }
        else
        {
            int i = 0;

            if (worldIn.func_180495_p(position.west()).func_177230_c() == Blocks.netherrack)
            {
                ++i;
            }

            if (worldIn.func_180495_p(position.east()).func_177230_c() == Blocks.netherrack)
            {
                ++i;
            }

            if (worldIn.func_180495_p(position.north()).func_177230_c() == Blocks.netherrack)
            {
                ++i;
            }

            if (worldIn.func_180495_p(position.south()).func_177230_c() == Blocks.netherrack)
            {
                ++i;
            }

            if (worldIn.func_180495_p(position.func_177977_b()).func_177230_c() == Blocks.netherrack)
            {
                ++i;
            }

            int j = 0;

            if (worldIn.func_175623_d(position.west()))
            {
                ++j;
            }

            if (worldIn.func_175623_d(position.east()))
            {
                ++j;
            }

            if (worldIn.func_175623_d(position.north()))
            {
                ++j;
            }

            if (worldIn.func_175623_d(position.south()))
            {
                ++j;
            }

            if (worldIn.func_175623_d(position.func_177977_b()))
            {
                ++j;
            }

            if (!this.field_94524_b && i == 4 && j == 1 || i == 5)
            {
                worldIn.func_180501_a(position, this.field_150553_a.func_176223_P(), 2);
                worldIn.forceBlockUpdateTick(this.field_150553_a, position, rand);
            }

            return true;
        }
    }
}
