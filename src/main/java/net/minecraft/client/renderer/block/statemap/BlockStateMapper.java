package net.minecraft.client.renderer.block.statemap;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraftforge.fml.relauncher.Side;
import java.util.Set;
import com.google.common.base.Objects;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Collections;
import net.minecraft.block.state.IBlockState;
import com.google.common.collect.Sets;

/**
 *
 */
public class BlockStateMapper extends Object {

    /**
     *
     */
    private java.util.Map<Block,IStateMapper> blockStateMap;

    /**
     *
     */
    private java.util.Set<Block> setBuiltInBlocks;

    /**
     *
     */
    public BlockStateMapper() {
        
    }

    /**
     *
     */
    public void registerBlockStateMapper(Block p_178447_1_,
                                         IStateMapper p_178447_2_) {
        return;
    }

    /**
     *
     */
    public void registerBuiltInBlocks(Block... p_178448_1_) {
        return;
    }

    /**
     *
     */
    public java.util.Map<IBlockState,ModelResourceLocation> putAllStateModelLocations() {
        return null;
    }

}