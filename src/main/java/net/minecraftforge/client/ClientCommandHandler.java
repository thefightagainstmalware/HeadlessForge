package net.minecraftforge.client;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import static net.minecraft.util.EnumChatFormatting.*;

/**
 * The class that handles client-side chat commands. You should register any
 * commands that you want handled on the client with this command handler.
 *
 * If there is a command with the same name registered both on the server and
 * client, the client takes precedence!
 *
 */
public class ClientCommandHandler extends CommandHandler
{
    public static final ClientCommandHandler instance = new ClientCommandHandler();

    public String[] latestAutoComplete = null;

    /**
     * @return 1 if successfully executed, -1 if no permission or wrong usage,
     *         0 if it doesn't exist or it was canceled (it's sent to the server)
     */
    @Override
    public int func_71556_a(ICommandSender sender, String message)
    {
        message = message.trim();

        if (message.startsWith("/"))
        {
            message = message.substring(1);
        }

        String[] temp = message.split(" ");
        String[] args = new String[temp.length - 1];
        String commandName = temp[0];
        System.arraycopy(temp, 1, args, 0, args.length);
        ICommand icommand = (ICommand) func_71555_a().get(commandName);

        try
        {
            if (icommand == null)
            {
                return 0;
            }

            if (icommand.func_71519_b(sender))
            {

                icommand.func_71515_b(sender, args);
                return 1;
            }
            else
            {
                sender.func_145747_a(format(RED, "commands.generic.permission"));
            }
        }
        catch (WrongUsageException wue)
        {
            sender.func_145747_a(format(RED, "commands.generic.usage", format(RED, wue.getMessage(), wue.getErrorObjects())));
        }
        catch (CommandException ce)
        {
            sender.func_145747_a(format(RED, ce.getMessage(), ce.getErrorObjects()));
        }
        catch (Throwable t)
        {
            sender.func_145747_a(format(RED, "commands.generic.exception"));
            t.printStackTrace();
        }

        return -1;
    }

    //Couple of helpers because the mcp names are stupid and long...
    private ChatComponentTranslation format(EnumChatFormatting color, String str, Object... args)
    {
        ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
        ret.func_150256_b().func_150238_a(color);
        return ret;
    }

    public void autoComplete(String leftOfCursor, String full)
    {
    }
}