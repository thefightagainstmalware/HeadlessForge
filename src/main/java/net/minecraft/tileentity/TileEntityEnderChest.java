package net.minecraft.tileentity;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.capabilities.Capability;

/**
 *
 */
public class TileEntityEnderChest extends TileEntity implements ITickable {
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return super.getCapability(capability, facing);
    }

    /**
     *
     */
    public float lidAngle;

    /**
     * The angle of the ender chest lid last tick
     */
    public float prevLidAngle;

    /**
     *
     */
    public int numPlayersUsing;

    /**
     *
     */
    private int ticksSinceSync;

    /**
     *
     */
    public TileEntityEnderChest() {
        
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update() {
        return;
    }

    /**
     *
     */
    @Override
    public boolean receiveClientEvent(int id,
                                      int type) {
        return true;
    }

    /**
     * invalidates a tile entity
     */
    @Override
    public void invalidate() {
        return;
    }

    /**
     *
     */
    public void openChest() {
        return;
    }

    /**
     *
     */
    public void closeChest() {
        return;
    }

    /**
     *
     */
    public boolean canBeUsed(EntityPlayer p_145971_1_) {
        return true;
    }

    /**
     *
     */
    @Override
    public void tick() {

    }
}