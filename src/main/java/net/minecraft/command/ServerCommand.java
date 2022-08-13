package net.minecraft.command;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 */
public class ServerCommand extends Object {

    /**
     * The command string.
     */
    public final java.lang.String command;

    /**
     *
     */
    public final ICommandSender sender;

    /**
     *
     */
    public ServerCommand(String input,
                         ICommandSender sender) {
        this.command = input;
        this.sender = sender;
    }

}