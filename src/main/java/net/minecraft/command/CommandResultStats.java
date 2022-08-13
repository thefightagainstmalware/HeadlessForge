package net.minecraft.command;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CommandResultStats
{
    /** The number of result command result types that are possible. */
    private static final int NUM_RESULT_TYPES = CommandResultStats.Type.values().length;
    private static final String[] STRING_RESULT_TYPES = new String[NUM_RESULT_TYPES];
    private String[] field_179675_c;
    private String[] field_179673_d;

    public CommandResultStats()
    {
        this.field_179675_c = STRING_RESULT_TYPES;
        this.field_179673_d = STRING_RESULT_TYPES;
    }

    public void func_179672_a(final ICommandSender sender, CommandResultStats.Type resultTypeIn, int p_179672_3_)
    {
        String s = this.field_179675_c[resultTypeIn.getTypeID()];

        if (s != null)
        {
            ICommandSender icommandsender = new ICommandSender()
            {
                public String func_70005_c_()
                {
                    return sender.func_70005_c_();
                }
                public IChatComponent func_145748_c_()
                {
                    return sender.func_145748_c_();
                }
                public void func_145747_a(IChatComponent component)
                {
                    sender.func_145747_a(component);
                }
                public boolean func_70003_b(int permLevel, String commandName)
                {
                    return true;
                }
                public BlockPos func_180425_c()
                {
                    return sender.func_180425_c();
                }
                public Vec3 func_174791_d()
                {
                    return sender.func_174791_d();
                }
                public World func_130014_f_()
                {
                    return sender.func_130014_f_();
                }
                public Entity func_174793_f()
                {
                    return sender.func_174793_f();
                }
                public boolean func_174792_t_()
                {
                    return sender.func_174792_t_();
                }
                public void func_174794_a(CommandResultStats.Type type, int amount)
                {
                    sender.func_174794_a(type, amount);
                }
            };
            String s1;

            try
            {
                s1 = CommandBase.func_175758_e(icommandsender, s);
            }
            catch (EntityNotFoundException var11)
            {
                return;
            }

            String s2 = this.field_179673_d[resultTypeIn.getTypeID()];

            if (s2 != null)
            {
                Scoreboard scoreboard = sender.func_130014_f_().func_96441_U();
                ScoreObjective scoreobjective = scoreboard.func_96518_b(s2);

                if (scoreobjective != null)
                {
                    if (scoreboard.func_178819_b(s1, scoreobjective))
                    {
                        Score score = scoreboard.func_96529_a(s1, scoreobjective);
                        score.func_96647_c(p_179672_3_);
                    }
                }
            }
        }
    }

    public void readStatsFromNBT(NBTTagCompound tagcompound)
    {
        if (tagcompound.func_150297_b("CommandStats", 10))
        {
            NBTTagCompound nbttagcompound = tagcompound.func_74775_l("CommandStats");

            for (CommandResultStats.Type commandresultstats$type : CommandResultStats.Type.values())
            {
                String s = commandresultstats$type.func_179637_b() + "Name";
                String s1 = commandresultstats$type.func_179637_b() + "Objective";

                if (nbttagcompound.func_150297_b(s, 8) && nbttagcompound.func_150297_b(s1, 8))
                {
                    String s2 = nbttagcompound.getString(s);
                    String s3 = nbttagcompound.getString(s1);
                    func_179667_a(this, commandresultstats$type, s2, s3);
                }
            }
        }
    }

    public void writeStatsToNBT(NBTTagCompound tagcompound)
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        for (CommandResultStats.Type commandresultstats$type : CommandResultStats.Type.values())
        {
            String s = this.field_179675_c[commandresultstats$type.getTypeID()];
            String s1 = this.field_179673_d[commandresultstats$type.getTypeID()];

            if (s != null && s1 != null)
            {
                nbttagcompound.func_74778_a(commandresultstats$type.func_179637_b() + "Name", s);
                nbttagcompound.func_74778_a(commandresultstats$type.func_179637_b() + "Objective", s1);
            }
        }

        if (!nbttagcompound.hasNoTags())
        {
            tagcompound.func_74782_a("CommandStats", nbttagcompound);
        }
    }

    public static void func_179667_a(CommandResultStats stats, CommandResultStats.Type resultType, String p_179667_2_, String p_179667_3_)
    {
        if (p_179667_2_ != null && p_179667_2_.length() != 0 && p_179667_3_ != null && p_179667_3_.length() != 0)
        {
            if (stats.field_179675_c == STRING_RESULT_TYPES || stats.field_179673_d == STRING_RESULT_TYPES)
            {
                stats.field_179675_c = new String[NUM_RESULT_TYPES];
                stats.field_179673_d = new String[NUM_RESULT_TYPES];
            }

            stats.field_179675_c[resultType.getTypeID()] = p_179667_2_;
            stats.field_179673_d[resultType.getTypeID()] = p_179667_3_;
        }
        else
        {
            func_179669_a(stats, resultType);
        }
    }

    private static void func_179669_a(CommandResultStats resultStatsIn, CommandResultStats.Type resultTypeIn)
    {
        if (resultStatsIn.field_179675_c != STRING_RESULT_TYPES && resultStatsIn.field_179673_d != STRING_RESULT_TYPES)
        {
            resultStatsIn.field_179675_c[resultTypeIn.getTypeID()] = null;
            resultStatsIn.field_179673_d[resultTypeIn.getTypeID()] = null;
            boolean flag = true;

            for (CommandResultStats.Type commandresultstats$type : CommandResultStats.Type.values())
            {
                if (resultStatsIn.field_179675_c[commandresultstats$type.getTypeID()] != null && resultStatsIn.field_179673_d[commandresultstats$type.getTypeID()] != null)
                {
                    flag = false;
                    break;
                }
            }

            if (flag)
            {
                resultStatsIn.field_179675_c = STRING_RESULT_TYPES;
                resultStatsIn.field_179673_d = STRING_RESULT_TYPES;
            }
        }
    }

    public void func_179671_a(CommandResultStats resultStatsIn)
    {
        for (CommandResultStats.Type commandresultstats$type : CommandResultStats.Type.values())
        {
            func_179667_a(this, commandresultstats$type, resultStatsIn.field_179675_c[commandresultstats$type.getTypeID()], resultStatsIn.field_179673_d[commandresultstats$type.getTypeID()]);
        }
    }

    public enum Type
    {
        SUCCESS_COUNT(0, "SuccessCount"),
        AFFECTED_BLOCKS(1, "AffectedBlocks"),
        AFFECTED_ENTITIES(2, "AffectedEntities"),
        AFFECTED_ITEMS(3, "AffectedItems"),
        QUERY_RESULT(4, "QueryResult");

        final int typeID;
        final String typeName;

        Type(int id, String name)
        {
            this.typeID = id;
            this.typeName = name;
        }

        public int getTypeID()
        {
            return this.typeID;
        }

        public String func_179637_b()
        {
            return this.typeName;
        }

        public static String[] func_179634_c()
        {
            String[] astring = new String[values().length];
            int i = 0;

            for (CommandResultStats.Type commandresultstats$type : values())
            {
                astring[i++] = commandresultstats$type.func_179637_b();
            }

            return astring;
        }

        public static CommandResultStats.Type func_179635_a(String name)
        {
            for (CommandResultStats.Type commandresultstats$type : values())
            {
                if (commandresultstats$type.func_179637_b().equals(name))
                {
                    return commandresultstats$type;
                }
            }

            return null;
        }
    }
}
