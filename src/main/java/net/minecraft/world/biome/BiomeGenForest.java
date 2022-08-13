package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockFlower;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenForest;

/**
 *
 */
public class BiomeGenForest extends BiomeGenBase {

    /**
     *
     */
    private int field_150632_aF;

    /**
     *
     */
    protected static final WorldGenForest field_150629_aC = new WorldGenForest(false, false);

    /**
     *
     */
    protected static final WorldGenForest field_150630_aD = new WorldGenForest(false, true);

    /**
     *
     */
    protected static final WorldGenCanopyTree field_150631_aE = new WorldGenCanopyTree(false);

    /**
     *
     */
    public BiomeGenForest(int p_i45377_1_,
                          int p_i45377_2_) {
        super(p_i45377_1_);

    }

    /**
     *
     */
    @Override
    public BiomeGenBase func_150557_a(int p_150557_1_,
                                      boolean p_150557_2_) {
        return null;
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
    public BlockFlower.EnumFlowerType pickRandomFlower(java.util.Random rand,
                                                       BlockPos pos) {
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

    /**
     *
     */
    @Override
    public int getGrassColorAtPos(BlockPos pos) {
        return 0;
    }

    /**
     *
     */
    @Override
    public BiomeGenBase createMutatedBiome(int p_180277_1_) {
        return null;
    }

    /**
     * Adds the default flowers, as of 1.7, it is 2 yellow, and 1 red. I chose 10 to allow some wiggle room in the numbers.
     */
    public void addDefaultFlowers() {
        return;
    }

}