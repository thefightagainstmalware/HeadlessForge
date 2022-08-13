package net.minecraft.entity.effect;

import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class EntityLightningBolt extends EntityWeatherEffect {

    /**
     * Declares which state the lightning bolt is in. Whether it's in the air, hit the ground, etc.
     */
    private int lightningState;

    /**
     * A random long that is used to change the vertex of the lightning rendered in RenderLightningBolt
     */
    public long boltVertex;

    /**
     * Determines the time before the EntityLightningBolt is destroyed. It is a random integer decremented over time.
     */
    private int boltLivingTime;

    /**
     *
     */
    public EntityLightningBolt(World worldIn,
                               double posX,
                               double posY,
                               double posZ) {
        super(worldIn);
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
    protected void entityInit() {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

}