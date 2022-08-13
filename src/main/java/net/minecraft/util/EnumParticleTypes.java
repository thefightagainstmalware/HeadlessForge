package net.minecraft.util;

import com.google.common.collect.Maps;

/**
 *
 */
public enum EnumParticleTypes {
    BARRIER ,BLOCK_CRACK ,BLOCK_DUST ,CLOUD ,CRIT ,CRIT_MAGIC ,DRIP_LAVA ,DRIP_WATER ,ENCHANTMENT_TABLE ,EXPLOSION_HUGE ,EXPLOSION_LARGE ,EXPLOSION_NORMAL ,FIREWORKS_SPARK ,FLAME ,FOOTSTEP ,HEART ,ITEM_CRACK ,ITEM_TAKE ,LAVA ,MOB_APPEARANCE ,NOTE ,PORTAL ,REDSTONE ,SLIME ,SMOKE_LARGE ,SMOKE_NORMAL ,SNOW_SHOVEL ,SNOWBALL ,SPELL ,SPELL_INSTANT ,SPELL_MOB ,SPELL_MOB_AMBIENT ,SPELL_WITCH ,SUSPENDED ,SUSPENDED_DEPTH ,TOWN_AURA ,VILLAGER_ANGRY ,VILLAGER_HAPPY ,WATER_BUBBLE ,WATER_DROP ,WATER_SPLASH ,WATER_WAKE;

    EnumParticleTypes(Object... args) {
        this.particleName = this.name().toLowerCase();
        this.particleID = this.ordinal();
        this.shouldIgnoreRange = false;
        this.argumentCount = args.length;
    }

    /**
     *
     */
    private final java.lang.String particleName;

    /**
     *
     */
    private final int particleID;

    /**
     *
     */
    private final boolean shouldIgnoreRange;

    /**
     *
     */
    private final int argumentCount;

    /**
     *
     */
    private static final java.util.Map<java.lang.Integer,EnumParticleTypes> PARTICLES = Maps.newHashMap();

    /**
     *
     */
    private static final java.lang.String[] PARTICLE_NAMES = func_179349_a();

    /**
     *
     */
    public static String[] func_179349_a() {
        return null;
    }

    /**
     *
     */
    public String func_179346_b() {
        return null;
    }

    /**
     *
     */
    public int getParticleID() {
        return 0;
    }

    /**
     *
     */
    public int func_179345_d() {
        return 0;
    }

    /**
     *
     */
    public boolean getShouldIgnoreRange() {
        return true;
    }

    /**
     *
     */
    public boolean func_179343_f() {
        return true;
    }

    /**
     * Gets the relative EnumParticleTypes by id.
     */
    public static EnumParticleTypes getParticleFromId(int particleId) {
        return null;
    }

}