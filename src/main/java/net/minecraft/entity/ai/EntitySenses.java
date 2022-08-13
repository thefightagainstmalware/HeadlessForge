package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.Entity;

/**
 *
 */
public class EntitySenses extends Object {

    /**
     *
     */
    EntityLiving entityObj;

    /**
     *
     */
    java.util.List<Entity> seenEntities;

    /**
     *
     */
    java.util.List<Entity> unseenEntities;

    /**
     *
     */
    public EntitySenses(EntityLiving entityObjIn) {
        
    }

    /**
     * Clears canSeeCachePositive and canSeeCacheNegative.
     */
    public void clearSensingCache() {
        return;
    }

    /**
     * Checks, whether 'our' entity can see the entity given as argument (true) or not (false), caching the result.
     */
    public boolean canSee(Entity entityIn) {
        return true;
    }

}