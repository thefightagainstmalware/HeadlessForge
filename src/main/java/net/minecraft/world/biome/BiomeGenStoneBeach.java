package net.minecraft.world.biome;

import net.minecraft.init.Blocks;

public class BiomeGenStoneBeach extends BiomeGenBase
{
    public BiomeGenStoneBeach(int p_i45384_1_)
    {
        super(p_i45384_1_);
        this.spawnableCreatureList.clear();
        this.topBlock = Blocks.field_150348_b.func_176223_P();
        this.fillerBlock = Blocks.field_150348_b.func_176223_P();
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.cactiPerChunk = 0;
    }
}
