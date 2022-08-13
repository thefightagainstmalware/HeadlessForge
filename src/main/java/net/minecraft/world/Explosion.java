package net.minecraft.world;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import com.google.common.collect.Lists;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import com.google.common.collect.Maps;
import net.minecraft.util.Vec3;

/**
 *
 */
public class Explosion extends Object {

    /**
     * whether or not the explosion sets fire to blocks around it
     */
    private final boolean isFlaming;

    /**
     * whether or not this explosion spawns smoke particles
     */
    private final boolean isSmoking;

    /**
     *
     */
    private final java.util.Random explosionRNG;

    /**
     *
     */
    private final World worldObj;

    /**
     *
     */
    private final double explosionX;

    /**
     *
     */
    private final double explosionY;

    /**
     *
     */
    private final double explosionZ;

    /**
     *
     */
    private final Entity exploder;

    /**
     *
     */
    private final float explosionSize;

    /**
     *
     */
    private final java.util.List<BlockPos> affectedBlockPositions;

    /**
     *
     */
    private final java.util.Map<EntityPlayer,Vec3> playerKnockbackMap;

    /**
     *
     */
    private final Vec3 position = new Vec3(0.0D, 0.0D, 0.0D);

    /**
     *
     */
    public Explosion(World worldIn,
                     Entity p_i45752_2_,
                     double p_i45752_3_,
                     double p_i45752_5_,
                     double p_i45752_7_,
                     float p_i45752_9_,
                     java.util.List<BlockPos> p_i45752_10_) {
        this(worldIn, p_i45752_2_, p_i45752_3_, p_i45752_5_, p_i45752_7_, p_i45752_9_, false, true, p_i45752_10_);
    }

    /**
     *
     */
    public Explosion(World worldIn,
                     Entity p_i45753_2_,
                     double p_i45753_3_,
                     double p_i45753_5_,
                     double p_i45753_7_,
                     float p_i45753_9_,
                     boolean p_i45753_10_,
                     boolean p_i45753_11_,
                     java.util.List<BlockPos> p_i45753_12_) {
        this(worldIn, p_i45753_2_, p_i45753_3_, p_i45753_5_, p_i45753_7_, p_i45753_9_, p_i45753_10_, p_i45753_11_);
        this.affectedBlockPositions.addAll(p_i45753_12_);
    }

    /**
     *
     */
    public Explosion(World worldIn,
                     Entity p_i45754_2_,
                     double p_i45754_3_,
                     double p_i45754_5_,
                     double p_i45754_7_,
                     float size,
                     boolean p_i45754_10_,
                     boolean p_i45754_11_) {
        this.explosionRNG = new Random();
        this.affectedBlockPositions = Lists.<BlockPos>newArrayList();
        this.playerKnockbackMap = Maps.<EntityPlayer, Vec3>newHashMap();
        this.worldObj = worldIn;
        this.exploder = p_i45754_2_;
        this.explosionSize = size;
        this.explosionX = p_i45754_3_;
        this.explosionY = p_i45754_5_;
        this.explosionZ = p_i45754_7_;
        this.isFlaming = p_i45754_10_;
        this.isSmoking = p_i45754_11_;
    }

    /**
     * Does the first part of the explosion (destroy blocks)
     */
    public void doExplosionA() {
        return;
    }

    /**
     * Does the second part of the explosion (sound, particles, drop spawn)
     */
    public void doExplosionB(boolean spawnParticles) {
        return;
    }

    /**
     *
     */
    public java.util.Map<EntityPlayer,Vec3> getPlayerKnockbackMap() {
        return null;
    }

    /**
     * Returns either the entity that placed the explosive block, the entity that caused the explosion or null.
     */
    public EntityLivingBase getExplosivePlacedBy() {
        return null;
    }

    /**
     *
     */
    public void func_180342_d() {
        return;
    }

    /**
     *
     */
    public java.util.List<BlockPos> getAffectedBlockPositions() {
        return null;
    }

    /**
     *
     */
    public Vec3 getPosition() {
        return null;
    }

}