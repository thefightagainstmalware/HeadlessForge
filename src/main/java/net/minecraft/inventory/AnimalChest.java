package net.minecraft.inventory;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class AnimalChest extends InventoryBasic {

    /**
     *
     */
    public AnimalChest(String inventoryName,
                       int slotCount) {
        super(inventoryName, true, slotCount);
    }

    /**
     *
     */
    public AnimalChest(IChatComponent invTitle,
                       int slotCount) {
        super(invTitle, slotCount);
    }

}