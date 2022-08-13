package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.Block;

/**
 *
 */
public class WorldGenBigMushroom extends WorldGenerator {

    /**
     * The mushroom type. 0 for brown, 1 for red.
     */
    private Block mushroomType;

    /**
     *
     */
    public WorldGenBigMushroom(Block p_i46449_1_) {
        
    }

    /**
     *
     */
    public WorldGenBigMushroom() {
        
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