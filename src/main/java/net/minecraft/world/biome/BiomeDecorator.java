package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderSettings;

/**
 *
 */
public class BiomeDecorator extends Object {

    /**
     * The world the BiomeDecorator is currently decorating
     */
    public World currentWorld;

    /**
     * The Biome Decorator's random number generator.
     */
    public java.util.Random randomGenerator;

    /**
     *
     */
    public BlockPos field_180294_c;

    /**
     *
     */
    public ChunkProviderSettings chunkProviderSettings;

    /**
     * The clay generator.
     */
    public WorldGenerator clayGen;

    /**
     * The sand generator.
     */
    public WorldGenerator sandGen;

    /**
     * The gravel generator.
     */
    public WorldGenerator gravelAsSandGen;

    /**
     * The dirt generator.
     */
    public WorldGenerator dirtGen;

    /**
     *
     */
    public WorldGenerator gravelGen;

    /**
     *
     */
    public WorldGenerator graniteGen;

    /**
     *
     */
    public WorldGenerator dioriteGen;

    /**
     *
     */
    public WorldGenerator andesiteGen;

    /**
     *
     */
    public WorldGenerator coalGen;

    /**
     *
     */
    public WorldGenerator ironGen;

    /**
     * Field that holds gold WorldGenMinable
     */
    public WorldGenerator goldGen;

    /**
     *
     */
    public WorldGenerator redstoneGen;

    /**
     *
     */
    public WorldGenerator diamondGen;

    /**
     * Field that holds Lapis WorldGenMinable
     */
    public WorldGenerator lapisGen;

    /**
     *
     */
    public WorldGenFlowers yellowFlowerGen;

    /**
     * Field that holds mushroomBrown WorldGenFlowers
     */
    public WorldGenerator mushroomBrownGen;

    /**
     * Field that holds mushroomRed WorldGenFlowers
     */
    public WorldGenerator mushroomRedGen;

    /**
     * Field that holds big mushroom generator
     */
    public WorldGenerator bigMushroomGen;

    /**
     * Field that holds WorldGenReed
     */
    public WorldGenerator reedGen;

    /**
     * Field that holds WorldGenCactus
     */
    public WorldGenerator cactusGen;

    /**
     * The water lily generation!
     */
    public WorldGenerator waterlilyGen;

    /**
     * Amount of waterlilys per chunk.
     */
    public int waterlilyPerChunk;

    /**
     * The number of trees to attempt to generate per chunk. Up to 10 in forests, none in deserts.
     */
    public int treesPerChunk;

    /**
     * The number of yellow flower patches to generate per chunk. The game generates much less than this number, since
     * it attempts to generate them at a random altitude.
     */
    public int flowersPerChunk;

    /**
     * The amount of tall grass to generate per chunk.
     */
    public int grassPerChunk;

    /**
     * The number of dead bushes to generate per chunk. Used in deserts and swamps.
     */
    public int deadBushPerChunk;

    /**
     * The number of extra mushroom patches per chunk. It generates 1/4 this number in brown mushroom patches, and 1/8
     * this number in red mushroom patches. These mushrooms go beyond the default base number of mushrooms.
     */
    public int mushroomsPerChunk;

    /**
     * The number of reeds to generate per chunk. Reeds won't generate if the randomly selected placement is unsuitable.
     */
    public int reedsPerChunk;

    /**
     * The number of cactus plants to generate per chunk. Cacti only work on sand.
     */
    public int cactiPerChunk;

    /**
     * The number of sand patches to generate per chunk. Sand patches only generate when part of it is underwater.
     */
    public int sandPerChunk;

    /**
     * The number of sand patches to generate per chunk. Sand patches only generate when part of it is underwater. There
     * appear to be two separate fields for this.
     */
    public int sandPerChunk2;

    /**
     * The number of clay patches to generate per chunk. Only generates when part of it is underwater.
     */
    public int clayPerChunk;

    /**
     * Amount of big mushrooms per chunk
     */
    public int bigMushroomsPerChunk;

    /**
     * True if decorator should generate surface lava &amp; water
     */
    public boolean generateLakes;

    /**
     *
     */
    public BiomeDecorator() {
        
    }

    /**
     *
     */
    public void decorate(World worldIn,
                         java.util.Random random,
                         BiomeGenBase p_180292_3_,
                         BlockPos p_180292_4_) {
        return;
    }

    /**
     *
     */
    protected void genDecorations(BiomeGenBase biomeGenBaseIn) {
        return;
    }

    /**
     * Standard ore generation helper. Generates most ores.
     */
    protected void genStandardOre1(int blockCount,
                                   WorldGenerator generator,
                                   int minHeight,
                                   int maxHeight) {
        return;
    }

    /**
     * Standard ore generation helper. Generates Lapis Lazuli.
     */
    protected void genStandardOre2(int blockCount,
                                   WorldGenerator generator,
                                   int centerHeight,
                                   int spread) {
        return;
    }

    /**
     * Generates ores in the current chunk
     */
    protected void generateOres() {
        return;
    }

}