package net.minecraft.scoreboard;

import com.google.common.collect.Sets;
import net.minecraft.util.EnumChatFormatting;

/**
 *
 */
public class ScorePlayerTeam extends Team {

    /**
     *
     */
    private final Scoreboard theScoreboard;

    /**
     *
     */
    private final java.lang.String registeredName;

    /**
     *
     */
    private final java.util.Set<java.lang.String> membershipSet;

    /**
     *
     */
    private java.lang.String teamNameSPT;

    /**
     *
     */
    private java.lang.String namePrefixSPT;

    /**
     *
     */
    private java.lang.String colorSuffix;

    /**
     *
     */
    private boolean allowFriendlyFire;

    /**
     *
     */
    private boolean canSeeFriendlyInvisibles;

    /**
     *
     */
    private Team.EnumVisible nameTagVisibility;

    /**
     *
     */
    private Team.EnumVisible deathMessageVisibility;

    /**
     *
     */
    private EnumChatFormatting chatFormat;

    /**
     *
     */
    public ScorePlayerTeam(Scoreboard theScoreboardIn,
                           String name) {
        this.theScoreboard = theScoreboardIn;
        this.registeredName = name;
        this.membershipSet = Sets.newHashSet();
    }

    /**
     * Retrieve the name by which this team is registered in the scoreboard
     */
    public String getRegisteredName() {
        return null;
    }

    /**
     *
     */
    public String getTeamName() {
        return null;
    }

    /**
     *
     */
    public void setTeamName(String name) {
        return;
    }

    /**
     *
     */
    public java.util.Collection<String> getMembershipCollection() {
        return null;
    }

    /**
     * Returns the color prefix for the player's team name
     */
    public String getColorPrefix() {
        return null;
    }

    /**
     *
     */
    public void setNamePrefix(String prefix) {
        return;
    }

    /**
     * Returns the color suffix for the player's team name
     */
    public String getColorSuffix() {
        return null;
    }

    /**
     *
     */
    public void setNameSuffix(String suffix) {
        return;
    }

    /**
     *
     */
    public String formatString(String input) {
        return null;
    }

    /**
     * Returns the player name including the color prefixes and suffixes
     */
    public static String formatPlayerName(Team p_96667_0_,
                                                    String p_96667_1_) {
        return null;
    }

    /**
     *
     */
    public boolean getAllowFriendlyFire() {
        return true;
    }

    /**
     *
     */
    public void setAllowFriendlyFire(boolean friendlyFire) {
        return;
    }

    /**
     *
     */
    public boolean getSeeFriendlyInvisiblesEnabled() {
        return true;
    }

    /**
     *
     */
    public void setSeeFriendlyInvisiblesEnabled(boolean friendlyInvisibles) {
        return;
    }

    /**
     *
     */
    public Team.EnumVisible getNameTagVisibility() {
        return null;
    }

    /**
     *
     */
    public Team.EnumVisible getDeathMessageVisibility() {
        return null;
    }

    /**
     *
     */
    public void setNameTagVisibility(Team.EnumVisible p_178772_1_) {
        return;
    }

    /**
     *
     */
    public void setDeathMessageVisibility(Team.EnumVisible p_178773_1_) {
        return;
    }

    /**
     *
     */
    public int func_98299_i() {
        return 0;
    }

    /**
     *
     */
    public void func_98298_a(int p_98298_1_) {
        return;
    }

    /**
     *
     */
    public void setChatFormat(EnumChatFormatting p_178774_1_) {
        return;
    }

    /**
     *
     */
    public EnumChatFormatting getChatFormat() {
        return null;
    }

}