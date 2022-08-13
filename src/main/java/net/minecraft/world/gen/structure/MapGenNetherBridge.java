package net.minecraft.world.gen.structure;

import java.util.List;
import net.minecraft.world.World;
import java.util.Random;
import com.google.common.collect.Lists;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityPigZombie;

/**
 *
 */
public class MapGenNetherBridge extends MapGenStructure {

    /**
     *
     */
    private java.util.List<BiomeGenBase.SpawnListEntry> spawnList;

    /**
     *
     */
    public MapGenNetherBridge() {
        
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
    public java.util.List<BiomeGenBase.SpawnListEntry> getSpawnList() {
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