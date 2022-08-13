package net.minecraft.command;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class ServerCommandManager extends CommandHandler implements IAdminCommand {

    /**
     *
     */
    public ServerCommandManager() {
        
    }

    /**
     * Send an informative message to the server operators
     */
    public void func_152372_a(ICommandSender sender,
                              ICommand command,
                              int flags,
                              String msgFormat,
                              Object... msgParams) {
        return;
    }

}