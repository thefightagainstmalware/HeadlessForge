package net.minecraft.block;

import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class BlockAir extends Block {

    /**
     *
     */
    protected BlockAir() {
        super(Material.field_151579_a);
    }

    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    @Override
    public int getRenderType() {
        return 0;
    }

    /**
     *
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBox(World worldIn,
                                                 BlockPos pos,
                                                 IBlockState state) {
        return null;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    @Override
    public boolean isOpaqueCube() {
        return true;
    }

    /**
     *
     */
    @Override
    public boolean canCollideCheck(IBlockState state,
                                   boolean hitIfLiquid) {
        return true;
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    @Override
    public void dropBlockAsItemWithChance(World worldIn,
                                          BlockPos pos,
                                          IBlockState state,
                                          float chance,
                                          int fortune) {
        return;
    }

    /**
     * Whether this Block can be replaced directly by other blocks (true for e.g. tall grass)
     */
    @Override
    public boolean isReplaceable(World worldIn,
                                 BlockPos pos) {
        return true;
    }

}