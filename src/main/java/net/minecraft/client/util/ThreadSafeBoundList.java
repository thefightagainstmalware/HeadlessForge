package net.minecraft.client.util;

import java.util.concurrent.locks.ReadWriteLock;

/**
 *
 */
public class ThreadSafeBoundList<T> {

    /**
     *
     */
    private final T[] field_152759_a;

    /**
     *
     */
    private final java.lang.Class<? extends T> field_152760_b;

    /**
     *
     */
    private final java.util.concurrent.locks.ReadWriteLock field_152761_c;

    /**
     *
     */
    private int field_152762_d;

    /**
     *
     */
    private int field_152763_e;

    /**
     *
     */
    public ThreadSafeBoundList(Class<? extends T> p_i1126_1_,
                               int p_i1126_2_) {
    	field_152760_b = p_i1126_1_;
    	field_152761_c = null;
    	field_152759_a = null;
    }

    /**
     *
     */
    public T func_152757_a(T p_152757_1_) {
        return null;
    }

    /**
     *
     */
    public int func_152758_b() {
        return 0;
    }

    /**
     *
     */
    public T[] func_152756_c() {
        return null;
    }

}