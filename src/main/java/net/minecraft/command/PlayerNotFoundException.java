package net.minecraft.command;

/**
 *
 */
public class PlayerNotFoundException extends CommandException {

    /**
     *
     */
    public PlayerNotFoundException() {
        super("commands.generic.player.notFound");
    }

    /**
     *
     */
    public PlayerNotFoundException(String message,
                                   Object... replacements) {
        super(message, replacements);
    }

}