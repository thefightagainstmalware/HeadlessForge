package net.minecraft.server.management;

import com.mojang.authlib.GameProfile;
import java.io.File;
import com.google.gson.JsonObject;

/**
 *
 */
public class UserListBans extends UserList<GameProfile,UserListBansEntry> {

    /**
     *
     */
    public UserListBans(java.io.File bansFile) {
        super(bansFile);
    }

    /**
     *
     */
    @Override
    protected UserListEntry<GameProfile> createEntry(JsonObject entryData) {
        return null;
    }

    /**
     *
     */
    public boolean isBanned(GameProfile profile) {
        return true;
    }

    /**
     *
     */
    @Override
    public String[] func_152685_a() {
        return null;
    }

    /**
     * Gets the key value for the given object
     */
    @Override
    protected String getObjectKey(GameProfile obj) {
        return null;
    }

    /**
     *
     */
    public GameProfile func_152703_a(String username) {
        return null;
    }

}