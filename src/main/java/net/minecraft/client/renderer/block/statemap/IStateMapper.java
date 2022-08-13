package net.minecraft.client.renderer.block.statemap;

import java.util.Map;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public interface IStateMapper {

    /**
     *
     */
    java.util.Map<IBlockState,ModelResourceLocation> putStateModelLocations(Block blockIn);

}