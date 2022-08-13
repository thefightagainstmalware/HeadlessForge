package net.minecraft.client.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class EntityDamageSource extends DamageSource {

    /**
     *
     */
    protected Entity damageSourceEntity;

    /**
     * Whether this EntityDamageSource is from an entity wearing Thorns-enchanted armor.
     */
    private boolean isThornsDamage;

    /**
     *
     */
    public EntityDamageSource(String p_i1567_1_,
                              Entity damageSourceEntityIn) {
        super(p_i1567_1_);
    }

    /**
     * Sets this EntityDamageSource as originating from Thorns armor
     */
    public EntityDamageSource setIsThornsDamage() {
        return null;
    }

    /**
     *
     */
    public boolean getIsThornsDamage() {
        return true;
    }

    /**
     *
     */
    @Override
    public Entity getEntity() {
        return null;
    }

    /**
     * Gets the death message that is displayed when the player dies
     */
    @Override
    public IChatComponent getDeathMessage(EntityLivingBase p_151519_1_) {
        return null;
    }

    /**
     * Return whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    @Override
    public boolean isDifficultyScaled() {
        return true;
    }

}