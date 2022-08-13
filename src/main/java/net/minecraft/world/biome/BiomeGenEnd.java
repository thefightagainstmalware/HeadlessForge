package net.minecraft.world.biome;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.Blocks;

public class BiomeGenEnd extends BiomeGenBase
{
    public BiomeGenEnd(int p_i1990_1_)
    {
        super(p_i1990_1_);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = Blocks.field_150346_d.func_176223_P();
        this.fillerBlock = Blocks.field_150346_d.func_176223_P();
        this.theBiomeDecorator = new BiomeEndDecorator();
    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float p_76731_1_)
    {
        return 0;
    }
}
