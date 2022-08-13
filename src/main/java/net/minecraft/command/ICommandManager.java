package net.minecraft.command;

import net.minecraft.util.BlockPos;

/**
 *
 */
public interface ICommandManager {

    /**
     *
     */
    int func_71556_a(ICommandSender sender,
                     String rawCommand);

    /**
     *
     */
    java.util.List<String> getTabCompletionOptions(ICommandSender sender,
                                                             String input,
                                                             BlockPos pos);

    /**
     *
     */
    java.util.List<ICommand> func_71557_a(ICommandSender sender);

    /**
     *
     */
    java.util.Map<String,ICommand> func_71555_a();

}