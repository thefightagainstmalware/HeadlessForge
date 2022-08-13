package net.minecraft.world.gen;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.BlockBush;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 *
 */
public class GeneratorBushFeature extends WorldGenerator {

    /**
     *
     */
    private BlockBush field_175908_a;

    /**
     *
     */
    public GeneratorBushFeature(BlockBush p_i45633_1_) {
        
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