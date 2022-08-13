package net.minecraft.client.player.inventory;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class LocalBlockIntercommunication extends Object implements IInteractionObject {

    /**
     *
     */
    private java.lang.String guiID;

    /**
     *
     */
    private IChatComponent displayName;

    /**
     *
     */
    public LocalBlockIntercommunication(String guiIdIn,
                                        IChatComponent displayNameIn) {
        
    }

    /**
     *
     */
    public Container createContainer(InventoryPlayer playerInventory,
                                     EntityPlayer playerIn) {
        return null;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName() {
        return null;
    }

    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName() {
        return true;
    }

    /**
     *
     */
    public String getGuiID() {
        return null;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     * @return
     */
    public IChatComponent getDisplayName() {
        return null;
    }

}