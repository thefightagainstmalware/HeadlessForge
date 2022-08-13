package net.minecraft.entity.player;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

import java.util.Locale;

/**
 *
 */
public enum EnumPlayerModelParts {
    CAPE,
    HAT,
            JACKET,
    LEFT_PANTS_LEG,
            LEFT_SLEEVE,
    RIGHT_PANTS_LEG,
            RIGHT_SLEEVE;
    /**
     *
     */
    private final int partId = this.ordinal();

    /**
     *
     */
    private final int partMask = 1 << this.partId;

    /**
     *
     */
    private final java.lang.String partName = toString().toLowerCase(Locale.ROOT);

    /**
     *
     */
    private final IChatComponent field_179339_k = new ChatComponentTranslation("options.modelPart." + this.partName);

    /**
     *
     */
    public int getPartMask() {
        return 0;
    }

    /**
     *
     */
    public int getPartId() {
        return 0;
    }

    /**
     *
     */
    public String getPartName() {
        return null;
    }

    /**
     *
     */
    public IChatComponent func_179326_d() {
        return null;
    }

}