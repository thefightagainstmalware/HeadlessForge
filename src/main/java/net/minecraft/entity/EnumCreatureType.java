package net.minecraft.entity;

import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;

/**
 *
 */
public enum EnumCreatureType {
    MONSTER(IMob.class, 70, Material.field_151579_a, false, false),
    CREATURE(EntityAnimal.class, 10, Material.field_151579_a, true, true),
    AMBIENT(EntityAmbientCreature.class, 15, Material.field_151579_a, true, false),
    WATER_CREATURE(EntityWaterMob.class, 5, Material.water, true, false);
    private EnumCreatureType(Class <? extends IAnimals > creatureClassIn, int maxNumberOfCreatureIn, Material creatureMaterialIn, boolean isPeacefulCreatureIn, boolean isAnimalIn)
    {
        this.creatureClass = creatureClassIn;
        this.maxNumberOfCreature = maxNumberOfCreatureIn;
        this.creatureMaterial = creatureMaterialIn;
        this.isPeacefulCreature = isPeacefulCreatureIn;
        this.isAnimal = isAnimalIn;
    }
    /**
     *
     */
    private final java.lang.Class<? extends IAnimals> creatureClass ;

    /**
     *
     */
    private final int maxNumberOfCreature;

    /**
     *
     */
    private final Material creatureMaterial;

    /**
     * A flag indicating whether this creature type is peaceful.
     */
    private final boolean isPeacefulCreature;

    /**
     * Whether this creature type is an animal.
     */
    private final boolean isAnimal;


    /**
     *
     */
    public Class<? extends IAnimals> getCreatureClass() {
        return null;
    }

    /**
     *
     */
    public int getMaxNumberOfCreature() {
        return 0;
    }

    /**
     * Gets whether or not this creature type is peaceful.
     */
    public boolean getPeacefulCreature() {
        return true;
    }

    /**
     * Return whether this creature type is an animal.
     */
    public boolean getAnimal() {
        return true;
    }

}