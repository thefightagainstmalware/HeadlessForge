package net.minecraft.tileentity;

import net.minecraft.entity.Entity;
import net.minecraft.util.ITickable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.IBlockState;

/**
 *
 */
public class TileEntityPiston extends TileEntity implements ITickable {

    /**
     *
     */
    private IBlockState pistonState;

    /**
     *
     */
    private EnumFacing pistonFacing;

    /**
     * if this piston is extending or not
     */
    private boolean extending;

    /**
     *
     */
    private boolean shouldHeadBeRendered;

    /**
     *
     */
    private float progress;

    /**
     * the progress in (de)extending
     */
    private float lastProgress;

    /**
     *
     */
    private java.util.List<Entity> field_174933_k;

    /**
     *
     */
    public TileEntityPiston() {
        
    }

    /**
     *
     */
    public TileEntityPiston(IBlockState pistonStateIn,
                            EnumFacing pistonFacingIn,
                            boolean extendingIn,
                            boolean shouldHeadBeRenderedIn) {
        
    }

    /**
     *
     */
    public IBlockState getPistonState() {
        return null;
    }

    /**
     *
     */
    @Override
    public int getBlockMetadata() {
        return 0;
    }

    /**
     * Returns true if a piston is extending
     */
    public boolean isExtending() {
        return true;
    }

    /**
     *
     */
    public EnumFacing getFacing() {
        return null;
    }

    /**
     *
     */
    public boolean shouldPistonHeadBeRendered() {
        return true;
    }

    /**
     * Get interpolated progress value (between lastProgress and progress) given the fractional time between ticks as an
     * argument
     */
    public float getProgress(float ticks) {
        return 0;
    }

    /**
     *
     */
    private void launchWithSlimeBlock(float p_145863_1_,
                                      float p_145863_2_) {
        return;
    }

    /**
     *
     */
    public float getOffsetX(float ticks) {
        return 0;
    }

    /**
     *
     */
    public float getOffsetY(float ticks) {
        return 0;
    }

    /**
     *
     */
    public float getOffsetZ(float ticks) {
        return 0;
    }

    /**
     * removes a piston's tile entity (and if the piston is moving, stops it)
     */
    public void clearPistonTileEntity() {
        return;
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

}