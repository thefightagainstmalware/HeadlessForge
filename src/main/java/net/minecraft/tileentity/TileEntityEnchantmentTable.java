package net.minecraft.tileentity;

import net.minecraft.inventory.Container;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ITickable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class TileEntityEnchantmentTable extends TileEntity implements ITickable, IInteractionObject {

    /**
     *
     */
    public int tickCount;

    /**
     *
     */
    public float pageFlip;

    /**
     *
     */
    public float pageFlipPrev;

    /**
     *
     */
    public float field_145932_k;

    /**
     *
     */
    public float field_145929_l;

    /**
     *
     */
    public float bookSpread;

    /**
     *
     */
    public float bookSpreadPrev;

    /**
     *
     */
    public float bookRotation;

    /**
     *
     */
    public float bookRotationPrev;

    /**
     *
     */
    public float field_145924_q;

    /**
     *
     */
    private static java.util.Random rand;

    /**
     *
     */
    private java.lang.String customName;

    /**
     *
     */
    public TileEntityEnchantmentTable() {
        
    }

    /**
     *
     */
    @Override
    public void func_145841_b(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    @Override
    public void func_145839_a(NBTTagCompound compound) {
        return;
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update() {
        return;
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
    public void setCustomName(String customNameIn) {
        return;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     * @return
     */
    public IChatComponent getDisplayName() {
        return null;
    }

    /**
     *
     */
    public Container createContainer(InventoryPlayer playerInventory,
                                     EntityPlayer playerIn) {
        return null;
    }

    /**
     *
     */
    public String getGuiID() {
        return null;
    }

}