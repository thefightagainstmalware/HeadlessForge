package net.minecraft.entity.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class EntityXPOrb extends Entity {

    /**
     * A constantly increasing value that RenderXPOrb uses to control the colour shifting (Green / yellow)
     */
    public int xpColor;

    /**
     * The age of the XP orb in ticks.
     */
    public int xpOrbAge;

    /**
     *
     */
    public int delayBeforeCanPickup;

    /**
     * The health of this XP orb.
     */
    private int xpOrbHealth;

    /**
     * This is how much XP this orb has.
     */
    public int xpValue;

    /**
     * The closest EntityPlayer to this orb.
     */
    private EntityPlayer closestPlayer;

    /**
     * Threshold color for tracking players
     */
    private int xpTargetColor;

    /**
     *
     */
    public EntityXPOrb(World worldIn,
                       double x,
                       double y,
                       double z,
                       int expValue) {
        super(worldIn);
    }

    /**
     *
     */
    public EntityXPOrb(World worldIn) {
        super(worldIn);
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    @Override
    protected boolean canTriggerWalking() {
        return true;
    }

    /**
     *
     */
    protected void entityInit() {
        return;
    }

    /**
     *
     */
    @Override
    public int getBrightnessForRender(float partialTicks) {
        return 0;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        return;
    }

    /**
     * Returns if this entity is in water and will end up adding the waters velocity to the entity
     */
    @Override
    public boolean handleWaterMovement() {
        return true;
    }

    /**
     * Will deal the specified amount of damage to the entity if the entity isn't immune to fire damage. Args:
     * amountDamage
     */
    @Override
    protected void dealFireDamage(int amount) {
        return;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source,
                                    float amount) {
        return true;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        return;
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn) {
        return;
    }

    /**
     * Returns the XP value of this XP orb.
     */
    public int getXpValue() {
        return 0;
    }

    /**
     * Returns a number from 1 to 10 based on how much XP this orb is worth. This is used by RenderXPOrb to determine
     * what texture to use.
     */
    public int getTextureByXP() {
        return 0;
    }

    /**
     * Get a fragment of the maximum experience points value for the supplied value of experience points value.
     */
    public static int getXPSplit(int expValue) {
        return 0;
    }

    /**
     * If returns false, the item will not inflict any damage against entities.
     */
    @Override
    public boolean canAttackWithItem() {
        return true;
    }

}