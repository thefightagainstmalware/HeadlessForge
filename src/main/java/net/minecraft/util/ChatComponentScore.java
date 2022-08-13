package net.minecraft.util;

import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;

public class ChatComponentScore extends ChatComponentStyle
{
    private final String name;
    private final String objective;

    /** The value displayed instead of the real score (may be null) */
    private String value = "";

    public ChatComponentScore(String nameIn, String objectiveIn)
    {
        this.name = nameIn;
        this.objective = objectiveIn;
    }

    public String getName()
    {
        return this.name;
    }

    public String getObjective()
    {
        return this.objective;
    }

    /**
     * Sets the value displayed instead of the real score.
     */
    public void setValue(String valueIn)
    {
        this.value = valueIn;
    }

    /**
     * Gets the text of this component, without any special formatting codes added, for chat.  TODO: why is this two
     * different methods?
     */
    public String getUnformattedTextForChat()
    {
        MinecraftServer minecraftserver = MinecraftServer.func_71276_C();

        if (minecraftserver != null && minecraftserver.isAnvilFileSet() && StringUtils.isNullOrEmpty(this.value))
        {
            Scoreboard scoreboard = minecraftserver.func_71218_a(0).func_96441_U();
            ScoreObjective scoreobjective = scoreboard.func_96518_b(this.objective);

            if (scoreboard.func_178819_b(this.name, scoreobjective))
            {
                Score score = scoreboard.func_96529_a(this.name, scoreobjective);
                this.setValue(String.format("%d", new Object[] {Integer.valueOf(score.getScorePoints())}));
            }
            else
            {
                this.value = "";
            }
        }

        return this.value;
    }

    /**
     * Creates a copy of this component.  Almost a deep copy, except the style is shallow-copied.
     */
    public ChatComponentScore func_150259_f()
    {
        ChatComponentScore chatcomponentscore = new ChatComponentScore(this.name, this.objective);
        chatcomponentscore.setValue(this.value);
        chatcomponentscore.setChatStyle(this.func_150256_b().createShallowCopy());

        for (IChatComponent ichatcomponent : this.getSiblings())
        {
            chatcomponentscore.func_150257_a(ichatcomponent.func_150259_f());
        }

        return chatcomponentscore;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (this == p_equals_1_)
        {
            return true;
        }
        else if (!(p_equals_1_ instanceof ChatComponentScore))
        {
            return false;
        }
        else
        {
            ChatComponentScore chatcomponentscore = (ChatComponentScore)p_equals_1_;
            return this.name.equals(chatcomponentscore.name) && this.objective.equals(chatcomponentscore.objective) && super.equals(p_equals_1_);
        }
    }

    public String toString()
    {
        return "ScoreComponent{name=\'" + this.name + '\'' + "objective=\'" + this.objective + '\'' + ", siblings=" + this.siblings + ", style=" + this.func_150256_b() + '}';
    }
}
