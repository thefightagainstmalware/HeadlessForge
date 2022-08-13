package net.minecraft.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.BlockPos;

/**
 *
 */
public class CommandScoreboard extends CommandBase {

    /**
     *
     */
    public CommandScoreboard() {

    }

    /**
     * Gets the name of the command
     */
    public String func_71517_b() {
        return null;
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel() {
        return 0;
    }

    /**
     * Gets the usage string for the command.
     * @param sender The command sender that executed the command
     */
    public String func_71518_a(ICommandSender sender) {
        return null;
    }

    /**
     * Callback when the command is invoked
     * @param sender The command sender that executed the command
     * @param args The arguments that were passed
     * @throws CommandException
     */
    public void func_71515_b(ICommandSender sender,
                             String[] args)
                        throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    private boolean func_175780_b(ICommandSender p_175780_1_,
                                  String[] p_175780_2_)
                           throws CommandException {
        return true;
    }

    /**
     *
     */
    protected Scoreboard getScoreboard() {
        return null;
    }

    /**
     *
     * @throws CommandException
     */
    protected ScoreObjective getObjective(String name,
                                          boolean edit)
                                   throws CommandException {
        return null;
    }

    /**
     *
     * @throws CommandException
     */
    protected ScorePlayerTeam getTeam(String name)
                               throws CommandException {
        return null;
    }

    /**
     *
     * @throws CommandException
     */
    protected void addObjective(ICommandSender sender,
                                String[] args,
                                int index)
                         throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void addTeam(ICommandSender sender,
                           String[] args,
                           int index)
                    throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void setTeamOption(ICommandSender sender,
                                 String[] args,
                                 int index)
                          throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void removeTeam(ICommandSender p_147194_1_,
                              String[] p_147194_2_,
                              int p_147194_3_)
                       throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void listTeams(ICommandSender p_147186_1_,
                             String[] p_147186_2_,
                             int p_147186_3_)
                      throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void joinTeam(ICommandSender p_147190_1_,
                            String[] p_147190_2_,
                            int p_147190_3_)
                     throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void leaveTeam(ICommandSender p_147199_1_,
                             String[] p_147199_2_,
                             int p_147199_3_)
                      throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void emptyTeam(ICommandSender p_147188_1_,
                             String[] p_147188_2_,
                             int p_147188_3_)
                      throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void removeObjective(ICommandSender p_147191_1_,
                                   String p_147191_2_)
                            throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void listObjectives(ICommandSender p_147196_1_)
                           throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void setObjectiveDisplay(ICommandSender p_147198_1_,
                                       String[] p_147198_2_,
                                       int p_147198_3_)
                                throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void listPlayers(ICommandSender p_147195_1_,
                               String[] p_147195_2_,
                               int p_147195_3_)
                        throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void setPlayer(ICommandSender p_147197_1_,
                             String[] p_147197_2_,
                             int p_147197_3_)
                      throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void resetPlayers(ICommandSender p_147187_1_,
                                String[] p_147187_2_,
                                int p_147187_3_)
                         throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void func_175779_n(ICommandSender p_175779_1_,
                                 String[] p_175779_2_,
                                 int p_175779_3_)
                          throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void func_175781_o(ICommandSender p_175781_1_,
                                 String[] p_175781_2_,
                                 int p_175781_3_)
                          throws CommandException {
        return;
    }

    /**
     *
     * @throws CommandException
     */
    protected void func_175778_p(ICommandSender p_175778_1_,
                                 String[] p_175778_2_,
                                 int p_175778_3_)
                          throws CommandException {
        return;
    }

    /**
     *
     */
    @Override
    public java.util.List<String> func_71516_a(ICommandSender sender,
                                               String[] args,
                                               BlockPos pos) {
        return null;
    }

    /**
     *
     */
    protected java.util.List<String> func_147184_a(boolean p_147184_1_) {
        return null;
    }

    /**
     *
     */
    protected java.util.List<String> func_175782_e() {
        return null;
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     * @param args The arguments that were passed
     */
    @Override
    public boolean func_82358_a(String[] args,
                                int index) {
        return true;
    }

}