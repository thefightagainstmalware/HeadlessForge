package net.minecraft.inventory;

import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.stats.AchievementList;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item;

/**
 *
 */
public class SlotCrafting extends Slot {

    /**
     * The craft matrix inventory linked to this result slot.
     */
    private final InventoryCrafting craftMatrix;

    /**
     * The player that is using the GUI where this slot resides.
     */
    private final EntityPlayer thePlayer;

    /**
     * The number of items that have been crafted so far. Gets passed to ItemStack.onCrafting before being reset.
     */
    private int amountCrafted;

    /**
     *
     */
    public SlotCrafting(EntityPlayer player,
                        InventoryCrafting craftingInventory,
                        IInventory p_i45790_3_,
                        int slotIndex,
                        int xPosition,
                        int yPosition) {
        super(p_i45790_3_, slotIndex, xPosition, yPosition);
        this.thePlayer = player;
        this.craftMatrix = craftingInventory;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack stack) {
        return true;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    @Override
    public ItemStack decrStackSize(int amount) {
        return null;
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    @Override
    protected void onCrafting(ItemStack stack,
                              int amount) {
        return;
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    @Override
    protected void onCrafting(ItemStack stack) {
        return;
    }

    /**
     *
     */
    @Override
    public void onPickupFromSlot(EntityPlayer playerIn,
                                 ItemStack stack) {
        return;
    }

}