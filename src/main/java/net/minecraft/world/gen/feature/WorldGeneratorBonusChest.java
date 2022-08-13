package net.minecraft.world.gen.feature;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class WorldGeneratorBonusChest extends WorldGenerator
{
    private final List<WeightedRandomChestContent> chestItems;

    /**
     * Value of this int will determine how much items gonna generate in Bonus Chest.
     */
    private final int itemsToGenerateInBonusChest;

    public WorldGeneratorBonusChest(List<WeightedRandomChestContent> p_i45634_1_, int p_i45634_2_)
    {
        this.chestItems = p_i45634_1_;
        this.itemsToGenerateInBonusChest = p_i45634_2_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        Block block;

        while (((block = worldIn.func_180495_p(position).func_177230_c()).func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.leaves) && position.func_177956_o() > 1)
        {
            position = position.func_177977_b();
        }

        if (position.func_177956_o() < 1)
        {
            return false;
        }
        else
        {
            position = position.up();

            for (int i = 0; i < 4; ++i)
            {
                BlockPos blockpos = position.add(rand.nextInt(4) - rand.nextInt(4), rand.nextInt(3) - rand.nextInt(3), rand.nextInt(4) - rand.nextInt(4));

                if (worldIn.func_175623_d(blockpos) && World.doesBlockHaveSolidTopSurface(worldIn, blockpos.func_177977_b()))
                {
                    worldIn.func_180501_a(blockpos, Blocks.field_150486_ae.func_176223_P(), 2);
                    TileEntity tileentity = worldIn.func_175625_s(blockpos);

                    if (tileentity instanceof TileEntityChest)
                    {
                        WeightedRandomChestContent.generateChestContents(rand, this.chestItems, (TileEntityChest)tileentity, this.itemsToGenerateInBonusChest);
                    }

                    BlockPos blockpos1 = blockpos.east();
                    BlockPos blockpos2 = blockpos.west();
                    BlockPos blockpos3 = blockpos.north();
                    BlockPos blockpos4 = blockpos.south();

                    if (worldIn.func_175623_d(blockpos2) && World.doesBlockHaveSolidTopSurface(worldIn, blockpos2.func_177977_b()))
                    {
                        worldIn.func_180501_a(blockpos2, Blocks.torch.func_176223_P(), 2);
                    }

                    if (worldIn.func_175623_d(blockpos1) && World.doesBlockHaveSolidTopSurface(worldIn, blockpos1.func_177977_b()))
                    {
                        worldIn.func_180501_a(blockpos1, Blocks.torch.func_176223_P(), 2);
                    }

                    if (worldIn.func_175623_d(blockpos3) && World.doesBlockHaveSolidTopSurface(worldIn, blockpos3.func_177977_b()))
                    {
                        worldIn.func_180501_a(blockpos3, Blocks.torch.func_176223_P(), 2);
                    }

                    if (worldIn.func_175623_d(blockpos4) && World.doesBlockHaveSolidTopSurface(worldIn, blockpos4.func_177977_b()))
                    {
                        worldIn.func_180501_a(blockpos4, Blocks.torch.func_176223_P(), 2);
                    }

                    return true;
                }
            }

            return false;
        }
    }
}
