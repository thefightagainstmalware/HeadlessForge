package net.minecraft.entity.projectile;

import net.minecraft.world.World;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class EntityLargeFireball extends EntityFireball {

    /**
     *
     */
    public int explosionPower;

    /**
     *
     */
    public EntityLargeFireball(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityLargeFireball(World worldIn,
                               double x,
                               double y,
                               double z,
                               double accelX,
                               double accelY,
                               double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    /**
     *
     */
    public EntityLargeFireball(World worldIn,
                               EntityLivingBase shooter,
                               double accelX,
                               double accelY,
                               double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition movingObject) {
        return;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

}