package net.minecraft.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;

/**
 *
 */
public abstract class EntityMob extends EntityCreature implements IMob {

    /**
     *
     */
    public EntityMob(World worldIn) {
        super(worldIn);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
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
    protected String getSwimSound() {
        return null;
    }

    /**
     *
     */
    @Override
    protected String getSplashSound() {
        return null;
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
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        return null;
    }

    /**
     *
     */
    @Override
    protected String getFallSoundString(int damageValue) {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return true;
    }

    /**
     *
     */
    @Override
    public float getBlockPathWeight(BlockPos pos) {
        return 0;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel() {
        return true;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     * Entity won't drop items or experience points if this returns false
     */
    @Override
    protected boolean canDropLoot() {
        return true;
    }

}