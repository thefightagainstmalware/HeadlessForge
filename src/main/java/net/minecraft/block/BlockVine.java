package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockVine extends Block
{
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool[] ALL_FACES = new PropertyBool[] {UP, NORTH, SOUTH, WEST, EAST};

    public BlockVine()
    {
        super(Material.vine);
        this.setDefaultState(this.blockState.getBaseState().withProperty(UP, Boolean.FALSE).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(UP, worldIn.func_180495_p(pos.up()).func_177230_c().isBlockNormalCube());
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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

    /**
     * Whether this Block can be replaced directly by other blocks (true for e.g. tall grass)
     */
    public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return true;
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        float f = 0.0625F;
        float f1 = 1.0F;
        float f2 = 1.0F;
        float f3 = 1.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag = false;

        if ((Boolean) worldIn.func_180495_p(pos).getValue(WEST))
        {
            f4 = Math.max(f4, 0.0625F);
            f1 = 0.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
            flag = true;
        }

        if (((Boolean)worldIn.func_180495_p(pos).getValue(EAST)).booleanValue())
        {
            f1 = Math.min(f1, 0.9375F);
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
            flag = true;
        }

        if (((Boolean)worldIn.func_180495_p(pos).getValue(NORTH)).booleanValue())
        {
            f6 = Math.max(f6, 0.0625F);
            f3 = 0.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }

        if (((Boolean)worldIn.func_180495_p(pos).getValue(SOUTH)).booleanValue())
        {
            f3 = Math.min(f3, 0.9375F);
            f6 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f2 = 0.0F;
            f5 = 1.0F;
            flag = true;
        }

        if (!flag && this.canPlaceOn(worldIn.func_180495_p(pos.up()).func_177230_c()))
        {
            f2 = Math.min(f2, 0.9375F);
            f5 = 1.0F;
            f1 = 0.0F;
            f4 = 1.0F;
            f3 = 0.0F;
            f6 = 1.0F;
        }

        this.setBlockBounds(f1, f2, f3, f4, f5, f6);
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    /**
     * Check whether this Block can be placed on the given side
     */
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
    {
        switch (side)
        {
            case UP:
                return this.canPlaceOn(worldIn.func_180495_p(pos.up()).func_177230_c());

            case NORTH:
            case SOUTH:
            case EAST:
            case WEST:
                return this.canPlaceOn(worldIn.func_180495_p(pos.offset(side.getOpposite())).func_177230_c());

            default:
                return false;
        }
    }

    private boolean canPlaceOn(Block blockIn)
    {
        return blockIn.func_149686_d() && blockIn.blockMaterial.blocksMovement();
    }

    private boolean recheckGrownSides(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState iblockstate = state;

        for (Object enumfacing0 : EnumFacing.Plane.HORIZONTAL)
        {
            EnumFacing enumfacing = (EnumFacing) enumfacing0;
            PropertyBool propertybool = getPropertyFor(enumfacing);

            if (((Boolean)state.getValue(propertybool)).booleanValue() && !this.canPlaceOn(worldIn.func_180495_p(pos.offset(enumfacing)).func_177230_c()))
            {
                IBlockState iblockstate1 = worldIn.func_180495_p(pos.up());

                if (iblockstate1.func_177230_c() != this || !((Boolean)iblockstate1.getValue(propertybool)).booleanValue())
                {
                    state = state.withProperty(propertybool, Boolean.valueOf(false));
                }
            }
        }

        if (getNumGrownFaces(state) == 0)
        {
            return false;
        }
        else
        {
            if (iblockstate != state)
            {
                worldIn.func_180501_a(pos, state, 2);
            }

            return true;
        }
    }

    public int getBlockColor()
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    public int getRenderColor(IBlockState state)
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return worldIn.getBiomeGenForCoords(pos).getFoliageColorAtPos(pos);
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.isRemote && !this.recheckGrownSides(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (worldIn.rand.nextInt(4) == 0)
            {
                int i = 4;
                int j = 5;
                boolean flag = false;
                label62:

                for (int k = -i; k <= i; ++k)
                {
                    for (int l = -i; l <= i; ++l)
                    {
                        for (int i1 = -1; i1 <= 1; ++i1)
                        {
                            if (worldIn.func_180495_p(pos.add(k, i1, l)).func_177230_c() == this)
                            {
                                --j;

                                if (j <= 0)
                                {
                                    flag = true;
                                    break label62;
                                }
                            }
                        }
                    }
                }

                EnumFacing enumfacing1 = EnumFacing.random(rand);
                BlockPos blockpos1 = pos.up();

                if (enumfacing1 == EnumFacing.UP && pos.func_177956_o() < 255 && worldIn.func_175623_d(blockpos1))
                {
                    if (!flag)
                    {
                        IBlockState iblockstate2 = state;

                        for (Object enumfacing30 : EnumFacing.Plane.HORIZONTAL)
                        {
                            EnumFacing enumfacing3 = (EnumFacing) enumfacing30;

                            if (rand.nextBoolean() || !this.canPlaceOn(worldIn.func_180495_p(blockpos1.offset(enumfacing3)).func_177230_c()))
                            {
                                iblockstate2 = iblockstate2.withProperty(getPropertyFor(enumfacing3), Boolean.valueOf(false));
                            }
                        }

                        if (((Boolean)iblockstate2.getValue(NORTH)).booleanValue() || ((Boolean)iblockstate2.getValue(EAST)).booleanValue() || ((Boolean)iblockstate2.getValue(SOUTH)).booleanValue() || ((Boolean)iblockstate2.getValue(WEST)).booleanValue())
                        {
                            worldIn.func_180501_a(blockpos1, iblockstate2, 2);
                        }
                    }
                }
                else if (enumfacing1.getAxis().isHorizontal() && !((Boolean)state.getValue(getPropertyFor(enumfacing1))).booleanValue())
                {
                    if (!flag)
                    {
                        BlockPos blockpos3 = pos.offset(enumfacing1);
                        Block block1 = worldIn.func_180495_p(blockpos3).func_177230_c();

                        if (block1.blockMaterial == Material.field_151579_a)
                        {
                            EnumFacing enumfacing2 = enumfacing1.rotateY();
                            EnumFacing enumfacing4 = enumfacing1.rotateYCCW();
                            boolean flag1 = ((Boolean)state.getValue(getPropertyFor(enumfacing2))).booleanValue();
                            boolean flag2 = ((Boolean)state.getValue(getPropertyFor(enumfacing4))).booleanValue();
                            BlockPos blockpos4 = blockpos3.offset(enumfacing2);
                            BlockPos blockpos = blockpos3.offset(enumfacing4);

                            if (flag1 && this.canPlaceOn(worldIn.func_180495_p(blockpos4).func_177230_c()))
                            {
                                worldIn.func_180501_a(blockpos3, this.func_176223_P().withProperty(getPropertyFor(enumfacing2), Boolean.valueOf(true)), 2);
                            }
                            else if (flag2 && this.canPlaceOn(worldIn.func_180495_p(blockpos).func_177230_c()))
                            {
                                worldIn.func_180501_a(blockpos3, this.func_176223_P().withProperty(getPropertyFor(enumfacing4), Boolean.valueOf(true)), 2);
                            }
                            else if (flag1 && worldIn.func_175623_d(blockpos4) && this.canPlaceOn(worldIn.func_180495_p(pos.offset(enumfacing2)).func_177230_c()))
                            {
                                worldIn.func_180501_a(blockpos4, this.func_176223_P().withProperty(getPropertyFor(enumfacing1.getOpposite()), Boolean.valueOf(true)), 2);
                            }
                            else if (flag2 && worldIn.func_175623_d(blockpos) && this.canPlaceOn(worldIn.func_180495_p(pos.offset(enumfacing4)).func_177230_c()))
                            {
                                worldIn.func_180501_a(blockpos, this.func_176223_P().withProperty(getPropertyFor(enumfacing1.getOpposite()), Boolean.valueOf(true)), 2);
                            }
                            else if (this.canPlaceOn(worldIn.func_180495_p(blockpos3.up()).func_177230_c()))
                            {
                                worldIn.func_180501_a(blockpos3, this.func_176223_P(), 2);
                            }
                        }
                        else if (block1.blockMaterial.isOpaque() && block1.func_149686_d())
                        {
                            worldIn.func_180501_a(pos, state.withProperty(getPropertyFor(enumfacing1), Boolean.valueOf(true)), 2);
                        }
                    }
                }
                else
                {
                    if (pos.func_177956_o() > 1)
                    {
                        BlockPos blockpos2 = pos.func_177977_b();
                        IBlockState iblockstate = worldIn.func_180495_p(blockpos2);
                        Block block = iblockstate.func_177230_c();

                        if (block.blockMaterial == Material.field_151579_a)
                        {
                            IBlockState iblockstate1 = state;

                            for (Object enumfacing0 : EnumFacing.Plane.HORIZONTAL)
                            {
                                EnumFacing enumfacing = (EnumFacing) enumfacing0;

                                if (rand.nextBoolean())
                                {
                                    iblockstate1 = iblockstate1.withProperty(getPropertyFor(enumfacing), Boolean.valueOf(false));
                                }
                            }

                            if (((Boolean)iblockstate1.getValue(NORTH)).booleanValue() || ((Boolean)iblockstate1.getValue(EAST)).booleanValue() || ((Boolean)iblockstate1.getValue(SOUTH)).booleanValue() || ((Boolean)iblockstate1.getValue(WEST)).booleanValue())
                            {
                                worldIn.func_180501_a(blockpos2, iblockstate1, 2);
                            }
                        }
                        else if (block == this)
                        {
                            IBlockState iblockstate3 = iblockstate;

                            for (Object enumfacing50 : EnumFacing.Plane.HORIZONTAL)
                            {
                                EnumFacing enumfacing5 = (EnumFacing) enumfacing50;
                                PropertyBool propertybool = getPropertyFor(enumfacing5);

                                if (rand.nextBoolean() && ((Boolean)state.getValue(propertybool)).booleanValue())
                                {
                                    iblockstate3 = iblockstate3.withProperty(propertybool, Boolean.valueOf(true));
                                }
                            }

                            if (((Boolean)iblockstate3.getValue(NORTH)).booleanValue() || ((Boolean)iblockstate3.getValue(EAST)).booleanValue() || ((Boolean)iblockstate3.getValue(SOUTH)).booleanValue() || ((Boolean)iblockstate3.getValue(WEST)).booleanValue())
                            {
                                worldIn.func_180501_a(blockpos2, iblockstate3, 2);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = this.func_176223_P().withProperty(UP, Boolean.valueOf(false)).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false));
        return facing.getAxis().isHorizontal() ? iblockstate.withProperty(getPropertyFor(facing.getOpposite()), Boolean.valueOf(true)) : iblockstate;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
    {
        if (!worldIn.isRemote && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() == Items.shears)
        {
            player.func_71029_a(StatList.mineBlockStatArray[Block.func_149682_b(this)]);
            spawnAsEntity(worldIn, pos, new ItemStack(Blocks.vine, 1, 0));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te);
        }
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
        return this.func_176223_P().withProperty(SOUTH, Boolean.valueOf((meta & 1) > 0)).withProperty(WEST, Boolean.valueOf((meta & 2) > 0)).withProperty(NORTH, Boolean.valueOf((meta & 4) > 0)).withProperty(EAST, Boolean.valueOf((meta & 8) > 0));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        int i = 0;

        if (((Boolean)state.getValue(SOUTH)).booleanValue())
        {
            i |= 1;
        }

        if (((Boolean)state.getValue(WEST)).booleanValue())
        {
            i |= 2;
        }

        if (((Boolean)state.getValue(NORTH)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(EAST)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {UP, NORTH, EAST, SOUTH, WEST});
    }

    public static PropertyBool getPropertyFor(EnumFacing side)
    {
        switch (side)
        {
            case UP:
                return UP;

            case NORTH:
                return NORTH;

            case SOUTH:
                return SOUTH;

            case EAST:
                return EAST;

            case WEST:
                return WEST;

            default:
                throw new IllegalArgumentException(side + " is an invalid choice");
        }
    }

    public static int getNumGrownFaces(IBlockState state)
    {
        int i = 0;

        for (PropertyBool propertybool : ALL_FACES)
        {
            if (((Boolean)state.getValue(propertybool)).booleanValue())
            {
                ++i;
            }
        }

        return i;
    }
}
