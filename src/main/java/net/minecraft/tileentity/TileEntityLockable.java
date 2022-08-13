package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.LockCode;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.IItemHandler;

/**
 *
 */
public abstract class TileEntityLockable extends TileEntity implements IInteractionObject, ILockableContainer {

    /**
     *
     */
    private LockCode code;

    /**
     *
     */
    private IItemHandler itemHandler;

    /**
     *
     */
    public TileEntityLockable() {
        
    }

    /**
     *
     */
    @Override
    public void func_145839_a(NBTTagCompound compound) {
        return;
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
    public boolean isLocked() {
        return true;
    }

    /**
     *
     */
    public LockCode getLockCode() {
        return null;
    }

    /**
     *
     */
    public void setLockCode(LockCode code) {
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
    protected IItemHandler createUnSidedHandler() {
        return null;
    }

    /**
     * Retrieves the handler for the capability requested on the specific side.
     * The return value CAN be null if the object does not support the capability.
     * The return value CAN be the same for multiple faces.
     * @param capability The capability to check
     * @param facing The Side to check from:
     *    CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return True if this object supports the capability.
     */
    @Override
    public <T> T getCapability(Capability<T> capability,
                               EnumFacing facing) {
        return null;
    }

    /**
     * Determines if this object has support for the capability in question on the specific side.
     * The return value of this MIGHT change during runtime if this object gains or looses support
     * for a capability.
     * 
     * Example:
     *   A Pipe getting a cover placed on one side causing it loose the Inventory attachment function for that side.
     * 
     * This is a light weight version of getCapability, intended for metadata uses.
     * @param capability The capability to check
     * @param facing The Side to check from:
     *    CAN BE NULL. Null is defined to represent 'internal' or 'self'
     * @return True if this object supports the capability.
     */
    @Override
    public boolean hasCapability(Capability<?> capability,
                                 EnumFacing facing) {
        return true;
    }

}