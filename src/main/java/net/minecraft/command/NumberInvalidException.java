package net.minecraft.command;

/**
 *
 */
public class NumberInvalidException extends CommandException {

    /**
     *
     */
    public NumberInvalidException() {
        super("commands.generic.num.invalid");
    }

    /**
     *
     */
    public NumberInvalidException(String message,
                                  Object... replacements) {
        super(message, replacements);
    }

}