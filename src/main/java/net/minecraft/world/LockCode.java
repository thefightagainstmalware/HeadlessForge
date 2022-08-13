package net.minecraft.world;

import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class LockCode extends Object {

    /**
     *
     */
    public static final LockCode EMPTY_CODE = new LockCode("");

    /**
     *
     */
    private final java.lang.String lock;

    /**
     *
     */
    public LockCode(String code) {
        this.lock = code;
    }

    /**
     *
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     *
     */
    public String getLock() {
        return null;
    }

    /**
     *
     */
    public void toNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     *
     */
    public static LockCode fromNBT(NBTTagCompound nbt) {
        return null;
    }

}