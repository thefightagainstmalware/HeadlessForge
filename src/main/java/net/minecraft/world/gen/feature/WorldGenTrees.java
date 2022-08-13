package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WorldGenTrees extends WorldGenAbstractTree
{
    private static final IBlockState field_181653_a = Blocks.log.func_176223_P().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
    private static final IBlockState field_181654_b = Blocks.leaves.func_176223_P().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

    /** The minimum height of a generated tree. */
    private final int minTreeHeight;

    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;

    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;

    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;

    public WorldGenTrees(boolean p_i2027_1_)
    {
        this(p_i2027_1_, 4, field_181653_a, field_181654_b, false);
    }

    public WorldGenTrees(boolean p_i46446_1_, int p_i46446_2_, IBlockState p_i46446_3_, IBlockState p_i46446_4_, boolean p_i46446_5_)
    {
        super(p_i46446_1_);
        this.minTreeHeight = p_i46446_2_;
        this.metaWood = p_i46446_3_;
        this.metaLeaves = p_i46446_4_;
        this.vinesGrow = p_i46446_5_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(3) + this.minTreeHeight;
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
                    int k2 = 3;
                    int l2 = 0;

                    for (int i3 = position.func_177956_o() - k2 + i; i3 <= position.func_177956_o() + i; ++i3)
                    {
                        int i4 = i3 - (position.func_177956_o() + i);
                        int j1 = l2 + 1 - i4 / 2;

                        for (int k1 = position.func_177958_n() - j1; k1 <= position.func_177958_n() + j1; ++k1)
                        {
                            int l1 = k1 - position.func_177958_n();

                            for (int i2 = position.func_177952_p() - j1; i2 <= position.func_177952_p() + j1; ++i2)
                            {
                                int j2 = i2 - position.func_177952_p();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(k1, i3, i2);
                                    Block block = worldIn.func_180495_p(blockpos).func_177230_c();

                                    if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.leaves || block.func_149688_o() == Material.vine)
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (int j3 = 0; j3 < i; ++j3)
                    {
                        Block block2 = worldIn.func_180495_p(position.up(j3)).func_177230_c();

                        if (block2.func_149688_o() == Material.field_151579_a || block2.func_149688_o() == Material.leaves || block2.func_149688_o() == Material.vine)
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j3), this.metaWood);

                            if (this.vinesGrow && j3 > 0)
                            {
                                if (rand.nextInt(3) > 0 && worldIn.func_175623_d(position.add(-1, j3, 0)))
                                {
                                    this.func_181651_a(worldIn, position.add(-1, j3, 0), BlockVine.EAST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.func_175623_d(position.add(1, j3, 0)))
                                {
                                    this.func_181651_a(worldIn, position.add(1, j3, 0), BlockVine.WEST);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.func_175623_d(position.add(0, j3, -1)))
                                {
                                    this.func_181651_a(worldIn, position.add(0, j3, -1), BlockVine.SOUTH);
                                }

                                if (rand.nextInt(3) > 0 && worldIn.func_175623_d(position.add(0, j3, 1)))
                                {
                                    this.func_181651_a(worldIn, position.add(0, j3, 1), BlockVine.NORTH);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (int k3 = position.func_177956_o() - 3 + i; k3 <= position.func_177956_o() + i; ++k3)
                        {
                            int j4 = k3 - (position.func_177956_o() + i);
                            int k4 = 2 - j4 / 2;
                            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                            for (int l4 = position.func_177958_n() - k4; l4 <= position.func_177958_n() + k4; ++l4)
                            {
                                for (int i5 = position.func_177952_p() - k4; i5 <= position.func_177952_p() + k4; ++i5)
                                {
                                    blockpos$mutableblockpos1.func_181079_c(l4, k3, i5);

                                    if (worldIn.func_180495_p(blockpos$mutableblockpos1).func_177230_c().func_149688_o() == Material.leaves)
                                    {
                                        BlockPos blockpos2 = blockpos$mutableblockpos1.west();
                                        BlockPos blockpos3 = blockpos$mutableblockpos1.east();
                                        BlockPos blockpos4 = blockpos$mutableblockpos1.north();
                                        BlockPos blockpos1 = blockpos$mutableblockpos1.south();

                                        if (rand.nextInt(4) == 0 && worldIn.func_180495_p(blockpos2).func_177230_c().func_149688_o() == Material.field_151579_a)
                                        {
                                            this.func_181650_b(worldIn, blockpos2, BlockVine.EAST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.func_180495_p(blockpos3).func_177230_c().func_149688_o() == Material.field_151579_a)
                                        {
                                            this.func_181650_b(worldIn, blockpos3, BlockVine.WEST);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.func_180495_p(blockpos4).func_177230_c().func_149688_o() == Material.field_151579_a)
                                        {
                                            this.func_181650_b(worldIn, blockpos4, BlockVine.SOUTH);
                                        }

                                        if (rand.nextInt(4) == 0 && worldIn.func_180495_p(blockpos1).func_177230_c().func_149688_o() == Material.field_151579_a)
                                        {
                                            this.func_181650_b(worldIn, blockpos1, BlockVine.NORTH);
                                        }
                                    }
                                }
                            }
                        }

                        if (rand.nextInt(5) == 0 && i > 5)
                        {
                            for (int l3 = 0; l3 < 2; ++l3)
                            {
                                for (Object enumfacing0 : EnumFacing.Plane.HORIZONTAL)
                                {
                                    EnumFacing enumfacing = (EnumFacing) enumfacing0;

                                    if (rand.nextInt(4 - l3) == 0)
                                    {
                                        EnumFacing enumfacing1 = enumfacing.getOpposite();
                                        this.func_181652_a(worldIn, rand.nextInt(3), position.add(enumfacing1.getFrontOffsetX(), i - 5 + l3, enumfacing1.getFrontOffsetZ()), enumfacing);
                                    }
                                }
                            }
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

    private void func_181652_a(World p_181652_1_, int p_181652_2_, BlockPos p_181652_3_, EnumFacing p_181652_4_)
    {
        this.setBlockAndNotifyAdequately(p_181652_1_, p_181652_3_, Blocks.cocoa.func_176223_P().withProperty(BlockCocoa.AGE, Integer.valueOf(p_181652_2_)).withProperty(BlockCocoa.FACING, p_181652_4_));
    }

    private void func_181651_a(World p_181651_1_, BlockPos p_181651_2_, PropertyBool p_181651_3_)
    {
        this.setBlockAndNotifyAdequately(p_181651_1_, p_181651_2_, Blocks.vine.func_176223_P().withProperty(p_181651_3_, Boolean.valueOf(true)));
    }

    private void func_181650_b(World p_181650_1_, BlockPos p_181650_2_, PropertyBool p_181650_3_)
    {
        this.func_181651_a(p_181650_1_, p_181650_2_, p_181650_3_);
        int i = 4;

        for (p_181650_2_ = p_181650_2_.func_177977_b(); p_181650_1_.func_180495_p(p_181650_2_).func_177230_c().func_149688_o() == Material.field_151579_a && i > 0; --i)
        {
            this.func_181651_a(p_181650_1_, p_181650_2_, p_181650_3_);
            p_181650_2_ = p_181650_2_.func_177977_b();
        }
    }
}
