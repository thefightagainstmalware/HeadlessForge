package net.minecraft.client.renderer;

import com.google.common.collect.Maps;
import net.minecraft.client.renderer.block.statemap.BlockStateMapper;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelManager;

/**
 *
 */
public class BlockModelShapes extends Object {

    /**
     *
     */
    private final java.util.Map<IBlockState,IBakedModel> bakedModelStore = Maps.newHashMap();

    /**
     *
     */
    private final BlockStateMapper blockStateMapper = new BlockStateMapper();

    /**
     *
     */
    private final ModelManager modelManager;

    /**
     *
     */
    public BlockModelShapes(ModelManager manager) {
        this.modelManager = manager;
    }

    /**
     *
     */
    public BlockStateMapper getBlockStateMapper() {
        return null;
    }

    /**
     *
     */
    public TextureAtlasSprite getTexture(IBlockState state) {
        return null;
    }

    /**
     *
     */
    public IBakedModel getModelForState(IBlockState state) {
        return null;
    }

    /**
     *
     */
    public ModelManager getModelManager() {
        return null;
    }

    /**
     *
     */
    public void reloadModels() {
        return;
    }

    /**
     *
     */
    public void registerBlockWithStateMapper(Block assoc,
                                             IStateMapper stateMapper) {
        return;
    }

    /**
     *
     */
    public void registerBuiltInBlocks(Block... builtIns) {
        return;
    }

    /**
     *
     */
    private void registerAllBlocks() {
        return;
    }

}