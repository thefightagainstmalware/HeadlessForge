package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class WorldGenFlowers extends WorldGenerator {

    /**
     *
     */
    private BlockFlower flower;

    /**
     *
     */
    private IBlockState field_175915_b;

    /**
     *
     */
    public WorldGenFlowers(BlockFlower p_i45632_1_,
                           BlockFlower.EnumFlowerType p_i45632_2_) {
        
    }

    /**
     *
     */
    public void setGeneratedBlock(BlockFlower p_175914_1_,
                                  BlockFlower.EnumFlowerType p_175914_2_) {
        return;
    }

    /**
     *
     */
    public boolean generate(World worldIn,
                            java.util.Random rand,
                            BlockPos position) {
        return true;
    }

}