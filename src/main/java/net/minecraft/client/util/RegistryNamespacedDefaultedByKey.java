package net.minecraft.client.util;

import net.minecraft.util.RegistryNamespaced;

/**
 *
 */
public class RegistryNamespacedDefaultedByKey<K,V> extends RegistryNamespaced<K,V> {

    /**
     * The key of the default value.
     */
    private final K defaultValueKey;

    /**
     * The default value for this registry, retrurned in the place of a null value.
     */
    private V defaultValue;

    /**
     *
     */
    public RegistryNamespacedDefaultedByKey(K p_i46017_1_) {
        this.defaultValueKey = p_i46017_1_;
    }

    /**
     *
     */
    @Override
    public void register(int id,
                         K p_177775_2_,
                         V p_177775_3_) {
        return;
    }

    /**
     * validates that this registry's key is non-null
     */
    public void validateKey() {
        return;
    }

    /**
     *
     */
    public V getObject(K name) {
        return null;
    }

    /**
     * Gets the object identified by the given ID.
     */
    @Override
    public V getObjectById(int id) {
        return null;
    }

}