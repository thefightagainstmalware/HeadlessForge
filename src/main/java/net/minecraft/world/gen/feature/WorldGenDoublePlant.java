package net.minecraft.world.gen.feature;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.BlockDoublePlant;

/**
 *
 */
public class WorldGenDoublePlant extends WorldGenerator {

    /**
     *
     */
    private BlockDoublePlant.EnumPlantType field_150549_a;

    /**
     *
     */
    public WorldGenDoublePlant() {
        
    }

    /**
     *
     */
    public void setPlantType(BlockDoublePlant.EnumPlantType p_180710_1_) {
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