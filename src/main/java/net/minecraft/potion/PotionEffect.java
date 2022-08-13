package net.minecraft.potion;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import net.minecraft.entity.EntityLivingBase;

/**
 *
 */
public class PotionEffect extends Object {

    /**
     *
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * ID value of the potion this effect matches.
     */
    private int potionID;

    /**
     * The duration of the potion effect
     */
    private int duration;

    /**
     * The amplifier of the potion effect
     */
    private int amplifier;

    /**
     * Whether the potion is a splash potion
     */
    private boolean isSplashPotion;

    /**
     * Whether the potion effect came from a beacon
     */
    private boolean isAmbient;

    /**
     * True if potion effect duration is at maximum, false otherwise.
     */
    private boolean isPotionDurationMax;

    /**
     *
     */
    private boolean showParticles;

    /**
     * List of ItemStack that can cure the potion effect
     */
    private java.util.List<ItemStack> curativeItems;

    /**
     *
     */
    public PotionEffect(int id,
                        int effectDuration) {
        
    }

    /**
     *
     */
    public PotionEffect(int id,
                        int effectDuration,
                        int effectAmplifier) {
        
    }

    /**
     *
     */
    public PotionEffect(int id,
                        int effectDuration,
                        int effectAmplifier,
                        boolean ambient,
                        boolean showParticles) {
        
    }

    /**
     *
     */
    public PotionEffect(PotionEffect other) {
        
    }

    /**
     * merges the input PotionEffect into this one if this.amplifier &lt;= tomerge.amplifier. The duration in the supplied
     * potion effect is assumed to be greater.
     */
    public void combine(PotionEffect other) {
        return;
    }

    /**
     * Retrieve the ID of the potion this effect matches.
     */
    public int getPotionID() {
        return 0;
    }

    /**
     *
     */
    public int getDuration() {
        return 0;
    }

    /**
     *
     */
    public int getAmplifier() {
        return 0;
    }

    /**
     * Set whether this potion is a splash potion.
     */
    public void setSplashPotion(boolean splashPotion) {
        return;
    }

    /**
     * Gets whether this potion effect originated from a beacon
     */
    public boolean getIsAmbient() {
        return true;
    }

    /**
     *
     */
    public boolean getIsShowParticles() {
        return true;
    }

    /**
     *
     */
    public boolean onUpdate(EntityLivingBase entityIn) {
        return true;
    }

    /**
     *
     */
    private int deincrementDuration() {
        return 0;
    }

    /**
     *
     */
    public void performEffect(EntityLivingBase entityIn) {
        return;
    }

    /**
     *
     */
    public String func_76453_d() {
        return null;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     * Write a custom potion effect to a potion item's NBT data.
     */
    public NBTTagCompound writeCustomPotionEffectToNBT(NBTTagCompound nbt) {
        return null;
    }

    /**
     * Read a custom potion effect from a potion item's NBT data.
     */
    public static PotionEffect readCustomPotionEffectFromNBT(NBTTagCompound nbt) {
        return null;
    }

    /**
     * Toggle the isPotionDurationMax field.
     */
    public void setPotionDurationMax(boolean maxDuration) {
        return;
    }

    /**
     *
     */
    public boolean getIsPotionDurationMax() {
        return true;
    }

    /**
     * Returns a list of curative items for the potion effect
     * @return The list (ItemStack) of curative items for the potion effect
     */
    public java.util.List<ItemStack> getCurativeItems() {
        return null;
    }

    /**
     * Checks the given ItemStack to see if it is in the list of curative items for the potion effect
     * @param stack The ItemStack being checked against the list of curative items for the potion effect
     * @return true if the given ItemStack is in the list of curative items for the potion effect, false otherwise
     */
    public boolean isCurativeItem(ItemStack stack) {
        return true;
    }

    /**
     * Sets the array of curative items for the potion effect
     * @param curativeItems The list of ItemStacks being set to the potion effect
     */
    public void setCurativeItems(java.util.List<ItemStack> curativeItems) {
        return;
    }

    /**
     * Adds the given stack to list of curative items for the potion effect
     * @param stack The ItemStack being added to the curative item list
     */
    public void addCurativeItem(ItemStack stack) {
        return;
    }

}