package net.minecraft.world.gen.structure;

import java.util.Iterator;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import java.util.LinkedList;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.ChunkCoordIntPair;

/**
 *
 */
public abstract class StructureStart extends Object {

    /**
     *
     */
    protected java.util.LinkedList<StructureComponent> components;

    /**
     *
     */
    protected StructureBoundingBox boundingBox;

    /**
     *
     */
    private int chunkPosX;

    /**
     *
     */
    private int chunkPosZ;

    /**
     *
     */
    public StructureStart() {
        
    }

    /**
     *
     */
    public StructureStart(int chunkX,
                          int chunkZ) {
        
    }

    /**
     *
     */
    public StructureBoundingBox getBoundingBox() {
        return null;
    }

    /**
     *
     */
    public java.util.LinkedList<StructureComponent> getComponents() {
        return null;
    }

    /**
     * Keeps iterating Structure Pieces and spawning them until the checks tell it to stop
     */
    public void generateStructure(World worldIn,
                                  java.util.Random rand,
                                  StructureBoundingBox structurebb) {
        return;
    }

    /**
     * Calculates total bounding box based on components' bounding boxes and saves it to boundingBox
     */
    protected void updateBoundingBox() {
        return;
    }

    /**
     *
     */
    public NBTTagCompound writeStructureComponentsToNBT(int chunkX,
                                                        int chunkZ) {
        return null;
    }

    /**
     *
     */
    public void writeToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     *
     */
    public void readStructureComponentsFromNBT(World worldIn,
                                               NBTTagCompound tagCompound) {
        return;
    }

    /**
     *
     */
    public void readFromNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * offsets the structure Bounding Boxes up to a certain height, typically 63 - 10
     */
    protected void markAvailableHeight(World worldIn,
                                       java.util.Random rand,
                                       int p_75067_3_) {
        return;
    }

    /**
     *
     */
    protected void setRandomHeight(World worldIn,
                                   java.util.Random rand,
                                   int p_75070_3_,
                                   int p_75070_4_) {
        return;
    }

    /**
     * currently only defined for Villages, returns true if Village has more than 2 non-road components
     */
    public boolean isSizeableStructure() {
        return true;
    }

    /**
     *
     */
    public boolean func_175788_a(ChunkCoordIntPair pair) {
        return true;
    }

    /**
     *
     */
    public void func_175787_b(ChunkCoordIntPair pair) {
        return;
    }

    /**
     *
     */
    public int getChunkPosX() {
        return 0;
    }

    /**
     *
     */
    public int getChunkPosZ() {
        return 0;
    }

}