package net.minecraft.client.util;

/**
 *
 */
public class Vec3 extends Object {

    /**
     * X coordinate of Vec3D
     */
    public final double xCoord;

    /**
     * Y coordinate of Vec3D
     */
    public final double yCoord;

    /**
     * Z coordinate of Vec3D
     */
    public final double zCoord;

    /**
     *
     */
    public Vec3(double x,
                double y,
                double z) {
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;
    }

    /**
     *
     */
    public Vec3(Vec3i p_i46377_1_) {
        this.xCoord = p_i46377_1_.getX();
        this.yCoord = p_i46377_1_.getY();
        this.zCoord = p_i46377_1_.getZ();
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