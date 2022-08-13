package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;

/**
 *
 */
public class WorldGenSand extends WorldGenerator {

    /**
     *
     */
    private Block block;

    /**
     * The maximum radius used when generating a patch of blocks.
     */
    private int radius;

    /**
     *
     */
    public WorldGenSand(Block p_i45462_1_,
                        int p_i45462_2_) {
        
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