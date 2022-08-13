package net.minecraft.command;

/**
 *
 */
public interface IAdminCommand {

    /**
     * Send an informative message to the server operators
     */
    void func_152372_a(ICommandSender sender,
                       ICommand command,
                       int flags,
                       String msgFormat,
                       Object... msgParams);

}