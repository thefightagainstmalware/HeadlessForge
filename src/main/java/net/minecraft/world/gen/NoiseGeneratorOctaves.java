package net.minecraft.world.gen;

import net.minecraft.util.MathHelper;

/**
 *
 */
public class NoiseGeneratorOctaves extends NoiseGenerator {

    /**
     * Collection of noise generation functions.  Output is combined to produce different octaves of noise.
     */
    private NoiseGeneratorImproved[] generatorCollection;

    /**
     *
     */
    private int octaves;

    /**
     *
     */
    public NoiseGeneratorOctaves(java.util.Random p_i2111_1_,
                                 int p_i2111_2_) {
        
    }

    /**
     * pars:(par2,3,4=noiseOffset ; so that adjacent noise segments connect) (pars5,6,7=x,y,zArraySize),(pars8,10,12 =
     * x,y,z noiseScale)
     */
    public double[] generateNoiseOctaves(double[] p_76304_1_,
                                         int p_76304_2_,
                                         int p_76304_3_,
                                         int p_76304_4_,
                                         int p_76304_5_,
                                         int p_76304_6_,
                                         int p_76304_7_,
                                         double p_76304_8_,
                                         double p_76304_10_,
                                         double p_76304_12_) {
        return null;
    }

    /**
     * Bouncer function to the main one with some default arguments.
     */
    public double[] generateNoiseOctaves(double[] p_76305_1_,
                                         int p_76305_2_,
                                         int p_76305_3_,
                                         int p_76305_4_,
                                         int p_76305_5_,
                                         double p_76305_6_,
                                         double p_76305_8_,
                                         double p_76305_10_) {
        return null;
    }

}