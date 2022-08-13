package net.minecraft.world.biome;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenSpikes;

/**
 *
 */
public class BiomeEndDecorator extends BiomeDecorator {

    /**
     *
     */
    protected WorldGenerator spikeGen;

    /**
     *
     */
    public BiomeEndDecorator() {
        
    }

    /**
     *
     */
    @Override
    protected void genDecorations(BiomeGenBase biomeGenBaseIn) {
        return;
    }

}