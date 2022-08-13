package net.minecraft.client.renderer;

import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.resources.model.IBakedModel;

/**
 *
 */
public class BlockModelRenderer extends Object {

    /**
     *
     */
    public BlockModelRenderer() {
        
    }

    /**
     *
     */
    public boolean renderModel(IBlockAccess blockAccessIn,
                               IBakedModel modelIn,
                               IBlockState blockStateIn,
                               BlockPos blockPosIn,
                               WorldRenderer worldRendererIn) {
        return true;
    }

    /**
     *
     */
    public boolean renderModel(IBlockAccess blockAccessIn,
                               IBakedModel modelIn,
                               IBlockState blockStateIn,
                               BlockPos blockPosIn,
                               WorldRenderer worldRendererIn,
                               boolean checkSides) {
        return true;
    }

    /**
     *
     */
    public boolean renderModelAmbientOcclusion(IBlockAccess blockAccessIn,
                                               IBakedModel modelIn,
                                               Block blockIn,
                                               BlockPos blockPosIn,
                                               WorldRenderer worldRendererIn,
                                               boolean checkSides) {
        return true;
    }

    /**
     *
     */
    public boolean renderModelStandard(IBlockAccess blockAccessIn,
                                       IBakedModel modelIn,
                                       Block blockIn,
                                       BlockPos blockPosIn,
                                       WorldRenderer worldRendererIn,
                                       boolean checkSides) {
        return true;
    }

    /**
     *
     */
    private void renderModelAmbientOcclusionQuads(IBlockAccess blockAccessIn,
                                                  Block blockIn,
                                                  BlockPos blockPosIn,
                                                  WorldRenderer worldRendererIn,
                                                  java.util.List<BakedQuad> listQuadsIn,
                                                  float[] quadBounds,
                                                  java.util.BitSet boundsFlags,
                                                  BlockModelRenderer.AmbientOcclusionFace aoFaceIn) {
        return;
    }

    /**
     *
     */
    private void fillQuadBounds(Block blockIn,
                                int[] vertexData,
                                EnumFacing facingIn,
                                float[] quadBounds,
                                java.util.BitSet boundsFlags) {
        return;
    }

    /**
     *
     */
    private void renderModelStandardQuads(IBlockAccess blockAccessIn,
                                          Block blockIn,
                                          BlockPos blockPosIn,
                                          EnumFacing faceIn,
                                          int brightnessIn,
                                          boolean ownBrightness,
                                          WorldRenderer worldRendererIn,
                                          java.util.List<BakedQuad> listQuadsIn,
                                          java.util.BitSet boundsFlags) {
        return;
    }

    /**
     *
     */
    public void renderModelBrightnessColor(IBakedModel bakedModel,
                                           float p_178262_2_,
                                           float red,
                                           float green,
                                           float blue) {
        return;
    }

    /**
     *
     */
    public void renderModelBrightness(IBakedModel model,
                                      IBlockState p_178266_2_,
                                      float brightness,
                                      boolean p_178266_4_) {
        return;
    }

    /**
     *
     */
    private void renderModelBrightnessColorQuads(float brightness,
                                                 float red,
                                                 float green,
                                                 float blue,
                                                 java.util.List<BakedQuad> listQuads) {
        return;
    }

    public class AmbientOcclusionFace {
    }
}