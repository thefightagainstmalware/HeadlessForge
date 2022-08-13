package net.minecraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.EnumDifficulty;

/**
 *
 */
public class FoodStats extends Object {

    /**
     * The player's food level.
     */
    private int foodLevel;

    /**
     * The player's food saturation.
     */
    private float foodSaturationLevel;

    /**
     * The player's food exhaustion.
     */
    private float foodExhaustionLevel;

    /**
     * The player's food timer value.
     */
    private int foodTimer;

    /**
     *
     */
    private int prevFoodLevel;

    /**
     *
     */
    public FoodStats() {
        
    }

    /**
     * Add food stats.
     */
    public void addStats(int foodLevelIn,
                         float foodSaturationModifier) {
        return;
    }

    /**
     *
     */
    public void addStats(ItemFood foodItem,
                         ItemStack p_151686_2_) {
        return;
    }

    /**
     * Handles the food game logic.
     */
    public void onUpdate(EntityPlayer player) {
        return;
    }

    /**
     * Reads the food data for the player.
     */
    public void readNBT(NBTTagCompound p_75112_1_) {
        return;
    }

    /**
     * Writes the food data for the player.
     */
    public void writeNBT(NBTTagCompound p_75117_1_) {
        return;
    }

    /**
     * Get the player's food level.
     */
    public int getFoodLevel() {
        return 0;
    }

    /**
     *
     */
    public int getPrevFoodLevel() {
        return 0;
    }

    /**
     * Get whether the player must eat food.
     */
    public boolean needFood() {
        return true;
    }

    /**
     * adds input to foodExhaustionLevel to a max of 40
     */
    public void addExhaustion(float p_75113_1_) {
        return;
    }

    /**
     * Get the player's food saturation level.
     */
    public float getSaturationLevel() {
        return 0;
    }

    /**
     *
     */
    public void setFoodLevel(int foodLevelIn) {
        return;
    }

    /**
     *
     */
    public void setFoodSaturationLevel(float foodSaturationLevelIn) {
        return;
    }

}