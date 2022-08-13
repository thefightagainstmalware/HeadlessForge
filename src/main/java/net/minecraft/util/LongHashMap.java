package net.minecraft.util;

/**
 *
 */
public class LongHashMap<V> extends Object {

    /**
     *
     */
    private transient LongHashMap.Entry[] hashArray;

    /**
     * the number of elements in the hash array
     */
    private transient int numHashElements;

    /**
     *
     */
    private int mask;

    /**
     * the maximum amount of elements in the hash (probably 3/4 the size due to meh hashing function)
     */
    private int capacity;

    /**
     * percent of the hasharray that can be used without hash colliding probably
     */
    private final float percentUseable = 0F;

    /**
     * count of times elements have been added/removed
     */
    private transient volatile int modCount;

    /**
     *
     */
    public LongHashMap() {
        
    }

    /**
     * returns the hashed key given the original key
     */
    private static int getHashedKey(long originalKey) {
        return 0;
    }

    /**
     * the hash function
     */
    private static int hash(int integer) {
        return 0;
    }

    /**
     * gets the index in the hash given the array length and the hashed key
     */
    private static int getHashIndex(int p_76158_0_,
                                    int p_76158_1_) {
        return 0;
    }

    /**
     *
     */
    public int getNumHashElements() {
        return 0;
    }

    /**
     * get the value from the map given the key
     */
    public V getValueByKey(long p_76164_1_) {
        return null;
    }

    /**
     *
     */
    public boolean containsItem(long p_76161_1_) {
        return true;
    }

    /**
     *
     */
    final LongHashMap.Entry getEntry(long p_76160_1_) {
        return null;
    }

    /**
     * Add a key-value pair.
     */
    public void add(long p_76163_1_,
                    V p_76163_3_) {
        return;
    }

    /**
     * resizes the table
     */
    private void resizeTable(int p_76153_1_) {
        return;
    }

    /**
     * copies the hash table to the specified array
     */
    private void copyHashTableTo(LongHashMap.Entry[] p_76154_1_) {
        return;
    }

    /**
     * calls the removeKey method and returns removed object
     */
    public V remove(long p_76159_1_) {
        return null;
    }

    /**
     *
     */
    final LongHashMap.Entry removeKey(long p_76152_1_) {
        return null;
    }

    /**
     * creates the key in the hash table
     */
    private void createKey(int p_76156_1_,
                           long p_76156_2_,
                           V p_76156_4_,
                           int p_76156_5_) {
        return;
    }

    public class Entry<V> {
    }
}