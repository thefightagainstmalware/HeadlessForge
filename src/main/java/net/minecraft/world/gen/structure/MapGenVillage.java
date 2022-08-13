package net.minecraft.world.gen.structure;

import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;

/**
 *
 */
public class MapGenVillage extends MapGenStructure {

    /**
     *
     */
    public static java.util.List<BiomeGenBase> villageSpawnBiomes;

    /**
     * World terrain type, 0 for normal, 1 for flat map
     */
    private int terrainType;

    /**
     *
     */
    private int field_82665_g;

    /**
     *
     */
    private int field_82666_h;

    /**
     *
     */
    public MapGenVillage() {
        
    }

    /**
     *
     */
    public MapGenVillage(java.util.Map<String,String> p_i2093_1_) {
        
    }

    /**
     *
     */
    public String getStructureName() {
        return null;
    }

    /**
     *
     */
    protected boolean canSpawnStructureAtCoords(int chunkX,
                                                int chunkZ) {
        return true;
    }

    /**
     *
     */
    protected StructureStart getStructureStart(int chunkX,
                                               int chunkZ) {
        return null;
    }

}