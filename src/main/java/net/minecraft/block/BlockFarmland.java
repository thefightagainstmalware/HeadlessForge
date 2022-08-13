package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFarmland extends Block
{
    public static final PropertyInteger MOISTURE = PropertyInteger.create("moisture", 0, 7);

    protected BlockFarmland()
    {
        super(Material.ground);
        this.setDefaultState(this.blockState.getBaseState().withProperty(MOISTURE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return new AxisAlignedBB((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), (double)(pos.func_177958_n() + 1), (double)(pos.func_177956_o() + 1), (double)(pos.func_177952_p() + 1));
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

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int i = ((Integer)state.getValue(MOISTURE)).intValue();

        if (!this.hasWater(worldIn, pos) && !worldIn.canLightningStrike(pos.up()))
        {
            if (i > 0)
            {
                worldIn.func_180501_a(pos, state.withProperty(MOISTURE, Integer.valueOf(i - 1)), 2);
            }
            else if (!this.hasCrops(worldIn, pos))
            {
                worldIn.setBlockState(pos, Blocks.field_150346_d.func_176223_P());
            }
        }
        else if (i < 7)
        {
            worldIn.func_180501_a(pos, state.withProperty(MOISTURE, Integer.valueOf(7)), 2);
        }
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        if (entityIn instanceof EntityLivingBase)
        {
            if (!worldIn.isRemote && worldIn.rand.nextFloat() < fallDistance - 0.5F)
            {
                if (!(entityIn instanceof EntityPlayer) && !worldIn.func_82736_K().func_82766_b("mobGriefing"))
                {
                    return;
                }

                worldIn.setBlockState(pos, Blocks.field_150346_d.func_176223_P());
            }

            super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
        }
    }

    private boolean hasCrops(World worldIn, BlockPos pos)
    {
        Block block = worldIn.func_180495_p(pos.up()).func_177230_c();
        return block instanceof BlockCrops || block instanceof BlockStem;
    }

    private boolean hasWater(World worldIn, BlockPos pos)
    {
        for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4)))
        {
            if (worldIn.func_180495_p(blockpos$mutableblockpos).func_177230_c().func_149688_o() == Material.water)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);

        if (worldIn.func_180495_p(pos.up()).func_177230_c().func_149688_o().isSolid())
        {
            worldIn.setBlockState(pos, Blocks.field_150346_d.func_176223_P());
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        switch (side)
        {
            case UP:
                return true;

            case NORTH:
            case SOUTH:
            case WEST:
            case EAST:
                Block block = worldIn.func_180495_p(pos).func_177230_c();
                return !block.isOpaqueCube() && block != Blocks.farmland;

            default:
                return super.shouldSideBeRendered(worldIn, pos, side);
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Blocks.field_150346_d.getItemDropped(Blocks.field_150346_d.func_176223_P().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), rand, fortune);
    }

    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.func_150898_a(Blocks.field_150346_d);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(MOISTURE, Integer.valueOf(meta & 7));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((Integer)state.getValue(MOISTURE)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {MOISTURE});
    }
}
