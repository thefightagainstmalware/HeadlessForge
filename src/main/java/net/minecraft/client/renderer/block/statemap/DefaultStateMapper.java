package net.minecraft.client.renderer.block.statemap;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class DefaultStateMapper extends StateMapperBase {

    /**
     *
     */
    public DefaultStateMapper() {
        
    }

    /**
     *
     */
    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
        return null;
    }

}