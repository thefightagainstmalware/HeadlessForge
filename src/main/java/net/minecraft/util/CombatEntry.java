package net.minecraft.util;

import net.minecraft.util.IChatComponent;

/**
 *
 */
public class CombatEntry extends Object {

    /**
     *
     */
    private final DamageSource damageSrc;

    /**
     *
     */
    private final int field_94567_b;

    /**
     *
     */
    private final float damage;

    /**
     *
     */
    private final float health;

    /**
     *
     */
    private final java.lang.String field_94566_e;

    /**
     *
     */
    private final float fallDistance;

    /**
     *
     */
    public CombatEntry(DamageSource damageSrcIn,
                       int p_i1564_2_,
                       float healthAmount,
                       float damageAmount,
                       String p_i1564_5_,
                       float fallDistanceIn) {
        this.damageSrc = damageSrcIn;
        this.field_94567_b = p_i1564_2_;
        this.health = healthAmount;
        this.damage = damageAmount;
        this.field_94566_e = p_i1564_5_;
        this.fallDistance = fallDistanceIn;
    }

    /**
     * Get the DamageSource of the CombatEntry instance.
     */
    public DamageSource getDamageSrc() {
        return null;
    }

    /**
     *
     */
    public float func_94563_c() {
        return 0;
    }

    /**
     * Returns true if <a href="../../../net/minecraft/util/DamageSource.html#getEntity--"><code>damage source</code></a> is a living entity
     */
    public boolean isLivingDamageSrc() {
        return true;
    }

    /**
     *
     */
    public String func_94562_g() {
        return null;
    }

    /**
     *
     */
    public IChatComponent getDamageSrcDisplayName() {
        return null;
    }

    /**
     *
     */
    public float getDamageAmount() {
        return 0;
    }

}