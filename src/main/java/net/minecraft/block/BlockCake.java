package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCake extends Block
{
    public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 6);

    protected BlockCake()
    {
        super(Material.cake);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BITES, Integer.valueOf(0)));
        this.setTickRandomly(true);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        float f = 0.0625F;
        float f1 = (float)(1 + ((Integer)worldIn.func_180495_p(pos).getValue(BITES)).intValue() * 2) / 16.0F;
        float f2 = 0.5F;
        this.setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        this.setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        float f = 0.0625F;
        float f1 = (float)(1 + ((Integer)state.getValue(BITES)).intValue() * 2) / 16.0F;
        float f2 = 0.5F;
        return new AxisAlignedBB((double)((float)pos.func_177958_n() + f1), (double)pos.func_177956_o(), (double)((float)pos.func_177952_p() + f), (double)((float)(pos.func_177958_n() + 1) - f), (double)((float)pos.func_177956_o() + f2), (double)((float)(pos.func_177952_p() + 1) - f));
    }

    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
        return this.getCollisionBoundingBox(worldIn, pos, worldIn.func_180495_p(pos));
    }

    public boolean func_149686_d()
    {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        this.eatCake(worldIn, pos, state, playerIn);
        return true;
    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        this.eatCake(worldIn, pos, worldIn.func_180495_p(pos), playerIn);
    }

    private void eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        if (player.canEat(false))
        {
            player.func_71029_a(StatList.field_181724_H);
            player.getFoodStats().addStats(2, 0.1F);
            int i = ((Integer)state.getValue(BITES)).intValue();

            if (i < 6)
            {
                worldIn.func_180501_a(pos, state.withProperty(BITES, Integer.valueOf(i + 1)), 3);
            }
            else
            {
                worldIn.setBlockToAir(pos);
            }
        }
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
        }
    }

    private boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return worldIn.func_180495_p(pos.func_177977_b()).func_177230_c().func_149688_o().isSolid();
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 0;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

    public Item getItem(World worldIn, BlockPos pos)
    {
        return Items.field_151105_aU;
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
        return this.func_176223_P().withProperty(BITES, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((Integer)state.getValue(BITES)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {BITES});
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return (7 - ((Integer)worldIn.func_180495_p(pos).getValue(BITES)).intValue()) * 2;
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }
}
