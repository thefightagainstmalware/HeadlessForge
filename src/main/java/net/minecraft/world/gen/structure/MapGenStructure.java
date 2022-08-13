package net.minecraft.world.gen.structure;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.chunk.ChunkPrimer;

/**
 *
 */
public abstract class MapGenStructure extends MapGenBase {

    /**
     *
     */
    private MapGenStructureData structureData;

    /**
     *
     */
    protected java.util.Map<java.lang.Long,StructureStart> structureMap;

    /**
     *
     */
    public MapGenStructure() {
        
    }

    /**
     *
     */
    public abstract String getStructureName();

    /**
     * Recursively called by generate()
     */
    @Override
    protected final void recursiveGenerate(World worldIn,
                                           int chunkX,
                                           int chunkZ,
                                           int p_180701_4_,
                                           int p_180701_5_,
                                           ChunkPrimer chunkPrimerIn) {
        return;
    }

    /**
     *
     */
    public boolean generateStructure(World worldIn,
                                     java.util.Random randomIn,
                                     ChunkCoordIntPair chunkCoord) {
        return true;
    }

    /**
     *
     */
    public boolean func_175795_b(BlockPos pos) {
        return true;
    }

    /**
     *
     */
    protected StructureStart func_175797_c(BlockPos pos) {
        return null;
    }

    /**
     *
     */
    public boolean func_175796_a(World worldIn,
                                 BlockPos pos) {
        return true;
    }

    /**
     *
     */
    public BlockPos getClosestStrongholdPos(World worldIn,
                                            BlockPos pos) {
        return null;
    }

    /**
     *
     */
    protected java.util.List<BlockPos> getCoordList() {
        return null;
    }

    /**
     *
     */
    private void func_143027_a(World worldIn) {
        return;
    }

    /**
     *
     */
    private void func_143026_a(int p_143026_1_,
                               int p_143026_2_,
                               StructureStart start) {
        return;
    }

    /**
     *
     */
    protected abstract boolean canSpawnStructureAtCoords(int chunkX,
                                                         int chunkZ);

    /**
     *
     */
    protected abstract StructureStart getStructureStart(int chunkX,
                                                        int chunkZ);

}