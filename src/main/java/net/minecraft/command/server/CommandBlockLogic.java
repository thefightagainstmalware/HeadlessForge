package net.minecraft.command.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.command.CommandResultStats;
import net.minecraft.nbt.NBTTagCompound;

import java.text.SimpleDateFormat;

import net.minecraft.util.IChatComponent;

/**
 *
 */
public abstract class CommandBlockLogic extends Object implements ICommandSender {

    /**
     * The formatting for the timestamp on commands run.
     */
    private static final java.text.SimpleDateFormat timestampFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * The number of successful commands run. (used for redstone output)
     */
    private int successCount;

    /**
     *
     */
    private boolean trackOutput;

    /**
     * The previously run command.
     */
    private IChatComponent lastOutput;

    /**
     * The command stored in the command block.
     */
    private java.lang.String commandStored;

    /**
     * The custom name of the command block. (defaults to "@")
     */
    private java.lang.String customName;

    /**
     *
     */
    private final CommandResultStats resultStats = new CommandResultStats();

    /**
     *
     */
    public CommandBlockLogic() {
        
    }

    /**
     * returns the successCount int.
     */
    public int getSuccessCount() {
        return 0;
    }

    /**
     * Returns the lastOutput.
     */
    public IChatComponent getLastOutput() {
        return null;
    }

    /**
     * Stores data to NBT format.
     */
    public void writeDataToNBT(NBTTagCompound tagCompound) {
        return;
    }

    /**
     * Reads NBT formatting and stored data into variables.
     */
    public void readDataFromNBT(NBTTagCompound nbt) {
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
     * Sets the command.
     */
    public void setCommand(String command) {
        return;
    }

    /**
     * Returns the command of the command block.
     */
    public String getCommand() {
        return null;
    }

    /**
     *
     */
    public void trigger(World worldIn) {
        return;
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
     *
     */
    public void setName(String p_145754_1_) {
        return;
    }

    /**
     * Send a chat message to the CommandSender
     */
    public void func_145747_a(IChatComponent component) {
        return;
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
    public abstract void updateCommand();

    /**
     *
     */
    public abstract int func_145751_f();

    /**
     *
     */
    public abstract void func_145757_a(ByteBuf p_145757_1_);

    /**
     *
     */
    public void setLastOutput(IChatComponent lastOutputMessage) {
        return;
    }

    /**
     *
     */
    public void setTrackOutput(boolean shouldTrackOutput) {
        return;
    }

    /**
     *
     */
    public boolean shouldTrackOutput() {
        return true;
    }

    /**
     *
     */
    public boolean tryOpenEditCommandBlock(EntityPlayer playerIn) {
        return true;
    }

    /**
     *
     */
    public CommandResultStats getCommandResultStats() {
        return null;
    }

}