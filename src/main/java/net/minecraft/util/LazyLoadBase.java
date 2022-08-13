package net.minecraft.util;

/**
 *
 */
public abstract class LazyLoadBase<T> extends Object {

    /**
     *
     */
    private T value;

    /**
     *
     */
    private boolean isLoaded;

    /**
     *
     */
    public LazyLoadBase() {
        
    }

    /**
     *
     */
    public T getValue() {
        return null;
    }

    /**
     *
     */
    protected abstract T load();

}