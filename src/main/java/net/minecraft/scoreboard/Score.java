package net.minecraft.scoreboard;

import net.minecraft.entity.player.EntityPlayer;
import java.util.List;
import java.util.Comparator;

/**
 *
 */
public class Score extends Object {

    /**
     *
     */
    public static final Comparator<Score> scoreComparator = new Comparator<Score>()
    {
        public int compare(Score p_compare_1_, Score p_compare_2_)
        {
            return p_compare_1_.getScorePoints() > p_compare_2_.getScorePoints() ? 1 : (p_compare_1_.getScorePoints() < p_compare_2_.getScorePoints() ? -1 : p_compare_2_.getPlayerName().compareToIgnoreCase(p_compare_1_.getPlayerName()));
        }
    };

    /**
     *
     */
    private final Scoreboard theScoreboard;

    /**
     *
     */
    private final ScoreObjective theScoreObjective;

    /**
     *
     */
    private final java.lang.String scorePlayerName;

    /**
     *
     */
    private int scorePoints;

    /**
     *
     */
    private boolean locked;

    /**
     *
     */
    private boolean forceUpdate;

    /**
     *
     */
    public Score(Scoreboard theScoreboardIn,
                 ScoreObjective theScoreObjectiveIn,
                 String scorePlayerNameIn) {
        this.theScoreboard = theScoreboardIn;
        this.theScoreObjective = theScoreObjectiveIn;
        this.scorePlayerName = scorePlayerNameIn;
        this.scorePoints = 0;
    }

    /**
     *
     */
    public void func_96649_a(int amount) {
        return;
    }

    /**
     *
     */
    public void decreaseScore(int amount) {
        return;
    }

    /**
     *
     */
    public void func_96648_a() {
        return;
    }

    /**
     *
     */
    public int getScorePoints() {
        return 0;
    }

    /**
     *
     */
    public void func_96647_c(int points) {
        return;
    }

    /**
     *
     */
    public ScoreObjective getObjective() {
        return null;
    }

    /**
     * Returns the name of the player this score belongs to
     */
    public String getPlayerName() {
        return null;
    }

    /**
     *
     */
    public Scoreboard getScoreScoreboard() {
        return null;
    }

    /**
     *
     */
    public boolean func_178816_g() {
        return true;
    }

    /**
     *
     */
    public void func_178815_a(boolean locked) {
        return;
    }

    /**
     *
     */
    public void func_96651_a(java.util.List<EntityPlayer> p_96651_1_) {
        return;
    }

}