package net.minecraft.server.management;

import java.util.Date;
import com.google.gson.JsonObject;

/**
 *
 */
public class IPBanEntry extends BanEntry<String> {

    /**
     *
     */
    public IPBanEntry(String valueIn) {
        super(valueIn, null, null, null, null);
    }

    /**
     *
     */
    public IPBanEntry(String valueIn,
                      java.util.Date startDate,
                      String banner,
                      java.util.Date endDate,
                      String banReason) {
        super(valueIn, startDate, banner, endDate, banReason);
    }

    /**
     *
     */
    public IPBanEntry(JsonObject json) {
        super(getIPFromJson(json), null, null, null, null);
    }

    /**
     *
     */
    private static String getIPFromJson(JsonObject json) {
        return null;
    }

    /**
     *
     */
    @Override
    protected void onSerialization(JsonObject data) {
        return;
    }

}