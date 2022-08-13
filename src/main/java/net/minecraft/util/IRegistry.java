package net.minecraft.util;

public interface IRegistry<K, V> extends Iterable<V>
{
    V func_82594_a(K name);

    /**
     * Register an object on this registry.
     */
    void putObject(K p_82595_1_, V p_82595_2_);
}
