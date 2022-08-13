package net.minecraft.client.particle;

import net.minecraft.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 *
 */
public class EntityBreakingFX extends EntityFX {

    /**
     *
     */
    protected EntityBreakingFX(World worldIn,
                               double posXIn,
                               double posYIn,
                               double posZIn,
                               Item p_i1195_8_) {
        super(worldIn, posXIn, posYIn, posZIn);
    }

    /**
     *
     */
    protected EntityBreakingFX(World worldIn,
                               double posXIn,
                               double posYIn,
                               double posZIn,
                               double xSpeedIn,
                               double ySpeedIn,
                               double zSpeedIn,
                               Item p_i1197_14_,
                               int p_i1197_15_) {
        super(worldIn, posXIn, posYIn, posZIn, xSpeedIn, ySpeedIn, zSpeedIn);
    }

    /**
     *
     */
    protected EntityBreakingFX(World worldIn,
                               double posXIn,
                               double posYIn,
                               double posZIn,
                               Item p_i1196_8_,
                               int p_i1196_9_) {
        super(worldIn, posXIn, posYIn, posZIn);
    }

    /**
     *
     */
    @Override
    public int getFXLayer() {
        return 0;
    }

    /**
     * Renders the particle
     */
    @Override
    public void renderParticle(WorldRenderer worldRendererIn,
                               Entity entityIn,
                               float partialTicks,
                               float p_180434_4_,
                               float p_180434_5_,
                               float p_180434_6_,
                               float p_180434_7_,
                               float p_180434_8_) {
        return;
    }

}