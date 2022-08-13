package net.minecraft.stats;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import net.minecraft.event.HoverEvent;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IJsonSerializable;

public class StatBase
{
    /** The Stat ID */
    public final String field_75975_e;

    /** The Stat name */
    private final IChatComponent statName;
    public boolean isIndependent;
    private final IStatType type;
    private final IScoreObjectiveCriteria field_150957_c;
    private Class <? extends IJsonSerializable > field_150956_d;
    private static NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.US);
    public static IStatType simpleStatType = new IStatType()
    {
        public String format(int p_75843_1_)
        {
            return StatBase.numberFormat.format((long)p_75843_1_);
        }
    };
    private static DecimalFormat decimalFormat = new DecimalFormat("########0.00");
    public static IStatType timeStatType = new IStatType()
    {
        public String format(int p_75843_1_)
        {
            double d0 = (double)p_75843_1_ / 20.0D;
            double d1 = d0 / 60.0D;
            double d2 = d1 / 60.0D;
            double d3 = d2 / 24.0D;
            double d4 = d3 / 365.0D;
            return d4 > 0.5D ? StatBase.decimalFormat.format(d4) + " y" : (d3 > 0.5D ? StatBase.decimalFormat.format(d3) + " d" : (d2 > 0.5D ? StatBase.decimalFormat.format(d2) + " h" : (d1 > 0.5D ? StatBase.decimalFormat.format(d1) + " m" : d0 + " s")));
        }
    };
    public static IStatType distanceStatType = new IStatType()
    {
        public String format(int p_75843_1_)
        {
            double d0 = (double)p_75843_1_ / 100.0D;
            double d1 = d0 / 1000.0D;
            return d1 > 0.5D ? StatBase.decimalFormat.format(d1) + " km" : (d0 > 0.5D ? StatBase.decimalFormat.format(d0) + " m" : p_75843_1_ + " cm");
        }
    };
    public static IStatType field_111202_k = new IStatType()
    {
        public String format(int p_75843_1_)
        {
            return StatBase.decimalFormat.format((double)p_75843_1_ * 0.1D);
        }
    };

    public StatBase(String statIdIn, IChatComponent statNameIn, IStatType typeIn)
    {
        this.field_75975_e = statIdIn;
        this.statName = statNameIn;
        this.type = typeIn;
        this.field_150957_c = new ObjectiveStat(this);
        IScoreObjectiveCriteria.INSTANCES.put(this.field_150957_c.getName(), this.field_150957_c);
    }

    public StatBase(String statIdIn, IChatComponent statNameIn)
    {
        this(statIdIn, statNameIn, simpleStatType);
    }

    /**
     * Initializes the current stat as independent (i.e., lacking prerequisites for being updated) and returns the
     * current instance.
     */
    public StatBase initIndependentStat()
    {
        this.isIndependent = true;
        return this;
    }

    /**
     * Register the stat into StatList.
     */
    public StatBase registerStat()
    {
        if (StatList.oneShotStats.containsKey(this.field_75975_e))
        {
            throw new RuntimeException("Duplicate stat id: \"" + ((StatBase)StatList.oneShotStats.get(this.field_75975_e)).statName + "\" and \"" + this.statName + "\" at id " + this.field_75975_e);
        }
        else
        {
            StatList.field_75940_b.add(this);
            StatList.oneShotStats.put(this.field_75975_e, this);
            return this;
        }
    }

    /**
     * Returns whether or not the StatBase-derived class is a statistic (running counter) or an achievement (one-shot).
     */
    public boolean isAchievement()
    {
        return false;
    }

    public String format(int p_75968_1_)
    {
        return this.type.format(p_75968_1_);
    }

    public IChatComponent getStatName()
    {
        IChatComponent ichatcomponent = this.statName.func_150259_f();
        ichatcomponent.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
        ichatcomponent.func_150256_b().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ACHIEVEMENT, new ChatComponentText(this.field_75975_e)));
        return ichatcomponent;
    }

    public IChatComponent func_150955_j()
    {
        IChatComponent ichatcomponent = this.getStatName();
        IChatComponent ichatcomponent1 = (new ChatComponentText("[")).func_150257_a(ichatcomponent).func_150258_a("]");
        ichatcomponent1.setChatStyle(ichatcomponent.func_150256_b());
        return ichatcomponent1;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (this == p_equals_1_)
        {
            return true;
        }
        else if (p_equals_1_ != null && this.getClass() == p_equals_1_.getClass())
        {
            StatBase statbase = (StatBase)p_equals_1_;
            return this.field_75975_e.equals(statbase.field_75975_e);
        }
        else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return this.field_75975_e.hashCode();
    }

    public String toString()
    {
        return "Stat{id=" + this.field_75975_e + ", nameId=" + this.statName + ", awardLocallyOnly=" + this.isIndependent + ", formatter=" + this.type + ", objectiveCriteria=" + this.field_150957_c + '}';
    }

    public IScoreObjectiveCriteria func_150952_k()
    {
        return this.field_150957_c;
    }

    public Class <? extends IJsonSerializable > func_150954_l()
    {
        return this.field_150956_d;
    }

    public StatBase func_150953_b(Class <? extends IJsonSerializable > p_150953_1_)
    {
        this.field_150956_d = p_150953_1_;
        return this;
    }
}
