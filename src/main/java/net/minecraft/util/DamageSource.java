package net.minecraft.util;

import net.minecraft.util.IChatComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class DamageSource extends Object {

    /**
     *
     */
    public static DamageSource inFire;

    /**
     *
     */
    public static DamageSource lightningBolt;

    /**
     *
     */
    public static DamageSource onFire;

    /**
     *
     */
    public static DamageSource lava;

    /**
     *
     */
    public static DamageSource inWall;

    /**
     *
     */
    public static DamageSource drown;

    /**
     *
     */
    public static DamageSource starve;

    /**
     *
     */
    public static DamageSource cactus;

    /**
     *
     */
    public static DamageSource fall;

    /**
     *
     */
    public static DamageSource outOfWorld;

    /**
     *
     */
    public static DamageSource generic;

    /**
     *
     */
    public static DamageSource magic;

    /**
     *
     */
    public static DamageSource wither;

    /**
     *
     */
    public static DamageSource anvil;

    /**
     *
     */
    public static DamageSource fallingBlock;

    /**
     * This kind of damage can be blocked or not.
     */
    private boolean isUnblockable;

    /**
     *
     */
    private boolean isDamageAllowedInCreativeMode;

    /**
     * Whether or not the damage ignores modification by potion effects or enchantments.
     */
    private boolean damageIsAbsolute;

    /**
     *
     */
    private float hungerDamage;

    /**
     * This kind of damage is based on fire or not.
     */
    private boolean fireDamage;

    /**
     * This kind of damage is based on a projectile or not.
     */
    private boolean projectile;

    /**
     * Whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    private boolean difficultyScaled;

    /**
     * Whether the damage is magic based.
     */
    private boolean magicDamage;

    /**
     *
     */
    private boolean explosion;

    /**
     *
     */
    public java.lang.String damageType;

    /**
     *
     */
    public DamageSource(String damageTypeIn) {
        
    }

    /**
     *
     */
    public static DamageSource causeMobDamage(EntityLivingBase mob) {
        return null;
    }

    /**
     * returns an EntityDamageSource of type player
     */
    public static DamageSource causePlayerDamage(EntityPlayer player) {
        return null;
    }

    /**
     * returns EntityDamageSourceIndirect of an arrow
     */
    public static DamageSource causeArrowDamage(EntityArrow arrow,
                                                Entity p_76353_1_) {
        return null;
    }

    /**
     * returns EntityDamageSourceIndirect of a fireball
     */
    public static DamageSource causeFireballDamage(EntityFireball fireball,
                                                   Entity p_76362_1_) {
        return null;
    }

    /**
     *
     */
    public static DamageSource causeThrownDamage(Entity p_76356_0_,
                                                 Entity p_76356_1_) {
        return null;
    }

    /**
     *
     */
    public static DamageSource causeIndirectMagicDamage(Entity p_76354_0_,
                                                        Entity p_76354_1_) {
        return null;
    }

    /**
     * Returns the EntityDamageSource of the Thorns enchantment
     */
    public static DamageSource causeThornsDamage(Entity p_92087_0_) {
        return null;
    }

    /**
     *
     */
    public static DamageSource setExplosionSource(Explosion explosionIn) {
        return null;
    }

    /**
     * Returns true if the damage is projectile based.
     */
    public boolean isProjectile() {
        return true;
    }

    /**
     * Define the damage type as projectile based.
     */
    public DamageSource setProjectile() {
        return null;
    }

    /**
     *
     */
    public boolean isExplosion() {
        return true;
    }

    /**
     *
     */
    public DamageSource setExplosion() {
        return null;
    }

    /**
     *
     */
    public boolean isUnblockable() {
        return true;
    }

    /**
     * How much satiate(food) is consumed by this DamageSource
     */
    public float getHungerDamage() {
        return 0;
    }

    /**
     *
     */
    public boolean canHarmInCreative() {
        return true;
    }

    /**
     * Whether or not the damage ignores modification by potion effects or enchantments.
     */
    public boolean isDamageAbsolute() {
        return true;
    }

    /**
     *
     */
    public Entity getSourceOfDamage() {
        return null;
    }

    /**
     *
     */
    public Entity getEntity() {
        return null;
    }

    /**
     *
     */
    public DamageSource setDamageBypassesArmor() {
        return null;
    }

    /**
     *
     */
    public DamageSource setDamageAllowedInCreativeMode() {
        return null;
    }

    /**
     * Sets a value indicating whether the damage is absolute (ignores modification by potion effects or enchantments),
     * and also clears out hunger damage.
     */
    public DamageSource setDamageIsAbsolute() {
        return null;
    }

    /**
     * Define the damage type as fire based.
     */
    public DamageSource setFireDamage() {
        return null;
    }

    /**
     * Gets the death message that is displayed when the player dies
     */
    public IChatComponent getDeathMessage(EntityLivingBase p_151519_1_) {
        return null;
    }

    /**
     * Returns true if the damage is fire based.
     */
    public boolean isFireDamage() {
        return true;
    }

    /**
     * Return the name of damage type.
     */
    public String getDamageType() {
        return null;
    }

    /**
     * Set whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    public DamageSource setDifficultyScaled() {
        return null;
    }

    /**
     * Return whether this damage source will have its damage amount scaled based on the current difficulty.
     */
    public boolean isDifficultyScaled() {
        return true;
    }

    /**
     * Returns true if the damage is magic based.
     */
    public boolean isMagicDamage() {
        return true;
    }

    /**
     * Define the damage type as magic based.
     */
    public DamageSource setMagicDamage() {
        return null;
    }

    /**
     *
     */
    public boolean isCreativePlayer() {
        return true;
    }

}