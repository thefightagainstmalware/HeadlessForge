package net.minecraft.network.rcon;

import net.minecraft.command.ICommandSender;
import net.minecraft.world.World;
import net.minecraft.util.BlockPos;
import net.minecraft.command.CommandResultStats;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class RConConsoleSource extends Object implements ICommandSender {

    /**
     * Single instance of RConConsoleSource
     */
    private static final RConConsoleSource instance = new RConConsoleSource();

    /**
     * RCon string buffer for log.
     */
    private java.lang.StringBuffer buffer;

    /**
     *
     */
    public RConConsoleSource() {

    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String func_70005_c_() {
        return null;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    public IChatComponent func_145748_c_() {
        return null;
    }

    /**
     * Send a chat message to the CommandSender
     */
    public void func_145747_a(IChatComponent component) {
        return;
    }

    /**
     * Returns <code>true</code> if the CommandSender is allowed to execute the command, <code>false</code> if not
     */
    public boolean func_70003_b(int permLevel,
                                String commandName) {
        return true;
    }

    /**
     * Get the position in the world. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    public BlockPos func_180425_c() {
        return null;
    }

    /**
     * Get the position vector. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return 0.0D,
     * 0.0D, 0.0D
     */
    public Vec3 func_174791_d() {
        return null;
    }

    /**
     * Get the world, if available. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return
     * the overworld
     */
    public World func_130014_f_() {
        return null;
    }

    /**
     * Returns the entity associated with the command sender. MAY BE NULL!
     */
    public Entity func_174793_f() {
        return null;
    }

    /**
     * Returns true if the command sender should be sent feedback about executed commands
     */
    public boolean func_174792_t_() {
        return true;
    }

    /**
     *
     */
    public void func_174794_a(CommandResultStats.Type type,
                              int amount) {
        return;
    }

    /**
     *
     */
    public static RConConsoleSource getInstance() {
        return null;
    }

    /**
     * Clears the RCon log
     */
    public void resetLog() {
        return;
    }

    /**
     * Gets the contents of the RCon log
     */
    public String getLogContents() {
        return null;
    }

}