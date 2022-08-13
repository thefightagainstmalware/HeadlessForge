package net.minecraft.server.management;

import java.io.File;
import java.net.SocketAddress;
import com.google.gson.JsonObject;

/**
 *
 */
public class BanList extends UserList<String,IPBanEntry> {

    /**
     *
     */
    public BanList(java.io.File bansFile) {
        super(bansFile);
    }

    /**
     *
     */
    @Override
    protected UserListEntry<String> createEntry(JsonObject entryData) {
        return null;
    }

    /**
     *
     */
    public boolean isBanned(java.net.SocketAddress address) {
        return true;
    }

    /**
     *
     */
    public IPBanEntry getBanEntry(java.net.SocketAddress address) {
        return null;
    }

    /**
     *
     */
    private String addressToString(java.net.SocketAddress address) {
        return null;
    }

}