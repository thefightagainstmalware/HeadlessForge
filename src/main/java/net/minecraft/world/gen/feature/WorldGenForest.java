package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenForest extends WorldGenAbstractTree
{
    private static final IBlockState field_181629_a = Blocks.log.func_176223_P().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
    private static final IBlockState field_181630_b = Blocks.leaves.func_176223_P().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty(BlockOldLeaf.CHECK_DECAY, Boolean.valueOf(false));
    private boolean useExtraRandomHeight;

    public WorldGenForest(boolean p_i45449_1_, boolean p_i45449_2_)
    {
        super(p_i45449_1_);
        this.useExtraRandomHeight = p_i45449_2_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(3) + 5;

        if (this.useExtraRandomHeight)
        {
            i += rand.nextInt(7);
        }

        boolean flag = true;

        if (position.func_177956_o() >= 1 && position.func_177956_o() + i + 1 <= 256)
        {
            for (int j = position.func_177956_o(); j <= position.func_177956_o() + 1 + i; ++j)
            {
                int k = 1;

                if (j == position.func_177956_o())
                {
                    k = 0;
                }

                if (j >= position.func_177956_o() + 1 + i - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.func_177958_n() - k; l <= position.func_177958_n() + k && flag; ++l)
                {
                    for (int i1 = position.func_177952_p() - k; i1 <= position.func_177952_p() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.func_150523_a(worldIn.func_180495_p(blockpos$mutableblockpos.func_181079_c(l, j, i1)).func_177230_c()))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block1 = worldIn.func_180495_p(position.func_177977_b()).func_177230_c();

                if ((block1 == Blocks.field_150349_c || block1 == Blocks.field_150346_d || block1 == Blocks.farmland) && position.func_177956_o() < 256 - i - 1)
                {
                    this.func_175921_a(worldIn, position.func_177977_b());

                    for (int i2 = position.func_177956_o() - 3 + i; i2 <= position.func_177956_o() + i; ++i2)
                    {
                        int k2 = i2 - (position.func_177956_o() + i);
                        int l2 = 1 - k2 / 2;

                        for (int i3 = position.func_177958_n() - l2; i3 <= position.func_177958_n() + l2; ++i3)
                        {
                            int j1 = i3 - position.func_177958_n();

                            for (int k1 = position.func_177952_p() - l2; k1 <= position.func_177952_p() + l2; ++k1)
                            {
                                int l1 = k1 - position.func_177952_p();

                                if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(i3, i2, k1);
                                    Block block = worldIn.func_180495_p(blockpos).func_177230_c();

                                    if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.leaves)
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, field_181630_b);
                                    }
                                }
                            }
                        }
                    }

                    for (int j2 = 0; j2 < i; ++j2)
                    {
                        Block block2 = worldIn.func_180495_p(position.up(j2)).func_177230_c();

                        if (block2.func_149688_o() == Material.field_151579_a || block2.func_149688_o() == Material.leaves)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j2), field_181629_a);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}
