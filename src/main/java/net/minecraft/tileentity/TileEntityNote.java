package net.minecraft.tileentity;

import net.minecraft.util.MathHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class TileEntityNote extends TileEntity {

    /**
     * Note to play
     */
    public byte note;

    /**
     * stores the latest redstone state
     */
    public boolean previousRedstoneState;

    /**
     *
     */
    public TileEntityNote() {
        
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
     * change pitch by -&gt; (currentPitch + 1) % 25
     */
    public void changePitch() {
        return;
    }

    /**
     *
     */
    public void triggerNote(World worldIn,
                            BlockPos p_175108_2_) {
        return;
    }

}