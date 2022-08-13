package net.minecraft.entity.player;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class PlayerCapabilities extends Object {

    /**
     * Disables player damage.
     */
    public boolean disableDamage;

    /**
     * Sets/indicates whether the player is flying.
     */
    public boolean isFlying;

    /**
     * whether or not to allow the player to fly when they double jump.
     */
    public boolean allowFlying;

    /**
     * Used to determine if creative mode is enabled, and therefore if items should be depleted on usage
     */
    public boolean field_75098_d;

    /**
     * Indicates whether the player is allowed to modify the surroundings
     */
    public boolean allowEdit;

    /**
     *
     */
    private float flySpeed;

    /**
     *
     */
    private float walkSpeed;

    /**
     *
     */
    public PlayerCapabilities() {
        
    }

    /**
     *
     */
    public void writeCapabilitiesToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     *
     */
    public void readCapabilitiesFromNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     *
     */
    public float getFlySpeed() {
        return 0;
    }

    /**
     *
     */
    public void setFlySpeed(float speed) {
        return;
    }

    /**
     *
     */
    public float getWalkSpeed() {
        return 0;
    }

    /**
     *
     */
    public void setPlayerWalkSpeed(float speed) {
        return;
    }

}