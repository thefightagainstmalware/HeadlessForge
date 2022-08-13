package net.minecraft.client.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

/**
 *
 */
public class BlockPos extends Vec3i {

    /**
     * The BlockPos with all coordinates 0
     */
    public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);

    /**
     *
     */
    private static final int NUM_X_BITS = 4;

    /**
     *
     */
    private static final int NUM_Z_BITS = 4;

    /**
     *
     */
    private static final int NUM_Y_BITS = 8;

    /**
     *
     */
    private static final int Y_SHIFT = 0;

    /**
     *
     */
    private static final int X_SHIFT = 0;

    /**
     *
     */
    private static final long X_MASK = 0xFF;

    /**
     *
     */
    private static final long Y_MASK = 0xFF;

    /**
     *
     */
    private static final long Z_MASK = 0xFF;

    /**
     *
     */
    public BlockPos(int x,
                    int y,
                    int z) {
        super(x, y, z);
    }

    /**
     *
     */
    public BlockPos(double x,
                    double y,
                    double z) {
        super(x, y, z);
    }

    /**
     *
     */
    public BlockPos(Entity source) {
        super(source.field_70165_t, source.field_70163_u, source.field_70161_v);
    }

    /**
     *
     */
    public BlockPos(Vec3 source) {
        super(source.xCoord, source.yCoord, source.zCoord);
    }

    /**
     *
     */
    public BlockPos(Vec3i source) {
        super(source.getX(), source.getY(), source.getZ());
    }

    /**
     * Add the given coordinates to the coordinates of this BlockPos
     */
    public BlockPos add(double x,
                        double y,
                        double z) {
        return null;
    }

    /**
     * Add the given coordinates to the coordinates of this BlockPos
     */
    public BlockPos add(int x,
                        int y,
                        int z) {
        return null;
    }

    /**
     * Add the given Vector to this BlockPos
     */
    public BlockPos add(Vec3i vec) {
        return null;
    }

    /**
     * Subtract the given Vector from this BlockPos
     */
    public BlockPos subtract(Vec3i vec) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block up
     */
    public BlockPos up() {
        return null;
    }

    /**
     * Offset this BlockPos n blocks up
     */
    public BlockPos up(int n) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block down
     */
    public BlockPos down() {
        return null;
    }

    /**
     * Offset this BlockPos n blocks down
     */
    public BlockPos down(int n) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block in northern direction
     */
    public BlockPos north() {
        return null;
    }

    /**
     * Offset this BlockPos n blocks in northern direction
     */
    public BlockPos north(int n) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block in southern direction
     */
    public BlockPos south() {
        return null;
    }

    /**
     * Offset this BlockPos n blocks in southern direction
     */
    public BlockPos south(int n) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block in western direction
     */
    public BlockPos west() {
        return null;
    }

    /**
     * Offset this BlockPos n blocks in western direction
     */
    public BlockPos west(int n) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block in eastern direction
     */
    public BlockPos east() {
        return null;
    }

    /**
     * Offset this BlockPos n blocks in eastern direction
     */
    public BlockPos east(int n) {
        return null;
    }

    /**
     * Offset this BlockPos 1 block in the given direction
     */
    public BlockPos offset(EnumFacing facing) {
        return null;
    }

    /**
     * Offsets this BlockPos n blocks in the given direction
     */
    public BlockPos offset(EnumFacing facing,
                           int n) {
        return null;
    }

    /**
     * Calculate the cross product of this and the given Vector
     */
    @Override
    public BlockPos crossProduct(Vec3i vec) {
        return null;
    }

    /**
     * Serialize this BlockPos into a long value
     */
    public long toLong() {
        return 0;
    }

    /**
     * Create a BlockPos from a serialized long value (created by toLong)
     */
    public static BlockPos fromLong(long serialized) {
        return null;
    }

    /**
     *
     */
    public static Iterable<BlockPos> getAllInBox(BlockPos from,
                                                           BlockPos to) {
        return null;
    }

    /**
     *
     */
    public static Iterable<BlockPos.MutableBlockPos> getAllInBoxMutable(BlockPos from,
                                                                                  BlockPos to) {
        return null;
    }

    /**
     * Returns a version of this BlockPos that is guaranteed to be Immutable.
     * In most cases this will return 'this', but if 'this' is an instance of
     * MutableBlockPos it will return a new instance of BlockPos with the same values.
     * 
     * When storing a parameter given to you for an extended period of time, make sure you
     * use this in case the value is changed internally.
     * @return An immutable BlockPos.
     */
    public BlockPos getImmutable() {
        return null;
    }

    public class MutableBlockPos {
    }
}