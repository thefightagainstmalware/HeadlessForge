package net.minecraft.entity.boss;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public interface IBossDisplayData {

    /**
     *
     */
    float getMaxHealth();

    /**
     *
     */
    float getHealth();

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    IChatComponent getDisplayName();

}