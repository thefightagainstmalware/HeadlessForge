package net.minecraft.server.management;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import com.google.gson.JsonObject;

/**
 *
 */
public class UserListWhitelistEntry extends UserListEntry<GameProfile> {

    /**
     *
     */
    public UserListWhitelistEntry(GameProfile profile) {
        super(profile);
    }

    /**
     *
     */
    public UserListWhitelistEntry(JsonObject p_i1130_1_) {
        super(gameProfileFromJsonObject(p_i1130_1_));
    }

    /**
     *
     */
    @Override
    protected void onSerialization(JsonObject data) {
        return;
    }

    /**
     *
     */
    private static GameProfile gameProfileFromJsonObject(JsonObject p_152646_0_) {
        return null;
    }

}