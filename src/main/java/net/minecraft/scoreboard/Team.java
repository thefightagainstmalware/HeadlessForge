package net.minecraft.scoreboard;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public abstract class Team extends Object {

    /**
     *
     */
    public Team() {
        
    }

    /**
     * Same as ==
     */
    public boolean isSameTeam(Team other) {
        return true;
    }

    /**
     * Retrieve the name by which this team is registered in the scoreboard
     */
    public abstract String getRegisteredName();

    /**
     *
     */
    public abstract String formatString(String input);

    /**
     *
     */
    public abstract boolean getSeeFriendlyInvisiblesEnabled();

    /**
     *
     */
    public abstract boolean getAllowFriendlyFire();

    /**
     *
     */
    public abstract Team.EnumVisible getNameTagVisibility();

    /**
     *
     */
    public abstract java.util.Collection<String> getMembershipCollection();

    /**
     *
     */
    public abstract Team.EnumVisible getDeathMessageVisibility();

    public class EnumVisible {
    }
}