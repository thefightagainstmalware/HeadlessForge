package net.minecraft.util;

/**
 *
 */
public class AxisAlignedBB extends Object {

    /**
     *
     */
    public final double minX;

    /**
     *
     */
    public final double minY;

    /**
     *
     */
    public final double minZ;

    /**
     *
     */
    public final double maxX;

    /**
     *
     */
    public final double maxY;

    /**
     *
     */
    public final double maxZ;

    /**
     *
     */
    public AxisAlignedBB(double x1,
                         double y1,
                         double z1,
                         double x2,
                         double y2,
                         double z2) {
        minX = Math.min(x1, x2);
        minY = Math.min(y1, y2);
        minZ = Math.min(z1, z2);
        maxX = Math.max(x1, x2);
        maxY = Math.max(y1, y2);
        maxZ = Math.max(z1, z2);
    }

    /**
     *
     */
    public AxisAlignedBB(BlockPos pos1,
                         BlockPos pos2) {
        minX = Math.min(pos1.func_177958_n(), pos2.func_177958_n());
        minY = Math.min(pos1.func_177956_o(), pos2.func_177956_o());
        minZ = Math.min(pos1.func_177952_p(), pos2.func_177952_p());
        maxX = Math.max(pos1.func_177958_n(), pos2.func_177958_n());
        maxY = Math.max(pos1.func_177956_o(), pos2.func_177956_o());
        maxZ = Math.max(pos1.func_177952_p(), pos2.func_177952_p());
    }

    /**
     * Adds the coordinates to the bounding box extending it if the point lies outside the current ranges. Args: x, y, z
     */
    public AxisAlignedBB addCoord(double x,
                                  double y,
                                  double z) {
        return null;
    }

    /**
     * Returns a bounding box expanded by the specified vector (if negative numbers are given it will shrink). Args: x,
     * y, z
     */
    public AxisAlignedBB expand(double x,
                                double y,
                                double z) {
        return null;
    }

    /**
     *
     */
    public AxisAlignedBB union(AxisAlignedBB other) {
        return null;
    }

    /**
     * returns an AABB with corners x1, y1, z1 and x2, y2, z2
     */
    public static AxisAlignedBB fromBounds(double x1,
                                           double y1,
                                           double z1,
                                           double x2,
                                           double y2,
                                           double z2) {
        return null;
    }

    /**
     * Offsets the current bounding box by the specified coordinates. Args: x, y, z
     */
    public AxisAlignedBB offset(double x,
                                double y,
                                double z) {
        return null;
    }

    /**
     * if instance and the argument bounding boxes overlap in the Y and Z dimensions, calculate the offset between them
     * in the X dimension.  return var2 if the bounding boxes do not overlap or if var2 is closer to 0 then the
     * calculated offset.  Otherwise return the calculated offset.
     */
    public double calculateXOffset(AxisAlignedBB other,
                                   double offsetX) {
        return 0;
    }

    /**
     * if instance and the argument bounding boxes overlap in the X and Z dimensions, calculate the offset between them
     * in the Y dimension.  return var2 if the bounding boxes do not overlap or if var2 is closer to 0 then the
     * calculated offset.  Otherwise return the calculated offset.
     */
    public double calculateYOffset(AxisAlignedBB other,
                                   double offsetY) {
        return 0;
    }

    /**
     * if instance and the argument bounding boxes overlap in the Y and X dimensions, calculate the offset between them
     * in the Z dimension.  return var2 if the bounding boxes do not overlap or if var2 is closer to 0 then the
     * calculated offset.  Otherwise return the calculated offset.
     */
    public double calculateZOffset(AxisAlignedBB other,
                                   double offsetZ) {
        return 0;
    }

    /**
     * Returns whether the given bounding box intersects with this one. Args: axisAlignedBB
     */
    public boolean intersectsWith(AxisAlignedBB other) {
        return true;
    }

    /**
     * Returns if the supplied Vec3D is completely inside the bounding box
     */
    public boolean isVecInside(Vec3 vec) {
        return true;
    }

    /**
     * Returns the average length of the edges of the bounding box.
     */
    public double getAverageEdgeLength() {
        return 0;
    }

    /**
     * Returns a bounding box that is inset by the specified amounts
     */
    public AxisAlignedBB contract(double x,
                                  double y,
                                  double z) {
        return null;
    }

    /**
     *
     */
    public MovingObjectPosition calculateIntercept(Vec3 vecA,
                                                   Vec3 vecB) {
        return null;
    }

    /**
     * Checks if the specified vector is within the YZ dimensions of the bounding box. Args: Vec3D
     */
    private boolean isVecInYZ(Vec3 vec) {
        return true;
    }

    /**
     * Checks if the specified vector is within the XZ dimensions of the bounding box. Args: Vec3D
     */
    private boolean isVecInXZ(Vec3 vec) {
        return true;
    }

    /**
     * Checks if the specified vector is within the XY dimensions of the bounding box. Args: Vec3D
     */
    private boolean isVecInXY(Vec3 vec) {
        return true;
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
    public boolean func_181656_b() {
        return true;
    }

}