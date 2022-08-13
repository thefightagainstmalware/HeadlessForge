package net.minecraft.client.renderer;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class BlockFluidRenderer extends Object {

    /**
     *
     */
    private TextureAtlasSprite[] atlasSpritesLava;

    /**
     *
     */
    private TextureAtlasSprite[] atlasSpritesWater;

    /**
     *
     */
    public BlockFluidRenderer() {
        
    }

    /**
     *
     */
    protected void initAtlasSprites() {
        return;
    }

    /**
     *
     */
    public boolean renderFluid(IBlockAccess blockAccess,
                               IBlockState blockStateIn,
                               BlockPos blockPosIn,
                               WorldRenderer worldRendererIn) {
        return true;
    }

    /**
     *
     */
    private float getFluidHeight(IBlockAccess blockAccess,
                                 BlockPos blockPosIn,
                                 Material blockMaterial) {
        return 0;
    }

}