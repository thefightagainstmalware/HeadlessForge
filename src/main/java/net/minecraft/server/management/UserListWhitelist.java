package net.minecraft.server.management;

import com.mojang.authlib.GameProfile;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.io.File;
import com.google.gson.JsonObject;

/**
 *
 */
public class UserListWhitelist extends UserList<GameProfile,UserListWhitelistEntry> {

    /**
     *
     */
    public UserListWhitelist(java.io.File p_i1132_1_) {
        super(p_i1132_1_);
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
     * Returns true if the profile is in the whitelist.
     */
    public boolean isWhitelisted(GameProfile profile) {
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
     * Gets the GameProfile for the UserListBanEntry with the specified username, if present
     */
    public GameProfile func_152706_a(String p_152706_1_) {
        return null;
    }

}