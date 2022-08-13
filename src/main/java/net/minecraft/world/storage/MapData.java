package net.minecraft.world.storage;

import net.minecraft.network.Packet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.Vec4b;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

/**
 *
 */
public class MapData extends WorldSavedData {

    /**
     *
     */
    public int xCenter;

    /**
     *
     */
    public int zCenter;

    /**
     *
     */
    public int dimension;

    /**
     *
     */
    public byte scale;

    /**
     * colours
     */
    public byte[] colors;

    /**
     *
     */
    public java.util.List<MapData.MapInfo> playersArrayList;

    /**
     *
     */
    private java.util.Map<EntityPlayer,MapData.MapInfo> playersHashMap;

    /**
     *
     */
    public java.util.Map<java.lang.String,Vec4b> mapDecorations;

    /**
     *
     */
    public MapData(String mapname) {
        super(mapname);
    }

    /**
     *
     */
    public void calculateMapCenter(double x,
                                   double z,
                                   int mapScale) {
        return;
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound nbt) {
        return;
    }

    /**
     * Adds the player passed to the list of visible players and checks to see which players are visible
     */
    public void updateVisiblePlayers(EntityPlayer player,
                                     ItemStack mapStack) {
        return;
    }

    /**
     *
     */
    private void updateDecorations(int type,
                                   World worldIn,
                                   String entityIdentifier,
                                   double worldX,
                                   double worldZ,
                                   double rotation) {
        return;
    }

    /**
     *
     */
    public Packet getMapPacket(ItemStack mapStack,
                               World worldIn,
                               EntityPlayer player) {
        return null;
    }

    /**
     *
     */
    public void updateMapData(int x,
                              int y) {
        return;
    }

    /**
     *
     */
    public MapData.MapInfo getMapInfo(EntityPlayer player) {
        return null;
    }

    public class MapInfo {
    }
}