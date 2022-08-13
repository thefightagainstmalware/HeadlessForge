package net.minecraft.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.enchantment.EnchantmentData;

/**
 *
 */
public class ContainerEnchantment extends Container {

    /**
     * SlotEnchantmentTable object with ItemStack to be enchanted
     */
    public IInventory tableInventory;

    /**
     * current world (for bookshelf counting)
     */
    private World worldPointer;

    /**
     *
     */
    private BlockPos position;

    /**
     *
     */
    private java.util.Random rand;

    /**
     *
     */
    public int xpSeed;

    /**
     * 3-member array storing the enchantment levels of each slot
     */
    public int[] enchantLevels;

    /**
     *
     */
    public int[] field_178151_h;

    /**
     *
     */
    public ContainerEnchantment(InventoryPlayer playerInv,
                                World worldIn) {
        
    }

    /**
     *
     */
    public ContainerEnchantment(InventoryPlayer playerInv,
                                World worldIn,
                                BlockPos pos) {
        
    }

    /**
     *
     */
    @Override
    public void onCraftGuiOpened(ICrafting listener) {
        return;
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void func_75142_b() {
        return;
    }

    /**
     *
     */
    @Override
    public void updateProgressBar(int id,
                                  int data) {
        return;
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        return;
    }

    /**
     * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
     */
    @Override
    public boolean enchantItem(EntityPlayer playerIn,
                               int id) {
        return true;
    }

    /**
     *
     */
    private java.util.List<EnchantmentData> func_178148_a(ItemStack stack,
                                                          int p_178148_2_,
                                                          int p_178148_3_) {
        return null;
    }

    /**
     *
     */
    public int getLapisAmount() {
        return 0;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        return;
    }

    /**
     *
     */
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn,
                                         int index) {
        return null;
    }

}