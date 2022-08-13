package net.minecraft.entity.boss;

import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class EntityDragonPart extends Entity {

    /**
     * The dragon entity this dragon part belongs to
     */
    public final IEntityMultiPart entityDragonObj;

    /**
     *
     */
    public final java.lang.String partName;

    /**
     *
     */
    public EntityDragonPart(IEntityMultiPart parent,
                            String partName,
                            float base,
                            float sizeHeight) {
        super(parent.getWorld());
        this.entityDragonObj = parent;
        this.partName = partName;

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

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source,
                                    float amount) {
        return true;
    }

    /**
     * Returns true if Entity argument is equal to this Entity
     */
    @Override
    public boolean isEntityEqual(Entity entityIn) {
        return true;
    }

}