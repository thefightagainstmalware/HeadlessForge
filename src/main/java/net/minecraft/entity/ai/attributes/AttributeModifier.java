package net.minecraft.entity.ai.attributes;

import net.minecraft.util.MathHelper;

import java.util.UUID;

/**
 *
 */
public class AttributeModifier extends Object {

    /**
     *
     */
    private final double amount;

    /**
     *
     */
    private final int operation;

    /**
     *
     */
    private final java.lang.String name;

    /**
     *
     */
    private final java.util.UUID id;

    /**
     * If false, this modifier is not saved in NBT. Used for "natural" modifiers like speed boost from sprinting
     */
    private boolean isSaved;

    /**
     *
     */
    public AttributeModifier(String nameIn,
                             double amountIn,
                             int operationIn) {
        this(UUID.randomUUID(), nameIn, amountIn, operationIn);
    }

    /**
     *
     */
    public AttributeModifier(java.util.UUID idIn,
                             String nameIn,
                             double amountIn,
                             int operationIn) {
        this.id = idIn;
        this.name = nameIn;
        this.amount = amountIn;
        this.operation = operationIn;
    }

    /**
     *
     */
    public java.util.UUID getID() {
        return null;
    }

    /**
     *
     */
    public String getName() {
        return null;
    }

    /**
     *
     */
    public int getOperation() {
        return 0;
    }

    /**
     *
     */
    public double getAmount() {
        return 0;
    }

    /**
     *
     */
    public boolean isSaved() {
        return true;
    }

    /**
     *
     */
    public AttributeModifier setSaved(boolean saved) {
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
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return null;
    }

}