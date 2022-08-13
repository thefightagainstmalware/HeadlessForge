package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;

/**
 *
 */
public class WorldGenLakes extends WorldGenerator {

    /**
     *
     */
    private Block block;

    /**
     *
     */
    public WorldGenLakes(Block blockIn) {
        
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