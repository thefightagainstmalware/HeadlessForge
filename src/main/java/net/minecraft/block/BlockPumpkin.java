package net.minecraft.block;

import com.google.common.base.Predicate;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.util.BlockPos;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPumpkin extends BlockDirectional
{
    private BlockPattern snowmanBasePattern;
    private BlockPattern snowmanPattern;
    private BlockPattern golemBasePattern;
    private BlockPattern golemPattern;
    private static final Predicate<IBlockState> field_181085_Q = new Predicate<IBlockState>()
    {
        public boolean apply(IBlockState p_apply_1_)
        {
            return p_apply_1_ != null && (p_apply_1_.func_177230_c() == Blocks.field_150423_aK || p_apply_1_.func_177230_c() == Blocks.lit_pumpkin);
        }
    };

    protected BlockPumpkin()
    {
        super(Material.gourd, MapColor.adobeColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.trySpawnGolem(worldIn, pos);
    }

    public boolean canDispenserPlace(World worldIn, BlockPos pos)
    {
        return this.getSnowmanBasePattern().match(worldIn, pos) != null || this.getGolemBasePattern().match(worldIn, pos) != null;
    }

    private void trySpawnGolem(World worldIn, BlockPos pos)
    {

    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.func_180495_p(pos).func_177230_c().blockMaterial.isReplaceable() && World.doesBlockHaveSolidTopSurface(worldIn, pos.func_177977_b());
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.func_176223_P().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState func_176203_a(int meta)
    {
        return this.func_176223_P().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int func_176201_c(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }

    protected BlockPattern getSnowmanBasePattern()
    {
        if (this.snowmanBasePattern == null)
        {
            this.snowmanBasePattern = FactoryBlockPattern.start().aisle(new String[] {" ", "#", "#"}).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.snow))).build();
        }

        return this.snowmanBasePattern;
    }

    protected BlockPattern getSnowmanPattern()
    {
        if (this.snowmanPattern == null)
        {
            this.snowmanPattern = FactoryBlockPattern.start().aisle(new String[] {"^", "#", "#"}).where('^', BlockWorldState.hasState(field_181085_Q)).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.snow))).build();
        }

        return this.snowmanPattern;
    }

    protected BlockPattern getGolemBasePattern()
    {
        if (this.golemBasePattern == null)
        {
            this.golemBasePattern = FactoryBlockPattern.start().aisle(new String[] {"~ ~", "###", "~#~"}).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.field_150350_a))).build();
        }

        return this.golemBasePattern;
    }

    protected BlockPattern getGolemPattern()
    {
        if (this.golemPattern == null)
        {
            this.golemPattern = FactoryBlockPattern.start().aisle(new String[] {"~^~", "###", "~#~"}).where('^', BlockWorldState.hasState(field_181085_Q)).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.field_150350_a))).build();
        }

        return this.golemPattern;
    }
}
