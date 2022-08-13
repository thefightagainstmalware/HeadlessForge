package net.minecraft.entity;

import net.minecraft.world.World;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.util.DamageSource;

/**
 *
 */
public interface IEntityMultiPart {

    /**
     *
     */
    World getWorld();

    /**
     *
     */
    boolean attackEntityFromPart(EntityDragonPart dragonPart,
                                 DamageSource source,
                                 float p_70965_3_);

}