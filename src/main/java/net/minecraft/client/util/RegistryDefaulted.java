package net.minecraft.client.util;

import net.minecraft.util.RegistrySimple;

/**
 *
 */
public class RegistryDefaulted<K,V> extends RegistrySimple<K,V> {

    /**
     * Default object for this registry, returned when an object is not found.
     */
    private final V defaultObject;

    /**
     *
     */
    public RegistryDefaulted(V defaultObjectIn) {
        this.defaultObject = defaultObjectIn;
    }

    /**
     *
     */
    @Override
    public V func_82594_a(K name) {
        return null;
    }

}