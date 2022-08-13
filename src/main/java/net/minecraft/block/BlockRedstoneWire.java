package net.minecraft.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneWire extends Block
{
    public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> NORTH = PropertyEnum.<BlockRedstoneWire.EnumAttachPosition>create("north", BlockRedstoneWire.EnumAttachPosition.class);
    public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> EAST = PropertyEnum.<BlockRedstoneWire.EnumAttachPosition>create("east", BlockRedstoneWire.EnumAttachPosition.class);
    public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> SOUTH = PropertyEnum.<BlockRedstoneWire.EnumAttachPosition>create("south", BlockRedstoneWire.EnumAttachPosition.class);
    public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> WEST = PropertyEnum.<BlockRedstoneWire.EnumAttachPosition>create("west", BlockRedstoneWire.EnumAttachPosition.class);
    public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 15);
    private boolean canProvidePower = true;
    private final Set<BlockPos> blocksNeedingUpdate = Sets.<BlockPos>newHashSet();

    public BlockRedstoneWire()
    {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(EAST, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(SOUTH, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(WEST, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(POWER, Integer.valueOf(0)));
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        state = state.withProperty(WEST, this.getAttachPosition(worldIn, pos, EnumFacing.WEST));
        state = state.withProperty(EAST, this.getAttachPosition(worldIn, pos, EnumFacing.EAST));
        state = state.withProperty(NORTH, this.getAttachPosition(worldIn, pos, EnumFacing.NORTH));
        state = state.withProperty(SOUTH, this.getAttachPosition(worldIn, pos, EnumFacing.SOUTH));
        return state;
    }

    private BlockRedstoneWire.EnumAttachPosition getAttachPosition(IBlockAccess worldIn, BlockPos pos, EnumFacing direction)
    {
        BlockPos blockpos = pos.offset(direction);
        Block block = worldIn.func_180495_p(pos.offset(direction)).func_177230_c();

        if (!canConnectTo(worldIn.func_180495_p(blockpos), direction) && (block.isBlockNormalCube() || !canConnectUpwardsTo(worldIn.func_180495_p(blockpos.func_177977_b()))))
        {
            Block block1 = worldIn.func_180495_p(pos.up()).func_177230_c();
            return !block1.isBlockNormalCube() && block.isBlockNormalCube() && canConnectUpwardsTo(worldIn.func_180495_p(blockpos.up())) ? BlockRedstoneWire.EnumAttachPosition.UP : BlockRedstoneWire.EnumAttachPosition.NONE;
        }
        else
        {
            return BlockRedstoneWire.EnumAttachPosition.SIDE;
        }
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean func_149686_d()
    {
        return false;
    }

    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        IBlockState iblockstate = worldIn.func_180495_p(pos);
        return iblockstate.func_177230_c() != this ? super.colorMultiplier(worldIn, pos, renderPass) : this.colorMultiplier(((Integer)iblockstate.getValue(POWER)).intValue());
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return World.doesBlockHaveSolidTopSurface(worldIn, pos.func_177977_b()) || worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() == Blocks.glowstone;
    }

    private IBlockState updateSurroundingRedstone(World worldIn, BlockPos pos, IBlockState state)
    {
        state = this.calculateCurrentChanges(worldIn, pos, pos, state);
        List<BlockPos> list = Lists.newArrayList(this.blocksNeedingUpdate);
        this.blocksNeedingUpdate.clear();

        for (BlockPos blockpos : list)
        {
            worldIn.notifyNeighborsOfStateChange(blockpos, this);
        }

        return state;
    }

    private IBlockState calculateCurrentChanges(World worldIn, BlockPos pos1, BlockPos pos2, IBlockState state)
    {
        IBlockState iblockstate = state;
        int i = ((Integer)state.getValue(POWER)).intValue();
        int j = 0;
        j = this.getMaxCurrentStrength(worldIn, pos2, j);
        this.canProvidePower = false;
        int k = worldIn.isBlockIndirectlyGettingPowered(pos1);
        this.canProvidePower = true;

        if (k > 0 && k > j - 1)
        {
            j = k;
        }

        int l = 0;

        for (Object enumfacing0 : EnumFacing.Plane.HORIZONTAL)
        {
            EnumFacing enumfacing = (EnumFacing) enumfacing0;
            BlockPos blockpos = pos1.offset(enumfacing);
            boolean flag = blockpos.func_177958_n() != pos2.func_177958_n() || blockpos.func_177952_p() != pos2.func_177952_p();

            if (flag)
            {
                l = this.getMaxCurrentStrength(worldIn, blockpos, l);
            }

            if (worldIn.func_180495_p(blockpos).func_177230_c().isNormalCube() && !worldIn.func_180495_p(pos1.up()).func_177230_c().isNormalCube())
            {
                if (flag && pos1.func_177956_o() >= pos2.func_177956_o())
                {
                    l = this.getMaxCurrentStrength(worldIn, blockpos.up(), l);
                }
            }
            else if (!worldIn.func_180495_p(blockpos).func_177230_c().isNormalCube() && flag && pos1.func_177956_o() <= pos2.func_177956_o())
            {
                l = this.getMaxCurrentStrength(worldIn, blockpos.func_177977_b(), l);
            }
        }

        if (l > j)
        {
            j = l - 1;
        }
        else if (j > 0)
        {
            --j;
        }
        else
        {
            j = 0;
        }

        if (k > j - 1)
        {
            j = k;
        }

        if (i != j)
        {
            state = state.withProperty(POWER, Integer.valueOf(j));

            if (worldIn.func_180495_p(pos1) == iblockstate)
            {
                worldIn.func_180501_a(pos1, state, 2);
            }

            this.blocksNeedingUpdate.add(pos1);

            for (EnumFacing enumfacing1 : EnumFacing.values())
            {
                this.blocksNeedingUpdate.add(pos1.offset(enumfacing1));
            }
        }

        return state;
    }

    /**
     * Calls World.notifyNeighborsOfStateChange() for all neighboring blocks, but only if the given block is a redstone
     * wire.
     */
    private void notifyWireNeighborsOfStateChange(World worldIn, BlockPos pos)
    {
        if (worldIn.func_180495_p(pos).func_177230_c() == this)
        {
            worldIn.notifyNeighborsOfStateChange(pos, this);

            for (EnumFacing enumfacing : EnumFacing.values())
            {
                worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
            }
        }
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            this.updateSurroundingRedstone(worldIn, pos, state);

            for (Object enumfacing : EnumFacing.Plane.VERTICAL)
            {
                worldIn.notifyNeighborsOfStateChange(pos.offset((EnumFacing) enumfacing), this);
            }

            for (Object enumfacing10 : EnumFacing.Plane.HORIZONTAL)
            {
                EnumFacing enumfacing1 = (EnumFacing) enumfacing10;
                this.notifyWireNeighborsOfStateChange(worldIn, pos.offset(enumfacing1));
            }

            for (Object enumfacing20 : EnumFacing.Plane.HORIZONTAL)
            {
                EnumFacing enumfacing2 = (EnumFacing) enumfacing20;
                BlockPos blockpos = pos.offset(enumfacing2);

                if (worldIn.func_180495_p(blockpos).func_177230_c().isNormalCube())
                {
                    this.notifyWireNeighborsOfStateChange(worldIn, blockpos.up());
                }
                else
                {
                    this.notifyWireNeighborsOfStateChange(worldIn, blockpos.func_177977_b());
                }
            }
        }
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);

        if (!worldIn.isRemote)
        {
            for (EnumFacing enumfacing : EnumFacing.values())
            {
                worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
            }

            this.updateSurroundingRedstone(worldIn, pos, state);

            for (Object enumfacing1 : EnumFacing.Plane.HORIZONTAL)
            {
                this.notifyWireNeighborsOfStateChange(worldIn, pos.offset((EnumFacing) enumfacing1));
            }

            for (Object enumfacing2 : EnumFacing.Plane.HORIZONTAL)
            {
                BlockPos blockpos = pos.offset((EnumFacing) enumfacing2);

                if (worldIn.func_180495_p(blockpos).func_177230_c().isNormalCube())
                {
                    this.notifyWireNeighborsOfStateChange(worldIn, blockpos.up());
                }
                else
                {
                    this.notifyWireNeighborsOfStateChange(worldIn, blockpos.func_177977_b());
                }
            }
        }
    }

    private int getMaxCurrentStrength(World worldIn, BlockPos pos, int strength)
    {
        if (worldIn.func_180495_p(pos).func_177230_c() != this)
        {
            return strength;
        }
        else
        {
            int i = ((Integer)worldIn.func_180495_p(pos).getValue(POWER)).intValue();
            return i > strength ? i : strength;
        }
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.isRemote)
        {
            if (this.canPlaceBlockAt(worldIn, pos))
            {
                this.updateSurroundingRedstone(worldIn, pos, state);
            }
            else
            {
                this.dropBlockAsItem(worldIn, pos, state, 0);
                worldIn.setBlockToAir(pos);
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.redstone;
    }

    public int getStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return !this.canProvidePower ? 0 : this.getWeakPower(worldIn, pos, state, side);
    }

    public int getWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
    {
        if (!this.canProvidePower)
        {
            return 0;
        }
        else
        {
            int i = ((Integer)state.getValue(POWER)).intValue();

            if (i == 0)
            {
                return 0;
            }
            else if (side == EnumFacing.UP)
            {
                return i;
            }
            else
            {
                EnumSet<EnumFacing> enumset = EnumSet.<EnumFacing>noneOf(EnumFacing.class);

                for (Object enumfacing0 : EnumFacing.Plane.HORIZONTAL)
                {
                    EnumFacing enumfacing = (EnumFacing) enumfacing0;

                    if (this.func_176339_d(worldIn, pos, enumfacing))
                    {
                        enumset.add(enumfacing);
                    }
                }

                if (side.getAxis().isHorizontal() && enumset.isEmpty())
                {
                    return i;
                }
                else if (enumset.contains(side) && !enumset.contains(side.rotateYCCW()) && !enumset.contains(side.rotateY()))
                {
                    return i;
                }
                else
                {
                    return 0;
                }
            }
        }
    }

    private boolean func_176339_d(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        BlockPos blockpos = pos.offset(side);
        IBlockState iblockstate = worldIn.func_180495_p(blockpos);
        Block block = iblockstate.func_177230_c();
        boolean flag = block.isNormalCube();
        boolean flag1 = worldIn.func_180495_p(pos.up()).func_177230_c().isNormalCube();
        return !flag1 && flag && canConnectUpwardsTo(worldIn, blockpos.up()) ? true : (canConnectTo(iblockstate, side) ? true : (block == Blocks.field_150416_aS && iblockstate.getValue(BlockRedstoneDiode.FACING) == side ? true : !flag && canConnectUpwardsTo(worldIn, blockpos.func_177977_b())));
    }

    protected static boolean canConnectUpwardsTo(IBlockAccess worldIn, BlockPos pos)
    {
        return canConnectUpwardsTo(worldIn.func_180495_p(pos));
    }

    protected static boolean canConnectUpwardsTo(IBlockState state)
    {
        return canConnectTo(state, (EnumFacing)null);
    }

    protected static boolean canConnectTo(IBlockState blockState, EnumFacing side)
    {
        Block block = blockState.func_177230_c();

        if (block == Blocks.redstone_wire)
        {
            return true;
        }
        else if (Blocks.field_150413_aR.isAssociated(block))
        {
            EnumFacing enumfacing = (EnumFacing)blockState.getValue(BlockRedstoneRepeater.FACING);
            return enumfacing == side || enumfacing.getOpposite() == side;
        }
        else
        {
            return block.canProvidePower() && side != null;
        }
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower()
    {
        return this.canProvidePower;
    }

    private int colorMultiplier(int powerLevel)
    {
        float f = (float)powerLevel / 15.0F;
        float f1 = f * 0.6F + 0.4F;

        if (powerLevel == 0)
        {
            f1 = 0.3F;
        }

        float f2 = f * f * 0.7F - 0.5F;
        float f3 = f * f * 0.6F - 0.7F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        int i = MathHelper.clamp_int((int)(f1 * 255.0F), 0, 255);
        int j = MathHelper.clamp_int((int)(f2 * 255.0F), 0, 255);
        int k = MathHelper.clamp_int((int)(f3 * 255.0F), 0, 255);
        return -16777216 | i << 16 | j << 8 | k;
    }

    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int i = ((Integer)state.getValue(POWER)).intValue();

        if (i != 0)
        {
            double d0 = (double)pos.func_177958_n() + 0.5D + ((double)rand.nextFloat() - 0.5D) * 0.2D;
            double d1 = (double)((float)pos.func_177956_o() + 0.0625F);
            double d2 = (double)pos.func_177952_p() + 0.5D + ((double)rand.nextFloat() - 0.5D) * 0.2D;
            float f = (float)i / 15.0F;
            float f1 = f * 0.6F + 0.4F;
            float f2 = Math.max(0.0F, f * f * 0.7F - 0.5F);
            float f3 = Math.max(0.0F, f * f * 0.6F - 0.7F);
            worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, (double)f1, (double)f2, (double)f3, new int[0]);
        }
    }

    public Item getItem(World worldIn, BlockPos pos)
    {
        return Items.redstone;
    }

    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(POWER, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((Integer)state.getValue(POWER)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {NORTH, EAST, SOUTH, WEST, POWER});
    }

    enum EnumAttachPosition implements IStringSerializable
    {
        UP("up"),
        SIDE("side"),
        NONE("none");

        private final String name;

        EnumAttachPosition(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this.name;
        }
    }
}
