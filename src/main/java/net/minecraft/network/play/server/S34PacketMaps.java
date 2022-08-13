package net.minecraft.network.play.server;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.Vec4b;
import net.minecraft.world.storage.MapData;

/**
 *
 */
public class S34PacketMaps extends Object implements Packet<INetHandlerPlayClient> {

    /**
     *
     */
    private int mapId;

    /**
     *
     */
    private byte mapScale;

    /**
     *
     */
    private Vec4b[] mapVisiblePlayersVec4b;

    /**
     *
     */
    private int mapMinX;

    /**
     *
     */
    private int mapMinY;

    /**
     *
     */
    private int mapMaxX;

    /**
     *
     */
    private int mapMaxY;

    /**
     *
     */
    private byte[] mapDataBytes;

    /**
     *
     */
    public S34PacketMaps() {
        
    }

    /**
     *
     */
    public S34PacketMaps(int mapIdIn,
                         byte scale,
                         java.util.Collection<Vec4b> visiblePlayers,
                         byte[] colors,
                         int minX,
                         int minY,
                         int maxX,
                         int maxY) {
        
    }

    /**
     * Reads the raw packet data from the data stream.
     * @throws java.io.IOException
     */
    public void readPacketData(PacketBuffer buf)
                        throws java.io.IOException {
        return;
    }

    /**
     * Writes the raw packet data to the data stream.
     * @throws java.io.IOException
     */
    public void writePacketData(PacketBuffer buf)
                         throws java.io.IOException {
        return;
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(INetHandlerPlayClient handler) {
        return;
    }

    /**
     *
     */
    public int getMapId() {
        return 0;
    }

    /**
     * Sets new MapData from the packet to given MapData param
     */
    public void setMapdataTo(MapData mapdataIn) {
        return;
    }

}