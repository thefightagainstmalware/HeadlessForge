package net.minecraft.world.biome;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;

/**
 *
 */
public class BiomeGenSavanna extends BiomeGenBase {

    /**
     *
     */
    private static final WorldGenSavannaTree field_150627_aC = new WorldGenSavannaTree(false);

    /**
     *
     */
    public BiomeGenSavanna(int p_i45383_1_) {
        super(p_i45383_1_);
    }

    /**
     *
     */
    @Override
    public WorldGenAbstractTree genBigTreeChance(java.util.Random rand) {
        return null;
    }

    /**
     *
     */
    @Override
    public BiomeGenBase createMutatedBiome(int p_180277_1_) {
        return null;
    }

    /**
     *
     */
    @Override
    public void decorate(World worldIn,
                         java.util.Random rand,
                         BlockPos pos) {
        return;
    }

}