package net.minecraft.entity.passive;

import net.minecraft.entity.IEntityOwnable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.World;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public abstract class EntityTameable extends EntityAnimal implements IEntityOwnable {

    /**
     *
     */
    protected EntityAISit aiSit;

    /**
     *
     */
    public EntityTameable(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
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

    /**
     * Play the taming effect, will either be hearts or smoke depending on status
     */
    protected void playTameEffect(boolean play) {
        return;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     *
     */
    public boolean isTamed() {
        return true;
    }

    /**
     *
     */
    public void setTamed(boolean tamed) {
        return;
    }

    /**
     *
     */
    protected void setupTamedAI() {
        return;
    }

    /**
     *
     */
    public boolean isSitting() {
        return true;
    }

    /**
     *
     */
    public void setSitting(boolean sitting) {
        return;
    }

    /**
     *
     */
    public String getOwnerId() {
        return null;
    }

    /**
     *
     */
    public void setOwnerId(String ownerUuid) {
        return;
    }

    /**
     *
     */
    public EntityLivingBase getOwner() {
        return null;
    }

    /**
     *
     */
    public boolean isOwner(EntityLivingBase entityIn) {
        return true;
    }

    /**
     * Returns the AITask responsible of the sit logic
     */
    public EntityAISit getAISit() {
        return null;
    }

    /**
     *
     */
    public boolean shouldAttackEntity(EntityLivingBase p_142018_1_,
                                      EntityLivingBase p_142018_2_) {
        return true;
    }

    /**
     *
     */
    @Override
    public Team func_96124_cp() {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean isOnSameTeam(EntityLivingBase otherEntity) {
        return true;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource cause) {
        return;
    }

}