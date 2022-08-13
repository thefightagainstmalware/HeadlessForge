package net.minecraft.client.particle;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.WorldRenderer;

/**
 *
 */
public class EntityParticleEmitter extends EntityFX {

    /**
     *
     */
    private Entity attachedEntity;

    /**
     *
     */
    private int age;

    /**
     *
     */
    private int lifetime;

    /**
     *
     */
    private EnumParticleTypes particleTypes;

    /**
     *
     */
    public EntityParticleEmitter(World worldIn,
                                 Entity p_i46279_2_,
                                 EnumParticleTypes particleTypesIn) {
        super(worldIn, p_i46279_2_.field_70165_t, p_i46279_2_.field_70163_u, p_i46279_2_.field_70161_v);
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

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     *
     */
    @Override
    public int getFXLayer() {
        return 0;
    }

}