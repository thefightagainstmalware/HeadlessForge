package net.minecraft.tileentity;

import com.mojang.authlib.GameProfile;
import net.minecraft.util.StringUtils;
import net.minecraft.network.Packet;
import net.minecraft.nbt.NBTTagCompound;

/**
 *
 */
public class TileEntitySkull extends TileEntity {

    /**
     *
     */
    private int skullType;

    /**
     *
     */
    private int skullRotation;

    /**
     *
     */
    private GameProfile playerProfile;

    /**
     *
     */
    public TileEntitySkull() {
        
    }

    /**
     *
     */
    @Override
    public void func_145841_b(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    @Override
    public void func_145839_a(NBTTagCompound compound) {
        return;
    }

    /**
     *
     */
    public GameProfile getPlayerProfile() {
        return null;
    }

    /**
     * Allows for a specialized description packet to be created. This is often used to sync tile entity data from the
     * server to the client easily. For example this is used by signs to synchronise the text to be displayed.
     */
    @Override
    public Packet getDescriptionPacket() {
        return null;
    }

    /**
     *
     */
    public void setType(int type) {
        return;
    }

    /**
     *
     */
    public void setPlayerProfile(GameProfile playerProfile) {
        return;
    }

    /**
     *
     */
    private void updatePlayerProfile() {
        return;
    }

    /**
     *
     */
    public static GameProfile updateGameprofile(GameProfile input) {
        return null;
    }

    /**
     *
     */
    public int getSkullType() {
        return 0;
    }

    /**
     *
     */
    public int getSkullRotation() {
        return 0;
    }

    /**
     *
     */
    public void setSkullRotation(int rotation) {
        return;
    }

}