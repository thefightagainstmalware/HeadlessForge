package net.minecraft.world.gen.structure;

import net.minecraft.util.Vec3i;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class StructureBoundingBox extends Object {

    /**
     * The first x coordinate of a bounding box.
     */
    public int field_78897_a;

    /**
     * The first y coordinate of a bounding box.
     */
    public int field_78895_b;

    /**
     * The first z coordinate of a bounding box.
     */
    public int field_78896_c;

    /**
     * The second x coordinate of a bounding box.
     */
    public int field_78893_d;

    /**
     * The second y coordinate of a bounding box.
     */
    public int field_78894_e;

    /**
     * The second z coordinate of a bounding box.
     */
    public int field_78892_f;

    /**
     *
     */
    public StructureBoundingBox() {
        
    }

    /**
     *
     */
    public StructureBoundingBox(int[] coords) {
        
    }

    /**
     *
     */
    public StructureBoundingBox(StructureBoundingBox structurebb) {
        
    }

    /**
     *
     */
    public StructureBoundingBox(int xMin,
                                int yMin,
                                int zMin,
                                int xMax,
                                int yMax,
                                int zMax) {
        
    }

    /**
     *
     */
    public StructureBoundingBox(Vec3i vec1,
                                Vec3i vec2) {
        
    }

    /**
     *
     */
    public StructureBoundingBox(int xMin,
                                int zMin,
                                int xMax,
                                int zMax) {
        
    }

    /**
     * returns a new StructureBoundingBox with MAX values
     */
    public static StructureBoundingBox getNewBoundingBox() {
        return null;
    }

    /**
     * Create a bounding box with the specified dimensions and rotate it. Used to project a possible new component
     * Bounding Box - to check if it would cut anything already spawned
     */
    public static StructureBoundingBox getComponentToAddBoundingBox(int p_175897_0_,
                                                                    int p_175897_1_,
                                                                    int p_175897_2_,
                                                                    int p_175897_3_,
                                                                    int p_175897_4_,
                                                                    int p_175897_5_,
                                                                    int p_175897_6_,
                                                                    int p_175897_7_,
                                                                    int p_175897_8_,
                                                                    EnumFacing p_175897_9_) {
        return null;
    }

    /**
     *
     */
    public static StructureBoundingBox func_175899_a(int p_175899_0_,
                                                     int p_175899_1_,
                                                     int p_175899_2_,
                                                     int p_175899_3_,
                                                     int p_175899_4_,
                                                     int p_175899_5_) {
        return null;
    }

    /**
     * Discover if bounding box can fit within the current bounding box object.
     */
    public boolean func_78884_a(StructureBoundingBox structurebb) {
        return true;
    }

    /**
     * Discover if a coordinate is inside the bounding box area.
     */
    public boolean intersectsWith(int minXIn,
                                  int minZIn,
                                  int maxXIn,
                                  int maxZIn) {
        return true;
    }

    /**
     * Expands a bounding box's dimensions to include the supplied bounding box.
     */
    public void expandTo(StructureBoundingBox sbb) {
        return;
    }

    /**
     * Offsets the current bounding box by the specified coordinates. Args: x, y, z
     */
    public void offset(int x,
                       int y,
                       int z) {
        return;
    }

    /**
     * Checks if given Vec3i is inside of StructureBoundingBox
     */
    public boolean func_175898_b(Vec3i vec) {
        return true;
    }

    /**
     *
     */
    public Vec3i func_175896_b() {
        return null;
    }

    /**
     * Get dimension of the bounding box in the x direction.
     */
    public int func_78883_b() {
        return 0;
    }

    /**
     * Get dimension of the bounding box in the y direction.
     */
    public int func_78882_c() {
        return 0;
    }

    /**
     * Get dimension of the bounding box in the z direction.
     */
    public int func_78880_d() {
        return 0;
    }

    /**
     *
     */
    public Vec3i getCenter() {
        return null;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     *
     */
    public NBTTagIntArray toNBTTagIntArray() {
        return null;
    }

}