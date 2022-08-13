package net.minecraft.scoreboard;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ScoreObjective extends Object {

    /**
     *
     */
    private final Scoreboard theScoreboard;

    /**
     *
     */
    private final java.lang.String name;

    /**
     * The ScoreObjectiveCriteria for this objetive
     */
    private final IScoreObjectiveCriteria objectiveCriteria;

    /**
     *
     */
    private IScoreObjectiveCriteria.EnumRenderType renderType;

    /**
     *
     */
    private java.lang.String displayName;

    /**
     *
     */
    public ScoreObjective(Scoreboard theScoreboardIn,
                          String nameIn,
                          IScoreObjectiveCriteria objectiveCriteriaIn) {
        this.theScoreboard = theScoreboardIn;
        this.name = nameIn;
        this.objectiveCriteria = objectiveCriteriaIn;
    }

    /**
     *
     */
    public Scoreboard getScoreboard() {
        return null;
    }

    /**
     *
     */
    public String func_96679_b() {
        return null;
    }

    /**
     *
     */
    public IScoreObjectiveCriteria func_96680_c() {
        return null;
    }

    /**
     *
     */
    public String getDisplayName() {
        return null;
    }

    /**
     *
     */
    public void setDisplayName(String nameIn) {
        return;
    }

    /**
     *
     */
    public IScoreObjectiveCriteria.EnumRenderType getRenderType() {
        return null;
    }

    /**
     *
     */
    public void setRenderType(IScoreObjectiveCriteria.EnumRenderType type) {
        return;
    }

}