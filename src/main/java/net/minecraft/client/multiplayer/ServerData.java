package net.minecraft.client.multiplayer;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IChatComponent;

/**
 *
 */
public class ServerData extends Object {

    /**
     *
     */
    public java.lang.String serverName;

    /**
     *
     */
    public java.lang.String serverIP;

    /**
     * the string indicating number of players on and capacity of the server that is shown on the server browser (i.e.
     * "5/20" meaning 5 slots used out of 20 slots total)
     */
    public java.lang.String populationInfo;

    /**
     * (better variable name would be 'hostname') server name as displayed in the server browser's second line (grey
     * text)
     */
    public java.lang.String serverMOTD;

    /**
     * last server ping that showed up in the server browser
     */
    public long pingToServer;

    /**
     *
     */
    public int version;

    /**
     * Game version for this server.
     */
    public java.lang.String gameVersion;

    /**
     *
     */
    public boolean field_78841_f;

    /**
     *
     */
    public java.lang.String playerList;

    /**
     *
     */
    private ServerData.ServerResourceMode resourceMode;

    /**
     *
     */
    private java.lang.String serverIcon;

    /**
     *
     */
    private boolean field_181042_l;

    /**
     *
     */
    public ServerData(String p_i46420_1_,
                      String p_i46420_2_,
                      boolean p_i46420_3_) {
        
    }

    /**
     * Returns an NBTTagCompound with the server's name, IP and maybe acceptTextures.
     */
    public NBTTagCompound getNBTCompound() {
        return null;
    }

    /**
     *
     */
    public ServerData.ServerResourceMode getResourceMode() {
        return null;
    }

    /**
     *
     */
    public void setResourceMode(ServerData.ServerResourceMode mode) {
        return;
    }

    /**
     * Takes an NBTTagCompound with 'name' and 'ip' keys, returns a ServerData instance.
     */
    public static ServerData getServerDataFromNBTCompound(NBTTagCompound nbtCompound) {
        return null;
    }

    /**
     * Returns the base-64 encoded representation of the server's icon, or null if not available
     */
    public String getBase64EncodedIconData() {
        return null;
    }

    /**
     *
     */
    public void setBase64EncodedIconData(String icon) {
        return;
    }

    /**
     *
     */
    public boolean func_181041_d() {
        return true;
    }

    /**
     *
     */
    public void copyFrom(ServerData serverDataIn) {
        return;
    }

    public class ServerResourceMode {
    }
}