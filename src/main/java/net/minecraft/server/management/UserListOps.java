package net.minecraft.server.management;

import com.mojang.authlib.GameProfile;
import java.io.File;
import com.google.gson.JsonObject;

/**
 *
 */
public class UserListOps extends UserList<GameProfile,UserListOpsEntry> {

    /**
     *
     */
    public UserListOps(java.io.File saveFile) {
        super(saveFile);
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
    @Override
    public String[] func_152685_a() {
        return null;
    }

    /**
     *
     */
    public boolean func_183026_b(GameProfile p_183026_1_) {
        return true;
    }

    /**
     * Gets the key value for the given object
     */
    @Override
    protected String getObjectKey(GameProfile obj) {
        return null;
    }

    /**
     * Gets the GameProfile of based on the provided username.
     */
    public GameProfile func_152700_a(String username) {
        return null;
    }

}