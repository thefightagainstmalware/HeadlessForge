package net.minecraft.util;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import net.minecraft.entity.Entity;

public class BlockPos extends Vec3i
{
    /** The BlockPos with all coordinates 0 */
    public static final BlockPos ORIGIN = new BlockPos(0, 0, 0);
    private static final int NUM_X_BITS = 1 + MathHelper.calculateLogBaseTwo(MathHelper.roundUpToPowerOfTwo(30000000));
    private static final int NUM_Z_BITS = NUM_X_BITS;
    private static final int NUM_Y_BITS = 64 - NUM_X_BITS - NUM_Z_BITS;
    private static final int Y_SHIFT = 0 + NUM_Z_BITS;
    private static final int X_SHIFT = Y_SHIFT + NUM_Y_BITS;
    private static final long X_MASK = (1L << NUM_X_BITS) - 1L;
    private static final long Y_MASK = (1L << NUM_Y_BITS) - 1L;
    private static final long Z_MASK = (1L << NUM_Z_BITS) - 1L;

    public BlockPos(int x, int y, int z)
    {
        super(x, y, z);
    }

    public BlockPos(double x, double y, double z)
    {
        super(x, y, z);
    }

    public BlockPos(Entity source)
    {
        this(source.field_70165_t, source.field_70163_u, source.field_70161_v);
    }

    public BlockPos(Vec3 source)
    {
        this(source.field_72450_a, source.field_72448_b, source.field_72449_c);
    }

    public BlockPos(Vec3i source)
    {
        this(source.func_177958_n(), source.func_177956_o(), source.func_177952_p());
    }

    /**
     * Add the given coordinates to the coordinates of this BlockPos
     */
    public BlockPos add(double x, double y, double z)
    {
        return x == 0.0D && y == 0.0D && z == 0.0D ? this : new BlockPos((double)this.func_177958_n() + x, (double)this.func_177956_o() + y, (double)this.func_177952_p() + z);
    }

    /**
     * Add the given coordinates to the coordinates of this BlockPos
     */
    public BlockPos add(int x, int y, int z)
    {
        return x == 0 && y == 0 && z == 0 ? this : new BlockPos(this.func_177958_n() + x, this.func_177956_o() + y, this.func_177952_p() + z);
    }

    /**
     * Add the given Vector to this BlockPos
     */
    public BlockPos func_177971_a(Vec3i vec)
    {
        return vec.func_177958_n() == 0 && vec.func_177956_o() == 0 && vec.func_177952_p() == 0 ? this : new BlockPos(this.func_177958_n() + vec.func_177958_n(), this.func_177956_o() + vec.func_177956_o(), this.func_177952_p() + vec.func_177952_p());
    }

    /**
     * Subtract the given Vector from this BlockPos
     */
    public BlockPos subtract(Vec3i vec)
    {
        return vec.func_177958_n() == 0 && vec.func_177956_o() == 0 && vec.func_177952_p() == 0 ? this : new BlockPos(this.func_177958_n() - vec.func_177958_n(), this.func_177956_o() - vec.func_177956_o(), this.func_177952_p() - vec.func_177952_p());
    }

    /**
     * Offset this BlockPos 1 block up
     */
    public BlockPos up()
    {
        return this.up(1);
    }

    /**
     * Offset this BlockPos n blocks up
     */
    public BlockPos up(int n)
    {
        return this.offset(EnumFacing.UP, n);
    }

    /**
     * Offset this BlockPos 1 block down
     */
    public BlockPos func_177977_b()
    {
        return this.down(1);
    }

    /**
     * Offset this BlockPos n blocks down
     */
    public BlockPos down(int n)
    {
        return this.offset(EnumFacing.DOWN, n);
    }

    /**
     * Offset this BlockPos 1 block in northern direction
     */
    public BlockPos north()
    {
        return this.north(1);
    }

    /**
     * Offset this BlockPos n blocks in northern direction
     */
    public BlockPos north(int n)
    {
        return this.offset(EnumFacing.NORTH, n);
    }

    /**
     * Offset this BlockPos 1 block in southern direction
     */
    public BlockPos south()
    {
        return this.south(1);
    }

    /**
     * Offset this BlockPos n blocks in southern direction
     */
    public BlockPos south(int n)
    {
        return this.offset(EnumFacing.SOUTH, n);
    }

    /**
     * Offset this BlockPos 1 block in western direction
     */
    public BlockPos west()
    {
        return this.west(1);
    }

    /**
     * Offset this BlockPos n blocks in western direction
     */
    public BlockPos west(int n)
    {
        return this.offset(EnumFacing.WEST, n);
    }

    /**
     * Offset this BlockPos 1 block in eastern direction
     */
    public BlockPos east()
    {
        return this.east(1);
    }

    /**
     * Offset this BlockPos n blocks in eastern direction
     */
    public BlockPos east(int n)
    {
        return this.offset(EnumFacing.EAST, n);
    }

    /**
     * Offset this BlockPos 1 block in the given direction
     */
    public BlockPos offset(EnumFacing facing)
    {
        return this.offset(facing, 1);
    }

    /**
     * Offsets this BlockPos n blocks in the given direction
     */
    public BlockPos offset(EnumFacing facing, int n)
    {
        return n == 0 ? this : new BlockPos(this.func_177958_n() + facing.getFrontOffsetX() * n, this.func_177956_o() + facing.getFrontOffsetY() * n, this.func_177952_p() + facing.getFrontOffsetZ() * n);
    }

    /**
     * Calculate the cross product of this and the given Vector
     */
    public BlockPos crossProduct(Vec3i vec)
    {
        return new BlockPos(this.func_177956_o() * vec.func_177952_p() - this.func_177952_p() * vec.func_177956_o(), this.func_177952_p() * vec.func_177958_n() - this.func_177958_n() * vec.func_177952_p(), this.func_177958_n() * vec.func_177956_o() - this.func_177956_o() * vec.func_177958_n());
    }

    /**
     * Serialize this BlockPos into a long value
     */
    public long toLong()
    {
        return ((long)this.func_177958_n() & X_MASK) << X_SHIFT | ((long)this.func_177956_o() & Y_MASK) << Y_SHIFT | ((long)this.func_177952_p() & Z_MASK) << 0;
    }

    /**
     * Create a BlockPos from a serialized long value (created by toLong)
     */
    public static BlockPos fromLong(long serialized)
    {
        int i = (int)(serialized << 64 - X_SHIFT - NUM_X_BITS >> 64 - NUM_X_BITS);
        int j = (int)(serialized << 64 - Y_SHIFT - NUM_Y_BITS >> 64 - NUM_Y_BITS);
        int k = (int)(serialized << 64 - NUM_Z_BITS >> 64 - NUM_Z_BITS);
        return new BlockPos(i, j, k);
    }

    public static Iterable<BlockPos> getAllInBox(BlockPos from, BlockPos to)
    {
        final BlockPos blockpos = new BlockPos(Math.min(from.func_177958_n(), to.func_177958_n()), Math.min(from.func_177956_o(), to.func_177956_o()), Math.min(from.func_177952_p(), to.func_177952_p()));
        final BlockPos blockpos1 = new BlockPos(Math.max(from.func_177958_n(), to.func_177958_n()), Math.max(from.func_177956_o(), to.func_177956_o()), Math.max(from.func_177952_p(), to.func_177952_p()));
        return new Iterable<BlockPos>()
        {
            public Iterator<BlockPos> iterator()
            {
                return new AbstractIterator<BlockPos>()
                {
                    private BlockPos lastReturned = null;
                    protected BlockPos computeNext()
                    {
                        if (this.lastReturned == null)
                        {
                            this.lastReturned = blockpos;
                            return this.lastReturned;
                        }
                        else if (this.lastReturned.equals(blockpos1))
                        {
                            return (BlockPos)this.endOfData();
                        }
                        else
                        {
                            int i = this.lastReturned.func_177958_n();
                            int j = this.lastReturned.func_177956_o();
                            int k = this.lastReturned.func_177952_p();

                            if (i < blockpos1.func_177958_n())
                            {
                                ++i;
                            }
                            else if (j < blockpos1.func_177956_o())
                            {
                                i = blockpos.func_177958_n();
                                ++j;
                            }
                            else if (k < blockpos1.func_177952_p())
                            {
                                i = blockpos.func_177958_n();
                                j = blockpos.func_177956_o();
                                ++k;
                            }

                            this.lastReturned = new BlockPos(i, j, k);
                            return this.lastReturned;
                        }
                    }
                };
            }
        };
    }

    public static Iterable<BlockPos.MutableBlockPos> getAllInBoxMutable(BlockPos from, BlockPos to)
    {
        final BlockPos blockpos = new BlockPos(Math.min(from.func_177958_n(), to.func_177958_n()), Math.min(from.func_177956_o(), to.func_177956_o()), Math.min(from.func_177952_p(), to.func_177952_p()));
        final BlockPos blockpos1 = new BlockPos(Math.max(from.func_177958_n(), to.func_177958_n()), Math.max(from.func_177956_o(), to.func_177956_o()), Math.max(from.func_177952_p(), to.func_177952_p()));
        return new Iterable<BlockPos.MutableBlockPos>()
        {
            public Iterator<BlockPos.MutableBlockPos> iterator()
            {
                return new AbstractIterator<BlockPos.MutableBlockPos>()
                {
                    private BlockPos.MutableBlockPos theBlockPos = null;
                    protected BlockPos.MutableBlockPos computeNext()
                    {
                        if (this.theBlockPos == null)
                        {
                            this.theBlockPos = new BlockPos.MutableBlockPos(blockpos.func_177958_n(), blockpos.func_177956_o(), blockpos.func_177952_p());
                            return this.theBlockPos;
                        }
                        else if (this.theBlockPos.equals(blockpos1))
                        {
                            return (BlockPos.MutableBlockPos)this.endOfData();
                        }
                        else
                        {
                            int i = this.theBlockPos.func_177958_n();
                            int j = this.theBlockPos.func_177956_o();
                            int k = this.theBlockPos.func_177952_p();

                            if (i < blockpos1.func_177958_n())
                            {
                                ++i;
                            }
                            else if (j < blockpos1.func_177956_o())
                            {
                                i = blockpos.func_177958_n();
                                ++j;
                            }
                            else if (k < blockpos1.func_177952_p())
                            {
                                i = blockpos.func_177958_n();
                                j = blockpos.func_177956_o();
                                ++k;
                            }

                            this.theBlockPos.x = i;
                            this.theBlockPos.y = j;
                            this.theBlockPos.z = k;
                            return this.theBlockPos;
                        }
                    }
                };
            }
        };
    }

    public static final class MutableBlockPos extends BlockPos
    {
        private int x;
        private int y;
        private int z;

        public MutableBlockPos()
        {
            this(0, 0, 0);
        }

        public MutableBlockPos(int x_, int y_, int z_)
        {
            super(0, 0, 0);
            this.x = x_;
            this.y = y_;
            this.z = z_;
        }

        public int func_177958_n()
        {
            return this.x;
        }

        public int func_177956_o()
        {
            return this.y;
        }

        public int func_177952_p()
        {
            return this.z;
        }

        public BlockPos.MutableBlockPos func_181079_c(int p_181079_1_, int p_181079_2_, int p_181079_3_)
        {
            this.x = p_181079_1_;
            this.y = p_181079_2_;
            this.z = p_181079_3_;
            return this;
        }
    }
}
