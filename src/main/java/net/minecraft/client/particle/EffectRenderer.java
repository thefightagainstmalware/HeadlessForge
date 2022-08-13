package net.minecraft.client.particle;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

/**
 *
 */
public class EffectRenderer extends Object {

    /**
     *
     */
    private static final ResourceLocation particleTextures = new ResourceLocation("textures/particle/particles.png");

    /**
     * Reference to the World object.
     */
    protected World worldObj;

    /**
     *
     */
    private java.util.List<EntityFX>[][] fxLayers;

    /**
     *
     */
    private java.util.List<EntityParticleEmitter> particleEmitters;

    /**
     *
     */
    private TextureManager renderer;

    /**
     * RNG.
     */
    private java.util.Random rand;

    /**
     *
     */
    private java.util.Map<java.lang.Integer,IParticleFactory> particleTypes;

    /**
     *
     */
    public EffectRenderer(World worldIn,
                          TextureManager rendererIn) {

    }

    /**
     *
     */
    private void registerVanillaParticles() {
        return;
    }

    /**
     *
     */
    public void registerParticle(int id,
                                 IParticleFactory particleFactory) {
        return;
    }

    /**
     *
     */
    public void emitParticleAtEntity(Entity entityIn,
                                     EnumParticleTypes particleTypes) {
        return;
    }

    /**
     * Spawns the relevant particle according to the particle id.
     */
    public EntityFX spawnEffectParticle(int particleId,
                                        double p_178927_2_,
                                        double p_178927_4_,
                                        double p_178927_6_,
                                        double p_178927_8_,
                                        double p_178927_10_,
                                        double p_178927_12_,
                                        int... p_178927_14_) {
        return null;
    }

    /**
     *
     */
    public void addEffect(EntityFX effect) {
        return;
    }

    /**
     *
     */
    public void updateEffects() {
        return;
    }

    /**
     *
     */
    private void updateEffectLayer(int p_178922_1_) {
        return;
    }

    /**
     *
     */
    private void updateEffectAlphaLayer(java.util.List<EntityFX> p_178925_1_) {
        return;
    }

    /**
     *
     */
    private void tickParticle(EntityFX p_178923_1_) {
        return;
    }

    /**
     * Renders all current particles. Args player, partialTickTime
     */
    public void renderParticles(Entity entityIn,
                                float partialTicks) {
        return;
    }

    /**
     *
     */
    public void renderLitParticles(Entity entityIn,
                                   float p_78872_2_) {
        return;
    }

    /**
     *
     */
    public void clearEffects(World worldIn) {
        return;
    }

    /**
     *
     */
    public void addBlockDestroyEffects(BlockPos pos,
                                       IBlockState state) {
        return;
    }

    /**
     * Adds block hit particles for the specified block
     */
    public void addBlockHitEffects(BlockPos pos,
                                   EnumFacing side) {
        return;
    }

    /**
     *
     */
    public void moveToAlphaLayer(EntityFX effect) {
        return;
    }

    /**
     *
     */
    public void moveToNoAlphaLayer(EntityFX effect) {
        return;
    }

    /**
     *
     */
    private void moveToLayer(EntityFX effect,
                             int p_178924_2_,
                             int p_178924_3_) {
        return;
    }

    /**
     *
     */
    public String getStatistics() {
        return null;
    }

    /**
     *
     */
    public void addBlockHitEffects(BlockPos pos,
                                   MovingObjectPosition target) {
        return;
    }

}