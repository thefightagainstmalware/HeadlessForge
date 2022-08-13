package net.minecraft.client.util;

import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import gq.malwarefight.headlessforge.Utils;

public class Session {
    private final String playerID;

    private String token = "eyJhbGciOiJIUzI1NiJ9";

    private final String username;

    private final UUID profileID;

    public Session() {
        StringBuilder middlePartBuilder = new StringBuilder();
        middlePartBuilder.append("{");
        long value = ThreadLocalRandom.current().nextLong(25000000000000L, 26000000000000L);
        middlePartBuilder.append(Utils.jsonQuote("xuid", Long.valueOf(value)));
        middlePartBuilder.append(Utils.jsonQuote("agg", "Adult"));
        middlePartBuilder.append(Utils.jsonQuote("sub", UUID.randomUUID().toString().replace("-", "")));
        middlePartBuilder.append(Utils.jsonQuote("nbf", Long.valueOf(System.currentTimeMillis() / 1000L)));
        middlePartBuilder.append(Utils.jsonQuote("auth", "XBOX"));
        middlePartBuilder.append(Utils.jsonQuote("roles", "[]"));
        middlePartBuilder.append(Utils.jsonQuote("iss", "authentication"));
        middlePartBuilder.append(Utils.jsonQuote("iat", Long.valueOf(System.currentTimeMillis() / 1000L)));
        middlePartBuilder.append(Utils.jsonQuote("platform", "UNKNOWN"));
        middlePartBuilder.append(Utils.jsonQuote("yuid", UUID.randomUUID().toString().replace("-", "")));
        middlePartBuilder.setLength(middlePartBuilder.length() - 1);
        middlePartBuilder.append("}");
        String middlePart = new String(Base64.getEncoder().encode(middlePartBuilder.toString().getBytes()));
        this.token += "." + middlePart + "." + Utils.generateRandomString(43);
        this.playerID = this.token;
        this.username = Utils.generateRandomUsername();
        this.profileID = UUID.randomUUID();
    }

    public String func_111285_a() {
        return this.username;
    }

    public String func_111286_b() {
        return this.playerID;
    }

    public String func_148254_d() {
        return this.token;
    }

    public String func_148255_b() {
        return this.profileID.toString().replace("-", "");
    }
}
