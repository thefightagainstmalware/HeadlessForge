package net.minecraft.client.renderer.block.statemap;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraftforge.fml.relauncher.Side;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public abstract class StateMapperBase extends Object implements IStateMapper {

    /**
     *
     */
    protected java.util.Map<IBlockState,ModelResourceLocation> mapStateModelLocations;

    /**
     *
     */
    public StateMapperBase() {
        
    }

    /**
     *
     */
    public String getPropertyString(java.util.Map<IProperty,Comparable> p_178131_1_) {
        return null;
    }

    /**
     *
     */
    public java.util.Map<IBlockState,ModelResourceLocation> putStateModelLocations(Block blockIn) {
        return null;
    }

    /**
     *
     */
    protected abstract ModelResourceLocation getModelResourceLocation(IBlockState state);

}