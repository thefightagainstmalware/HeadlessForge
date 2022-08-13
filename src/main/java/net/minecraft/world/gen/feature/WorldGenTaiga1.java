package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenTaiga1 extends WorldGenAbstractTree
{
    private static final IBlockState field_181636_a = Blocks.log.func_176223_P().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
    private static final IBlockState field_181637_b = Blocks.leaves.func_176223_P().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    public WorldGenTaiga1()
    {
        super(false);
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(5) + 7;
        int j = i - rand.nextInt(2) - 3;
        int k = i - j;
        int l = 1 + rand.nextInt(k + 1);
        boolean flag = true;

        if (position.func_177956_o() >= 1 && position.func_177956_o() + i + 1 <= 256)
        {
            for (int i1 = position.func_177956_o(); i1 <= position.func_177956_o() + 1 + i && flag; ++i1)
            {
                int j1 = 1;

                if (i1 - position.func_177956_o() < j)
                {
                    j1 = 0;
                }
                else
                {
                    j1 = l;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int k1 = position.func_177958_n() - j1; k1 <= position.func_177958_n() + j1 && flag; ++k1)
                {
                    for (int l1 = position.func_177952_p() - j1; l1 <= position.func_177952_p() + j1 && flag; ++l1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            if (!this.func_150523_a(worldIn.func_180495_p(blockpos$mutableblockpos.func_181079_c(k1, i1, l1)).func_177230_c()))
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
                Block block = worldIn.func_180495_p(position.func_177977_b()).func_177230_c();

                if ((block == Blocks.field_150349_c || block == Blocks.field_150346_d) && position.func_177956_o() < 256 - i - 1)
                {
                    this.func_175921_a(worldIn, position.func_177977_b());
                    int k2 = 0;

                    for (int l2 = position.func_177956_o() + i; l2 >= position.func_177956_o() + j; --l2)
                    {
                        for (int j3 = position.func_177958_n() - k2; j3 <= position.func_177958_n() + k2; ++j3)
                        {
                            int k3 = j3 - position.func_177958_n();

                            for (int i2 = position.func_177952_p() - k2; i2 <= position.func_177952_p() + k2; ++i2)
                            {
                                int j2 = i2 - position.func_177952_p();

                                if (Math.abs(k3) != k2 || Math.abs(j2) != k2 || k2 <= 0)
                                {
                                    BlockPos blockpos = new BlockPos(j3, l2, i2);

                                    if (!worldIn.func_180495_p(blockpos).func_177230_c().func_149730_j())
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, field_181637_b);
                                    }
                                }
                            }
                        }

                        if (k2 >= 1 && l2 == position.func_177956_o() + j + 1)
                        {
                            --k2;
                        }
                        else if (k2 < l)
                        {
                            ++k2;
                        }
                    }

                    for (int i3 = 0; i3 < i - 1; ++i3)
                    {
                        Block block1 = worldIn.func_180495_p(position.up(i3)).func_177230_c();

                        if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.leaves)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(i3), field_181636_a);
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
