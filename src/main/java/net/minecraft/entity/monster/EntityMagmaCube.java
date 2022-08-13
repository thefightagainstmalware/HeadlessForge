package net.minecraft.entity.monster;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.item.Item;

/**
 *
 */
public class EntityMagmaCube extends EntitySlime {

    /**
     *
     */
    public EntityMagmaCube(World worldIn) {
        super(worldIn);
    }

    /**
     *
     */
    @Override
    protected void applyEntityAttributes() {
        return;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    @Override
    public boolean isNotColliding() {
        return true;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    @Override
    public int getTotalArmorValue() {
        return 0;
    }

    /**
     *
     */
    @Override
    public int getBrightnessForRender(float partialTicks) {
        return 0;
    }

    /**
     * Gets how bright this entity is.
     */
    @Override
    public float getBrightness(float partialTicks) {
        return 0;
    }

    /**
     *
     */
    @Override
    protected EnumParticleTypes getParticleType() {
        return null;
    }

    /**
     *
     */
    @Override
    protected EntitySlime createInstance() {
        return null;
    }

    /**
     *
     */
    @Override
    protected Item getDropItem() {
        return null;
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
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    @Override
    public boolean isBurning() {
        return true;
    }

    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    @Override
    protected int getJumpDelay() {
        return 0;
    }

    /**
     *
     */
    @Override
    protected void alterSquishAmount() {
        return;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    @Override
    protected void jump() {
        return;
    }

    /**
     *
     */
    @Override
    protected void handleJumpLava() {
        return;
    }

    /**
     *
     */
    @Override
    public void fall(float distance,
                     float damageMultiplier) {
        return;
    }

    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    @Override
    protected boolean canDamagePlayer() {
        return true;
    }

    /**
     * Gets the amount of damage dealt to the player when "attacked" by the slime.
     */
    @Override
    protected int getAttackStrength() {
        return 0;
    }

    /**
     * Returns the name of the sound played when the slime jumps.
     */
    @Override
    protected String getJumpSound() {
        return null;
    }

    /**
     * Returns true if the slime makes a sound when it lands after a jump (based upon the slime's size)
     */
    @Override
    protected boolean makesSoundOnLand() {
        return true;
    }

}