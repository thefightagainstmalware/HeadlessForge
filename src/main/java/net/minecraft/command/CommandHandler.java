package net.minecraft.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandHandler implements ICommandManager
{
    private static final Logger logger = LogManager.getLogger();
    private final Map<String, ICommand> commandMap = Maps.<String, ICommand>newHashMap();
    private final Set<ICommand> commandSet = Sets.<ICommand>newHashSet();

    public int func_71556_a(ICommandSender sender, String rawCommand)
    {
        rawCommand = rawCommand.trim();

        if (rawCommand.startsWith("/"))
        {
            rawCommand = rawCommand.substring(1);
        }

        String[] astring = rawCommand.split(" ");
        String s = astring[0];
        astring = dropFirstString(astring);
        ICommand icommand = (ICommand)this.commandMap.get(s);
        int i = this.getUsernameIndex(icommand, astring);
        int j = 0;

        if (icommand == null)
        {
            ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("commands.generic.notFound", new Object[0]);
            chatcomponenttranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
            sender.func_145747_a(chatcomponenttranslation);
        }
        else if (icommand.func_71519_b(sender))
        {
            if (i > -1)
            {
                List<Entity> list = PlayerSelector.<Entity>func_179656_b(sender, astring[i], Entity.class);
                String s1 = astring[i];
                sender.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, list.size());

                for (Entity entity : list)
                {
                    astring[i] = entity.func_110124_au().toString();

                    if (this.tryExecute(sender, astring, icommand, rawCommand))
                    {
                        ++j;
                    }
                }

                astring[i] = s1;
            }
            else
            {
                sender.func_174794_a(CommandResultStats.Type.AFFECTED_ENTITIES, 1);

                if (this.tryExecute(sender, astring, icommand, rawCommand))
                {
                    ++j;
                }
            }
        }
        else
        {
            ChatComponentTranslation chatcomponenttranslation1 = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
            chatcomponenttranslation1.func_150256_b().func_150238_a(EnumChatFormatting.RED);
            sender.func_145747_a(chatcomponenttranslation1);
        }

        sender.func_174794_a(CommandResultStats.Type.SUCCESS_COUNT, j);
        return j;
    }

    protected boolean tryExecute(ICommandSender sender, String[] args, ICommand command, String input)
    {
        try
        {
            command.func_71515_b(sender, args);
            return true;
        }
        catch (WrongUsageException wrongusageexception)
        {
            ChatComponentTranslation chatcomponenttranslation2 = new ChatComponentTranslation("commands.generic.usage", new Object[] {new ChatComponentTranslation(wrongusageexception.getMessage(), wrongusageexception.getErrorObjects())});
            chatcomponenttranslation2.func_150256_b().func_150238_a(EnumChatFormatting.RED);
            sender.func_145747_a(chatcomponenttranslation2);
        }
        catch (CommandException commandexception)
        {
            ChatComponentTranslation chatcomponenttranslation1 = new ChatComponentTranslation(commandexception.getMessage(), commandexception.getErrorObjects());
            chatcomponenttranslation1.func_150256_b().func_150238_a(EnumChatFormatting.RED);
            sender.func_145747_a(chatcomponenttranslation1);
        }
        catch (Throwable var9)
        {
            ChatComponentTranslation chatcomponenttranslation = new ChatComponentTranslation("commands.generic.exception", new Object[0]);
            chatcomponenttranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
            sender.func_145747_a(chatcomponenttranslation);
            logger.warn("Couldn\'t process command: \'" + input + "\'");
        }

        return false;
    }

    /**
     * adds the command and any aliases it has to the internal map of available commands
     */
    public ICommand func_71560_a(ICommand command)
    {
        this.commandMap.put(command.func_71517_b(), command);
        this.commandSet.add(command);

        for (String s : command.func_71514_a())
        {
            ICommand icommand = (ICommand)this.commandMap.get(s);

            if (icommand == null || !icommand.func_71517_b().equals(s))
            {
                this.commandMap.put(s, command);
            }
        }

        return command;
    }

    /**
     * creates a new array and sets elements 0..n-2 to be 0..n-1 of the input (n elements)
     */
    private static String[] dropFirstString(String[] input)
    {
        String[] astring = new String[input.length - 1];
        System.arraycopy(input, 1, astring, 0, input.length - 1);
        return astring;
    }

    public List<String> getTabCompletionOptions(ICommandSender sender, String input, BlockPos pos)
    {
        String[] astring = input.split(" ", -1);
        String s = astring[0];

        if (astring.length == 1)
        {
            List<String> list = Lists.<String>newArrayList();

            for (Entry<String, ICommand> entry : this.commandMap.entrySet())
            {
                if (CommandBase.func_71523_a(s, (String)entry.getKey()) && ((ICommand)entry.getValue()).func_71519_b(sender))
                {
                    list.add(entry.getKey());
                }
            }

            return list;
        }
        else
        {
            if (astring.length > 1)
            {
                ICommand icommand = (ICommand)this.commandMap.get(s);

                if (icommand != null && icommand.func_71519_b(sender))
                {
                    return icommand.func_71516_a(sender, dropFirstString(astring), pos);
                }
            }

            return null;
        }
    }

    public List<ICommand> func_71557_a(ICommandSender sender)
    {
        List<ICommand> list = Lists.<ICommand>newArrayList();

        for (ICommand icommand : this.commandSet)
        {
            if (icommand.func_71519_b(sender))
            {
                list.add(icommand);
            }
        }

        return list;
    }

    public Map<String, ICommand> func_71555_a()
    {
        return this.commandMap;
    }

    /**
     * Return a command's first parameter index containing a valid username.
     */
    private int getUsernameIndex(ICommand command, String[] args)
    {
        if (command == null)
        {
            return -1;
        }
        else
        {
            for (int i = 0; i < args.length; ++i)
            {
                if (command.func_82358_a(args, i) && PlayerSelector.matchesMultiplePlayers(args[i]))
                {
                    return i;
                }
            }

            return -1;
        }
    }
}
