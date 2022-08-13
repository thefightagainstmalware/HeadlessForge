package net.minecraft.client.util;

import net.minecraft.inventory.IInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public final class EntitySelectors extends Object {

    /**
     *
     */
    public static final Object selectAnything = new Object();

    /**
     *
     */
    public static final boolean IS_STANDALONE = true;

    /**
     *
     */
    public static final Object selectInventories = new Object();

    /**
     *
     */
    public static final boolean NOT_SPECTATING = true;

    /**
     *
     */
    public EntitySelectors() {
        
    }

}