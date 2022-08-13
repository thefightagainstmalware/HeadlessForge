package net.minecraft.command;

import net.minecraft.util.BlockPos;

/**
 *
 */
public interface ICommand extends Comparable<ICommand> {

    /**
     * Gets the name of the command
     */
    String func_71517_b();

    /**
     * Gets the usage string for the command.
     * @param sender The command sender that executed the command
     */
    String func_71518_a(ICommandSender sender);

    /**
     *
     */
    java.util.List<String> func_71514_a();

    /**
     * Callback when the command is invoked
     * @param sender The command sender that executed the command
     * @param args The arguments that were passed
     * @throws CommandException
     */
    void func_71515_b(ICommandSender sender,
                      String[] args)
                 throws CommandException;

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    boolean func_71519_b(ICommandSender sender);

    /**
     *
     */
    java.util.List<String> func_71516_a(ICommandSender sender,
                                        String[] args,
                                        BlockPos pos);

    /**
     * Return whether the specified command parameter index is a username parameter.
     * @param args The arguments that were passed
     */
    boolean func_82358_a(String[] args,
                         int index);

}