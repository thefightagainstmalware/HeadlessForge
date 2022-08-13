package net.minecraft.world;

import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.util.Vec3;

/**
 *
 */
public class WorldProviderHell extends WorldProvider {

    /**
     *
     */
    public WorldProviderHell() {
        
    }

    /**
     * creates a new world chunk manager for WorldProvider
     */
    @Override
    public void registerWorldChunkManager() {
        return;
    }

    /**
     * Return Vec3D with biome specific fog color
     */
    @Override
    public Vec3 getFogColor(float p_76562_1_,
                            float p_76562_2_) {
        return null;
    }

    /**
     * Creates the light to brightness table
     */
    @Override
    protected void generateLightBrightnessTable() {
        return;
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    @Override
    public IChunkProvider createChunkGenerator() {
        return null;
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    @Override
    public boolean isSurfaceWorld() {
        return true;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    @Override
    public boolean canCoordinateBeSpawn(int x,
                                        int z) {
        return true;
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    @Override
    public float calculateCelestialAngle(long p_76563_1_,
                                         float p_76563_3_) {
        return 0;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere() {
        return true;
    }

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    @Override
    public boolean doesXZShowFog(int x,
                                 int z) {
        return true;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName() {
        return null;
    }

    /**
     *
     */
    public String getInternalNameSuffix() {
        return null;
    }

    /**
     *
     */
    @Override
    public WorldBorder getWorldBorder() {
        return null;
    }

}