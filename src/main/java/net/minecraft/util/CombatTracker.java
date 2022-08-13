package net.minecraft.util;

import com.google.common.collect.Lists;
import net.minecraft.util.IChatComponent;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class CombatTracker extends Object {

    /**
     *
     */
    private final java.util.List<CombatEntry> combatEntries = Lists.<CombatEntry>newArrayList();

    /**
     * The entity tracked.
     */
    private final EntityLivingBase fighter;

    /**
     *
     */
    private int field_94555_c;

    /**
     *
     */
    private int field_152775_d;

    /**
     *
     */
    private int field_152776_e;

    /**
     *
     */
    private boolean field_94552_d;

    /**
     *
     */
    private boolean field_94553_e;

    /**
     *
     */
    private java.lang.String field_94551_f;

    /**
     *
     */
    public CombatTracker(EntityLivingBase fighterIn) {
        this.fighter = fighterIn;
    }

    /**
     *
     */
    public void func_94545_a() {
        return;
    }

    /**
     * Adds an entry for the combat tracker
     */
    public void trackDamage(DamageSource damageSrc,
                            float healthIn,
                            float damageAmount) {
        return;
    }

    /**
     *
     */
    public IChatComponent getDeathMessage() {
        return null;
    }

    /**
     *
     */
    public EntityLivingBase func_94550_c() {
        return null;
    }

    /**
     *
     */
    private CombatEntry func_94544_f() {
        return null;
    }

    /**
     *
     */
    private String func_94548_b(CombatEntry p_94548_1_) {
        return null;
    }

    /**
     *
     */
    public int func_180134_f() {
        return 0;
    }

    /**
     *
     */
    private void func_94542_g() {
        return;
    }

    /**
     * Resets this trackers list of combat entries
     */
    public void reset() {
        return;
    }

    /**
     * Returns EntityLivingBase assigned for this CombatTracker
     */
    public EntityLivingBase getFighter() {
        return null;
    }

}