package net.minecraft.util;

import gq.malwarefight.headlessforge.Utils;

import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


public class Session {
    private String playerID;
    private String token;
    private String username;
    private UUID profileID;
    public Session() {
        this.token = "eyJhbGciOiJIUzI1NiJ9";
        StringBuilder middlePartBuilder = new StringBuilder();
        middlePartBuilder.append("{");
        long value = ThreadLocalRandom.current().nextLong(25000000000000L, 26000000000000L);
        middlePartBuilder.append(Utils.jsonQuote("xuid", value));
        middlePartBuilder.append(Utils.jsonQuote("agg", "Adult"));
        middlePartBuilder.append(Utils.jsonQuote("sub", UUID.randomUUID().toString().replace("-", "")));
        middlePartBuilder.append(Utils.jsonQuote("nbf", System.currentTimeMillis() / 1000L));
        middlePartBuilder.append(Utils.jsonQuote("auth", "XBOX"));
        middlePartBuilder.append(Utils.jsonQuote("roles", "[]"));
        middlePartBuilder.append(Utils.jsonQuote("iss", "authentication"));
        middlePartBuilder.append(Utils.jsonQuote("iat", System.currentTimeMillis() / 1000L));
        middlePartBuilder.append(Utils.jsonQuote("platform", "UNKNOWN"));
        middlePartBuilder.append(Utils.jsonQuote("yuid", UUID.randomUUID().toString().replace("-", "")));
        middlePartBuilder.setLength(middlePartBuilder.length() - 1);
        middlePartBuilder.append("}");
        // encode middlePartBuilder using base64
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