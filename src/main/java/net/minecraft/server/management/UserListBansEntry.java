package net.minecraft.server.management;

import com.mojang.authlib.GameProfile;
import java.util.Date;
import java.util.UUID;
import com.google.gson.JsonObject;

/**
 *
 */
public class UserListBansEntry extends BanEntry<GameProfile> {

    /**
     *
     */
    public UserListBansEntry(GameProfile profile) {
        super(profile, null, null, null, null);
    }

    /**
     *
     */
    public UserListBansEntry(GameProfile profile,
                             java.util.Date startDate,
                             String banner,
                             java.util.Date endDate,
                             String banReason) {
        super(profile, startDate, banner, endDate, banReason);
    }

    /**
     *
     */
    public UserListBansEntry(JsonObject json) {
        super(toGameProfile(json), null, null, null, null);
    }

    /**
     *
     */
    @Override
    protected void onSerialization(JsonObject data) {
        return;
    }

    /**
     * Convert a JsonObject into a com.mojang.authlib.GameProfile.
     * The json object must have <code>uuid</code> and <code>name</code> attributes or <code>null</code> will be returned.
     * @param json The json object
     */
    private static GameProfile toGameProfile(JsonObject json) {
        return null;
    }

}