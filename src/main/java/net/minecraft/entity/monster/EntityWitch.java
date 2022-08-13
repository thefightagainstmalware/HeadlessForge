package net.minecraft.entity.monster;

import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;

import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;

/**
 *
 */
public class EntityWitch extends EntityMob implements IRangedAttackMob {

    /**
     *
     */
    private static final java.util.UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");

    /**
     *
     */
    private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", -0.25D, 0)).setSaved(false);

    /**
     * List of items a witch should drop on death.
     */
    private static final Item[] witchDrops = new Item[] {Items.glowstone_dust, Items.sugar, Items.redstone, Items.spider_eye, Items.glass_bottle, Items.gunpowder, Items.stick, Items.stick};
    /**
     * Timer used as interval for a witch's attack, decremented every tick if aggressive and when reaches zero the witch
     * will throw a potion at the target entity.
     */
    private int witchAttackTimer;

    /**
     *
     */
    public EntityWitch(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected void entityInit() {
        return;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    protected String getLivingSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound() {
        return null;
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound() {
        return null;
    }

    /**
     * Set whether this witch is aggressive at an entity.
     */
    public void setAggressive(boolean aggressive) {
        return;
    }

    /**
     * Return whether this witch is aggressive at an entity.
     */
    public boolean getAggressive() {
        return true;
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        return;
    }

    /**
     *
     */
    @Override
    public void handleStatusUpdate(byte id) {
        return;
    }

    /**
     * Reduces damage, depending on potions
     */
    @Override
    protected float applyPotionDamageCalculations(DamageSource source,
                                                  float damage) {
        return 0;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    @Override
    protected void dropFewItems(boolean p_70628_1_,
                                int p_70628_2_) {
        return;
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_,
                                             float p_82196_2_) {
        return;
    }

    /**
     *
     */
    @Override
    public float getEyeHeight() {
        return 0;
    }

}