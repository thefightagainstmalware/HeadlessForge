package net.minecraft.command;

import net.minecraft.world.WorldSettings;
import net.minecraft.util.ChatComponentTranslation;

/**
 *
 */
public class CommandDefaultGameMode extends CommandGameMode {

    /**
     *
     */
    public CommandDefaultGameMode() {
        
    }

    /**
     * Gets the name of the command
     */
    @Override
    public String func_71517_b() {
        return null;
    }

    /**
     * Gets the usage string for the command.
     * @param sender The command sender that executed the command
     */
    @Override
    public String func_71518_a(ICommandSender sender) {
        return null;
    }

    /**
     * Callback when the command is invoked
     * @param sender The command sender that executed the command
     * @param args The arguments that were passed
     * @throws CommandException
     */
    @Override
    public void func_71515_b(ICommandSender sender,
                             String[] args)
                        throws CommandException {
        return;
    }

    /**
     *
     */
    protected void setGameType(WorldSettings.GameType p_71541_1_) {
        return;
    }

}