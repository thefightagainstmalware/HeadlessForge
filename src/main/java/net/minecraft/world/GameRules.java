package net.minecraft.world;

import java.util.Set;
import java.util.TreeMap;
import net.minecraft.nbt.NBTTagCompound;

public class GameRules
{
    private TreeMap theGameRules = new TreeMap();
    private static final String __OBFID = "CL_00000136";

    public GameRules()
    {
        this.addGameRule("doFireTick", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("mobGriefing", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("keepInventory", "false", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobSpawning", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("doMobLoot", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("doTileDrops", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("doEntityDrops", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("commandBlockOutput", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("naturalRegeneration", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("doDaylightCycle", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("logAdminCommands", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("showDeathMessages", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("randomTickSpeed", "3", GameRules.ValueType.NUMERICAL_VALUE);
        this.addGameRule("sendCommandFeedback", "true", GameRules.ValueType.BOOLEAN_VALUE);
        this.addGameRule("reducedDebugInfo", "false", GameRules.ValueType.BOOLEAN_VALUE);
    }

    public void addGameRule(String key, String value, GameRules.ValueType type)
    {
        this.theGameRules.put(key, new GameRules.Value(value, type));
    }

    public void func_82764_b(String key, String ruleValue)
    {
        GameRules.Value gamerules$value = (GameRules.Value)this.theGameRules.get(key);

        if (gamerules$value != null)
        {
            gamerules$value.setValue(ruleValue);
        }
        else
        {
            this.addGameRule(key, ruleValue, GameRules.ValueType.ANY_VALUE);
        }
    }

    /**
     * Gets the string Game Rule value.
     */
    public String func_82767_a(String name)
    {
        GameRules.Value gamerules$value = (GameRules.Value)this.theGameRules.get(name);
        return gamerules$value != null ? gamerules$value.getString() : "";
    }

    /**
     * Gets the boolean Game Rule value.
     */
    public boolean func_82766_b(String name)
    {
        GameRules.Value gamerules$value = (GameRules.Value)this.theGameRules.get(name);
        return gamerules$value != null && gamerules$value.getBoolean();
    }

    public int func_180263_c(String name)
    {
        GameRules.Value gamerules$value = (GameRules.Value)this.theGameRules.get(name);
        return gamerules$value != null ? gamerules$value.getInt() : 0;
    }

    /**
     * Return the defined game rules as NBT.
     */
    public NBTTagCompound writeToNBT()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        for (Object s : this.theGameRules.keySet())
        {
            GameRules.Value gamerules$value = (GameRules.Value)this.theGameRules.get(s);
            nbttagcompound.func_74778_a((String) s, gamerules$value.getString());
        }

        return nbttagcompound;
    }

    /**
     * Set defined game rules from NBT.
     */
    public void readFromNBT(NBTTagCompound nbt)
    {
        for (String s : nbt.getKeySet())
        {
            String s1 = nbt.getString(s);
            this.func_82764_b(s, s1);
        }
    }

    /**
     * Return the defined game rules.
     */
    public String[] func_82763_b()
    {
        Set set = this.theGameRules.keySet();
        return (String[]) set.toArray(new String[set.size()]);
    }

    /**
     * Return whether the specified game rule is defined.
     */
    public boolean func_82765_e(String name)
    {
        return this.theGameRules.containsKey(name);
    }

    public boolean func_180264_a(String key, GameRules.ValueType otherValue)
    {
        GameRules.Value gamerules$value = (GameRules.Value)this.theGameRules.get(key);
        return gamerules$value != null && (gamerules$value.getType() == otherValue || otherValue == GameRules.ValueType.ANY_VALUE);
    }

    static class Value
    {
        private String valueString;
        private boolean valueBoolean;
        private int valueInteger;
        private double valueDouble;
        private final GameRules.ValueType type;
        private static final String __OBFID = "CL_00000137";

        public Value(String value, GameRules.ValueType type)
        {
            this.type = type;
            this.setValue(value);
        }

        public void setValue(String value)
        {
            this.valueString = value;

            if (value != null)
            {
                if (value.equals("false"))
                {
                    this.valueBoolean = false;
                    return;
                }

                if (value.equals("true"))
                {
                    this.valueBoolean = true;
                    return;
                }
            }

            this.valueBoolean = Boolean.parseBoolean(value);
            this.valueInteger = this.valueBoolean ? 1 : 0;

            try
            {
                this.valueInteger = Integer.parseInt(value);
            }
            catch (NumberFormatException ignored)
            {
                ;
            }

            try
            {
                this.valueDouble = Double.parseDouble(value);
            }
            catch (NumberFormatException ignored)
            {
                ;
            }
        }

        public String getString()
        {
            return this.valueString;
        }

        public boolean getBoolean()
        {
            return this.valueBoolean;
        }

        public int getInt()
        {
            return this.valueInteger;
        }

        public GameRules.ValueType getType()
        {
            return this.type;
        }
    }

    public enum ValueType
    {
        ANY_VALUE("ANY_VALUE", 0),
        BOOLEAN_VALUE("BOOLEAN_VALUE", 1),
        NUMERICAL_VALUE("NUMERICAL_VALUE", 2);

        private static final GameRules.ValueType[] $VALUES = new GameRules.ValueType[]{ANY_VALUE, BOOLEAN_VALUE, NUMERICAL_VALUE};
        private static final String __OBFID = "CL_00002151";

        ValueType(String p_i15_3_, int p_i15_4_)
        {
        }
    }
}
