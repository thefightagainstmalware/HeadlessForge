package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceGate extends BlockDirectional
{
    public static final PropertyBool OPEN = PropertyBool.create("open");
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyBool IN_WALL = PropertyBool.create("in_wall");

    public BlockFenceGate(BlockPlanks.EnumType p_i46394_1_)
    {
        super(Material.wood, p_i46394_1_.func_181070_c());
        this.setDefaultState(this.blockState.getBaseState().withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)).withProperty(IN_WALL, Boolean.valueOf(false)));
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        EnumFacing.Axis enumfacing$axis = ((EnumFacing)state.getValue(FACING)).getAxis();

        if (enumfacing$axis == EnumFacing.Axis.Z && (worldIn.func_180495_p(pos.west()).func_177230_c() == Blocks.cobblestone_wall || worldIn.func_180495_p(pos.east()).func_177230_c() == Blocks.cobblestone_wall) || enumfacing$axis == EnumFacing.Axis.X && (worldIn.func_180495_p(pos.north()).func_177230_c() == Blocks.cobblestone_wall || worldIn.func_180495_p(pos.south()).func_177230_c() == Blocks.cobblestone_wall))
        {
            state = state.withProperty(IN_WALL, Boolean.valueOf(true));
        }

        return state;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.func_180495_p(pos.func_177977_b()).func_177230_c().func_149688_o().isSolid() ? super.canPlaceBlockAt(worldIn, pos) : false;
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        if (((Boolean)state.getValue(OPEN)).booleanValue())
        {
            return null;
        }
        else
        {
            EnumFacing.Axis enumfacing$axis = ((EnumFacing)state.getValue(FACING)).getAxis();
            return enumfacing$axis == EnumFacing.Axis.Z ? new AxisAlignedBB((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)((float)pos.func_177952_p() + 0.375F), (double)(pos.func_177958_n() + 1), (double)((float)pos.func_177956_o() + 1.5F), (double)((float)pos.func_177952_p() + 0.625F)) : new AxisAlignedBB((double)((float)pos.func_177958_n() + 0.375F), (double)pos.func_177956_o(), (double)pos.func_177952_p(), (double)((float)pos.func_177958_n() + 0.625F), (double)((float)pos.func_177956_o() + 1.5F), (double)(pos.func_177952_p() + 1));
        }
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        EnumFacing.Axis enumfacing$axis = ((EnumFacing)worldIn.func_180495_p(pos).getValue(FACING)).getAxis();

        if (enumfacing$axis == EnumFacing.Axis.Z)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
        }
        else
        {
            this.setBlockBounds(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
        }
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

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return ((Boolean)worldIn.func_180495_p(pos).getValue(OPEN)).booleanValue();
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.func_176223_P().withProperty(FACING, placer.getHorizontalFacing()).withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)).withProperty(IN_WALL, Boolean.valueOf(false));
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (((Boolean)state.getValue(OPEN)).booleanValue())
        {
            state = state.withProperty(OPEN, Boolean.valueOf(false));
            worldIn.func_180501_a(pos, state, 2);
        }
        else
        {
            EnumFacing enumfacing = EnumFacing.fromAngle((double)playerIn.field_70177_z);

            if (state.getValue(FACING) == enumfacing.getOpposite())
            {
                state = state.withProperty(FACING, enumfacing);
            }

            state = state.withProperty(OPEN, Boolean.valueOf(true));
            worldIn.func_180501_a(pos, state, 2);
        }

        worldIn.playAuxSFXAtEntity(playerIn, ((Boolean)state.getValue(OPEN)).booleanValue() ? 1003 : 1006, pos, 0);
        return true;
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.isRemote)
        {
            boolean flag = worldIn.isBlockPowered(pos);

            if (flag || neighborBlock.canProvidePower())
            {
                if (flag && !((Boolean)state.getValue(OPEN)).booleanValue() && !((Boolean)state.getValue(POWERED)).booleanValue())
                {
                    worldIn.func_180501_a(pos, state.withProperty(OPEN, Boolean.valueOf(true)).withProperty(POWERED, Boolean.valueOf(true)), 2);
                    worldIn.playAuxSFXAtEntity((EntityPlayer)null, 1003, pos, 0);
                }
                else if (!flag && ((Boolean)state.getValue(OPEN)).booleanValue() && ((Boolean)state.getValue(POWERED)).booleanValue())
                {
                    worldIn.func_180501_a(pos, state.withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)), 2);
                    worldIn.playAuxSFXAtEntity((EntityPlayer)null, 1006, pos, 0);
                }
                else if (flag != ((Boolean)state.getValue(POWERED)).booleanValue())
                {
                    worldIn.func_180501_a(pos, state.withProperty(POWERED, Boolean.valueOf(flag)), 2);
                }
            }
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(OPEN, Boolean.valueOf((meta & 4) != 0)).withProperty(POWERED, Boolean.valueOf((meta & 8) != 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();

        if (((Boolean)state.getValue(POWERED)).booleanValue())
        {
            i |= 8;
        }

        if (((Boolean)state.getValue(OPEN)).booleanValue())
        {
            i |= 4;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, OPEN, POWERED, IN_WALL});
    }
}
