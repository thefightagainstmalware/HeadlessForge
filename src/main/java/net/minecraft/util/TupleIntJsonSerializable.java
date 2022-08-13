package net.minecraft.util;

/**
 *
 */
public class TupleIntJsonSerializable extends Object {

    /**
     *
     */
    private int integerValue;

    /**
     *
     */
    private IJsonSerializable jsonSerializableValue;

    /**
     *
     */
    public TupleIntJsonSerializable() {
        
    }

    /**
     * Gets the integer value stored in this tuple.
     */
    public int getIntegerValue() {
        return 0;
    }

    /**
     * Sets this tuple's integer value to the given value.
     */
    public void setIntegerValue(int integerValueIn) {
        return;
    }

    /**
     *
     */
    public <T extends IJsonSerializable> T getJsonSerializableValue() {
        return null;
    }

    /**
     * Sets this tuple's JsonSerializable value to the given value.
     */
    public void setJsonSerializableValue(IJsonSerializable jsonSerializableValueIn) {
        return;
    }

}