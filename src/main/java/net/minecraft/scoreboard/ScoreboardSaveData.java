package net.minecraft.scoreboard;

import net.minecraft.util.EnumChatFormatting;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.WorldSavedData;
import net.minecraft.nbt.NBTTagList;

/**
 *
 */
public class ScoreboardSaveData extends WorldSavedData {

    /**
     *
     */
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    /**
     *
     */
    private Scoreboard theScoreboard;

    /**
     *
     */
    private NBTTagCompound delayedInitNbt;

    /**
     *
     */
    public ScoreboardSaveData() {
        this("scoreboard");
    }

    /**
     *
     */
    public ScoreboardSaveData(String name) {
        super(name);
    }

    /**
     *
     */
    public void setScoreboard(Scoreboard scoreboardIn) {
        return;
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     *
     */
    protected void readTeams(NBTTagList p_96498_1_) {
        return;
    }

    /**
     *
     */
    protected void func_96502_a(ScorePlayerTeam p_96502_1_,
                                NBTTagList p_96502_2_) {
        return;
    }

    /**
     *
     */
    protected void readDisplayConfig(NBTTagCompound p_96504_1_) {
        return;
    }

    /**
     *
     */
    protected void readObjectives(NBTTagList nbt) {
        return;
    }

    /**
     *
     */
    protected void readScores(NBTTagList nbt) {
        return;
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     *
     */
    protected NBTTagList func_96496_a() {
        return null;
    }

    /**
     *
     */
    protected void func_96497_d(NBTTagCompound p_96497_1_) {
        return;
    }

    /**
     *
     */
    protected NBTTagList objectivesToNbt() {
        return null;
    }

    /**
     *
     */
    protected NBTTagList scoresToNbt() {
        return null;
    }

}