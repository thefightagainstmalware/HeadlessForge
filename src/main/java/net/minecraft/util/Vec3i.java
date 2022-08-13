package net.minecraft.util;

/**
 *
 */
public class Vec3i extends Object implements Comparable<Vec3i> {

    /**
     * The Null vector constant (0, 0, 0)
     */
    public static final Vec3i NULL_VECTOR = new Vec3i(0, 0, 0);

    /**
     * X coordinate
     */
    private final int x;

    /**
     * Y coordinate
     */
    private final int y;

    /**
     * Z coordinate
     */
    private final int z;

    /**
     *
     */
    public Vec3i(int xIn,
                 int yIn,
                 int zIn) {
        this.x = xIn;
        this.y = yIn;
        this.z = zIn;
    }

    /**
     *
     */
    public Vec3i(double xIn,
                 double yIn,
                 double zIn) {
        this.x = (int) Math.round(xIn);
        this.y = (int) Math.round(yIn);
        this.z = (int) Math.round(zIn);

    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    public int compareTo(Vec3i p_compareTo_1_) {
        return 0;
    }

    /**
     * Get the X coordinate
     */
    public int func_177958_n() {
        return 0;
    }

    /**
     * Get the Y coordinate
     */
    public int func_177956_o() {
        return 0;
    }

    /**
     * Get the Z coordinate
     */
    public int func_177952_p() {
        return 0;
    }

    /**
     * Calculate the cross product of this and the given Vector
     */
    public Vec3i crossProduct(Vec3i vec) {
        return null;
    }

    /**
     * Calculate squared distance to the given coordinates
     */
    public double distanceSq(double toX,
                             double toY,
                             double toZ) {
        return 0;
    }

    /**
     * Compute square of distance from point x, y, z to center of this Block
     */
    public double distanceSqToCenter(double xIn,
                                     double yIn,
                                     double zIn) {
        return 0;
    }

    /**
     * Calculate squared distance to the given Vector
     */
    public double distanceSq(Vec3i to) {
        return 0;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

}