package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 *
 */
public class InventoryEnderChest extends InventoryBasic {

    /**
     *
     */
    private TileEntityEnderChest associatedChest;

    /**
     *
     */
    public InventoryEnderChest() {
        super("EnderChest", false, 27);
    }

    /**
     *
     */
    public void setChestTileEntity(TileEntityEnderChest chestTileEntity) {
        return;
    }

    /**
     *
     */
    public void loadInventoryFromNBT(NBTTagList p_70486_1_) {
        return;
    }

    /**
     *
     */
    public NBTTagList saveInventoryToNBT() {
        return null;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    /**
     *
     */
    @Override
    public void openInventory(EntityPlayer player) {
        return;
    }

    /**
     *
     */
    @Override
    public void closeInventory(EntityPlayer player) {
        return;
    }

}