package net.minecraft.util;

import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagFloat;

/**
 *
 */
public class Rotations extends Object {

    /**
     * Rotation on the X axis
     */
    protected final float x;

    /**
     * Rotation on the Y axis
     */
    protected final float y;

    /**
     * Rotation on the Z axis
     */
    protected final float z;

    /**
     *
     */
    public Rotations(float x,
                     float y,
                     float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     *
     */
    public Rotations(NBTTagList nbt) {
        this.x = nbt.getFloatAt(0);
        this.y = nbt.getFloatAt(1);
        this.z = nbt.getFloatAt(2);
    }

    /**
     *
     */
    public NBTTagList writeToNBT() {
        return null;
    }

    /**
     *
     */
    @Override
    public boolean equals(Object p_equals_1_) {
        return true;
    }

    /**
     * Gets the X axis rotation
     */
    public float getX() {
        return 0;
    }

    /**
     * Gets the Y axis rotation
     */
    public float getY() {
        return 0;
    }

    /**
     * Gets the Z axis rotation
     */
    public float getZ() {
        return 0;
    }

}