package net.minecraft.entity;

import com.google.common.collect.Maps;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rotations;

/**
 *
 */
public class DataWatcher extends Object {

    /**
     *
     */
    private final Entity owner;

    /**
     * When isBlank is true the DataWatcher is not watching any objects
     */
    private boolean isBlank;

    /**
     *
     */
    private static final java.util.Map<java.lang.Class<?>,java.lang.Integer> dataTypes = Maps.newHashMap();

    /**
     *
     */
    private final java.util.Map<java.lang.Integer,DataWatcher.WatchableObject> watchedObjects = Maps.newHashMap();

    /**
     * true if one or more object was changed
     */
    private boolean objectChanged;

    /**
     *
     */
    private java.util.concurrent.locks.ReadWriteLock lock;

    /**
     *
     */
    public DataWatcher(Entity owner) {
        this.owner = owner;
    }

    /**
     *
     */
    public <T> void addObject(int id,
                              T object) {
    }

    /**
     * Add a new object for the DataWatcher to watch, using the specified data type.
     */
    public void addObjectByDataType(int id,
                                    int type) {
        return;
    }

    /**
     * gets the bytevalue of a watchable object
     */
    public byte getWatchableObjectByte(int id) {
        return 0;
    }

    /**
     *
     */
    public short getWatchableObjectShort(int id) {
        return 0;
    }

    /**
     * gets a watchable object and returns it as a Integer
     */
    public int getWatchableObjectInt(int id) {
        return 0;
    }

    /**
     *
     */
    public float getWatchableObjectFloat(int id) {
        return 0;
    }

    /**
     * gets a watchable object and returns it as a String
     */
    public String getWatchableObjectString(int id) {
        return null;
    }

    /**
     * Get a watchable object as an ItemStack.
     */
    public ItemStack getWatchableObjectItemStack(int id) {
        return null;
    }

    /**
     * is threadsafe, unless it throws an exception, then
     */
    private DataWatcher.WatchableObject getWatchedObject(int id) {
        return null;
    }

    /**
     *
     */
    public Rotations getWatchableObjectRotations(int id) {
        return null;
    }

    /**
     *
     */
    public <T> void updateObject(int id,
                                 T newData) {
    }

    /**
     *
     */
    public void setObjectWatched(int id) {
        return;
    }

    /**
     * true if one or more object was changed
     */
    public boolean hasObjectChanged() {
        return true;
    }

    /**
     * Writes the list of watched objects (entity attribute of type {byte, short, int, float, string, ItemStack,
     * ChunkCoordinates}) to the specified PacketBuffer
     * @throws java.io.IOException
     */
    public static void writeWatchedListToPacketBuffer(java.util.List<DataWatcher.WatchableObject> objectsList,
                                                      PacketBuffer buffer)
                                               throws java.io.IOException {
        return;
    }

    /**
     *
     */
    public java.util.List<DataWatcher.WatchableObject> getChanged() {
        return null;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public void writeTo(PacketBuffer buffer)
                 throws java.io.IOException {
        return;
    }

    /**
     *
     */
    public java.util.List<DataWatcher.WatchableObject> getAllWatched() {
        return null;
    }

    /**
     * Writes a watchable object (entity attribute of type {byte, short, int, float, string, ItemStack,
     * ChunkCoordinates}) to the specified PacketBuffer
     * @throws java.io.IOException
     */
    private static void writeWatchableObjectToPacketBuffer(PacketBuffer buffer,
                                                           DataWatcher.WatchableObject object)
                                                    throws java.io.IOException {
        return;
    }

    /**
     * 
     * @throws java.io.IOException
     */
    public static java.util.List<DataWatcher.WatchableObject> readWatchedListFromPacketBuffer(PacketBuffer buffer)
                                                                                       throws java.io.IOException {
        return null;
    }

    /**
     *
     */
    public void updateWatchedObjectsFromList(java.util.List<DataWatcher.WatchableObject> p_75687_1_) {
        return;
    }

    /**
     *
     */
    public boolean getIsBlank() {
        return true;
    }

    /**
     *
     */
    public void func_111144_e() {
        return;
    }

    public class WatchableObject {
    }
}