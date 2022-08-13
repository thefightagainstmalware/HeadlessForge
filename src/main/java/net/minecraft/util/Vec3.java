package net.minecraft.util;

/**
 *
 */
public class Vec3 extends Object {

    /**
     * X coordinate of Vec3D
     */
    public final double field_72450_a;

    /**
     * Y coordinate of Vec3D
     */
    public final double field_72448_b;

    /**
     * Z coordinate of Vec3D
     */
    public final double field_72449_c;

    /**
     *
     */
    public Vec3(double x,
                double y,
                double z) {
        this.field_72450_a = x;
        this.field_72448_b = y;
        this.field_72449_c = z;
    }

    /**
     *
     */
    public Vec3(Vec3i p_i46377_1_) {
        this.field_72450_a = p_i46377_1_.func_177958_n();
        this.field_72448_b = p_i46377_1_.func_177956_o();
        this.field_72449_c = p_i46377_1_.func_177952_p();
    }

    /**
     * Returns a new vector with the result of the specified vector minus this.
     */
    public Vec3 subtractReverse(Vec3 vec) {
        return null;
    }

    /**
     * Normalizes the vector to a length of 1 (except if it is the zero vector)
     */
    public Vec3 normalize() {
        return null;
    }

    /**
     *
     */
    public double dotProduct(Vec3 vec) {
        return 0;
    }

    /**
     * Returns a new vector with the result of this vector x the specified vector.
     */
    public Vec3 crossProduct(Vec3 vec) {
        return null;
    }

    /**
     *
     */
    public Vec3 subtract(Vec3 vec) {
        return null;
    }

    /**
     *
     */
    public Vec3 subtract(double x,
                         double y,
                         double z) {
        return null;
    }

    /**
     *
     */
    public Vec3 add(Vec3 vec) {
        return null;
    }

    /**
     * Adds the specified x,y,z vector components to this vector and returns the resulting vector. Does not change this
     * vector.
     */
    public Vec3 addVector(double x,
                          double y,
                          double z) {
        return null;
    }

    /**
     * Euclidean distance between this and the specified vector, returned as double.
     */
    public double distanceTo(Vec3 vec) {
        return 0;
    }

    /**
     * The square of the Euclidean distance between this and the specified vector.
     */
    public double squareDistanceTo(Vec3 vec) {
        return 0;
    }

    /**
     * Returns the length of the vector.
     */
    public double lengthVector() {
        return 0;
    }

    /**
     * Returns a new vector with x value equal to the second parameter, along the line between this vector and the
     * passed in vector, or null if not possible.
     */
    public Vec3 getIntermediateWithXValue(Vec3 vec,
                                          double x) {
        return null;
    }

    /**
     * Returns a new vector with y value equal to the second parameter, along the line between this vector and the
     * passed in vector, or null if not possible.
     */
    public Vec3 getIntermediateWithYValue(Vec3 vec,
                                          double y) {
        return null;
    }

    /**
     * Returns a new vector with z value equal to the second parameter, along the line between this vector and the
     * passed in vector, or null if not possible.
     */
    public Vec3 getIntermediateWithZValue(Vec3 vec,
                                          double z) {
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
    public Vec3 rotatePitch(float pitch) {
        return null;
    }

    /**
     *
     */
    public Vec3 rotateYaw(float yaw) {
        return null;
    }

}