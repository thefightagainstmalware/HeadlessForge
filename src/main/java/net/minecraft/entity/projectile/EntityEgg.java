package net.minecraft.entity.projectile;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityEgg extends EntityThrowable {

    /**
     *
     */
    public EntityEgg(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityEgg(World worldIn,
                     EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    /**
     *
     */
    public EntityEgg(World worldIn,
                     double x,
                     double y,
                     double z) {
        super(worldIn, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_) {
        return;
    }

}