package net.minecraft.entity.item;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityEnderPearl extends EntityThrowable {

    /**
     *
     */
    private EntityLivingBase field_181555_c;

    /**
     *
     */
    public EntityEnderPearl(World p_i46455_1_) {
        super(p_i46455_1_);
    }

    /**
     *
     */
    public EntityEnderPearl(World worldIn,
                            EntityLivingBase p_i1783_2_) {
        super(worldIn, p_i1783_2_);
    }

    /**
     *
     */
    public EntityEnderPearl(World worldIn,
                            double p_i1784_2_,
                            double p_i1784_4_,
                            double p_i1784_6_) {
        super(worldIn, p_i1784_2_, p_i1784_4_, p_i1784_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_) {
        return;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

}