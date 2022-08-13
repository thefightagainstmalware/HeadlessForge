package net.minecraft.client.util;

import net.minecraft.util.IObjectIntIterable;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.RegistrySimple;

/**
 *
 */
public class RegistryNamespaced<K,V> extends RegistrySimple<K,V> implements IObjectIntIterable<V> {

    /**
     *
     */
    protected ObjectIntIdentityMap<V> underlyingIntegerMap;

    /**
     *
     */
    protected final java.util.Map<V,K> inverseObjectRegistry = new java.util.HashMap<V,K>();

    /**
     *
     */
    public RegistryNamespaced() {
        
    }

    /**
     *
     */
    public void register(int id,
                         K p_177775_2_,
                         V p_177775_3_) {
        return;
    }

    /**
     *
     */
    @Override
    protected java.util.Map<K,V> createUnderlyingMap() {
        return null;
    }

    /**
     *
     */
    public V getObject(K name) {
        return null;
    }

    /**
     * Gets the name we use to identify the given object.
     */
    public K getNameForObject(V p_177774_1_) {
        return null;
    }

    /**
     * Does this registry contain an entry for the given key?
     */
    public boolean containsKey(K p_148741_1_) {
        return true;
    }

    /**
     * Gets the integer ID we use to identify the given object.
     */
    public int getIDForObject(V p_148757_1_) {
        return 0;
    }

    /**
     * Gets the object identified by the given ID.
     */
    public V getObjectById(int id) {
        return null;
    }

    /**
     *
     */
    @Override
    public java.util.Iterator<V> iterator() {
        return null;
    }

}