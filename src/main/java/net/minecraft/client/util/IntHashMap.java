package net.minecraft.client.util;

/**
 *
 */
public class IntHashMap<V> extends Object {

    /**
     *
     */
    private transient IntHashMap.Entry[] slots;

    /**
     * The number of items stored in this map
     */
    private transient int count;

    /**
     * The grow threshold
     */
    private int threshold;

    /**
     * The scale factor used to determine when to grow the table
     */
    private final float growFactor = 0.75F;

    /**
     *
     */
    public IntHashMap() {
        
    }

    /**
     * Makes the passed in integer suitable for hashing by a number of shifts
     */
    private static int computeHash(int integer) {
        return 0;
    }

    /**
     * Computes the index of the slot for the hash and slot count passed in.
     */
    private static int getSlotIndex(int hash,
                                    int slotCount) {
        return 0;
    }

    /**
     * Returns the object associated to a key
     */
    public V lookup(int p_76041_1_) {
        return null;
    }

    /**
     * Returns true if this hash table contains the specified item.
     */
    public boolean containsItem(int p_76037_1_) {
        return true;
    }

    /**
     *
     */
    final IntHashMap.Entry lookupEntry(int p_76045_1_) {
        return null;
    }

    /**
     * Adds a key and associated value to this map
     */
    public void addKey(int p_76038_1_,
                       V p_76038_2_) {
        return;
    }

    /**
     * Increases the number of hash slots
     */
    private void grow(int p_76047_1_) {
        return;
    }

    /**
     * Copies the hash slots to a new array
     */
    private void copyTo(IntHashMap.Entry[] p_76048_1_) {
        return;
    }

    /**
     * Removes the specified object from the map and returns it
     */
    public V removeObject(int p_76049_1_) {
        return null;
    }

    /**
     *
     */
    final IntHashMap.Entry removeEntry(int p_76036_1_) {
        return null;
    }

    /**
     * Removes all entries from the map
     */
    public void clearMap() {
        return;
    }

    /**
     * Adds an object to a slot
     */
    private void insert(int p_76040_1_,
                        int p_76040_2_,
                        V p_76040_3_,
                        int p_76040_4_) {
        return;
    }

    public class Entry<V> {
    }
}