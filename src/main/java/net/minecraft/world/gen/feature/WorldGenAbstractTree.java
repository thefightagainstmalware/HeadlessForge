package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;

/**
 *
 */
public abstract class WorldGenAbstractTree extends WorldGenerator {

    /**
     *
     */
    public WorldGenAbstractTree(boolean p_i45448_1_) {
        
    }

    /**
     *
     */
    protected boolean func_150523_a(Block p_150523_1_) {
        return true;
    }

    /**
     *
     */
    public void func_180711_a(World worldIn,
                              java.util.Random p_180711_2_,
                              BlockPos p_180711_3_) {
        return;
    }

    /**
     *
     */
    protected void func_175921_a(World worldIn,
                                 BlockPos p_175921_2_) {
        return;
    }

    /**
     *
     */
    public boolean isReplaceable(World world,
                                 BlockPos pos) {
        return true;
    }

}