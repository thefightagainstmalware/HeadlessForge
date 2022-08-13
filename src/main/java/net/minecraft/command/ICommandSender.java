package net.minecraft.command;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.entity.Entity;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 *
 */
public interface ICommandSender {

    /**
     * Get the name of this object. For players this returns their username
     */
    String func_70005_c_();

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    IChatComponent func_145748_c_();

    /**
     * Send a chat message to the CommandSender
     */
    void func_145747_a(IChatComponent component);

    /**
     * Returns <code>true</code> if the CommandSender is allowed to execute the command, <code>false</code> if not
     */
    boolean func_70003_b(int permLevel,
                         String commandName);

    /**
     * Get the position in the world. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return
     * the coordinates 0, 0, 0
     */
    BlockPos func_180425_c();

    /**
     * Get the position vector. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return 0.0D,
     * 0.0D, 0.0D
     */
    Vec3 func_174791_d();

    /**
     * Get the world, if available. <b><code>null</code> is not allowed!</b> If you are not an entity in the world, return
     * the overworld
     */
    World func_130014_f_();

    /**
     * Returns the entity associated with the command sender. MAY BE NULL!
     */
    Entity func_174793_f();

    /**
     * Returns true if the command sender should be sent feedback about executed commands
     */
    boolean func_174792_t_();

    /**
     *
     */
    void func_174794_a(CommandResultStats.Type type,
                       int amount);

}