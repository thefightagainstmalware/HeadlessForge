package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenShrub extends WorldGenTrees
{
    private final IBlockState leavesMetadata;
    private final IBlockState woodMetadata;

    public WorldGenShrub(IBlockState p_i46450_1_, IBlockState p_i46450_2_)
    {
        super(false);
        this.woodMetadata = p_i46450_1_;
        this.leavesMetadata = p_i46450_2_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        Block block;

        while (((block = worldIn.func_180495_p(position).func_177230_c()).func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.leaves) && position.func_177956_o() > 0)
        {
            position = position.func_177977_b();
        }

        Block block1 = worldIn.func_180495_p(position).func_177230_c();

        if (block1 == Blocks.field_150346_d || block1 == Blocks.field_150349_c)
        {
            position = position.up();
            this.setBlockAndNotifyAdequately(worldIn, position, this.woodMetadata);

            for (int i = position.func_177956_o(); i <= position.func_177956_o() + 2; ++i)
            {
                int j = i - position.func_177956_o();
                int k = 2 - j;

                for (int l = position.func_177958_n() - k; l <= position.func_177958_n() + k; ++l)
                {
                    int i1 = l - position.func_177958_n();

                    for (int j1 = position.func_177952_p() - k; j1 <= position.func_177952_p() + k; ++j1)
                    {
                        int k1 = j1 - position.func_177952_p();

                        if (Math.abs(i1) != k || Math.abs(k1) != k || rand.nextInt(2) != 0)
                        {
                            BlockPos blockpos = new BlockPos(l, i, j1);

                            if (!worldIn.func_180495_p(blockpos).func_177230_c().func_149730_j())
                            {
                                this.setBlockAndNotifyAdequately(worldIn, blockpos, this.leavesMetadata);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
