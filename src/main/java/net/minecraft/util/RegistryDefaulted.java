package net.minecraft.util;

public class RegistryDefaulted<K, V> extends RegistrySimple<K, V>
{
    /**
     * Default object for this registry, returned when an object is not found.
     */
    private final V defaultObject;

    public RegistryDefaulted(V defaultObjectIn)
    {
        this.defaultObject = defaultObjectIn;
    }

    public V func_82594_a(K name)
    {
        V v = super.func_82594_a(name);
        return v == null ? this.defaultObject : v;
    }
}
