package net.minecraft.world;

import net.minecraft.util.MathHelper;

/**
 *
 */
public class DifficultyInstance extends Object {

    /**
     *
     */
    private final EnumDifficulty worldDifficulty;

    /**
     *
     */
    private final float additionalDifficulty;

    /**
     *
     */
    public DifficultyInstance(EnumDifficulty worldDifficulty,
                              long worldTime,
                              long chunkInhabitedTime,
                              float moonPhaseFactor) {
        this.worldDifficulty = worldDifficulty;
        this.additionalDifficulty = this.calculateAdditionalDifficulty(worldDifficulty, worldTime, chunkInhabitedTime, moonPhaseFactor);
    }

    /**
     *
     */
    public float getAdditionalDifficulty() {
        return 0;
    }

    /**
     *
     */
    public float getClampedAdditionalDifficulty() {
        return 0;
    }

    /**
     *
     */
    private float calculateAdditionalDifficulty(EnumDifficulty difficulty,
                                                long worldTime,
                                                long chunkInhabitedTime,
                                                float moonPhaseFactor) {
        return 0;
    }

}